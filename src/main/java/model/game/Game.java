package model.game;

import model.game.player.Player;
import model.game.player.board.sections.CardSection;
import model.user.User;

public class Game {
    private static Game gamePlayMenu;

    private Player whoseTurnItIs;
    private Player opponent;
    private CardSection selectedCard;
    private PhaseStatus phase = PhaseStatus.DRAW;
    private int rounds;
    private boolean isGameOver;

    /* Constructor */
    private Game() {
        //singleton class
    }

    public static Game getInstance() {
        if (gamePlayMenu == null) {
            gamePlayMenu = new Game();
        }
        return gamePlayMenu;
    }

    /* Select */
    public void selectCardFromOwn(int address, /*selected section name*/) {
//       check that return of the select card is not null
        setSelectedCard(whoseTurnItIs.getBoard().selectCard(address, /*selected section name*/));
    }

    public void selectCardFromOpponent(int address, /*selected section name*/) {
        //if(selected section name is not hand)

        //check that return of the select card is not null
        setSelectedCard(whoseTurnItIs.getBoard().selectCard(address, /*selected section name*/));

        //else error
    }

    /* Getters and Setters */

    public void setWhoseTurnItIs(User user) {
         whoseTurnItIs = new Player(user);
    }

    public void setOpponent(User user) {
        opponent = new Player(user);
    }

    public void setWhoseTurnItIs(Player whoseTurnItIs) {
        this.whoseTurnItIs = whoseTurnItIs;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Player getWhoseTurnItIs() {
        return whoseTurnItIs;
    }

    public Player getOpponent() {
        return opponent;
    }

    public CardSection getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(CardSection selectedCard) {
        this.selectedCard = selectedCard;
    }

    public PhaseStatus getPhase() {
        return phase;
    }

    public void setPhase(PhaseStatus phase) {
        this.phase = phase;
    }

    public int getRounds() {
        return rounds;
    }

    public void setRounds(int rounds) {
        this.rounds = rounds;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(boolean gameOver) {
        isGameOver = gameOver;
    }
}
