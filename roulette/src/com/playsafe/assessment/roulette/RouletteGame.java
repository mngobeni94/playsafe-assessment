package com.playsafe.assessment.roulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class RouletteGame {

    public static void main(String[] args) {
        new RouletteGame().play();
    }

    private void play() {
        File file = new File("src/input1.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String name;
            while ((name = br.readLine()) != null) {
                System.out.print(name + " ");

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
