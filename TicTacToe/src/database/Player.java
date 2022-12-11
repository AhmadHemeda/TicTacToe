package database;

public class Player {
    private int ID;
    private String mail;
    private String password;
    private String name;

    public Player() {
    }

    public Player(int ID, String mail, String password, String name) {
        this.ID = ID;
        this.mail = mail;
        this.password = password;
        this.name = name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public String getMail() {
        return mail;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }
    
    
}
