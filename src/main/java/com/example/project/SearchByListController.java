package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchByListController extends Options {
    @FXML
    TextArea outputlist;
    public void OnShowListClick(ActionEvent event) {
        List<ProductionCompanyMovieCount> list = new ArrayList<ProductionCompanyMovieCount>(AllProductionCompanies());
        ProductionCompanyMovieCount m = new ProductionCompanyMovieCount();
        for (int i = 0; i < list.size(); i++) {
            m = list.get(i);
            outputlist.appendText("Production Company Name: " + m.getName() + "\nMovie count: " + m.getCount() + "\n\n\n");

        }

    }

    public void OnGoBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchProductionCompany.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Search By Production Company");
        stage.setScene(scene);
        stage.show();
    }
}
