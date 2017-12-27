package pieces;

import board.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece{


    private int[][] offset = {{-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}};
    //Off[0] = new offset(-2, 1);

    public Knight(int color, int Id, String name, String image_path, int piecePosition_x, int piecePosition_y){
        super(color, Id, name, image_path);
        this.piecePosition_x = piecePosition_x;
        this.piecePosition_y = piecePosition_y;
    }

    @Override
    public ArrayList<Move> calculate_move(Board board) {

        possible_moves.clear();
        int temp_x = piecePosition_x;
        int temp_y = piecePosition_y;
        for(int i=0; i<8; i++){
            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = temp_x + offset[i][0];
            temp_y = temp_y + offset[i][1];

            if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
                //do not add to list
                continue;
            }

            if(board.GameBoard[temp_x][temp_y].isOccupied()){
                if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color){
                    //add to the list

                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
                else{
                    continue;
                }
            }
            else{
                //add to the list
                possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }
        return possible_moves;
    }

    public Piece get_copy(){
        Knight k1 = new Knight(this.color, this.Id, this.name, this.image_path, this.piecePosition_x, this.piecePosition_y);
        return this;
    }
}