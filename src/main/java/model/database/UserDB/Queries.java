package model.database.UserDB;

public enum Queries {
    GET_USER_BY_NICKNAME("SELECT * FROM `user` WHERE `nickname` == '%s'"),
    GET_USER_BY_USERNAME("SELECT * FROM `user` WHERE `username` == '%s'"),
    GET_USER_BY_ID("SELECT * FROM `user` WHERE `id` == %d"),
    INSERT_USER("INSERT INTO `user` (`username`,`nickname`,`password`,`score`,`money`) VALUES ('%s', '%s', '%s', %d, %d)");

    private final String value;

    Queries(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
