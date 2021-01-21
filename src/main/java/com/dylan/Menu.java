package com.dylan;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;


public class Menu {

    @FXML
    JFXToggleButton radio = new JFXToggleButton();
    public void initialize() {
        selectRadio();
    }
    public void selectRadio() {
        radio.setSelected(!App.mediaPlayer.isMute());
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
    public void musicToggle() {
        App.controlMusic(radio.isSelected());
    }

}
