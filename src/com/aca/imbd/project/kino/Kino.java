package com.aca.imbd.project.kino;
import com.aca.imbd.project.people.People;
import com.aca.imbd.repository.Repository;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public   class Kino implements Serializable {
    private String title;
    private String description;
    private Double rating;
    private LocalDate premierDate;
    private List <? extends People> team=new ArrayList<>();
    private Genre genre;
    private Repository <Integer,Kino> repository=new Repository<>("kino.txt");
    public  Integer id=0;

    public Kino(String title, Double rating) {
        this.title = title;
        this.rating = rating;
        ++id;
        this.addKino(id,this);
    }

    public Kino(String title, String description, Double rating, LocalDate premierDate, List<? extends People> team, Genre genre) {
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.premierDate = premierDate;
        this.team = team;
        this.genre = genre;
        ++id;

    }

    public Kino() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating += rating;
    }

    public LocalDate getPremierDate() {
        return premierDate;
    }

    public void setPremierDate(LocalDate premierDate) {
        this.premierDate = premierDate;
    }

    public List<? extends People> getTeam() {
        return team;
    }

    public void setTeam(List<? extends People> team) {
        this.team = team;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public String getTeamString()
    {
        String team1=null;
        for (People people:team
             ) {
            team1 ="" +people.getProfession()+people.getNameSurname()+"\n" ;

        }
        return team1;
    }
    public void addKino(Integer id, Kino kino)
    {
        repository.put(this.id,kino);

    }
    public Kino searchKinoByTitle(String title)
    {
        Kino kino;
        for (int i=0;i<=id;++i) {
            try {
                kino =repository.get(i);
                if(kino.getTitle().equals(title))
                {
                    return kino;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    public ArrayList<Kino> searcKinpByDates(LocalDate dateFrom,LocalDate dateTo)
    {
        List<Kino> kino=new ArrayList<>();

        for (int i=0;i<=id;++i)
        {
            try {
                if (repository.get(i).getPremierDate().compareTo(dateFrom)!=-1&&repository.get(i).getPremierDate().compareTo(dateTo)!=-1)
                {
                    kino.add(repository.get(i));


                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return (ArrayList<Kino>) kino;

    }
    public String toString ()
    {
        return "Title :" +title+ "\n"+ "Description :" +description+ "\n" +"Rating :" + rating+"\n" +" Premier" + premierDate+"\n" + "Genre :"+"\n" + genre+this.getTeamString()+"\n";
    }
}