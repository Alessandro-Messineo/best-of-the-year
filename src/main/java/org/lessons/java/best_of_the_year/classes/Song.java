package org.lessons.java.best_of_the_year.classes;

public class Song {

    private int id;
    private String titolo;

    public Song(){}

    public Song(int id, String titolo){
        this.id = id;
        this.titolo = titolo;
    }

    public int getId(){
        return id;
    }

    public String getTitolo(){
       return titolo;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitolo(String titolo){
        this.titolo = titolo;
    }

}
