package model.user;

public class WalletException extends Exception{
    public WalletException(String msg) {
        super(msg);
    }
}

class NegativeIncreaseValue extends WalletException{
    public NegativeIncreaseValue() {
        super("increase amount can not be negative");
    }
}

class NotEnoughMoney extends WalletException{
    public NotEnoughMoney() {
        super("not enough money");
    }
}