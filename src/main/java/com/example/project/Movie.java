package com.example.project;

public class Movie {
    private String Name;
    private int Releaseyear;
    private String Genre1, Genre2, Genre3;
    private String ProductionCompany;
    private int RunningTime;
    private long  Budget, Revenue;

    public void setName(String name) {
        Name = name;
    }

    public void setReleaseyear(int releaseyear) {
        Releaseyear = releaseyear;
    }

    public void setProductionCompany(String productionCompany) {
        ProductionCompany = productionCompany;
    }

    public void setBudget(long budget) {
        Budget = budget;
    }

    public void setGenre1(String genre1) {
        Genre1 = genre1;
    }

    public void setGenre2(String genre2) {
        Genre2 = genre2;
    }

    public void setGenre3(String genre3) {
        Genre3 = genre3;
    }

    public void setRevenue(long revenue) {
        Revenue = revenue;
    }

    public void setRunningTime(int runningTime) {
        RunningTime = runningTime;
    }

    public String getName() {
        return Name;
    }

    public int getReleaseyear() {
        return Releaseyear;
    }

    public int getRunningTime() {
        return RunningTime;
    }

    public long getBudget() {
        return Budget;
    }

    public long getRevenue() {
        return Revenue;
    }

    public String getGenre1() {
        return Genre1;
    }

    public String getGenre2() {
        return Genre2;
    }

    public String getGenre3() {
        return Genre3;
    }

    public String getProductionCompany() {
        return ProductionCompany;
    }
    public void show()
    {
        System.out.println("Movie Name: " + getName());
        System.out.println("Releasing Year: " + getReleaseyear());
        System.out.println("Genre: "+ getGenre1() + ", " + getGenre2() + ", " + getGenre3());
        System.out.println("Running Time: " + getRunningTime() + " minutes");
        System.out.println("Production Company: " + getProductionCompany());
        System.out.println("Budget: " + getBudget() + ", Revenue: " + getRevenue());



    }
}
