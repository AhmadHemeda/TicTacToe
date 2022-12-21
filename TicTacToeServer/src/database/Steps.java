package database;

public class Steps {
    private int gameID;
    private String button;
    private String text;

    public Steps() {
    }

    public Steps(int gameID, String button, String text) {
        this.gameID = gameID;
        this.button = button;
        this.text = text;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getGameID() {
        return gameID;
    }

    public String getButton() {
        return button;
    }

    public String getText() {
        return text;
    }
    
    
}
