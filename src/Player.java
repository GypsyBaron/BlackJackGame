public class Player {

    private Deck deck;
    private double money;

    public Player(Deck deck) {
        this.deck = deck;
        this.money = 1000.00;
    }

    public Deck getDeck() {
        return this.deck;
    }

    public double getMoney() {
        return this.money;
    }

    public void changeBalance(double cash) {
        this.money += cash;
    }
}
