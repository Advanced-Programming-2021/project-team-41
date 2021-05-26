package model.card.spellAndTrap;

import model.card.Card;

public abstract class SpellAndTrap extends Card {
//    private Icon icon;
    private Status status;

    //    getters and setters :
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

//    public Icon getIcon() {
//        return icon;
//    }
//
//    public void setIcon(Icon icon) {
//        this.icon = icon;
//    }
}
