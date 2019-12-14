package resturantmanagement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Person implements Serializable {

    protected String FName;
    protected String LName;
    private int id;

    private String userName;
    private String password;
    private int role;

    public Person() {

    }
    private boolean isFilled;

    public Person(String FName, String LName, String userName, String password, int role) {
        this.FName = FName;
        this.LName = LName;
        this.userName = userName;
        this.password = password;
        this.role = role;
        isFilled = false;

    }

    public String getFName() {
        return FName;
    }

    public void setFName(String FName) {
        this.FName = FName;
    }

    public String getLName() {
        return LName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public abstract int login(String userName, String passWord);

}
