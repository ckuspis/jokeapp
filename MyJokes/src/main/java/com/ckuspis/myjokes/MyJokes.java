package com.ckuspis.myjokes;

import java.util.Random;

public class MyJokes {

    private static String[] jokes = {
            "Some people wear Superman pajamas. Superman wears Chuck Norris pajamas.",
            "Chuck Norris once worked as a weatherman for the San Diego evening news. Every night he would make the same forecast: Partly cloudy with a 75% chance of Pain.",
            "Simply by pulling on both ends, Chuck Norris can stretch diamonds back into coal.",
            "When Chuck Norris does a pushup, he isn't lifting himself up, he's pushing the Earth down.",
            "Chuck Norris keeps his friends close and his enemies closer. Close enough to drop them with one round house kick to the face.",
            "There is in fact an 'I' in Norris, but there is no 'team'. Not even close.",
            "Scotty in Star Trek often says \"Ye cannae change the laws of physics.\" This is untrue. Chuck Norris can change the laws of physics. With his fists.",
            "Chuck Norris doesn't stub his toes. He accidentally destroys chairs, bedframes, and sidewalks.",
            "Chuck Norris roundhouse kicks don't really kill people. They wipe out their entire existence from the space-time continuum.",
            "Chuck Norris does not own a stove, oven, or microwave , because revenge is a dish best served cold.",
            "Tom Clancy has to pay royalties to Chuck Norris because \"The Sum of All Fears\" is the name of Chuck Norris' autobiography.",
            "Chuck Norris can slam a revolving door.",
            "If, by some incredible space-time paradox, Chuck Norris would ever fight himself, he'd win. Period."
    };


    public String getRandomJoke(){
        Random rng = new Random();

        int randomJokeNum = rng.nextInt(13);

        return jokes[randomJokeNum];
    }
}
