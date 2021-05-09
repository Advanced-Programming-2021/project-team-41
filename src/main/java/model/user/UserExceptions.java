package model.user;

class UserExceptions extends Exception {
    public UserExceptions(String msg) {
        super(msg);
    }
}

class UsernameAlreadyExists extends UserExceptions {
    public UsernameAlreadyExists(String username) {
        super(String.format("user with username %s already exists", username));
    }
}

class NicknameAlreadyExists extends UserExceptions {
    public NicknameAlreadyExists(String nickname) {
        super(String.format("user with nickname %s already exists", nickname));
    }
}

class InvalidCurrentPassword extends UserExceptions {
    public InvalidCurrentPassword() {
        super("current password is invalid");
    }
}

class RepeatedPassword extends UserExceptions {
    public RepeatedPassword() {
        super("please enter a new password");
    }
}

