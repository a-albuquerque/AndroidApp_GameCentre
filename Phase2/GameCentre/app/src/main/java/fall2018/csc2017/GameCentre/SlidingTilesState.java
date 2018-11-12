package fall2018.csc2017.GameCentre;

import java.io.Serializable;

/**
 * Game state class for SlidingTiles.
 */
class SlidingTilesState extends GameState implements Serializable {
    /**
     * The current BoardManager, containing current configuration of tiles.
     */
    private BoardManager boardManager;

    /**
     * The complexity of the current board.
     */
    private int complexity = 0;

    /**
     * The serialVersionUID of this serializable object.
     */
    static final long serialVersionUID = -3639293090140222289L;

    /**
     * Create sliding tile state with a given board manager and number of moves.
     *
     * @param boardManager the board manager
     * @param numMoves     the current number of moves
     */
    SlidingTilesState(BoardManager boardManager, int numMoves) {
        this.boardManager = boardManager;
        this.numMoves = numMoves;
    }

    /**
     * Create a sliding tile state with a given board manager, number of moves, complexity,
     * max undone, moves undone and if the number of undones are unlimited.
     *
     * @param boardManager the board manager
     * @param numMoves     the current number of moves
     * @param complexity   the complexity of the board
     * @param maxUndone    max number of undones
     * @param movesUndone  current number of moves undone
     * @param isUnlimited  if the number of moves undone has no limit
     */
    SlidingTilesState(BoardManager boardManager, int numMoves, int complexity, int maxUndone,
                      int movesUndone, boolean isUnlimited) {
        this.boardManager = boardManager;
        this.numMoves = numMoves;
        this.complexity = complexity;
        this.maxNumMovesUndone = maxUndone;
        this.numMovesUndone = movesUndone;
        this.unlimitedUndo = isUnlimited;
    }

    /**
     * Return the current BoardManager.
     *
     * @return current BoardManager.
     */
    BoardManager getBoardManager() {
        return boardManager;
    }

    /**
     * Calculate and return the score based on number of moves taken.
     *
     * @return score of this SlidingTilesState.
     */
    int getScore() {
        if (complexity == 3) {
            return (int) (Math.round((500 * Math.exp(-(double) numMoves / 35))));
        } else if (complexity == 4) {
            return (int) (Math.round((1000 * Math.exp(-(double) numMoves / 20))));
        } else {
            return (int) (Math.round((3000 * Math.exp(-(double) numMoves / 100))));
        }
    }

    /**
     * Return the complexity of this SlidingTilesState.
     *
     * @return the complexity.
     */
    int getComplexity() {
        return complexity;
    }

    /**
     * Set the complexity of the SlidingTilesState.
     *
     * @param complexity the desired complexity of SlidingTilesState.
     */
    void setComplexity(int complexity) {
        this.complexity = complexity;
    }
}
