package model.card.monster.effective;

import model.card.Card;
import model.card.monster.CardType;
import model.card.monster.Monster;

public class Scanner extends Monster {
    private boolean isAppliedEffectInThisTurn = false;
    private Card scannedCard = null;

    public Scanner(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
        setName(name);
        setLevel(level);
        setAttribute(attribute);
        setMonsterType(monsterType);
        setCardType(CardType.EFFECT);
        setAttack(attack);
        setDefence(defence);
        setDescription(description);
        setPrice(price);
    }

//    after being placed on the board, it becomes the scanned card :
    public void applyEffect(Card scannedCard) {
        setScannedCard(scannedCard);
    }

    public Card getScannedCard() {
        return scannedCard;
    }

    public void setScannedCard(Card scannedCard) {
        this.scannedCard = scannedCard;
    }

//    before start new turn
    public void disableEffect() {
        setScannedCard(null);
    }
}
