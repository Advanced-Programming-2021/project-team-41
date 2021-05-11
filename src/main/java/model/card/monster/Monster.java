package model.card.monster;

import model.card.Card;

public class Monster extends Card {
    private int level;
    private Attribute attribute;
    private MonsterType monsterType;
    private int attack;
    private int defence;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public MonsterType getMonsterType() {
        return monsterType;
    }

    public void setMonsterType(MonsterType monsterType) {
        this.monsterType = monsterType;
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

    public void increaseDefence(int amount) {
        defence += amount;
    }

    public void increaseAttack(int amount) {
        attack += amount;
    }

    public void decreaseDefence(int amount) {
        defence -= amount;
    }

    public void decreaseAttack(int amount) {
        attack -= amount;
    }
}
