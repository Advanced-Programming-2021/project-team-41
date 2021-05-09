package model.user;

import model.database.user.UserDB;
import model.database.user.UserDBException;

public class Wallet {
    /* Instance Fields */
    private final User user;
    private int amount = 100000;

    /* Constructor */
    Wallet(User user) {
        this.user = user;
    }

    Wallet(User user, int amount) {
        this.user = user;
        this.amount = amount;
    }

    /* Getters And Setters */
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) throws UserDBException {
        UserDB.updateMoney(this.user.getId(), amount);
        this.amount = amount;
    }

    /* Instance Methods */
    public void increaseAmount(int amount) throws WalletException, UserDBException {
        if (amount < 0) throw new NegativeIncreaseValue();
        setAmount(getAmount() + amount);
    }

    public void decreaseAmount(int amount) throws WalletException, UserDBException {
        if (amount < 0) amount = -amount;
        if (amount > this.amount) throw new NotEnoughMoney();
        setAmount(getAmount() - amount);
    }
}
