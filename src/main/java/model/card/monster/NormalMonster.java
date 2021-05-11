package model.card.monster;

public class NormalMonster extends Monster{
    public NormalMonster(String name, int level, String attribute, String monsterType, int attack, int defence, String description, int price) {
        setName(name);
        setLevel(level);
        setAttribute(attribute);
        setMonsterType(monsterType);
        setCardType(CardType.NORMAL);
        setAttack(attack);
        setDefence(defence);
        setDescription(description);
        setPrice(price);
    }
}
