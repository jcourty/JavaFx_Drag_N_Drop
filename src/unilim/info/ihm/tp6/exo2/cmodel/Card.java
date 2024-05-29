package unilim.info.ihm.tp6.exo2.cmodel;

public class Card {

    private final int value;

    public Card(int value) {
        if (value < 1 || value > 12) {
            throw new IllegalArgumentException("La valeur de la carte doit être comprise entre 1 et 12");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}