package org.acme.Card;

import java.util.ArrayList;
import java.util.List;

public class CardUtils {

    public static List<Card> parseDeckInput(String deckInput) {
        List<Card> deck = new ArrayList<>();

        String[] lines = deckInput.split("[\n\r]");
        for(String line : lines){
            String[] parts = line.split(" ");
            if (parts.length >= 4) {
                int numCopies = Integer.parseInt(parts[0]);
                String name = parts[1];
                String set = parts[2];
                int setNumber = Integer.parseInt(parts[3]);

                Card card = new Card(numCopies, name, set, setNumber);
                deck.add(card);
            }
        }
    
        return deck;
    }
}
