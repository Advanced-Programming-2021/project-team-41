package model.user;

public class UserLoaderException extends Exception {
    public UserLoaderException(String msg) {
        super(msg);
    }
}

class UsernameAndPasswordDidNotMatch extends UserLoaderException {
    public UsernameAndPasswordDidNotMatch() {
        super("Username and password didn’t match!");
    }
}

class CardNotFindInUsersCard extends UserLoaderException {
    public CardNotFindInUsersCard() {
        super("can not find card in user's cards");
    }
}

class CanNotFindActiveDeckInDecks extends UserLoaderException{
    public CanNotFindActiveDeckInDecks() {
        super("can not find active deck in user's decks");
    }
}
