package com.dylan;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class App extends Application {

    static Stage stage;
    static MediaPlayer mediaPlayer;
    private static Scene scene;

    public App() {
        mediaPlayer = new MediaPlayer(getMedia("backgroundTune.mp3"));
        startMusic();
    }

    @Override
    public void start(Stage stage) throws IOException {
        stage.getIcons().add(new Image(App.class.getResourceAsStream("icon.png")));
        stage.setTitle("Array Tasks");
        App.stage = stage;
        scene = new Scene(loadFXML("Menu"), 400, 400);
        stage.setResizable(false);
        startMusic();
        stage.setScene(scene);
        stage.show();
    }

    public static Media getMedia(String fileName) {
        Media media = null;
        try {
            media = new Media(App.class.getResource(fileName).toString());
        } catch (Exception ex) {
            System.out.println("Error playing media");
        }
        return media;
    }

    public void startMusic() {
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.seek(Duration.INDEFINITE);
    }

    static void controlMusic(boolean play) {
        mediaPlayer.setMute(!play);
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    static void showAlert(Alert.AlertType type, String title, String header, String context) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(context);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }

}