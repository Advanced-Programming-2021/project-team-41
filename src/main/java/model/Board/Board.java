import java.util.ArrayList;
import java.util.Collections;

public class Board {
    ArrayList<Card> deck;
    ArrayList<Card> hand;
    ArrayList<Monster> monsters;
    ArrayList<CardStatus> monstersStatus;
    ArrayList<SpellAndTrap> spells;
    ArrayList<CardStatus> spellsStatus;
    ArrayList<Card> graveYard;
    SpellAndTrap fieldCard;

    public Board(ArrayList<Card> deck){
        Collections.shuffle(deck);
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.monsters = new ArrayList<>();
        this.spells = new ArrayList<>();
        this.graveYard = new ArrayList<>();
    }
    //------------------------------------------------------------------------------------------------
    //give me the cordinates and I will give you the card
    public Card selectCard(CardSection cardSection, int number){
        switch (cardSection){
            case HAND:
                return hand.get(number);
            case MONSTER:
                return monsters.get(number);
            case FIELD_ZONE:
                return fieldCard;
            case GRAVE_YARD:
                return graveYard.get(number);
            case SPELL_TRAP:
                return spells.get(number);
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------
    //for knowing if a card is in deffence mode or attack or is hidden or not
    public CardStatus getCardStatus(CardSection cardSection, int number){
        switch (cardSection){
            case MONSTER:
                return monstersStatus.get(number);
            case SPELL_TRAP:
                return spellsStatus.get(number);
        }
        return null;
    }

    public CardStatus getCardStatus(Card card){
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getCardId().equals(card.getCardId())){
                return monstersStatus.get(i);
            }
        }
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getCardId().equals(card.getCardId())){
                return spellsStatus.get(i);
            }
        }
        return null;
    }
    //------------------------------------------------------------------------------------------------
    public void drawCard(int count){
        for (int i=0; i<count; i++) {
            putOnHand(deck.get(0));
        }
        for (int i=0; i<count; i++) {
            deck.remove(0);
        }
    }
    //------------------------------------------------------------------------------------------------
    //get counts of different sections
    public int getDeckCount(){
        return deck.size();
    }

    public int getHandCount(){
        return hand.size();
    }

    public int getGYCount(){
        return graveYard.size();
    }

    public int getMonsterSectionCount(){
        return monsters.size();
    }

    public int getSpellSectionCount(){
        return spells.size();
    }
    //------------------------------------------------------------------------------------------------
    //see in which section is a card
    public CardSection getCardSection(Card selectedCard){
        //check hand
        for (Card card : hand) {
            if (card.getCardId().equals(selectedCard.getCardId())){
                return CardSection.HAND;
            }
        }
        //check Monster
        for (Monster monster : monsters) {
            if (monster.getCardId().equals(selectedCard.getCardId())){
                return CardSection.MONSTER;
            }
        }
        //check spells
        for (SpellAndTrap spell : spells) {
            if (spell.getCardId().equals(selectedCard.getCardId())){
                return CardSection.SPELL_TRAP;
            }
        }
        //check GY
        for (Card card : graveYard) {
            if (card.getCardId().equals(selectedCard.getCardId())){
                return CardSection.GRAVE_YARD;
            }
        }
        //check field
        if (fieldCard.getCardId().equals(selectedCard.getCardId()))
            return CardSection.FIELD_ZONE;
        return null;
    }
    //------------------------------------------------------------------------------------------------
    //removes
    public void removeFromHand(Card card){
        if (hand.contains(card)){
            hand.remove(card);
        }
    }

    public void removeFromMonsters(Monster monster){
        for (int i = 0; i < monsters.size(); i++) {
            if (monsters.get(i).getCardId().equals(monster.getCardId())){
                monstersStatus.remove(i);
                monsters.remove(i);
                return;
            }
        }
    }

    public void removeFromSpells(SpellAndTrap spell){
        for (int i = 0; i < spells.size(); i++) {
            if (spells.get(i).getCardId().equals(spell.getCardId())){
                spellsStatus.remove(i);
                spells.remove(i);
                return;
            }
        }
    }

    public void removeFromGY(Card card){
        for (Card card1 : graveYard) {
            if (card1.getCardId().equals(card.getCardId())){
                graveYard.remove(card1);
                return;
            }
        }
    }

    public void removeFieldCard(){
        fieldCard = null;
    }
    //------------------------------------------------------------------------------------------------
    //puts
    public boolean putOnHand(Card card){
        return hand.add(card);
    }

    public boolean putOnMonsterSection(Monster newMonster, CardStatus cardStatus){
        if (getMonsterSectionCount()<5) {
            return (monsters.add(newMonster) && monstersStatus.add(cardStatus));
        }
        return false;
    }

    public boolean putOnSpellSection(SpellAndTrap newSpell, CardStatus cardStatus){
        if (getSpellSectionCount()<5) {
            return (spells.add(newSpell) && spellsStatus.add(cardStatus));
        }
        return false;
    }

    public boolean putOnGraveYard(Card dead){
        return graveYard.add(dead);
    }

    public void putOnFieldSection(SpellAndTrap spell){
        fieldCard = spell;
    }
    //------------------------------------------------------------------------------------------------

}
