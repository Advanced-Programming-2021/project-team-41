package model.user;

public class Validator {
    private static final String VALID_USERNAME = "^\\s*(?=.{3,20}$)(?![_])(?!.*[_]{2})[a-zA-Z0-9_]+(?<![_])\\s*$";
    private static final String VALID_PASSWORD = "^\\s*^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$\\s*$";
    private static final String VALID_NICKNAME = "^\\s*[\\w+]{5,30}\\s*$";
    private static final String VALID_DECK_NAME = "^\\s*[\\w+]{3,30}\\s*$";
    private static final String USERNAME_GUIDE = "Invalid username:\n" +
            "1- username must be only contains alphanumeric characters, underscore.\n" +
            "2- underscore can't be at the end or start of a username.\n" +
            "3- Number of characters must be between 3 to 20.";
    private static final String PASSWORD_GUIDE = "Invalid password:\n" +
            "1- password must be minimum eight characters.\n" +
            "2- at least one uppercase letter, one lowercase letter and one number.";

    private static final String NICKNAME_GUIDE = "Invalid nickname:\n" +
            "1- nickname must be alphanumeric characters.\n" +
            "2- minimum five characters and maximum 30 character.";

    private static final String DECK_NAME_GUIDE = "Invalid name for deck:\n" +
            "1- name of the deck must be alphanumeric characters.\n" +
            "2- minimum three characters and maximum 30 character.";

    private Validator() {
        // Can't instantiate from this class
    }

    public static void usernameValid(String username) throws Exception {
        if (!username.matches(VALID_USERNAME)) throw new Exception(USERNAME_GUIDE);
    }

    public static void passValid(String password) throws Exception {
        if (!password.matches(VALID_PASSWORD)) throw new Exception(PASSWORD_GUIDE);
    }

    public static void nicknameValid(String nickname) throws Exception {
        if (!nickname.matches(VALID_NICKNAME)) throw new Exception(NICKNAME_GUIDE);
    }

    public static void deckNameValid(String deckName) throws Exception {
        if (!deckName.matches(VALID_DECK_NAME)) throw new Exception(DECK_NAME_GUIDE);
    }
}
