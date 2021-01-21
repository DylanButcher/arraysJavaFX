package com.dylan;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Random;

public class Task2 {

    @FXML
    JFXTextField numIn;
    @FXML
    Text output;
    @FXML
    Text tried;
    @FXML
    Text guessed;

    public ArrayList<Integer> arrToGuess = new ArrayList<>();
    public ArrayList<Integer> arrTried = new ArrayList<>();
    public ArrayList<Integer> arrCorrectlyGuessed = new ArrayList<>();

    public Task2() {
        this.getRandArray();
    }

    @FXML
    public void checkInArr(ActionEvent ae) {
        String outputMsg = "";
        try {
            int toFind = Integer.parseInt(numIn.getText());
            if (toFind >= 101) {
                App.showAlert(Alert.AlertType.ERROR, "You've encountered an Error", "Value too big", "Only guess numbers between 0 and 99");
                numIn.clear();
                return;
            }
            if (arrCorrectlyGuessed.contains(toFind) || arrTried.contains(toFind)) {
                outputMsg = "You've already guessed this number, try again!";
            } else if (!arrToGuess.contains(toFind)) {
                outputMsg = "Value not in Array, try again!";
                arrTried.add(Integer.valueOf(numIn.getText()));
                tried.setText(arrTried.toString());
                tried.setTextAlignment(TextAlignment.LEFT);
            } else {
                arrCorrectlyGuessed.add(toFind);
                outputMsg = "You've guessed this number, well done!";
                guessed.setText(arrCorrectlyGuessed.toString());
                guessed.setTextAlignment(TextAlignment.LEFT);
                if (arrCorrectlyGuessed.size() == 10) {
                    App.showAlert(Alert.AlertType.INFORMATION, "Congratulations!", "You've won", "You guessed all 10 numbers well done!");
                    App.setRoot("Menu");
                }
            }
        } catch (Exception ex) {
            App.showAlert(Alert.AlertType.ERROR, "You've encountered an Error", "Error adding value to array", "Entry not valid, please only enter integers");
            numIn.clear();
            return;
        }
        numIn.clear();
        output.setText(outputMsg);
        output.setTextAlignment(TextAlignment.CENTER);
    }

    public void getRandArray() {
        arrToGuess.clear();
        Random random = new Random();
        do{
            int randomNum = random.nextInt(100)+1;
            System.out.println(arrToGuess.toString());
            if (arrToGuess.contains(randomNum)) {
                System.out.println(randomNum);
                getRandArray();
            } else {
                arrToGuess.add(randomNum);
            }
        }while(arrToGuess.size()!=10);
    }

    @FXML
    public void back() throws Exception {
        App.setRoot("Menu");
    }
}

