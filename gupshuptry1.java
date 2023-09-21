import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class gupshuptry1 {
    public static void main(String[] args) {
        // String input =  "players:tom,dick,harry,john;self:john;trump:c;dick:c2;tom:c5;harry:s3;cards:c1,c6,s3";
        String input = "players:tom,dick,harry,john;self:john;trump:c;dick:c2;tom:c5;harry:s3;cards:c1,c6,s3";
        // String input =
        // "players:tom,dick,harry,jhon;self:jhon;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha";
        // String input =
        // "players:tom,dick,harry,john;self:john;trump:s;dick:ca;tom:c10;harry:ck;cards:s3,s5,c3";

        String[] components = input.split(";");
        Map<String, String> componentsMap = new HashMap<>();
        for (String component : components) {
            String[] parts = component.split(":");
            componentsMap.put(parts[0].trim().toLowerCase(), parts[1].trim().toLowerCase());
        }

        String self = componentsMap.get("self");
        String trump = componentsMap.get("trump");
        String[] players = componentsMap.get("players").split(",");
        Map<String, String> cardsPlayed = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            if (!players[i].equals(self)) {
                String playerCard = componentsMap.get(players[i]);
                if (playerCard != null && !playerCard.isEmpty()) {
                    cardsPlayed.put(players[i], playerCard);
                }
            }
        }

        String selfCards = componentsMap.get("cards");

        // Determine the optimal card to be played
        String optimalCard = determineOptimalCard(self, trump, cardsPlayed, selfCards);
        System.out.println(optimalCard);

    }

    private static String determineOptimalCard(String self, String trump, Map<String, String> cardsPlayed,
            String selfCards) {
        Set<String> playersSet = cardsPlayed.keySet();
        String[] players = playersSet.toArray(new String[0]);

        char roundSuit = cardsPlayed.get(players[0]).charAt(0);
        // System.out.println(roundSuit);
         // Initialize highestCardInRoundSuit
         int highestCardInRoundSuit = 0;
         for (String card : cardsPlayed.values()) {
             if (card.charAt(0) == roundSuit) {
                 highestCardInRoundSuit = Math.min(highestCardInRoundSuit, getValueOfCard(card));
             }
         }

        // Initialize optimalSuit and optimalValue
        char optimalSuit = ' ';
        int optimalValue = Integer.MAX_VALUE;


        if (selfCards.contains(trump)) {
            // Play the smallest card of the trump suit
            for (String card : selfCards.split(",")) {
                if (card.charAt(0) == trump.charAt(0)) {
                    int cardValue = getValueOfCard(card);
                    if (cardValue < optimalValue) {
                        optimalValue = cardValue;
                        optimalSuit = card.charAt(0);
                    }
                }
            }
        } else {
            // Play the smallest card of the round suit that can win
            for (String card : selfCards.split(",")) {
                if (card.charAt(0) == roundSuit) {
                    int cardValue = getValueOfCard(card);
                    if (cardValue > highestCardInRoundSuit && cardValue < optimalValue) {
                        optimalValue = cardValue;
                        optimalSuit = roundSuit;
                    }
                }
            }
        }


        // Iterate through self's cards to find optimal card
        // for (String card : selfCards.split(",")) {
        //     char cardSuit = card.charAt(0);
        //     int cardValue = getValueOfCard(card);

        //     // Check if the card is of the round suit
        //     if (cardSuit == roundSuit) {
        //         if (cardValue > highestCardInRoundSuit && cardValue < optimalValue) {
        //             optimalValue = cardValue;
        //             optimalSuit = roundSuit;
        //         }
        //     } else if (cardSuit == trump.charAt(0)) {
        //         if (cardValue < optimalValue) {
        //             optimalValue = cardValue;
        //             optimalSuit = cardSuit;
        //         }
        //     } else {
        //         if (optimalSuit == ' ' && cardValue < optimalValue) {
        //             optimalValue = cardValue;
        //             optimalSuit = cardSuit;
        //         }
        //     }
        // }

        return optimalSuit + String.valueOf(optimalValue);
    }

    /*
     * public static String determineOptimalCard(String self, String trump,
     * Map<String, String> cardsPlayed,
     * String selfCards) {
     * Map<Character, Integer> highestCardsBySuit = new HashMap<>();
     * Set<String> playersSet = cardsPlayed.keySet();
     * String[] players = playersSet.toArray(new String[0]);
     * for (Map.Entry<String, String> entry : cardsPlayed.entrySet()) {
     * String card = entry.getValue();
     * char suit = card.charAt(0);
     * int value = getValueOfCard(card);
     * highestCardsBySuit.put(suit, Math.max(highestCardsBySuit.getOrDefault(suit,
     * 0), value));
     * }
     * 
     * char roundSuit = cardsPlayed.get(players[0]).charAt(0);
     * int highestCardInRoundSuit = highestCardsBySuit.getOrDefault(roundSuit, 0);
     * 
     * char optimalSuit = ' ';
     * int optimalValue = Integer.MAX_VALUE;
     * 
     * // Check if we have cards of the round suit
     * boolean hasRoundSuitCards = false;
     * for (String card : selfCards.split(",")) {
     * char cardSuit = card.charAt(0);
     * int cardValue = getValueOfCard(card);
     * 
     * if (cardSuit == roundSuit) {
     * hasRoundSuitCards = true;
     * if (cardValue > highestCardInRoundSuit && cardValue < optimalValue) {
     * optimalValue = cardValue;
     * optimalSuit = roundSuit;
     * }
     * }
     * else if (cardSuit == trump.charAt(0)) {
     * if (cardValue < optimalValue) {
     * optimalValue = cardValue;
     * optimalSuit = trump.charAt(0);
     * }
     * }
     * else if (optimalSuit == ' ' && cardValue < optimalValue) {
     * optimalValue = cardValue;
     * optimalSuit = cardSuit;
     * }
     * }
     * String cc = "";
     * if(optimalValue == 11)
     * cc = "j";
     * if(optimalValue == 12)
     * cc = "q";
     * if(optimalValue == 13)
     * cc = "k";
     * if(optimalValue == 14)
     * cc = "a";
     * return optimalSuit + cc;
     * // return optimalSuit + String.valueOf(optimalValue);
     * }
     */

   /*  private static int getHighestCardValue(Map<String, String> cardsPlayed, char suit) {
        int highestValue = 0;
        for (String card : cardsPlayed.values()) {
            if (card.charAt(0) == suit) {
                int cardValue = getValueOfCard(card);
                highestValue = Math.max(highestValue, cardValue);
            }
        }
        return highestValue;
    } */

    private static int getValueOfCard(String card) {
        char valueChar = card.charAt(1);
        switch (valueChar) {
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            case '1':
                return 10;
            case 'j':
                return 11;
            case 'q':
                return 12;
            case 'k':
                return 13;
            case 'a':
                return 14;
            default:
                return -1; // Invalid card
        }
    }
}
