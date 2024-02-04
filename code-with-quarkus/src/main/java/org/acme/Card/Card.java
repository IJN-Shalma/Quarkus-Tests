package org.acme.Card;

import io.quarkus.mongodb.panache.PanacheMongoEntity;

public class Card extends PanacheMongoEntity {
    int numCopies; // nCopies doesn't work, probably due to "PanacheMongoEntity naming convention"
    String name;
    String set;
    int setNumber;

    /**
     * Constructor
     * 
     * @param numCopies Number of copies in the same card in the deck
     * @param name      Name of the card
     * @param set       Official set abbreviation (ex: Paldea Evolved = PAL)
     * @param setNumber Number of the card in the set
     */
    public Card(int numCopies, String name, String set, int setNumber) {
        this.numCopies = numCopies;
        this.name = name;
        this.set = set;
        this.setNumber = setNumber;
    }

    /**
     * Necessary default constructor
     */
    public Card() {
    }

    public int getNumCopies() {
        return this.numCopies;
    }

    public void setNumCopies(int numCopies) {
        this.numCopies = numCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public int getSetNumber() {
        return setNumber;
    }

    public void setSetNumber(int setNumber) {
        this.setNumber = setNumber;
    }
}

/* Example of a deck in JSON format
 [
  { "numCopies": 4, "name": "Ralts", "set": "ASR", "setNumber": 60 },
  { "numCopies": 3, "name": "Kirlia", "set": "SIT", "setNumber": 68 },
  { "numCopies": 1, "name": "Kirlia", "set": "CRE", "setNumber": 60 },
  { "numCopies": 2, "name": "Gardevoir", "set": "CRE", "setNumber": 61 },
  { "numCopies": 2, "name": "Gardevoir ex", "set": "PAF", "setNumber": 29 },
  { "numCopies": 1, "name": "Zacian V", "set": "CEL", "setNumber": 16 },
  { "numCopies": 1, "name": "Scream Tail", "set": "PAR", "setNumber": 86 },
  { "numCopies": 1, "name": "Radiant Greninja", "set": "ASR", "setNumber": 46 },
  { "numCopies": 1, "name": "Mew", "set": "CEL", "setNumber": 11 },
  { "numCopies": 1, "name": "Manaphy", "set": "BRS", "setNumber": 41 },
  { "numCopies": 1, "name": "Jirachi", "set": "PAR", "setNumber": 126 },
  { "numCopies": 4, "name": "Iono", "set": "PAF", "setNumber": 80 },
  { "numCopies": 2, "name": "Professor's Research", "set": "PAF", "setNumber": 88 },
  { "numCopies": 1, "name": "Boss's Orders", "set": "PAL", "setNumber": 172 },
  { "numCopies": 4, "name": "Battle VIP Pass", "set": "FST", "setNumber": 225 },
  { "numCopies": 4, "name": "Level Ball", "set": "BST", "setNumber": 129 },
  { "numCopies": 3, "name": "Ultra Ball", "set": "PAF", "setNumber": 91 },
  { "numCopies": 3, "name": "Rare Candy", "set": "PAF", "setNumber": 89 },
  { "numCopies": 2, "name": "Fog Crystal", "set": "CRE", "setNumber": 140 },
  { "numCopies": 2, "name": "Super Rod", "set": "PAL", "setNumber": 188 },
  { "numCopies": 2, "name": "Counter Catcher", "set": "PAR", "setNumber": 160 },
  { "numCopies": 1, "name": "Lost Vacuum", "set": "CRZ", "setNumber": 135 },
  { "numCopies": 1, "name": "Collapsed Stadium", "set": "BRS", "setNumber": 137 },
  { "numCopies": 1, "name": "Artazon", "set": "PAF", "setNumber": 76 },
  { "numCopies": 10, "name": "Psychic Energy", "set": "5", "setNumber": 0 },
  { "numCopies": 2, "name": "Reversal Energy", "set": "PAL", "setNumber": 192 }
]
*/