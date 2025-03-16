package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TicTacToe extends Application {

	final int TIC_TAC_TOE_SIZE = 3;
	char current_player = 'X';

    Button[][] bts = new Button[TIC_TAC_TOE_SIZE][TIC_TAC_TOE_SIZE];
    Text next_text;

	/**
	 * Presents a GUI containing a button and a label that displays how many
	 * times the button is pushed.
	 */
	@Override
	public void start(Stage stage) {
		// panes are for handling the layout of elements of the interface. 
		GridPane pane = new GridPane();
        for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) {
            for(int j = 0; j < TIC_TAC_TOE_SIZE; j++) {
                bts[i][j] = new Button();
                bts[i][j].setOnAction(e -> processButtonPress(e));
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
		Button clickedButton = (Button) event.getSource(); 
		int row = GridPane.getRowIndex(clickedButton);
    	int col = GridPane.getColumnIndex(clickedButton);
		
		if(clickedButton.getText().isEmpty()) {
			bts[row][col].setText(Character.toString(current_player));
		}

		if(!check_completion()) {
			change_current();
		}
		else
		{

			System.out.println("Game finished, TODO: Make game actually finish lmao");
			// end_game();
		}
		


	}

	boolean check_completion(){
		int amount = 0;
		System.out.println("Checking completion... ");

		for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) 
		{
			for(int j = 0; j < TIC_TAC_TOE_SIZE; j++)
			{
				if(bts[i][j].getText() == Character.toString(current_player)) {
					amount++;
				}
			}
			
			if(amount == TIC_TAC_TOE_SIZE) {
				return true;	
			}
		}
		System.out.println("Vertical amount: " + Integer.toString(amount));

		amount = 0;
		for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) 
		{
			for(int j = 0; j < TIC_TAC_TOE_SIZE; j++)
			{
				int row = GridPane.getRowIndex(bts[j][i]);
    			int col = GridPane.getColumnIndex(bts[j][i]);
				if(bts[j][i].getText() == Character.toString(current_player)) {
					amount++;
				}
			}
			if(amount == TIC_TAC_TOE_SIZE) {
				return true;	
			}

		}
		System.out.println("Horizontal amount: " + Integer.toString(amount));

		return false;

	}

	void change_current(){
		if (current_player == 'X') {
			current_player = 'O';
		}
		else
		{
			current_player = 'X';
		}
	}

	public static void main(String[] args) {
		launch();
	}

}