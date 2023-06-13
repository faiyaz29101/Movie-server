package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchByRunningTimeController extends Options {

    @FXML
    TextField mintime;
    @FXML
    TextField maxtime;
    @FXML
    TextArea outputruntime;

    public void OnSearchClick(ActionEvent event) {
        Movie m = new Movie();
        List<Movie> copy = new ArrayList<Movie>(SearchByRunningTime(Integer.parseInt(mintime.getText()), Integer.parseInt(maxtime.getText())));
        if(copy.size()==0){
            outputruntime.setText("No such movie with this running time range");
        }
        else {
            for (int i = 0; i < copy.size(); i++) {
                m = copy.get(i);
                outputruntime.appendText("Movie name: " + m.getName() + "\nReleasing Year: " + m.getReleaseyear() + "\nGenre: " + m.getGenre1() + ", " + m.getGenre2() + ", " + m.getGenre3() + "\nRunning Time: " + m.getRunningTime() + " minutes" + "\nProduction Company: " + m.getProductionCompany() + "\nBudget: " + m.getBudget() + ", Revenue: " + m.getRevenue() + "\n\n\n");

            }
        }
    }

    public void OnGoBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchByMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Search By Movie");
        stage.setScene(scene);
        stage.show();
    }
}
