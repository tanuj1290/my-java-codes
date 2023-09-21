import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * gup1
 */
public class gup1 {
    private static final Map<String, Integer> suitMap = new HashMap<>();

    static String self = null;
    static String trumpSuit = null;
    static {
        suitMap.put("s", 1);
        suitMap.put("h", 2);
        suitMap.put("d", 3);
        suitMap.put("c", 4);
    }
    public static String getOptimalCard(String input) {
        String[] components = input.split(";");
        Map<String, String> playerCards = new HashMap<>();
        
        
        for (String component : components) {
            String[] keyValue = component.split(":");
            String key = keyValue[0];
            String value = keyValue[1];
            switch (key) {
                case "players":
                    String[] players = value.split(",");
                    self = players[players.length - 1];
                    break;
                case "cards":
                    playerCards.put(self, value);
                    break;
                case "trump":
                    trumpSuit = value;
                    break;
                default:
                    playerCards.put(key, value);
            }
        }
    
        // Get the highest card played so far.
        String highestCard = null;
        int highestCardValue = 0;
        for (String playerCard : playerCards.values()) {
            if (playerCard != null && playerCard.startsWith(trumpSuit)) {
                int cardValue = getCardValue(playerCard);
                if (cardValue > highestCardValue) {
                    highestCard = playerCard;
                    highestCardValue = cardValue;
                }
            }
        }
    
        // Determine the optimal card to play.
        return playerCards.keySet().stream()
                .filter(player -> playerCards.get(player).startsWith(trumpSuit))
                .findFirst()
                .map(player -> playerCards.get(player))
                .orElseGet(() -> getSmallestCard(playerCards.get(self), trumpSuit));
    }
    
    private static int getCardValue(String card) {
        int suitValue = suitMap.get(card.charAt(0));
        int cardValue = card.charAt(1) - '0';
        if (cardValue == 0) {
            cardValue = 13;
        }
        return suitValue * 100 + cardValue;
    }
    private static String getSmallestCard(String cards, String trumpSuit) {
        String smallestCard = null;
        int smallestCardValue = Integer.MAX_VALUE;
        for (String card : cards.split(",")) {
            if (smallestCard == null || getCardValue(card) < smallestCardValue) {
                if (card.startsWith(trumpSuit)) {
                    smallestCard = card;
                    smallestCardValue = getCardValue(card);
                } else if (smallestCard != null && !smallestCard.startsWith(trumpSuit)) {
                    smallestCardValue = Math.min(smallestCardValue, getCardValue(card));
                }
            }
        }
        if (smallestCard == null) {
            // If the player does not have any cards of the suit of the round, play the smallest card of any suit.
            for (String card : cards.split(",")) {
                if (smallestCard == null || getCardValue(card) < smallestCardValue) {
                    smallestCard = card;
                    smallestCardValue = getCardValue(card);
                }
            }
        }
        return smallestCard;
    }
   
    public static void main(String[] args) {
        String input = "players:tom,dick,harry,jhon;self:jhon;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha";
        String optimalCard = getOptimalCard(input);
        System.out.println(optimalCard);
    }
}