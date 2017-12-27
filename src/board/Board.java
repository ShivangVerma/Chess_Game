package board;
public class Board {
    public Tile GameBoard[][] = new Tile[8][8];
    public Board(){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                GameBoard[i][j] = new Tile(i, j ,null, false, false);
            }
        }
    }
}
