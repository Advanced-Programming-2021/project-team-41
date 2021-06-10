package model.game.player.board.sections.spellAndTrapSection;

import model.card.spellAndTrap.SpellAndTrap;
import model.game.player.board.sections.CardSection;

public class SpellAndTrapSection extends CardSection {
    private SpellAndTrapStatus status;

    /*Constructor*/
    public SpellAndTrapSection() {
    }

    @Override
    public void remove() {
        super.remove();
        setStatus(null);
    }

    /* Getters and Setters*/

    public SpellAndTrapStatus getStatus() {
        return status;
    }

    public void setStatus(SpellAndTrapStatus status) {
        this.status = status;
    }
}
