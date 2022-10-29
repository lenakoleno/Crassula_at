package enums;

public enum ExistingUserEnum {
    CLIENT("client@crassula.io", "Qwerty123");

    public final String username;
    public final String pass;

    ExistingUserEnum(String username, String pass) {
        this.username = username;
        this.pass = pass;
    }
}
