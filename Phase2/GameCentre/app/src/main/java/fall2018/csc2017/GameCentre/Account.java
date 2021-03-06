/*
Model class
 */
package fall2018.csc2017.GameCentre;

import java.io.Serializable;

/**
 * User Account that contains login info and game state info.
 * This is a model class that contains only getter and setter methods.
 */
class Account implements Serializable {

    static final long serialVersionUID = 4860302647072124829L;
    static final String slidingName = "sliding tiles";
    static final String hangmanName = "Hangman";
    static final String sudokuName = "sudoku";

    /**
     * User's username and password.
     */
    private String username, password;

    /**
     * User's save data.
     */
    private SaveManager[] slidingSaveManager = new SaveManager[3];
    private SaveManager[] hangmanSaveManager = new SaveManager[3];
    private SaveManager[] sudokuSaveManager = new SaveManager[3];

    /**
     * Setting the current save file to look at.
     * @param currentGame the current save file.
     */
    void setCurrentGame(int currentGame) {
        this.currentGame = currentGame;
    }

    /**
     * The current save file. (Ranging from 1 to 3 for all games)
     */
    private int currentGame;

    /**
     * Setting the most recent played game.
     * @param lastPlayedGame the most recent played game.
     */
    void setLastPlayedGame(String lastPlayedGame) {
        this.lastPlayedGame = lastPlayedGame;
    }

    /**
     * The most recent played game.
     */
    private String lastPlayedGame;

    /**
     * Creates a new User Account with username and password.
     *
     * @param username User's username
     * @param password User's password
     */
    Account(String username, String password) {
        this.username = username;
        this.password = password;

        slidingSaveManager[0] = new SaveManager();
        slidingSaveManager[1] = new SaveManager();
        slidingSaveManager[2] = new SaveManager();

        hangmanSaveManager[0] = new SaveManager();
        hangmanSaveManager[1] = new SaveManager();
        hangmanSaveManager[2] = new SaveManager();

        sudokuSaveManager[0] = new SaveManager();
        sudokuSaveManager[1] = new SaveManager();
        sudokuSaveManager[2] = new SaveManager();
    }

    SaveManager getCurrentSaveManager(String gameType){
        if (gameType.equals(Account.slidingName)){
            return slidingSaveManager[currentGame-1];
        }

        if (gameType.equals(Account.hangmanName)){
            return hangmanSaveManager[currentGame-1];
        }

        if (gameType.equals(Account.sudokuName)){
            return sudokuSaveManager[currentGame-1];
        }
        return new SaveManager();
    }

    /**
     * Return the username of the account object.
     *
     * @return account object's username
     */
    String getUsername() {
        return this.username;
    }

    /**
     * Return the user's password.
     *
     * @return user's password.
     */
    String getPassword() {
        return this.password;
    }

    /**
     * Set username.
     *
     * @param username username of user input
     */
    void setUsername(String username) {
        this.username = username;
    }

    /**
     * Set password.
     *
     * @param password password of user input
     */
    void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return the most recent played game.
     * @return the most recent played game.
     */
    String getLastPlayedGame() {
        return lastPlayedGame;
    }
}