package main;

public class Player {

    private Deck deck;
    private int money;
    private String name;
    private int bet;

    public Player(String name, Deck deck) {
        this.deck = deck;
        this.name = name;
        this.money = 1000;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public int getMoney() {
        return this.money;
    }

    public String getName() {
        return this.name;
    }

    public void addMoney() {
        this.money += this.bet;
        this.bet = 0;
    }

    public void removeMoney() {
        this.money -= this.bet;
        this.bet = 0;
    }


    public boolean addBet(int bet) {
        if (this.money >= bet) {
            this.bet = bet;
            return true;
        } else {
            return false;
        }
    }


}
