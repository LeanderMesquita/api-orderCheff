package com.llm.orderCheff.utils;

import java.util.Random;

public class Randomizer {

    public static String generateRegistration() {
        return "M" + String.format("%06d", new Random().nextInt(1_000_000));
    }

}
