package com.example.project;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Options extends MovieList {
        static int menu1 = -1, menu2 = -1;
        static int mainmenu = -1;

        static MovieList list;

        static String Productioncompany;


        public void Optionscontrol() {
                Scanner sc = new Scanner(System.in);
                mainmenu = 1;
                while (mainmenu > 0 && mainmenu < 5) {
                        System.out.println("Main menu:\n1) Search Movies\n2) Search Production Companies\n3) Add Movie\n4) Exit System");
                        System.out.println("Choose from option 1-4");
                        mainmenu = sc.nextInt();
                        inner: while (mainmenu == 1) {
                                System.out.println("Movie Searching Option\n1) By Movie Title\n2) By Release Year\n3) By Genre\n4) By Production Company\n5) By Running Time\n6) Top 10 Movies\n7) Back to Main Menu");
                                menu1 = sc.nextInt();
                                if (menu1 == 1) {
                                        System.out.println("Input movie name");
                                        Scanner sp = new Scanner(System.in);
                                        String name = sp.nextLine();
                                        Movie m = new Movie();
                                        m = SearchByMovieTitle(name);
                                       if(m.getName().equals("NOMOVIE")){
                                               System.out.println("No such movie with this name");
                                       }
                                       else{
                                               m.show();
                                       }
                                } else if (menu1 == 2) {
                                        System.out.println("Input release year");
                                        int y = sc.nextInt();
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(SearchByReleaseYear(y));
                                        if(copy.size()==0){
                                                System.out.println("No such movie in this year");
                                        }
                                        else {
                                                for (int i = 0; i < copy.size(); i++) {
                                                        m = copy.get(i);
                                                        m.show();
                                                }
                                        }


                                } else if (menu1 == 3) {
                                        System.out.println("Input genre");
                                        Scanner sp = new Scanner(System.in);
                                        String gen = sp.nextLine();
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(SearchByGenre(gen));
                                        if(copy.size()==0){
                                                System.out.println("No such movie with this genre");
                                        }
                                        else {
                                                for (int i = 0; i < copy.size(); i++) {
                                                        m = copy.get(i);
                                                        m.show();
                                                }
                                        }
                                } else if (menu1 == 4) {
                                        System.out.println("Input production company");
                                        Scanner sp = new Scanner(System.in);
                                        String procomp = sp.nextLine();
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(SearchByProductionCompany(procomp));
                                        if(copy.size()==0){
                                                System.out.println("No such movie with this production company");
                                        }
                                        else {
                                                for (int i = 0; i < copy.size(); i++) {
                                                        m = copy.get(i);
                                                        m.show();
                                                }
                                        }

                                } else if (menu1 == 5) {
                                        System.out.println("Input minimum duration");
                                        int t1 = sc.nextInt();
                                        System.out.println("Input maximum duration");
                                        int t2 = sc.nextInt();
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(SearchByRunningTime(t1, t2));
                                        if(copy.size()==0){
                                                System.out.println("No such movie with this duration");
                                        }
                                        else {
                                                for (int i = 0; i < copy.size(); i++) {
                                                        m = copy.get(i);
                                                        m.show();
                                                }
                                        }
                                } else if (menu1 == 6) {
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(SearchTop10());
                                        for (int i = 0; i < copy.size(); i++) {
                                                m = copy.get(i);
                                                System.out.println("Movie position: " + (i+1));
                                                m.show();
                                                System.out.println(" ");
                                        }
                                } else if (menu1 == 7) {
                                        break inner;
                                }
                                else if(menu1 < 1 || menu1 > 7){
                                        System.out.println("Invalid Input. Try Again");
                                }
                        }
                 inner: while (mainmenu == 2) {
                                System.out.println("Production Company Searching Options:\n1) Most Recent Movies\n2) Movies with the Maximum Revenue\n3) Total Profit\n4) List of Production Companies and the Count of their Produced Movies\n5) Back to Main Menu");
                                Scanner st = new Scanner(System.in);
                                menu2 = st.nextInt();
                                if(menu2 == 1) {
                                        System.out.println("Input Production Company");
                                        Scanner sp = new Scanner(System.in);
                                        String t = sp.nextLine();
                                        Movie m = new Movie();
                                        List<Movie> copy = new ArrayList<Movie>(CheckByProductionCompanyYear(t));
                                        if(copy.size()==0){
                                                System.out.println("No such movie with this production company");
                                        }
                                        else {
                                                for (int i = 0; i < copy.size(); i++) {
                                                        m = copy.get(i);
                                                        m.show();
                                                }
                                }
                                }

                                else if(menu2 == 2){
                                        System.out.println("Input Production Company");
                                        Scanner sp = new Scanner(System.in);
                                        String t = sp.nextLine();
                                        Movie m = new Movie();
                                        m = CheckByProductionCompanyRevenue(t);
                                        m.show();
                                }
                                else if(menu2 == 3){
                                        System.out.println("Input Production Company");
                                        Scanner sp = new Scanner(System.in);
                                        String t = sp.nextLine();
                                        long total = CheckTotalProfit(t);
                                        if(total !=0) {
                                                System.out.println("Total profit: " + total);
                                        }
                                        else{
                                                System.out.println("No such production company with this name");
                                        }
                                }
                                else if(menu2 == 4){
                                        List <ProductionCompanyMovieCount> list = new ArrayList<ProductionCompanyMovieCount>(AllProductionCompanies());
                                        ProductionCompanyMovieCount m = new ProductionCompanyMovieCount();
                                        for (int i = 0; i < list.size(); i++) {
                                                m = list.get(i);
                                                m.show();
                                        }


                                }
                                else if(menu2 == 5){
                                        break inner;
                                }
                                else if(menu1 < 1 || menu1 > 5){
                                        System.out.println("Invalid Input. Try Again");
                                }

                        }
                 while(mainmenu == 3){
                         AddNewMovie();
                         break;
                 }
                 while(mainmenu == 4){
                         break;
                 }
                if(mainmenu == 4) {
                        break;
                }
                }

        }

        public Movie SearchByMovieTitle(String MovieName) {
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {

                        m = details(i);
                        if (MovieName.equalsIgnoreCase(m.getName())) {
                                break;
                        } else if (i == size - 1) {
                                m.setName("NOMOVIE");
                        }
                }
                return m;

        }

        public List<Movie> SearchByReleaseYear(int year) {
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {

                        m = details(i);
                        if (year == m.getReleaseyear()) {
                                list.add(m);
                        } else if (i == size) {
                                m.setName("NOMOVIE");
                        }
                }
                return list;
        }

        public List<Movie> SearchByGenre(String gen) {
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (gen.equalsIgnoreCase(m.getGenre1())) {
                                list.add(m);
                        } else if (gen.equalsIgnoreCase(m.getGenre2())) {
                                list.add(m);
                        } else if (gen.equalsIgnoreCase(m.getGenre3())) {
                                list.add(m);
                }
        }
                return list;
        }

        public List<Movie> SearchByProductionCompany(String Procomp) {
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (Procomp.equalsIgnoreCase(m.getProductionCompany())) {
                                list.add(m);
                        }
                }
                return list;
        }

        public List<Movie> SearchByRunningTime(int t1, int t2) {
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (m.getRunningTime() > t1 && m.getRunningTime() < t2) {
                                list.add(m);
                        }
                }
                return list;
        }

        public List<Movie> SearchTop10() {
                int[] no = new int[size];
                for (int i = 0; i < size; i++) {
                        no[i] = i;
                }
                for (int i = 0; i < size; i++) {
                        Movie m = new Movie();
                        m = details(no[i]);
                        long l1 = m.getRevenue() - m.getBudget();
                        for (int j = 1; j < size; j++) {
                                Movie n = new Movie();
                                n = details(no[j]);
                                long l2 = n.getRevenue() - n.getBudget();
                                if (l1 < l2) {
                                        int t = no[i];
                                        no[i] = no[j];
                                        no[j] = t;
                                        j = 1;
                                        m = details(no[i]);
                                        l1 = m.getRevenue() - m.getBudget();
                                }
                        }
                }
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < 10; i++) {
                        m = details(no[i]);
                        list.add(m);

                }
                return list;
        }

        public List<Movie> CheckByProductionCompanyYear(String y) {
                int year = 0;
                List<Movie> list = new ArrayList<Movie>();
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (y.equalsIgnoreCase(m.getProductionCompany())) {
                                year = m.getReleaseyear();
                                System.out.println(year);
                                break;
                        }
                }
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if ((y.equalsIgnoreCase(m.getProductionCompany())) && (year < m.getReleaseyear())){
                                year = m.getReleaseyear();
                        }

                }
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (y.equalsIgnoreCase(m.getProductionCompany()) && year == m.getReleaseyear()){
                                list.add(m);
;                        }

                }
                return list;
        }
        public Movie CheckByProductionCompanyRevenue(String name){
                long revenue = 0;
                Movie m = new Movie();
                for (int i = 0; i < size; i++) {
                        m = details(i);
                        if (name.equalsIgnoreCase(m.getProductionCompany())) {
                                revenue = m.getRevenue();

                                break;
                        }
                        else if(!name.equalsIgnoreCase(m.getProductionCompany()) && i == size - 1 ){
                                m.setName("NOMOVIE");
                        }
                }
                System.out.println(m.getName());
                if(!m.getName().equalsIgnoreCase("NOMOVIE")) {
                        for (int i = 0; i < size; i++) {
                                m = details(i);
                                if (name.equalsIgnoreCase(m.getProductionCompany()) && revenue < m.getRevenue()) {
                                        revenue = m.getRevenue();
                                }

                        }
                        for (int i = 0; i < size; i++) {

                                m = details(i);
                                if (name.equalsIgnoreCase(m.getProductionCompany()) && revenue == m.getRevenue()) {
                                        break;
                                }

                        }
                }
                return m;
        }
        public long CheckTotalProfit(String name){
                long total = 0;
                int i = 0;
                Movie m = new Movie();
                m = details(0);
                for(; i < size; i++){
                        m = details(i);
                        if(name.equalsIgnoreCase(m.getProductionCompany())){
                                total += m.getRevenue() - m.getBudget();
                        }
                }
                if(!name.equalsIgnoreCase(m.getProductionCompany()) && i == size && total == 0){
                        total = 0;
                }
                return total;

        }
        public List<ProductionCompanyMovieCount> AllProductionCompanies(){
                List<String> Production = new ArrayList<String>();
                Production.add(Movielist.get(0).getProductionCompany());
                for(int i = 0; i < Movielist.size(); i++)
                {
                        if(Production.indexOf(Movielist.get(i).getProductionCompany()) == -1){
                                Production.add(Movielist.get(i).getProductionCompany());
                        }
                }
                int count = 0;
                List<ProductionCompanyMovieCount> list = new ArrayList<ProductionCompanyMovieCount>();
                for(int i = 0; i < Production.size(); i++){
                        for(int j = 0; j < Movielist.size(); j++){
                                if(Production.get(i).equalsIgnoreCase(Movielist.get(j).getProductionCompany())){
                                        count++;
                                }
                        }
                        ProductionCompanyMovieCount m = new ProductionCompanyMovieCount();
                        m.setCount(count);
                        m.setName(Production.get(i));
                        list.add(m);
                        count = 0;
                }
                return list;

        }
        public void AddNewMovie()
        {
                Scanner s = new Scanner(System.in);
                System.out.println("Please Input Movie Name");
                String name = s.nextLine();
                StringBuffer string = new StringBuffer(name);
                string.append(",");
                System.out.println("Please Input Release Year");
                String year = s.nextLine();
                string.append(year);
                System.out.println("Please Input First Genre");
                string.append(",");
                String gen1 = s.nextLine();
                string.append(gen1);
                string.append(",");
                System.out.println("Please Input Second Genre. Use whitespace if there is not any");
                String gen2 = s.nextLine();
                if(!gen2.equalsIgnoreCase(" ")){
                string.append(gen2);
                }
                string.append(",");
                System.out.println("Please Input Third Genre. Use whitespace if there is not any");
                String gen3 = s.nextLine();
                if(!gen3.equalsIgnoreCase(" ")){
                        string.append(gen3);
                }
                string.append(",");
                System.out.println("Please Input Running Time");
                String time = s.nextLine();
                string.append(time);
                string.append(",");
                System.out.println("Please Input Production Company");
                String comp = s.nextLine();
                string.append(comp);
                string.append(",");
                System.out.println("Please Input Budget");
                String budget = s.nextLine();
                string.append(budget);
                string.append(",");
                System.out.println("Please Input Revenue");
                String revenue = s.nextLine();
                string.append(revenue);
                String str = string.toString();
                System.out.println(str);
                addmovie(str);
        }

        public static void setProductioncompany(String productioncompany) {
                Productioncompany = productioncompany;
        }

        public Movie transfermovie(String moviename, String oldproductioncompany, String newproductioncompany){
                Movie m = new Movie();
                for(int i = 0; i < size; i++){
                        m = details(i);
                        if(m.getName().equalsIgnoreCase(moviename) && m.getProductionCompany().equalsIgnoreCase(oldproductioncompany)){
                                m.setProductionCompany(newproductioncompany);
                                break;
                        }
                        else if(i == size - 1){
                                m.setName("NOMOVIE");
                        }
                }
                return m;
        }
}
