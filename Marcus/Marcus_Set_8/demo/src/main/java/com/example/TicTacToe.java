package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Application {

    Button[][] bts;
    Text next_text;

	/**
	 * Presents a GUI containing a button and a label that displays how many
	 * times the button is pushed.
	 */
	@Override
	public void start(Stage stage) {
		// panes are for handling the layout of elements of the interface. 
		GridPane pane = new GridPane();
        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                bts[i][j] = new Button();
                bts[i][j].setOnAction(this::processButtonPress);
                pane.add(bts[i][j], i, j);
                
            }
        }

		// scenes are the main container for objects to be shown in a window/stage
		Scene scene = new Scene(pane,300,300);

		// add the scene to the stage and show it
		stage.setScene(scene);
		stage.setTitle("Push Counter");
		stage.show();

	}
    void processButtonPress(ActionEvent event) {
		// TODO: Make work
	}

	public static void main(String[] args) {
		launch();
	}

}