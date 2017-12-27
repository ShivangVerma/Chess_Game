package pieces;

import board.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pawn extends Piece{

    private int[][] offset_w = {{1, -1}, {1, 0}, {1, 1}};
    private int[][] offset_b = {{-1, 1}, {-1, 0}, {-1, -1}};
    //Off[0] = new offset(-2, 1);

    public Pawn(int color, int Id, String name, String image_path, int piecePosition_x, int piecePosition_y){
        super(color, Id, name, image_path);
        this.piecePosition_x = piecePosition_x;
        this.piecePosition_y = piecePosition_y;
    }

    @Override
    public ArrayList<Move> calculate_move(Board board) {

        if(this.color == 0) {
            possible_moves.clear();

            int temp_x = piecePosition_x;
            int temp_y = piecePosition_y;

            temp_x = temp_x + offset_w[0][0];
            temp_y = temp_y + offset_w[0][1];


            //for left up move

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile() != null) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }

            temp_x = piecePosition_x;
            temp_y = piecePosition_y;


            temp_x = temp_x + offset_w[1][0];
            temp_y = temp_y + offset_w[1][1];

            //for up move


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile() == null) {
                    if(piecePosition_x == 1){
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        temp_x = temp_x + offset_w[1][0];
                        temp_y = temp_y + offset_w[1][1];
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile() != null){

                        }
                        else {
                            possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    else {
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }

            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = temp_x + offset_w[2][0];
            temp_y = temp_y + offset_w[2][1];

            //for up-right move


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile() != null) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
        }
        else{
            possible_moves.clear();

            int temp_x = piecePosition_x;
            int temp_y = piecePosition_y;

            temp_x = temp_x + offset_b[0][0];
            temp_y = temp_y + offset_b[0][1];


            //for left up move

            if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile() != null) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }

            temp_x = piecePosition_x;
            temp_y = piecePosition_y;


            temp_x = temp_x + offset_b[1][0];
            temp_y = temp_y + offset_b[1][1];

            //for up move


            if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile() == null) {
                    if(piecePosition_x == 6){
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        temp_x = temp_x + offset_b[1][0];
                        temp_y = temp_y + offset_b[1][1];
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile() != null){

                        }
                        else {
                            possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    else{
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }

            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = temp_x + offset_b[2][0];
            temp_y = temp_y + offset_b[2][1];

            //for up-right move


            if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
                //do not add to list
            }
            else {
                if(board.GameBoard[temp_x][temp_y].getPieceOnTile() != null) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
        }
        return possible_moves;
    }

    public Piece get_copy(){
        Pawn k1 = new Pawn(this.color, this.Id, this.name, this.image_path, this.piecePosition_x, this.piecePosition_y);
        return this;
    }

}
