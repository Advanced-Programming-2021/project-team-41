package model.game.player.board.sections.monsterSection;

import model.card.monster.Monster;
import model.game.player.board.sections.CardSection;

public class MonsterSection extends CardSection {
    private MonsterStatus status;

    /*constructor*/
    public MonsterSection() {
    }

    @Override
    public void remove() {
        super.remove();
        setStatus(null);
    }

    //Getters and Setters

    public MonsterStatus getStatus() {
        return status;
    }

    public void setStatus(MonsterStatus status) {
        this.status = status;
    }
}
