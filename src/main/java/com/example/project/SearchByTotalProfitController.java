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

public class SearchByTotalProfitController extends Options {

    @FXML
    TextArea totalprofit;

    public void OnGoBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchProductionCompany.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Search By Production Company");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        long profit = CheckTotalProfit(Productioncompany);

            totalprofit.appendText("Production Company Name: " + Productioncompany+ "\nTotal Profit: " + profit + "\n\n");

    }
}
