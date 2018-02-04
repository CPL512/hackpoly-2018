package com.example.hmku.data;

import java.util.*;

/**
 * Generates results for the user based on mood.
 */

public class Generator {

    private final String REGEX = " \\| ";

    private Random rng;

    public Generator() {
        rng = new Random();
    }

    public String[] process(String mood) throws IllegalArgumentException {

        mood = mood.toLowerCase(); // prevent case errors

        switch (mood) {
            case "happy":
                return generate(Data.HAPPY_VERSES, Data.HAPPY_SONGS);
            case "sad":
                return generate(Data.SAD_VERSES, Data.SAD_SONGS);
            case "angry":
                return generate(Data.ANGRY_VERSES, Data.ANGRY_SONGS);
            case "stressed":
                return generate(Data.STRESSED_VERSES, Data.STRESSED_SONGS);
            case "burntout":
                return generate(Data.BURNTOUT_VERSES, Data.BURNTOUT_SONGS);
            case "ashamed":
                return generate(Data.ASHAMED_VERSES, Data.ASHAMED_SONGS);
            case "jealous":
                return generate(Data.JEALOUS_VERSES, Data.JEALOUS_SONGS);
            case "insecure":
                return generate(Data.INSECURE_VERSES, Data.INSECURE_SONGS);
        }

        // should never happen
        throw new IllegalArgumentException("Invalid mood!");

    }

    public String[] generate(String[] verses, String[] songs) {

        int index;
        String temp;
        String[] temparr;

        // result contains reference, text, title, author, link, description, link
        String[] result = new String[5];

        // parse verse info
        index = rng.nextInt(verses.length);
        temp = verses[index];
        temparr = temp.split(REGEX);
        result[0] = temparr[0];
        result[1] = temparr[1];

        // parse song info
        index = rng.nextInt(songs.length);
        temp = songs[index];
        temparr = temp.split(REGEX);
        result[2] = temparr[0];
        result[3] = temparr[1];
        result[4] = temparr[2];

        return result;

    }

}
