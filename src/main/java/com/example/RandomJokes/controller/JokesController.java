package com.example.RandomJokes.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class JokesController {

    ArrayList<String> jokesList=new ArrayList<>();

    @PostMapping(value = "/userjokes")
    public String savedJokes(@RequestBody String jokes){
        jokesList.add(jokes);
        return "saved Jokes";
    }

    @GetMapping(value="/check")
    public int checkize(){
        return jokesList.size();
    }
    @GetMapping(value = "/jokes")
    public String AddJokes(){
        jokesList.add(" What do you call a boomerang that won’t come back?\n" +
                "A stick.");
        jokesList.add("What does a cloud wear under his raincoat?\n" +
                "Thunderwear.");
        jokesList.add("Two pickles fell out of a jar onto the floor. What did one say to the other?\n" +
                "Dill with it.");
        jokesList.add("What time is it when the clock strikes 13?\n" +
                "Time to get a new clock.");
        jokesList.add("How does a cucumber become a pickle?\n" +
                "It goes through a jarring experience.");
        return "5 jokes added";
    }

    @DeleteMapping(value = "/deletejokes")
    public String deleteJokes(){
        jokesList.remove(0+(int)(Math.random() *((jokesList.size()-1 -0)+1)));
        return "jokes has been deleted";
    }
    @GetMapping(value = "/getjokes")
    public String getJokes(){
        int randomNumber=0+(int)(Math.random() *((jokesList.size()-1 -0)+1));
        return jokesList.get(randomNumber);
    }
    @PutMapping(value = "/updatejokes")
    public String updateJokes(){
        jokesList.add("UPDATED JOKE"+jokesList.get(0+(int)(Math.random() *((jokesList.size()-1 -0)+1))));
        return "jokes has been updated";
    }
}
