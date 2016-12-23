package object;


public class User {
    private String userName;
    private String userDescription;

    public User(String userName, String userDescription) {
        this.userName = userName;
        this.userDescription = userDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }
}
