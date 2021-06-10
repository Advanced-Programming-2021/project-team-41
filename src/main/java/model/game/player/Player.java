package model.game.player;

import model.game.player.board.Board;
import model.user.Deck;
import model.user.User;

public class Player {
    private final User user;
    private int lifePoints = 8000;
    private Board board;
    private boolean canSummon = true;


    public Player(User user) {
        this.user = user;
        this.board = new Board(user.getActiveDeck());
    }

    //Instance Methods

    public void addToLifePoint(int amount) {
        this.lifePoints += amount;
    }

    public void subtractFromLifePoint(int amount) {
        this.lifePoints -= amount;
    }

    //Getters and Setters
    public String getUsername() {
        return user.getUsername();
    }

    public String getNickname() {
        return user.getNickName();
    }

    public User getUser() {
        return user;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public void setLifePoints(int lifePoints) {
        this.lifePoints = lifePoints;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isCanSummon() {
        return canSummon;
    }

    public void setCanSummon(boolean canSummon) {
        this.canSummon = canSummon;
    }
}
