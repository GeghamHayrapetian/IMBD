package com.aca.imbd.project.kino;

import com.aca.imbd.project.people.People;
import com.aca.imbd.repository.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class Serial extends Kino implements Serializable {
    private Map<Integer, Integer> seasonsAndEpisods;
    public Integer id=0;
    private Repository<Integer,Serial> repository=new Repository<>("C:\\Users\\Gexam\\IdeaProjects\\Main\\files\\serials.txt");

    public Serial(String title, String description, Double rating, LocalDate premierDate, List<? extends People> team, Genre genre, Map<Integer, Integer> seasonsAndEpisods) {
        super(title, description, rating, premierDate, team, genre);
        this.seasonsAndEpisods = seasonsAndEpisods;
        ++id;
    }

    public Map<Integer, Integer> getSeasonsAndEpisods() {
        return seasonsAndEpisods;
    }

    public void setSeasonsAndEpisods(Map<Integer, Integer> seasonsAndEpisods) {
        this.seasonsAndEpisods = seasonsAndEpisods;
    }

    public Serial() {
    }
}

