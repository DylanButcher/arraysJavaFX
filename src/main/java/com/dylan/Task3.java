package com.dylan;

import javafx.fxml.FXML;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.util.Duration;

public class Task3 {

    public MediaPlayer mp;

    @FXML
    MediaView video;


    public void initialize() {
        App.controlMusic(false);
        mp = new MediaPlayer(App.getMedia("dance.mp4"));
        video.setMediaPlayer(mp);
        mp.setAutoPlay(true);
        mp.seek(Duration.ZERO);
    }


    public void back() throws Exception{
        mp.pause();
        App.setRoot("Menu");
    }
}
