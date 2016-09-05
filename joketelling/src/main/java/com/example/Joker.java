package com.example;

import java.util.ArrayList;
import java.util.Random;

public class Joker {

    ArrayList<String> jokes = new ArrayList<>();

    public String getJoke() {
        return getRandomJoke();
    }

    public String getRandomJoke(){
        generateJokes();
        return selectJokeFromArray();
    }

    public void generateJokes(){
        jokes.add("There are 10 types of people in the world: those who understand binary, and those who don't.");
        jokes.add("How many programmers does it take to change a light bulb? \n" + "None. It's a hardware problem.");
        jokes.add("Why was the JavaScript developer sad? \n" + "Because he didn't Node how to Express himself");
        jokes.add("Why did the developer go broke? \n" + "Because he used up all his cache");
        jokes.add("I put so much more effort into naming my first Wi-Fi than my first child.");
    }

    public String selectJokeFromArray(){
        Random randomizer = new Random();
        String joke = jokes.get(randomizer.nextInt(jokes.size()));
        return joke;
    }
}
