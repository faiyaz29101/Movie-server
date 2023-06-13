package com.example.project;

public class ProductionCompanyMovieCount {
    private String name;
    private int count;
    public String getName(){
            return name;
    }
    public int getCount(){
            return count;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void show(){
            System.out.println("Production Company: " + getName());
            System.out.println("Total Movie: "+ getCount());
    }


}
