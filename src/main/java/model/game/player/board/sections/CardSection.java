package model.game.player.board.sections;

import model.card.Card;

public abstract class CardSection {
    private Card card;

    public boolean isFull() {
        return card != null;
    }

    public void remove() {
        card = null;
    }

    /* Getters and Setters */

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
