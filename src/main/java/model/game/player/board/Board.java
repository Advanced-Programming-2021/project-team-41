package model.game.player.board;

import model.card.monster.Monster;
import model.game.player.board.sections.CardSection;
import model.game.player.board.sections.FieldZoneSection;
import model.game.player.board.sections.HandSection;
import model.game.player.board.sections.monsterSection.MonsterSection;
import model.game.player.board.sections.monsterSection.MonsterStatus;
import model.game.player.board.sections.spellAndTrapSection.SpellAndTrapSection;
import model.card.Card;
import model.game.player.board.sections.spellAndTrapSection.SpellAndTrapStatus;
import model.user.Deck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Board {
    private ArrayList<Card> mainDeck = new ArrayList<>();
    private ArrayList<Card> sideDeck = new ArrayList<>();
    private HashMap<Integer, MonsterSection> monstersSection = new HashMap<>();
    private HashMap<Integer, SpellAndTrapSection> spellsAndTrapsSection = new HashMap<>();
    private HashMap<Integer, HandSection> handsSections = new HashMap<>();
    private FieldZoneSection fieldZoneSection;
    private ArrayList<Card> graveYard = new ArrayList<>();


    /*Constructor*/
    public Board(Deck deck) {
        mainDeck.addAll(deck.getMain());
        sideDeck.addAll(deck.getSide());
        Collections.shuffle(mainDeck);
        Collections.shuffle(sideDeck);

        //Monsters section
        for (int i = 1; i <= 5; i++) {
            MonsterSection monsterSection = new MonsterSection();
            monstersSection.put(i, monsterSection);
        }

        //Spells and traps section
        for (int i = 1; i <= 5; i++) {
            SpellAndTrapSection spellAndTrapSection = new SpellAndTrapSection();
            spellsAndTrapsSection.put(i, spellAndTrapSection);
        }

        //Hand
        for (int i = 1; i <= 6; i++) {
            handsSections.put(i, null);
        }
    }

    public Card selectCard(int address, /*Selected section name*/) {
        seitch(/*selected section name*/) {
            case /*monaster*/:
                return monstersSection.get(address).getCard();
            break;
            case /*Spell or Trap*/:
                return spellsAndTrapsSection.get(address).getCard();
            break;
            case /*Hand*/:
                return handsSections.get(address).getCard();
            break;
            case /*Field*/:
                return getFieldZone().getCard();
            break;
            case /*GraveYard*/:
                return graveYard.get(address);
            break;
        }
    }

    public void drawCard(int count) {
        for (int i = 0; i < count; i++) {
            putOnHand(mainDeck.get(i));
        }
        if (count > 0) {
            mainDeck.subList(0, count).clear();
        }
    }

    public boolean isMonsterSectionFull() {
        for (int i = 1; i <= 5; i++) {
            if (monstersSection.get(i).getCard() == null) {
                return false;
            }
        }
        return true;
    }

    /* number of cards in each section */
    public int getNumberOfMonsters() {
        int num = 0;
        for (int i = 1; i <= 5; i++) {
            if (monstersSection.get(i).isFull()) i++;
        }
        return num;
    }


    /* put methods */
    public void putOnMonstersSection(CardSection cardSection, MonsterStatus status) {
        for (int i = 1; i <= 5; i++) {
            if (!monstersSection.get(i).isFull()) {

                monstersSection.get(i).setCard(cardSection.getCard());
                monstersSection.get(i).setStatus(status);

                ((MonsterSection) cardSection).remove();
                return;
            }
        }
    }

    public void putOnMonsterSection(Card card, MonsterStatus monsterStatus) {

    }

    public void putOnSpellsAndTrapsSection(CardSection cardSection) {
        for (int i = 1; i <= 5; i++) {
            if (!spellsAndTrapsSection.get(i).isFull()) {
                spellsAndTrapsSection.get(i).setCard(cardSection.getCard());
                ((SpellAndTrapSection) cardSection).remove();
                return;
            }
        }
    }

    public void putOnSpellsAndTrapsSection(Card card, SpellAndTrapStatus status) {

    }

    public void putOnHandsSection(CardSection cardSection) {
        for (int i = 1; i <= 5; i++) {
            if (!handsSections.get(i).isFull()) {
                handsSections.get(i).setCard(cardSection.getCard());
                cardSection.remove();
                return;
            }
        }
    }

    public void putOnHandsSection(Card card) {

    }

    public void putOnGraveYard(CardSection cardSection) {
        graveYard.add(cardSection.getCard());
    }

    public void putOnGraveYard(Card card) {

    }

    /* remove methods */

//    public void removeFromMonstersSection(MonsterSection monsterSection) {
//    }
//
//    public void removeFromSpellsAndTrapsSection(int sectionNumber) {
//        monstersSection.get(sectionNumber).setCard(null);
//    }
//
//    public void removeFromHandsSection(int handSectionNumber) {
//        handsSections.get(handSectionNumber).setCard(null);
//    }
//
//    public void removeFromFieldSection() {
//        fieldZoneSection.setCard(null);
//    }

    // remove all
    public void removeAllMonsters() {
        for (MonsterSection monsterSection : monstersSection.values()) {
            monsterSection.remove();
        }
    }

    public void removeAllSpellsAndTraps() {
        for (SpellAndTrapSection spellAndTrapSection : spellsAndTrapsSection.values()) {
            spellAndTrapSection.remove();
        }
    }

    public void removeAllHandsCard() {
        for (HandSection handSection : handsSections.values()) {
            handSection.remove();
        }
    }

    public void removeFieldZoneCard() {
        fieldZoneSection.remove();
    }

    /*Getters and Setters*/

    public FieldZoneSection getFieldZone() {
        return fieldZoneSection;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }
}
