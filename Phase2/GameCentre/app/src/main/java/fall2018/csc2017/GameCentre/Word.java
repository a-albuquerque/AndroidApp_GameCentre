package fall2018.csc2017.GameCentre;

import java.util.Iterator;
import java.util.List;


public class Word extends Board{
    /**
     * Number of rows
     */
    public static int numRows = 1;

    /**
     * Number of cols
     */
    public static int numCols; // todo update depending on Kevin's implementation

    /**
     * The letters on the Hangman Word in order
     */
    private Letter[][] letters = new Letter[numRows][numCols];

    void setLetter(int row, int col, Letter letter){
        letters[row][col] = letter;
        setChanged();
        notifyObservers();
    }

    public void setLetters(Letter[][] letters) {
        this.letters = letters;
    }

    public Letter[][] getLetters() {
        return letters;
    }

    /**
     * A new word made of letters in order.
     * Precondition: len(letters) == numCols
     *
     * @param l the letters for the word
     */
    Word(List<Letter> l) {

        Iterator<Letter> iterator = l.iterator();

        for (int i = 0; i < numCols; i++) {
            this.letters[0][i] = iterator.next();
        }
    }

    /**
     * Get the letter at a particular position (col)
     */
    public Letter getLetter(int row, int col) {
        return this.letters[0][col];  // TODO: adapt to Hangman
    }
}