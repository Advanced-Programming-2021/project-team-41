package model.card;

import java.util.HashMap;

public class Card {
    int cardId;
    String name;
    String type;
    String description;
    int price;

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
