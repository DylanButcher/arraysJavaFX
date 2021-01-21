package com.dylan;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;

import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

public class Task1 {

    @FXML
    Text outAvg;
    @FXML
    Text outMin;
    @FXML
    Text outMax;
    @FXML
    Text oddEven;
    @FXML
    Text showArrays;
    @FXML
    JFXTextField entries;

    public ArrayList<Integer> list = new ArrayList<>();

    @FXML
    public void addFile(){
        FileChooser fc = new FileChooser();
        File file = fc.showOpenDialog(App.stage);
        try {
            list.clear();
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String[] line = reader.readLine().split(",");
            for (String x:line) {
                list.add(Integer.parseInt(x));
            }
            showArrays.setText(list.toString());
            showArrays.setTextAlignment(TextAlignment.CENTER);
            calculateNew();
        } catch (Exception ex) {
            App.showAlert(Alert.AlertType.ERROR, "You've encountered an Error", "Error importing file", "Only allows text files with values seperated by commas");
        }
    }

    @FXML
    public void saveToFile(){
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("TEXT FILES", ".txt");
        fc.getExtensionFilters().add(filter);
        File saveTo = fc.showSaveDialog(App.stage);
        if(saveTo!=null){
            try{
                BufferedWriter writer = new BufferedWriter(new FileWriter(saveTo.toString(),false));
                writer.write(list.toString().substring(1,list.toString().length()-1).replaceAll("\\s+",""));
                writer.close();
            }catch (IOException ex){
                App.showAlert(Alert.AlertType.ERROR, "You've encountered an Error", "Error exporting file", "Could not save file");
            }
        }

    }

    @FXML
    public void add(ActionEvent ae) {
        try {
            list.add(Integer.valueOf(entries.getText()));
            entries.clear();
            calculateNew();
            showArrays.setText(list.toString());
            showArrays.setTextAlignment(TextAlignment.CENTER);
        } catch (Exception ex) {
            if(entries.getText().equals("Poggers")){
                try {
                    App.setRoot("Task3");
                } catch (IOException e) {
                    System.out.println("Not Pog");
                }
            }else{
                entries.clear();
                App.showAlert(Alert.AlertType.ERROR, "You've encountered an Error", "Error adding value to array", "Entry not valid, please only enter integers");

            }
        }
    }

    public void calculateNew() {
        newAverage();
        newMinMax();
        newOddEven();
    }

    public void newOddEven() {
        int even = 0;
        int odd = 0;
        for (int x : list) {
            if (x % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }
        oddEven.setText(odd + "/" + even);
        oddEven.setTextAlignment(TextAlignment.CENTER);
    }

    public void newMinMax() {
        ArrayList<Integer> x = list;
        Collections.sort(x);
        outMin.setText(String.valueOf(x.get(0)));
        outMax.setText(String.valueOf(x.get(x.size() - 1)));
        outMin.setTextAlignment(TextAlignment.CENTER);
        outMax.setTextAlignment(TextAlignment.CENTER);
    }

    public void newAverage() {
        DecimalFormat df = new DecimalFormat("0.00");
        double average = 0;
        for (int x : list) {
            average += x;
        }
        average = (average / list.size());
        outAvg.setText(df.format(average));
        outAvg.setTextAlignment(TextAlignment.CENTER);
    }

    @FXML
    public void clear() {
        oddEven.setText("");
        outAvg.setText("");
        outMin.setText("");
        outMax.setText("");
        list.clear();
        outAvg.setText("");
        entries.clear();
        showArrays.setText("");
    }

    @FXML
    public void back() throws Exception {
        App.setRoot("Menu");
    }

}
