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
    Text next_text = new Text("Next: X");

	/**
	 * Presents a GUI containing a button and a label that displays how many
	 * times the button is pushed.
	 */
	@SuppressWarnings("exports")
	@Override
	public void start(Stage stage) {
		// panes are for handling the layout of elements of the interface. 
		GridPane pane = new GridPane();
        for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) {
            for(int j = 0; j < TIC_TAC_TOE_SIZE; j++) {
				// Creates a button
                bts[i][j] = new Button();
                bts[i][j].setOnAction(e -> processButtonPress(e));

				// Button customization
				bts[i][j].setPrefSize(50, 50);
				
				// Adds button to pane
                pane.add(bts[i][j], i, j);
                
            }
        }
		pane.add(next_text, TIC_TAC_TOE_SIZE / 2, TIC_TAC_TOE_SIZE + 1);

		// scenes are the main container for objects to be shown in a window/stage
		Scene scene = new Scene(pane,300,300);

		// add the scene to the stage and show it
		stage.setScene(scene);
		stage.setWidth(TIC_TAC_TOE_SIZE*50);
		stage.setHeight(TIC_TAC_TOE_SIZE*50 + 100);
		stage.setTitle("Push Counter");
		stage.show();

	}

    void processButtonPress(ActionEvent event) {
		Button clickedButton = (Button) event.getSource(); 
		int row = GridPane.getRowIndex(clickedButton);
    	int col = GridPane.getColumnIndex(clickedButton);
		
		if(clickedButton.getText().isEmpty()) {
			bts[col][row].setText(Character.toString(current_player));
		}

		if(!check_completion()) {
			change_current();
		}
		else
		{
			end_game();
		}
		


	}

	void end_game(){
		for(Button[] btns : bts) {
			for(Button btn : btns) {
				btn.setDisable(true);
			}
		}
		next_text.setText("Winner: " + Character.toString(current_player) + "!");
	}

	boolean check_completion(){
		int amount = 0;

		// Checks vertical for completion
		for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) 
		{
			amount = 0;
			for(int j = 0; j < TIC_TAC_TOE_SIZE; j++)
			{
				if(bts[i][j].getText().equals(Character.toString(current_player))) {
					amount++;
				}
			}
			
			if(amount == TIC_TAC_TOE_SIZE) {
				return true;	
			}
		}

		amount = 0;

		// Checks horizontal for completion
		for(int i = 0; i < TIC_TAC_TOE_SIZE; i++) 
		{
			amount = 0;
			for(int j = 0; j < TIC_TAC_TOE_SIZE; j++)
			{

				if(bts[j][i].getText().equals(Character.toString(current_player))) {
					amount++;
				}
			}
			if(amount == TIC_TAC_TOE_SIZE) {
				return true;	
			}

		}

		amount = 0;

		for(int x = 0; x < TIC_TAC_TOE_SIZE; x++) {
			if(bts[x][x].getText().equals(Character.toString(current_player))) {
				amount++;
			}
		}
		if(amount == TIC_TAC_TOE_SIZE) {
			return true;	
		}

		amount = 0;
		for(int x = 0; x < TIC_TAC_TOE_SIZE; x++) {
			if(bts[TIC_TAC_TOE_SIZE-1-x][x].getText().equals(Character.toString(current_player))) {
				amount++;
			}
		}
		if(amount == TIC_TAC_TOE_SIZE) {
			return true;	
		}

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

		next_text.setText("Next: " + Character.toString(current_player));
	}

	public static void main(String[] args) {
		launch();
	}

}