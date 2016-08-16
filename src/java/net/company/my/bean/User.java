package net.company.my.bean;

/**
 *
 * @author Kostya
 */
public class User extends Entity {

    private String name;
    private String email;
    private String password;
    private UserType userType;

    public User() {
    }

    public User(int id, String name, String email, String password, UserType userType) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
        this.userType = userType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + getId() + ", name=" + name + ", email="
                + email + ", password=" + password + ", userType=" + userType + '}';
    }
}
