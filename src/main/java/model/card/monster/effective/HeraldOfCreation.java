package model.card.monster.effective;

import model.card.Card;
import model.card.monster.CardType;
import model.card.monster.Monster;

public class HeraldOfCreation extends Monster {
    private boolean isApplied = false;

    public HeraldOfCreation(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
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

    public void applyEffect(Player owner, Card theCardThatWillBeRemoved, Card theCardFromGrave) {
        owner.getBoard().removeFromHand(theCardThatWillBeRemoved);
        owner.getBoard().putOnGraveYard(theCardThatWillBeRemoved);

        owner.getBoard().removeFromGY(theCardThatWillBeRemoved);
        owner.getBoard().putOnMonsterSection(theCardFromGrave);

//        baba en rasman controllere
//        aval cardi ke mikhad hazf kone ro entekhab mikone
//        baad miad az grave entekhab mikone
    }
}
