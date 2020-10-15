package com.playsafe.assessment.roulette;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

public class RouletteGame {

    public static void main(String[] args) {
        new RouletteGame().play();
    }

    private void play() {
        File file = new File("src/input1.txt");
        Random random = new Random();

        int number = random.nextInt(36) + 1;
        try (BufferedReader br = new BufferedReader(new FileReader(file));
             Scanner scanner = new Scanner(System.in)) {
            Map<String, List<String>> betsMap = new HashMap<>();
            System.out.println("Please enter bets for each person");
            String name;
            while ((name = br.readLine()) != null) {
                System.out.print(name + " ");
                String bet = scanner.nextLine();
                if (Objects.isNull(betsMap.get(name))) {
                    List<String> bets = new ArrayList<>();
                    bets.add(bet);
                    betsMap.put(name, bets);
                } else {
                    betsMap.get(name).add(bet);
                }
            }
            showResults(betsMap, number);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showResults(Map<String, List<String>> betsMap, int number) {
        System.out.println("Number: " + number);
        System.out.println("Player \t\tBet\t\tOutcome\t\tWinnings");
        betsMap.forEach((name, bets) -> {
            System.out.println(name);
            bets.forEach(betLine -> {
                StringTokenizer st = new StringTokenizer(betLine, " ");
                String bet = st.nextToken();
                BigDecimal amount = new BigDecimal(st.nextToken());
                getAmountWon(number, bet, amount);
                BigDecimal amountWon = getAmountWon(number, bet, amount);
                String outcome = amountWon.doubleValue() > 0 ? "WIN" : "LOSE";
                System.out.println("\t\t\t" + bet + "\t\t" + outcome + "\t\t" + amountWon.doubleValue());
            });
        });
    }

    private BigDecimal getAmountWon(int number, String bet, BigDecimal amount) {
        switch (bet) {
            case "EVEN":
                if (number % 2 == 0)
                    return new BigDecimal(amount.doubleValue() * 2);
                break;
            case "ODD":
                if (number % 2 != 0)
                    return new BigDecimal(amount.doubleValue() * 2);
                break;
            default:
                if(Integer.parseInt(bet) == number)
                    return new BigDecimal(amount.doubleValue() * 36);
        }
        return BigDecimal.ZERO;
    }
}
