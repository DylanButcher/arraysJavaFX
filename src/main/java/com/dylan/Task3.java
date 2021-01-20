package com.dylan;

import com.jfoenix.controls.JFXToggleButton;
import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class Task3 {

    public MediaPlayer mp;

    @FXML
    MediaView video;
    @FXML
    JFXToggleButton videoToggle;


    public void initialize() {
        App.controlMusic(false);
        mp = new MediaPlayer(App.getMedia("dance.mp4"));
        video.setMediaPlayer(mp);
    }

    public void playPause(){
        if(videoToggle.isSelected()){
            mp.play();
        }else{
            mp.pause();
        }
    }

    public void back() throws Exception{
        App.controlMusic(!App.mediaPlayer.isMute());
        App.setRoot("Menu");
    }
}
