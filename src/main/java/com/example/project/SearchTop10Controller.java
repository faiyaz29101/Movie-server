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

public class SearchTop10Controller extends Options {
    @FXML
    TextArea top;


    public void OnGoBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchByMovie.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Search By Movie");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        Movie m = new Movie();
        List<Movie> copy = new ArrayList<Movie>(SearchTop10());
        for (int i = 0; i < copy.size(); i++) {
            m = copy.get(i);
            top.appendText("Movie position: " + (i+1) + "\n");
            top.appendText("Movie name: " + m.getName() + "\nReleasing Year: " + m.getReleaseyear() + "\nGenre: " + m.getGenre1() + ", " + m.getGenre2() + ", " + m.getGenre3() + "\nRunning Time: " + m.getRunningTime() + " minutes" + "\nProduction Company: " + m.getProductionCompany() + "\nBudget: " + m.getBudget() + ", Revenue: " + m.getRevenue() + "\n\n\n");

            //outputtop10.appendText(" ");
        }
    }
}
