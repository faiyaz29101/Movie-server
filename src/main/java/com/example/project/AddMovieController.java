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
import java.util.Scanner;

public class AddMovieController extends Options{
    @FXML
    TextField title;
    @FXML
    TextField year;
    @FXML
    TextField Genre1;
    @FXML
    TextField Genre2;
    @FXML
    TextField Genre3;
    @FXML
    TextField time;
    @FXML
    TextField productioncompany;
    @FXML
    TextField budget;
    @FXML
    TextField revenue;
    @FXML
    TextArea newmovieoutput;


    public void OnGoBackClick(ActionEvent event) throws IOException {
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }


    public void OnSubmitClick(ActionEvent event) {
        String name = title.getText();
        StringBuffer string = new StringBuffer(name);
        string.append(",");
        String y = year.getText();
        string.append(y);
        string.append(",");
        String gen1 = Genre1.getText();
        string.append(gen1);
        string.append(",");
        String gen2 = Genre2.getText();
        string.append(gen2);
        string.append(",");
        String gen3 = Genre3.getText();
        string.append(gen3);
        string.append(",");
        String t = time.getText();
        string.append(t);
        string.append(",");
        String comp = productioncompany.getText();
        string.append(comp);
        string.append(",");
        String bud = budget.getText();
        string.append(bud);
        string.append(",");
        String rev = revenue.getText();
        string.append(rev);
        String str = string.toString();
        System.out.println(str);
        addmovie(str);
        Movie m = new Movie();
        m = details(size-1);
        newmovieoutput.setText("Movie name: " + m.getName() + "\nReleasing Year: " + m.getReleaseyear() + "\nGenre: " + m.getGenre1() + ", " + m.getGenre2() + ", " + m.getGenre3() + "\nRunning Time: " + m.getRunningTime() + " minutes" + "\nProduction Company: " + m.getProductionCompany() + "\nBudget: " + m.getBudget() + ", Revenue: " + m.getRevenue());

    }
}
