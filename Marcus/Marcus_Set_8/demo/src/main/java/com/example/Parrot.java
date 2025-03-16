package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Parrot extends Application {

	Text parrot_text;
    TextField text_field; 

	/**
	 * Presents a GUI containing a button and a label that displays how many
	 * times the button is pushed.
	 */
	@Override
	public void start(Stage stage) {
		parrot_text = new Text();
        text_field = new TextField("Write whatever you want here!");
        text_field.setAlignment(Pos.CENTER);
		// a button to increment the counter
		Button push = new Button("Parrot what i say!");
		// invoke this.processButtonPress when it is pressed
		push.setOnAction(this::processButtonPress);

		// panes are for handling the layout of elements of the interface. 
		VBox pane = new VBox(text_field, push, parrot_text);
		// define an alignment for the elements in the pane
		pane.setAlignment(Pos.TOP_CENTER);
		// how much horizontal space to skip between elements
		pane.setSpacing(10);
		
		// scenes are the main container for objects to be shown in a window/stage
		Scene scene = new Scene(pane,200,50);

		// add the scene to the stage and show it
		stage.setScene(scene);
		stage.setTitle("Push Counter");
		stage.show();

	}

	private void processButtonPress(ActionEvent event) {
		parrot_text.setText(text_field.getText());
	}

	public static void main(String[] args) {
		launch();
	}

}