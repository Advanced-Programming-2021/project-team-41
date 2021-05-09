package model.database.UserDB;

public class UserDBException extends Exception {
    public UserDBException(String msg) {
        super(msg);
    }
}

class UserDoesNotExists extends UserDBException {
    public UserDoesNotExists(int userId) {
        super(String.format("user with id = (%d) doesn't exist", userId));
    }
}
