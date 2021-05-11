package model.card.monster;

import model.card.Card;
import model.card.monster.effective.CommandKnight;

import java.util.ArrayList;

public class Monster extends Card {
    private int level;
    private Attribute attribute;
    private MonsterType monsterType;
    private CardType cardType;
    private int attack;
    private int defence;
    private ArrayList<CommandKnight> commandKnightEffect;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        if ("EARTH".equals(attribute)) {
            this.attribute = Attribute.EARTH;
        } else if ("WATER".equals(attribute)) {
            this.attribute = Attribute.WATER;
        } else if ("DARK".equals(attribute)) {
            this.attribute = Attribute.DARK;
        } else if ("FIRE".equals(attribute)) {
            this.attribute = Attribute.FIRE;
        } else if ("LIGHT".equals(attribute)) {
            this.attribute = Attribute.LIGHT;
        } else if ("WIND".equals(attribute)) {
            this.attribute = Attribute.WIND;
        }
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(String monsterType) {
        if ("BEAST_WARRIOR".equals(monsterType)) {
            this.monsterType = MonsterType.BEAST_WARRIOR;
        } else if ("WARRIOR".equals(monsterType)) {
            this.monsterType = MonsterType.WARRIOR;
        } else if ("AQUA".equals(monsterType)) {
            this.monsterType = MonsterType.AQUA;
        } else if ("FIEND".equals(monsterType)) {
            this.monsterType = MonsterType.FIEND;
        } else if ("BEAST".equals(monsterType)) {
            this.monsterType = MonsterType.BEAST;
        } else if ("PYRO".equals(monsterType)) {
            this.monsterType = MonsterType.PYRO;
        } else if ("SPELL_CASTER".equals(monsterType)) {
            this.monsterType = MonsterType.SPELL_CASTER;
        } else if ("THUNDER".equals(monsterType)) {
            this.monsterType = MonsterType.THUNDER;
        } else if ("MACHINE".equals(monsterType)) {
            this.monsterType = MonsterType.MACHINE;
        } else if ("ROCK".equals(monsterType)) {
            this.monsterType = MonsterType.ROCK;
        } else if ("DRAGON".equals(monsterType)) {
            this.monsterType = MonsterType.DRAGON;
        } else if ("INSECT".equals(monsterType)) {
            this.monsterType = MonsterType.INSECT;
        } else if ("CYBERSE".equals(monsterType)) {
            this.monsterType = MonsterType.CYBERSE;
        } else if ("FAIRY".equals(monsterType)) {
            this.monsterType = MonsterType.FAIRY;
        }
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    //  ---------------------------------------------------------------------
//    increase and decrease attack and defence

    public void addToDefence(int amount) {
        defence += amount;
    }

    public void addToAttack(int amount) {
        attack += amount;
    }

    public void subtractFromDefence(int amount) {
        defence -= amount;
    }

    public void subtractFromAttack(int amount) {
        attack -= amount;
    }
//    -----------------------------------------------------------------------
    @Override
    public String toString() {
        return "Monster{" +
                "id=" + getCardId() +
                ", name='" + getName() + '\'' +
                ", type='" + getCardType() + '\'' +
                ", level=" + level +
                ", attribute='" + attribute + '\'' +
                ", monsterType='" + monsterType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", property='" + property + '\'' +
                ", status='" + status + '\'' +
                ", description='" + getDescription() + '\'' +
                ", price=" + getPrice() +
                '}';
    }
}
