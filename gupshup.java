import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class gupshup {
    public static void main(String[] args) {
        //  Scanner scanner = new Scanner(System.in);
        // String input = scanner.nextLine();
        // scanner.close();
        String input = "players:tom,dick,harry,john;self:john;trump:c;dick:c2;tom:c5;harry:s3;cards:c1,c6,s3";
        // String input = "players:tom,dick,harry,jhon;self:jhon;trump:s;dick:s10;tom:s2;harry:ca;cards:s3,sk,ha";
        // String input = "players:tom,dick,harry,john;self:john;trump:s;dick:ca;tom:c10;harry:ck;cards:s3,s5,c3";

        // Parse the input and extract relevant information
        Map<String, String> inputData = parseInput(input);

        // Determine the optimal card to be played by the last player
        String optimalCard = determineOptimalCard(inputData);

        // Output the optimal card
        System.out.println("Optimal Card: " + optimalCard);
    }
     public static Map<String, String> parseInput(String input) {
        Map<String, String> inputData = new HashMap<>();
        String[] components = input.split(";");
        for (String component : components) {
            String[] parts = component.split(":");
            inputData.put(parts[0].trim(), parts[1].trim());
        }
        return inputData;
    }
    private static String getFirstPlayedCard(Map<String, String> inputData) {
        // Determine the first player in the team
        String[] players = inputData.get("players").split(",");
        String firstPlayer = players[0];
        String thirdPlayer = players[2];

        // Check if the first player has played a card
        if (inputData.containsKey(firstPlayer)) {
            return inputData.get(firstPlayer);
        } else if (inputData.containsKey(thirdPlayer)) {
            // If not, consider the third player's card
            return inputData.get(thirdPlayer);
        }

        return "";
    }
    /* public static String getFirstPlayedCard(Map<String, String> inputData) {
        for (Map.Entry<String, String> entry : inputData.entrySet()) {
            String playerName = entry.getKey();
            if (!playerName.equals("self") && !playerName.equals("trump")) {
                return inputData.get(playerName);
            }
        }
        return "";
    } */
     private static class CardComparator implements Comparator<String> {
        private final String suitPreference = "cdhs";

        @Override
        public int compare(String card1, String card2) {
            char suit1 = card1.charAt(0);
            char suit2 = card2.charAt(0);
            int suitComparison = Integer.compare(suitPreference.indexOf(suit1), suitPreference.indexOf(suit2));
            if (suitComparison != 0) {
                return suitComparison;
            } else {
                return card1.compareTo(card2);
            }
        }
    }
    private static String determineOptimalCard(Map<String, String> inputData) {
        String selfCards = inputData.get("cards");
        String trump = inputData.get("trump");
        String firstPlayedCard = getFirstPlayedCard(inputData);
        String roundSuit = firstPlayedCard.substring(0, 1);
        String[] playedCards = selfCards.split(",");

        // Determine the optimal card based on the provided rules
        // This is a simplified implementation and does not fully implement the specified rules

        // Check if there are cards of the same suit as the round (suit of the first played card)
        // System.out.println("Played Cards: "+ playedCards.length);
        // String firstPlayedCard = playedCards[0];
        // System.out.println("First card: "+firstPlayedCard);
        // String roundSuit =firstPlayedCard.substring(0, 1);
        // String roundSuit = playedCards[0].substring(0, 1);
        String smallestCard = "";
        for (String card : playedCards) {
            if (card.startsWith(roundSuit) && (smallestCard.isEmpty() || card.compareTo(smallestCard) < 0))
                smallestCard = card;
        }

        // If there are cards of the round suit, play the smallest card of that suit
        if (!smallestCard.isEmpty()) {
            return smallestCard;
        }

        // If no cards of the round suit, play the smallest trump card
        for (String card : playedCards) {
            if (card.startsWith(trump) && (smallestCard.isEmpty() || card.compareTo(smallestCard) < 0))
                smallestCard = card;
        }

        // If no trump cards, play the smallest card overall
        if (!smallestCard.isEmpty()) {
            return smallestCard;
        }

        // If there are no cards of the round suit or trump, play the smallest card overall
        Arrays.sort(playedCards, new CardComparator());
        // Arrays.sort(playedCards);
        return playedCards[0];
    }

}
