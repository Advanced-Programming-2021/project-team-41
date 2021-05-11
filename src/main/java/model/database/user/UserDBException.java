package model.database.user;

public class UserDBException extends Exception {
    public UserDBException(String msg) {
        super(msg);
    }
}

class UserIdDoesNotExists extends UserDBException {
    public UserIdDoesNotExists(int userId) {
        super(String.format("user with id = (%d) doesn't exist", userId));
    }
}
class UsernameDoesNotExists extends UserDBException {
    public UsernameDoesNotExists(String username) {
        super(String.format("user with username = (%s) doesn't exist", username));
    }
}
