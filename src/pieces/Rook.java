package pieces;

import board.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Rook extends Piece{

    private int[][] offset = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    public Rook(int color, int Id, String name, String image_path, int piecePosition_x, int piecePosition_y){
        super(color, Id, name, image_path);
        this.piecePosition_x = piecePosition_x;
        this.piecePosition_y = piecePosition_y;
    }

    @Override
    public ArrayList<Move> calculate_move(Board board) {

        possible_moves.clear();
        int temp_x = piecePosition_x;
        int temp_y = piecePosition_y;
        //for offset (-1, 0) or only down move
        for (int i = piecePosition_x; i >= 0; i--) {
            temp_x = temp_x + offset[0][0];
            temp_y = temp_y + offset[0][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    } else {

                    }
                    break;
                } else {
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    continue;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (0, 1) or only right move

        for (int i = piecePosition_y; i < 8; i++) {
            temp_x = temp_x + offset[1][0];
            temp_y = temp_y + offset[1][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    } else {

                    }
                    break;
                } else {
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    continue;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (0, -1) or only left move

        for (int i = piecePosition_y; i >= 0; i--) {

            temp_x = temp_x + offset[2][0];
            temp_y = temp_y + offset[2][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    } else {

                    }
                    break;
                } else {
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    continue;
                }
            }
        }

        //for offset (1, 0) or only up move
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        for (int i = piecePosition_x; i < 8; i++) {
            temp_x = temp_x + offset[3][0];
            temp_y = temp_y + offset[3][1];


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    } else {

                    }
                    break;
                } else {
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    continue;
                }
            }
        }


        return possible_moves;
    }

    public Piece get_copy(){
        Rook k1 = new Rook(this.color, this.Id, this.name, this.image_path, this.piecePosition_x, this.piecePosition_y);
        return this;
    }
}
