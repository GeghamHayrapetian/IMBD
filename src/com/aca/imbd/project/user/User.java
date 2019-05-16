package com.aca.imbd.project.user;

import com.aca.imbd.project.kino.Kino;
import com.aca.imbd.repository.Repository;
import java.io.IOException;
import java.io.Serializable;
import java.util.Scanner;

public class User implements Serializable {
    private String username;
    private String password;
    public Integer id = 0;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        ++id;
    }

    private Repository<Integer, User> repository = new Repository<>("C:\\Users\\Gexam\\IdeaProjects\\Imbd\\files\\users.txt");

    public User() {

    }


    public boolean registration(String username, String password) {
        if (checkName(username)) {
            User user = new User(username, password);
            repository.put(id, user);
        }
        return true;

    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean checkName(String username) {
        boolean flag = true;
        for (int i = 0; i <= id; ++i) {
            try {
                if (repository.get(i).getUsername().equals(username)) {
                    System.out.println("Username is already taken");
                    flag = false;
                    break;


                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            catch (NullPointerException e)
            {
                return true;
            }
        }
        return flag;

    }


    public void rate(Double rate) {
        Kino kino = new Kino();
        Scanner scan = new Scanner(System.in);
        System.out.println("Write name of film");
        String name = scan.nextLine();
        kino.searchKinoByTitle(name).setRating(rate);

    }


}

