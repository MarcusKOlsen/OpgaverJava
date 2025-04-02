package dm575.imageeditor;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

import javax.imageio.ImageIO;
import javax.swing.Action;

import javafx.application.Application;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.stage.FileChooser.ExtensionFilter;

public class SimpleImageEditor extends Application {

    /* name of the file currently open, null if no file is open */
    private String filename;
    /* whether there are unsaved changes to the image */
    private boolean unsaved;

    /* UI elements */
    private Stage primaryStage;
    private ImageView imageView; // displays the image, see setImage
    private Label statusImageInfo;
    private Label statusZoom;
    private MenuItem fileSave;
    private MenuItem fileSaveAs;
    private MenuItem fileClose;
    private MenuItem fileZoomIn;
    private MenuItem fileZoomOut;
    private MenuItem fileZoomReset;

    private double zoom_level = 100.0;

    /* extension filter for files supported by javafx Image */
    private static ExtensionFilter imageExtensionFilter = new FileChooser.ExtensionFilter("Image Files", "*.jpg",
            "*.png", "*.bmp", "*.gif");

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        /* menus */
        MenuBar menuBar = new MenuBar();
        /* file menu */
        Menu fileMenu = new Menu("File");
        menuBar.getMenus().add(fileMenu);
        addMenuItem(fileMenu, "_Open", false, this::onFileOpen,
                new KeyCodeCombination(KeyCode.O, KeyCombination.CONTROL_DOWN));
        fileSave = addMenuItem(fileMenu, "_Save", true, this::onFileSave,
                new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN));
        fileSaveAs = addMenuItem(fileMenu, "Save _as...", true, this::onFileSaveAs,
                new KeyCodeCombination(KeyCode.S, KeyCombination.CONTROL_DOWN, KeyCombination.SHIFT_DOWN));
        fileClose = addMenuItem(fileMenu, "_Close", true, this::onFileClose, null);

        /* Show menu */
        Menu showMenu = new Menu("Show");
        menuBar.getMenus().add(showMenu);

        fileZoomIn = addMenuItem(showMenu,"_Zoom in", true, this::onFileZoomedIn, null);
        fileZoomOut = addMenuItem(showMenu,"_Zoom out", true, this::onFileZoomedOut, null);
        fileZoomReset = addMenuItem(showMenu, "_Reset Zoom", true, this::onFileZoomedReset, null);

        /* image area */
        imageView = new ImageView();
        imageView.setPreserveRatio(true);
        imageView.setCache(true);
        ScrollPane scrollPane = new ScrollPane(imageView);

        /* status bar */
        statusImageInfo = new Label();
        statusZoom = new Label();
        Pane paddingPane = new Pane();
        HBox statusBar = new HBox(statusImageInfo, paddingPane, statusZoom);
        statusBar.setPadding(new Insets(5));
        statusBar.setAlignment(Pos.CENTER_LEFT);
        HBox.setHgrow(statusImageInfo, Priority.ALWAYS);
        HBox.setHgrow(paddingPane, Priority.ALWAYS);
        HBox.setHgrow(statusZoom, Priority.ALWAYS);

        /* main scene */
        VBox vBox = new VBox(menuBar, scrollPane, statusBar);
        VBox.setVgrow(menuBar, Priority.NEVER);
        VBox.setVgrow(scrollPane, Priority.ALWAYS);
        VBox.setVgrow(statusBar, Priority.NEVER);
        Scene scene = new Scene(vBox, 960, 600);
        /* no file open yet */
        setImage(null);
        setFilename(null);
        /* intercept requests to close the window to check for unsaved changes */
        stage.setOnCloseRequest(this::onWindowCloseRequest);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Helper methods for creating menu items.
     */
    private MenuItem addMenuItem(Menu menu, String text, boolean disabled,
            EventHandler<ActionEvent> onActionHandler,
            KeyCombination keyCombination) {
        MenuItem item = new MenuItem(text);
        item.setOnAction(onActionHandler);
        item.setDisable(disabled);
        item.setAccelerator(keyCombination);
        menu.getItems().add(item);
        return item;
    }

    /**
     * sets the path to the file currently open updating the GUI accordingly.
     * 
     * @param value the path to the file or null if there is no file open.
     */
    private void setFilename(String value) {
        filename = value;
        if (filename == null) {
            primaryStage.setTitle("Simple Image Editor");
        } else {
            primaryStage.setTitle("Simple Image Editor (" + filename + ")");
        }
    }

    /**
     * Sets the image displayed by the editor and updates the GUI
     * (enabling/disabling menu items etc.)
     * 
     * @param image   the image to be displayed or null if there is no image open.
     * @param unsaved whether this image contains unsaved changes.
     */
    private void setImage(Image image, boolean unsaved) {
        boolean noImage = image == null;
        imageView.setImage(image);
        // enable/disable UI elements that require an image to be open
        fileSave.setDisable(noImage);
        fileSaveAs.setDisable(noImage);
        fileClose.setDisable(noImage);
        fileZoomIn.setDisable(noImage);
        fileZoomOut.setDisable(noImage);
        fileZoomReset.setDisable(noImage);

        // update status bar
        if (noImage) {
            statusImageInfo.setText("");
            statusZoom.setText("");
        } else {
            statusImageInfo.setText(String.format("W: %.0fpx, H: %.0fpx", image.getWidth(), image.getHeight()));
        }
        statusZoom.setText(String.format("Zoom: %.0f", zoom_level) + "%");
        this.unsaved = unsaved;
    }

    /**
     * Sets the image displayed by the editor and updates the GUI
     * (enabling/disabling menu items etc.)
     * 
     * @param image the image to be displayed or null if there is no image open.
     */
    void setImage(Image image) {
        setImage(image, image != null);
    }

    /* window events */

    private void onWindowCloseRequest(WindowEvent e) {
        boolean close = promptDiscardUnsavedChanges();
        if (!close) {
            e.consume();
        }
    }

    /**
     * If there are unsaved changes, prompts the user asking if it is ok to
     * proceed.
     * 
     * @return returns false if the user cancels.
     */
    private boolean promptDiscardUnsavedChanges() {
        if (unsaved) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.getButtonTypes().remove(ButtonType.OK);
            alert.getButtonTypes().add(ButtonType.CANCEL);
            alert.getButtonTypes().add(ButtonType.YES);
            alert.setTitle("Unsaved work");
            alert.setHeaderText("Close without saving?");
            alert.setContentText("The current image contains unsaved changes that will be lost.");
            alert.initOwner(primaryStage);
            Optional<ButtonType> res = alert.showAndWait();
            return res.isPresent() && res.get().equals(ButtonType.YES);
        } else {
            return true;
        }
    }

    /* file menu events */

    private void onFileOpen(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(SimpleImageEditor.imageExtensionFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            setFilename(file.getAbsolutePath());
            setImage(new Image(file.toURI().toString()), false);
        }
    }

    private void onFileClose(ActionEvent e) {
        boolean close = promptDiscardUnsavedChanges();
        if (close) {
            setImage(null);
            setFilename(null);
        }
    }

    private void onFileSave(ActionEvent e) {
        File file = new File(filename);
        saveToFile(file, filename);
    }

    private void onFileSaveAs(ActionEvent e) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(SimpleImageEditor.imageExtensionFilter);
        File currentFile = new File(filename);
        fileChooser.setInitialDirectory(currentFile.getParentFile());
        fileChooser.setInitialFileName(currentFile.getName());
        File newFile = fileChooser.showSaveDialog(primaryStage);
        if (newFile != null) {
            String newFilename = newFile.getAbsolutePath();
            if (saveToFile(newFile, newFilename)) {
                setFilename(newFilename);
            }
        }
    }

    private void onFileZoomedIn(ActionEvent e) {
        
        imageView.setFitHeight(imageView.getImage().getHeight() * (zoom_level / 100 + 0.1));
        imageView.setFitWidth(imageView.getImage().getWidth() * (zoom_level / 100 + 0.1) );
        statusZoom.setText(String.format("Zoom: %.0f", zoom_level) + "%");
        zoom_level += 10;

    }


    private void onFileZoomedOut(ActionEvent e) {
        imageView.setFitHeight(imageView.getImage().getHeight() * (zoom_level / 100 - 0.1));
        imageView.setFitWidth(imageView.getImage().getWidth() * (zoom_level / 100 - 0.1) );
        statusZoom.setText(String.format("Zoom: %.0f", zoom_level) + "%");
        zoom_level -= 10;
    }

    private void onFileZoomedReset(ActionEvent e) {
        imageView.setFitHeight(imageView.getImage().getHeight());
        imageView.setFitWidth(imageView.getImage().getWidth());
        
        zoom_level = 100;
        statusZoom.setText(String.format("Zoom: %.0f", zoom_level) + "%");

        
    }
    /**
     * Helper method for save and save as
     */
    private boolean saveToFile(File file, String filename) {
        String ext = filename.substring(filename.lastIndexOf(".") + 1);
        try {
            ImageIO.write(SwingFXUtils.fromFXImage(imageView.getImage(), null), ext, file);
            unsaved = false;
            return true;
        } catch (IOException ioe) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("An error occurred while saving \"" + filename + "\".");
            alert.setContentText(ioe.getMessage());
            alert.showAndWait();
            return false;
        }
    }

}