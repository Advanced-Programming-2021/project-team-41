package model.database.user;

import model.database.DataBase;

import java.util.Dictionary;

public class UserDB {
    /* Static Fields */
    private static final DataBase dataBase = DataBase.getInstance();

    /* Static methods */
    public static int countUserByNickname(String nickname) {
        return dataBase.getCount(String.format(Queries.GET_USER_BY_NICKNAME.getQuery(), nickname));
    }

    public static int countUserByUsername(String username) {
        return dataBase.getCount(String.format(Queries.GET_USER_BY_USERNAME.getQuery(), username));
    }

    public static int countUserById(int id) {
        return dataBase.getCount(String.format(Queries.GET_USER_BY_ID.getQuery(), id));
    }

    public static int insertUser(String username, String nickname, String password, int score, int money) {
        dataBase.exeUpdate(String.format(Queries.INSERT_USER.getQuery(), username, nickname, password, score, money));
        return dataBase.getGenerateKey();
    }

    public static Dictionary<String, String> getUser(String userName) throws UsernameDoesNotExists {
        if (countUserByUsername(userName) <= 0) throw new UsernameDoesNotExists(userName);
            return dataBase.getResult(String.format(Queries.GET_USER_BY_USERNAME.getQuery(),userName)).get(0);
    }

    public static void updateMoney(int userId, int newMoney) throws UserIdDoesNotExists {
        userIdExistsInDatabase(userId);
        dataBase.exeUpdate(String.format(Queries.UPDATE_USER_MONEY.getQuery(), newMoney, userId));
    }

    public static void updateScore(int userId, int newScore) throws UserIdDoesNotExists {
        userIdExistsInDatabase(userId);
        dataBase.exeUpdate(String.format(Queries.UPDATE_USER_SCORE.getQuery(), newScore, userId));
    }

    public static void userIdExistsInDatabase(int userId) throws UserIdDoesNotExists {
        if (countUserById(userId) <= 0) throw new UserIdDoesNotExists(userId);
    }
}
