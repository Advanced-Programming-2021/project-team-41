package model.card;

public class Card {
    int id;
    String name;
    String type;
    int level;
    String attribute;
    String monsterType;
    String cardType;
    int attack;
    int defence;
    String property;
    String status;
    String description;
    int price;

    public Card(int id, String name, String type, int level, String attribute, String monsterType, String cardType
            , int attack, int defence, String property, String status, String description, int price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.attribute = attribute;
        this.monsterType = monsterType;
        this.cardType = cardType;
        this.attack = attack;
        this.defence = defence;
        this.property = property;
        this.status = status;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", level=" + level +
                ", attribute='" + attribute + '\'' +
                ", monsterType='" + monsterType + '\'' +
                ", cardType='" + cardType + '\'' +
                ", attack=" + attack +
                ", defence=" + defence +
                ", property='" + property + '\'' +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
