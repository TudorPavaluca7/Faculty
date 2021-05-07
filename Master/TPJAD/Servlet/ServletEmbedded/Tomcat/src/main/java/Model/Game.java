package Model;

public class Game {

    private int nrOfAttemptsLeft;
    private int randomValue;
    private int nrOfAttempts;
    private String userMessage;

    public Game(int nrOfAttemptsLeft, int randomValue, int nrOfAttempts) {
        this.nrOfAttemptsLeft = nrOfAttemptsLeft;
        this.randomValue = randomValue;
        this.nrOfAttempts = nrOfAttempts;
        this.userMessage = "";
    }

    public int getNrOfAttemptsLeft() {
        return nrOfAttemptsLeft;
    }

    public void setNrOfAttemptsLeft(int nrOfAttemptsLeft) {
        this.nrOfAttemptsLeft = nrOfAttemptsLeft;
    }

    public int getRandomValue() {
        return randomValue;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }
}
