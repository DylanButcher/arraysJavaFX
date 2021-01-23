package com.dylan;

import com.jfoenix.controls.JFXColorPicker;
import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Settings {

    @FXML
    AnchorPane background;
    @FXML
    JFXColorPicker colourWheel;

    @FXML
    JFXToggleButton radio = new JFXToggleButton();

    public void initialize() {
        selectRadio();
        background.setStyle(App.getBackgroundColour());
    }

    public void selectRadio() {
        radio.setSelected(!App.mediaPlayer.isMute());
    }


    @FXML
    public void changeColour() {
        App.backgroundColour = "#" + colourWheel.getValue().toString().substring(2);
        background.setStyle("-fx-background-color: " + App.backgroundColour);
    }

    @FXML
    public void musicToggle() {
        App.controlMusic(radio.isSelected());
    }

    @FXML
    public void back() throws Exception {
        App.setRoot("Menu");
    }


}
