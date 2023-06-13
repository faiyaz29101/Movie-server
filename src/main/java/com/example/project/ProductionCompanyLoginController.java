package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProductionCompanyLoginController extends Options{
    @FXML
    TextField inputproductioncompanyname;
    @FXML
    Label prompt;


    public void OnLogInClick(ActionEvent event) throws IOException {
        String temp = inputproductioncompanyname.getText();
        Movie m = new Movie();

            for (int i = 0; i < size; i++) {

                m = details(i);
                if (m.getProductionCompany().equalsIgnoreCase(temp)) {
                    setProductioncompany(temp);
                    Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("SearchProductionCompany.fxml"));
                    Scene scene = new Scene(fxmlLoader.load(), 400, 500);
                    stage.setTitle("Search By Production Company");
                    stage.setScene(scene);
                    stage.show();
                    break;
                } else if (i == size - 1) {
                    prompt.setText("Invalid Input. Try Again");
                }
            }


    }


    public void OnGoBackClick(ActionEvent event) throws IOException{
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
