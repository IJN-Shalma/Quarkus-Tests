package org.acme;

public class Card {
    int id;
    int nCopies;
    String name;
    String set;
    int setNumber;

    public Card(int id, int nCopies, String name, String set, int setNumber) {
        this.id = id;
        this.nCopies = nCopies;
        this.name = name;
        this.set = set;
        this.setNumber = setNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNCopies() {
        return nCopies;
    }

    public void setNCopies(int nCopies) {
        this.nCopies = nCopies;
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
