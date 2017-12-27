package pieces;

import board.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class King extends Piece{
    private int[][] offset = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
    //Off[0] = new offset(-2, 1);
    private boolean check;
    public ArrayList<Move> danger_list = new ArrayList<Move>();
    public King(int color, int Id, String name, String image_path, int piecePosition_x, int piecePosition_y){
        super(color, Id, name, image_path);
        this.piecePosition_x = piecePosition_x;
        this.piecePosition_y = piecePosition_y;
        check = false;
    }
    private boolean highlight_danger;
    public boolean removes_check(Move move, Board board){
        boolean removes_checkk;
        //temporary alter board
        int src_x = move.src_x;
        int src_y = move.src_y;

        int des_x = move.des_x;
        int des_y = move.des_y;

        Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
        Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();

        int flag = 0;
        if(des_piece != null){
            //remove_piece(int x, int y);
            board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
            flag = 1;
        }

        board.GameBoard[src_x][src_y].removePieceOnTile();
        board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);

        //code for checking if check removed or not

        if(is_check(board)){
            removes_checkk = false;
        }
        else{
            removes_checkk = true;
        }
        //temporary alter board undo

        board.GameBoard[des_x][des_y].removePieceOnTile();
        board.GameBoard[src_x][src_y].setPieceOnTile(src_piece);

        if(des_piece != null){
            board.GameBoard[des_x][des_y].setPieceOnTile(des_piece);
        }

        return removes_checkk;
    }

    public void setHighlight_danger(JButton[][] squares){
        highlight_danger = true;
        squares[piecePosition_x][piecePosition_y].setBackground(Color.red);
    }

    public void desetHighlight_danger(JButton[][] squares){
        highlight_danger = false;
        if((piecePosition_x + piecePosition_y)%2 == 0){
            squares[piecePosition_x][piecePosition_y].setBackground(Color.WHITE);
        }
        else{
            squares[piecePosition_x][piecePosition_y].setBackground(Color.ORANGE);
        }
    }

    @Override
    public ArrayList<Move> calculate_move(Board board) {

        possible_moves.clear();
        int temp_x = piecePosition_x;
        int temp_y = piecePosition_y;
        //for offset (-1, 0) or only down move

        temp_x = temp_x + offset[0][0];
        temp_y = temp_y + offset[0][1];

        if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
            //do not add to list
        } else {
            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else {
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }

        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (0, 1) or only right move

        temp_x = temp_x + offset[1][0];
        temp_y = temp_y + offset[1][1];

        if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
            //do not add to list
        } else {
            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else {
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }

        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (0, -1) or only left move

        temp_x = temp_x + offset[2][0];
        temp_y = temp_y + offset[2][1];

        if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
            //do not add to list
        } else {
            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else {
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }


        //for offset (1, 0) or only up move
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        temp_x = temp_x + offset[3][0];
        temp_y = temp_y + offset[3][1];

        if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
            //do not add to list
        } else {
            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else {
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }


        //for offset (-1, 1) or only bottom right
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        temp_x = temp_x + offset[4][0];
        temp_y = temp_y + offset[4][1];

        if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
            //do not add to list
        }
        else{
            if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else{
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }



        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (-1, -1) or only down-left move
        temp_x = temp_x + offset[5][0];
        temp_y = temp_y + offset[5][1];

        if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
            //do not add to list
        }
        else{
            if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else{
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (1, -1) or only up-left move
        temp_x = temp_x + offset[6][0];
        temp_y = temp_y + offset[6][1];

        if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
            //do not add to list
        }
        else{
            if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else{
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        //for offset (1, 1) or only up-right move
        temp_x = temp_x + offset[7][0];
        temp_y = temp_y + offset[7][1];
        if(temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7){
            //do not add to list
        }
        else{
            if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                }
            }
            else{
                this.possible_moves.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
            }
        }

        return possible_moves;
    }

    public Piece get_copy(){
        King k1 = new King(this.color, this.Id, this.name, this.image_path, this.piecePosition_x, this.piecePosition_y);
        return this;
    }

    private void cal_danger_list(Board board) {
        //danger from up down left right
        danger_list.clear();
        int temp_x = piecePosition_x;
        int temp_y = piecePosition_y;
        //int[][] offset = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        int[][] offset_pawn_w = {{1, -1}, {1, 1}};
        int[][] offset_pawn_b = {{-1, -1}, {-1, 1}};
        //danger from pawn
        if(this.color == 0){
            temp_x = piecePosition_x + offset_pawn_w[0][0];
            temp_y = piecePosition_y + offset_pawn_w[0][1];
            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()){
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("b_pawn___")) {
                        danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = piecePosition_x + offset_pawn_w[1][0];
            temp_y = piecePosition_y + offset_pawn_w[1][1];
            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("b_pawn___")) {
                        danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
        }
        else{
            temp_x = piecePosition_x + offset_pawn_b[0][0];
            temp_y = piecePosition_y + offset_pawn_b[0][1];
            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("w_pawn___")) {
                        danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
            temp_x = piecePosition_x;
            temp_y = piecePosition_y;

            temp_x = piecePosition_x + offset_pawn_b[1][0];
            temp_y = piecePosition_y + offset_pawn_b[1][1];
            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("w_pawn___")) {
                        danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
        }
        int[][] offset = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};
        //danger from others rook, bishop, Queen

        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        for (int i = piecePosition_x; i >= 0; i--) {

            //attack from {-1, 0) or down
            temp_x = temp_x + offset[0][0];
            temp_y = temp_y + offset[0][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                                danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }

                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
                }
            }
        }


        //for offset (-1, 1) or only bottom right
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;


        for (int i = piecePosition_x, j = piecePosition_y; i >= 0 && j < 8; i--, j++) {
            temp_x = temp_x + offset[4][0];
            temp_y = temp_y + offset[4][1];


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list

            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (-1, -1) or only down-left move

        for (int i = piecePosition_x, j = piecePosition_y; i >= 0 && j >= 0; i--, j--) {
            temp_x = temp_x + offset[5][0];
            temp_y = temp_y + offset[5][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (1, -1) or only up-left move

        for (int i = piecePosition_x, j = piecePosition_y; i < 8 && j >= 0; i++, j--) {

            temp_x = temp_x + offset[6][0];
            temp_y = temp_y + offset[6][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }

                    break;
                }
            }
        }
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        //for offset (1, 1) or only up-right move

        for (int i = piecePosition_x, j = piecePosition_y; i < 8 && j < 8; i++, j++) {
            temp_x = temp_x + offset[7][0];
            temp_y = temp_y + offset[7][1];


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list

            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                        }
                    }
                    break;
                }
            }
        }

        //knight

        int[][] offset_k = {{-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}};


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        for (int i = 0; i < 8; i++) {
            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = temp_x + offset_k[i][0];
            temp_y = temp_y + offset_k[i][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
                continue;
            }

            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    String prefix;
                    if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                        prefix = "w";
                    }
                    else {
                        prefix = "b";
                    }
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_knight1")
                            || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_knight2")) {
                        danger_list.add(new Move(piecePosition_x, piecePosition_y, temp_x, temp_y));
                    }
                }
            }
        }
    }


    public boolean is_in_check(Board board){
        cal_danger_list(board);
        if(danger_list.isEmpty()){
            check = false;
        }
        else {
            check = true;
        }
        return check;
    }

    private boolean is_check(Board board){

        //danger from up down left right
        int temp_x = piecePosition_x;
        int temp_y = piecePosition_y;
        int[][] offset = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 1}, {-1, -1}, {1, -1}, {1, 1}};

        int[][] offset_pawn_w = {{1, -1}, {1, 1}};
        int[][] offset_pawn_b = {{-1, -1}, {-1, 1}};


        //danger from pawn
        if(this.color == 0){

            temp_x = piecePosition_x + offset_pawn_w[0][0];
            temp_y = piecePosition_y + offset_pawn_w[0][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if(board.GameBoard[temp_x][temp_y].isOccupied()){
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("b_pawn___")) {
                        return true;
                    }
                }
            }

            temp_x = piecePosition_x;
            temp_y = piecePosition_y;

            temp_x = piecePosition_x + offset_pawn_w[1][0];
            temp_y = piecePosition_y + offset_pawn_w[1][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("b_pawn___")) {
                        return true;
                    }
                }
            }
        }
        else{

            temp_x = piecePosition_x + offset_pawn_b[0][0];
            temp_y = piecePosition_y + offset_pawn_b[0][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("w_pawn___")) {
                        return true;
                    }
                }
            }


            temp_x = piecePosition_x;
            temp_y = piecePosition_y;

            temp_x = piecePosition_x + offset_pawn_b[1][0];
            temp_y = piecePosition_y + offset_pawn_b[1][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if(board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals("w_pawn___")) {
                        return true;
                    }
                }
            }

        }

        //danger from others rook, bishop, Queen
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;


        for (int i = piecePosition_x; i >= 0; i--) {

            //attack from {-1, 0) or down
            temp_x = temp_x + offset[0][0];
            temp_y = temp_y + offset[0][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            }
            else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {
                            return true;
                        }

                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {
                            return true;
                        }
                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }
                    break;
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
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook1__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_rook2__")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }
                    break;
                }
            }
        }


        //for offset (-1, 1) or only bottom right
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;


        for (int i = piecePosition_x, j = piecePosition_y; i >= 0 && j < 8; i--, j++) {
            temp_x = temp_x + offset[4][0];
            temp_y = temp_y + offset[4][1];


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list

            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }
                    break;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (-1, -1) or only down-left move

        for (int i = piecePosition_x, j = piecePosition_y; i >= 0 && j >= 0; i--, j--) {
            temp_x = temp_x + offset[5][0];
            temp_y = temp_y + offset[5][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }
                    break;
                }
            }
        }


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;

        //for offset (1, -1) or only up-left move

        for (int i = piecePosition_x, j = piecePosition_y; i < 8 && j >= 0; i++, j--) {

            temp_x = temp_x + offset[6][0];
            temp_y = temp_y + offset[6][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }

                    break;
                }
            }
        }
        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        //for offset (1, 1) or only up-right move

        for (int i = piecePosition_x, j = piecePosition_y; i < 8 && j < 8; i++, j++) {
            temp_x = temp_x + offset[7][0];
            temp_y = temp_y + offset[7][1];


            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list

            } else {
                if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                        //add to the list
                        String prefix;
                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                            prefix = "w";
                        }
                        else {
                            prefix = "b";
                        }

                        if(board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop1")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_bishop2")
                                || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_queen__")) {

                            return true;
                        }
                    }
                    break;
                }
            }
        }

        //knight

        int[][] offset_k = {{-2, 1}, {1, -2}, {-1, 2}, {2, -1}, {1, 2}, {2, 1}, {-1, -2}, {-2, -1}};


        temp_x = piecePosition_x;
        temp_y = piecePosition_y;
        for (int i = 0; i < 8; i++) {
            temp_x = piecePosition_x;
            temp_y = piecePosition_y;
            temp_x = temp_x + offset_k[i][0];
            temp_y = temp_y + offset_k[i][1];

            if (temp_x < 0 || temp_y < 0 || temp_x > 7 || temp_y > 7) {
                //do not add to list
                continue;
            }

            if (board.GameBoard[temp_x][temp_y].isOccupied()) {
                if (board.GameBoard[temp_x][temp_y].getPieceOnTile().color != this.color) {
                    //add to the list
                    String prefix;
                    if(board.GameBoard[temp_x][temp_y].getPieceOnTile().color == 0) {
                        prefix = "w";
                    }
                    else {
                        prefix = "b";
                    }
                    if (board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_knight1")
                            || board.GameBoard[temp_x][temp_y].getPieceOnTile().name.equals(prefix + "_knight2")) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
