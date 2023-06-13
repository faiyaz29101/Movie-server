package com.example.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovieList {
   static List<Movie> Movielist = new ArrayList<Movie>();
    static int size = 0;

    public void addmovie(String line){
        String[] words = line.split(",");
       // System.out.println(line);
        Movie x = new Movie();
        x.setName(words[0]);
        x.setReleaseyear(Integer.parseInt(words[1]));
        x.setGenre1(words[2]);
        x.setGenre2(words[3]);
        x.setGenre3(words[4]);
        x.setRunningTime(Integer.parseInt(words[5]));
        x.setProductionCompany(words[6]);
        x.setBudget(Long.parseLong(words[7]));
        x.setRevenue(Long.parseLong(words[8]));
        Movielist.add(x);
        //System.out.println(Movielist[1].getName());
        size++;
    }
    public int listsize(){
        return size;
    }
    public Movie details(int i){
        Movie m = new Movie();
        m = Movielist.get(i);
        return m;
    }
    public StringBuffer getMovieString(int i){
        Scanner s = new Scanner(System.in);
        StringBuffer string = new StringBuffer(Movielist.get(i).getName());
        string.append(",");
        string.append(String.valueOf(Movielist.get(i).getReleaseyear()));
        string.append(",");
        string.append(Movielist.get(i).getGenre1());
        string.append(",");
        string.append(Movielist.get(i).getGenre2());
        string.append(",");
        string.append(Movielist.get(i).getGenre3());
        string.append(",");
        string.append(String.valueOf(Movielist.get(i).getRunningTime()));
        string.append(",");
        string.append(Movielist.get(i).getProductionCompany());
        string.append(",");
        string.append(String.valueOf(Movielist.get(i).getBudget()));
        string.append(",");
        string.append(String.valueOf(Movielist.get(i).getRevenue()));
        return string;

    }
}
