package model.database.user;

public enum Queries {
    GET_USER_BY_NICKNAME("SELECT * FROM `user` WHERE `nickname` == '%s'"),
    GET_USER_BY_USERNAME("SELECT * FROM `user` WHERE `username` == '%s'"),
    GET_USER_BY_ID("SELECT * FROM `user` WHERE `id` == %d"),
    INSERT_USER("INSERT INTO `user` (`username`,`nickname`,`password`,`score`,`money`) VALUES ('%s', '%s', '%s', %d, %d)"),
    UPDATE_USER_SCORE("UPDATE `user` SET `score` = %d WHERE `id` == %d"),
    UPDATE_USER_MONEY("UPDATE `user` SET `money` = %d WHERE `id` == %d"),
    UPDATE_USER_NICKNAME("UPDATE `user` SET `nickname` = '%s' WHERE `id` == %d"),
    UPDATE_USER_PASSWORD("UPDATE `user` SET `password` = '%s' WHERE `id` == %d");

    private final String query;

    Queries(String query) {
        this.query = query;
    }

    public String getQuery() {
        return query;
    }
}
