package net.prison.net.backend.utils;

import java.util.Random;

public class Maths {

    public static int randInt(int min, int max) {

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }


}
