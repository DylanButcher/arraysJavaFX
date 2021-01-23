package com.dylan;

import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;


public class Menu {

    @FXML
    AnchorPane background;

    public void initialize(){
        background.setStyle("-fx-background-color: "+App.backgroundColour);
    }

    @FXML
    public void goTask1() throws Exception {
        App.setRoot("Task1");
    }

    @FXML
    public void goTask2() throws Exception {
        App.setRoot("Task2");
    }

    @FXML
    public void brexit() {
        System.exit(0);
    }

    @FXML
    public void goSettings() throws Exception{
        App.setRoot("Settings");
    }


}
