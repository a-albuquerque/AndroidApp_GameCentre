/*
Model
 */
package fall2018.csc2017.GameCentre;

public class SudokuBoard extends Board{
    /**
     * Number of rows
     */
    final static int numRows = 9;

    /**
     * Number of cols
     */
    final static int numCols = 9;

    /**
     * The tiles on the SudokuBoard in row-major order
     */
    private Tile[][] tiles = new Tile[numRows][numCols];

    /**
     * replaces a previous Tile with the indicated tile.
     * @param row of the tile
     * @param col of the tile
     * @param tile replaces the previous Tile at the indicated position
     */
    public void setTile(int row, int col, Tile tile){
        tiles[row][col] = tile;
        setChanged();
        notifyObservers();
    }

    /**
     * set the tiles of the board
     * @param tiles tiles of the board.
     */
    public void setTiles(Tile[][] tiles) {
        this.tiles = tiles;
    }

    /**
     * returns the tiles of the board
     * @return tiles
     */
    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * A new board of all tiles with backgound id 0
     */
    SudokuBoard(){
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                this.tiles[i][j] = new Tile(-1);
            }
        }

    }
    /**
     * Get the tile in row and col
     */
    public Tile getTile(int row, int col) {
        return this.tiles[row][col];
    }
}
