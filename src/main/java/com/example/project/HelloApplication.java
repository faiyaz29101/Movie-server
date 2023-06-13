package com.example.project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class HelloApplication extends Application {
    private static final String INPUT_FILE_NAME = "movies.txt";
    private static final String OUTPUT_FILE_NAME = "out.txt";
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("MainMenu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 500);
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME));
        //List<Movie> MovieList = new ArrayList();
        MovieList movielist = new MovieList();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            movielist.addmovie(line);
        }
        br.close();
        Options p = new Options();
        launch();
        BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
        for(int i = 0; i<movielist.listsize(); i++) {
            StringBuffer tex = movielist.getMovieString(i);
            String text = tex.toString();
            bw.write(text);
            bw.write(System.lineSeparator());
        }
        bw.close();
    }
}