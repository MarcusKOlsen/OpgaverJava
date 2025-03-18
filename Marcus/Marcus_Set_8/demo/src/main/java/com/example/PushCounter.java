package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class PushCounter extends Application {

	int count;
	Text countText;

	/**
	 * Presents a GUI containing a button and a label that displays how many
	 * times the button is pushed.
	 */
	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) {
		count = 0;
		countText = new Text("Pushes: 0");

		// a button to increment the counter
		Button push = new Button("Push Me!");
		// invoke this.processButtonPress when it is pressed
		push.setOnAction(this::processButtonPress);

		// panes are for handling the layout of elements of the interface. 
		FlowPane pane = new FlowPane(push,countText);
		// define an alignment for the elements in the pane
		pane.setAlignment(Pos.CENTER);
		// how much horizontal space to skip between elements
		pane.setHgap(20);
		
		// scenes are the main container for objects to be shown in a window/stage
		Scene scene = new Scene(pane,200,50);

		// add the scene to the stage and show it
		stage.setScene(scene);
		stage.setTitle("Push Counter");
		stage.show();

	}

	private void processButtonPress(ActionEvent event) {
		count += 1;
		countText.setText("Pushes: " + count);
	}

	public static void main(String[] args) {
		launch();
	}

}