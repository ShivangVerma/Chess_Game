package board;
import pieces.*;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame{
    private Container contents;
    public JFrame game_frame;
    private JButton[][] squares = new JButton[8][8];
    private int turn;
    private ArrayList<Move> highlighted_moves = new ArrayList<Move>();
    ArrayList<Move> available_moves = new ArrayList<Move>();
    public Board board = new Board();
    private Player player1 = new Player("champ1", 0);
    private Player player2 = new Player("champ2", 1);

    private Pawn w_pawn =  new Pawn(0, 1, "w_pawn___",  "White_Pawn.png", 1, 0);

    private Pawn w_pawn1 = new Pawn(0, 2, "w_pawn___",  "White_Pawn.png", 1, 1);

    private Pawn w_pawn2 = new Pawn(0, 3, "w_pawn___",  "White_Pawn.png", 1, 2);

    private Pawn w_pawn3 = new Pawn(0, 4, "w_pawn___",  "White_Pawn.png", 1, 3);

    private Pawn w_pawn4 = new Pawn(0, 5, "w_pawn___",  "White_Pawn.png", 1, 4);

    private Pawn w_pawn5 = new Pawn(0, 6, "w_pawn___",  "White_Pawn.png", 1, 5);

    private Pawn w_pawn6 = new Pawn(0, 7, "w_pawn___",  "White_Pawn.png", 1, 6);

    private Pawn w_pawn7 = new Pawn(0, 8, "w_pawn___",  "White_Pawn.png", 1, 7);

    private Rook w_rook1 = new Rook(0, 9, "w_rook1__", "White_Rook.png", 0, 0);

    private Knight w_knight1 = new Knight(0, 10, "w_knight1", "White_Knight.png", 0, 1);

    private Bishop w_bishop1 = new Bishop(0, 11, "w_bishop1", "White_Bishop.png",  0, 2);

    private Queen w_queen = new Queen(0, 12, "w_queen__", "White_Queen.png", 0, 3);

    private King w_king = new King(0, 28, "w_king___", "White_King.png",  0, 4);

    private Bishop w_bishop2 = new Bishop(0, 14, "w_bishop2", "White_Bishop.png", 0, 5);

    private Knight w_knight2 = new Knight(0, 15, "w_knight2","White_Knight.png", 0, 6);

    private Rook w_rook2 = new Rook(0, 16, "w_rook2__", "White_Rook.png", 0, 7);

    private Pawn b_pawn =  new Pawn(1, 1+16, "b_pawn___", "Black_Pawn.png", 6, 0);

    private Pawn b_pawn1 = new Pawn(1, 2+16, "b_pawn___", "Black_Pawn.png", 6, 1);

    private Pawn b_pawn2 = new Pawn(1, 3+16, "b_pawn___", "Black_Pawn.png", 6, 2);

    private Pawn b_pawn3 = new Pawn(1, 4+16, "b_pawn___", "Black_Pawn.png", 6, 3);

    private Pawn b_pawn4 = new Pawn(1, 5+16, "b_pawn___", "Black_Pawn.png", 6, 4);

    private Pawn b_pawn5 = new Pawn(1, 6+16, "b_pawn___", "Black_Pawn.png", 6, 5);

    private Pawn b_pawn6 = new Pawn(1, 7+16, "b_pawn___", "Black_Pawn.png", 6, 6);

    private Pawn b_pawn7 = new Pawn(1, 8+16, "b_pawn___", "Black_Pawn.png", 6, 7);

    private Rook b_rook1 = new Rook(1, 25, "b_rook1__", "Black_Rook.png",  7, 0);

    private Knight b_knight1 = new Knight(1, 26, "b_knight1", "Black_Knight.png",7, 1);

    private Bishop b_bishop1 = new Bishop(1, 27, "b_bishop1", "Black_Bishop.png", 7, 2);

    private Queen b_queen = new Queen(1, 15, "b_queen__", "Black_Queen.png", 7, 3);

    private King b_king = new King(1, 29, "b_king___", "Black_King.png", 7, 4);

    private Bishop b_bishop2 = new Bishop(1, 30, "b_bishop2", "Black_Bishop.png", 7, 5);

    private Knight b_knight2 = new Knight(1, 31, "b_knight2", "Black_Knight.png", 7, 6);

    private Rook b_rook2 = new Rook(1, 32, "b_rook2__", "Black_Rook.png",7, 7);

    public Game(){
        super("Chess");
        contents = getContentPane();
        setSize(900, 900);
        contents.setLayout(new BorderLayout());
        contents.setLayout(new GridLayout(8,8));
        ButtonHandler buttonHandler = new ButtonHandler();
        for(int i=7; i>=0;  i--){
            for(int j=0; j<8; j++){
                squares[i][j] = new JButton();
                if((i + j)%2 == 0){
                    squares[i][j].setBackground(Color.WHITE);
                }
                else{
                    squares[i][j].setBackground(Color.orange);
                }
                contents.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);
            }
        }


        setResizable(false);
        setVisible(true);

        player1.player_pieces_update(board, w_pawn);
        board.GameBoard[1][0].setPieceOnTile(w_pawn);

        player1.player_pieces_update(board, w_pawn1);
        board.GameBoard[1][1].setPieceOnTile(w_pawn1);

        player1.player_pieces_update(board, w_pawn2);
        board.GameBoard[1][2].setPieceOnTile(w_pawn2);

        player1.player_pieces_update(board, w_pawn3);
        board.GameBoard[1][3].setPieceOnTile(w_pawn3);

        player1.player_pieces_update(board, w_pawn4);
        board.GameBoard[1][4].setPieceOnTile(w_pawn4);

        player1.player_pieces_update(board, w_pawn5);
        board.GameBoard[1][5].setPieceOnTile(w_pawn5);

        player1.player_pieces_update(board, w_pawn6);
        board.GameBoard[1][6].setPieceOnTile(w_pawn6);

        player1.player_pieces_update(board, w_pawn7);
        board.GameBoard[1][7].setPieceOnTile(w_pawn7);

        player1.player_pieces_update(board, w_rook1);
        board.GameBoard[0][0].setPieceOnTile(w_rook1);

        player1.player_pieces_update(board, w_knight1);
        board.GameBoard[0][1].setPieceOnTile(w_knight1);

        player1.player_pieces_update(board, w_bishop1);
        board.GameBoard[0][2].setPieceOnTile(w_bishop1);

        player1.player_pieces_update(board, w_queen);
        board.GameBoard[0][3].setPieceOnTile(w_queen);

        player1.player_pieces_update(board, w_king);
        board.GameBoard[0][4].setPieceOnTile(w_king);

        player1.player_pieces_update(board, w_bishop2);
        board.GameBoard[0][5].setPieceOnTile(w_bishop2);

        player1.player_pieces_update(board, w_knight2);
        board.GameBoard[0][6].setPieceOnTile(w_knight2);

        player1.player_pieces_update(board, w_rook2);
        board.GameBoard[0][7].setPieceOnTile(w_rook2);

        player2.player_pieces_update(board, b_pawn);
        board.GameBoard[6][0].setPieceOnTile(b_pawn);

        player2.player_pieces_update(board, b_pawn1);
        board.GameBoard[6][1].setPieceOnTile(b_pawn1);

        player2.player_pieces_update(board, b_pawn2);
        board.GameBoard[6][2].setPieceOnTile(b_pawn2);

        player2.player_pieces_update(board, b_pawn3);
        board.GameBoard[6][3].setPieceOnTile(b_pawn3);

        player2.player_pieces_update(board, b_pawn4);
        board.GameBoard[6][4].setPieceOnTile(b_pawn4);

        player2.player_pieces_update(board, b_pawn5);
        board.GameBoard[6][5].setPieceOnTile(b_pawn5);

        player2.player_pieces_update(board, b_pawn6);
        board.GameBoard[6][6].setPieceOnTile(b_pawn6);

        player2.player_pieces_update(board, b_pawn7);
        board.GameBoard[6][7].setPieceOnTile(b_pawn7);

        player2.player_pieces_update(board, b_rook1);
        board.GameBoard[7][0].setPieceOnTile(b_rook1);

        player2.player_pieces_update(board, b_knight1);
        board.GameBoard[7][1].setPieceOnTile(b_knight1);

        player2.player_pieces_update(board, b_bishop1);
        board.GameBoard[7][2].setPieceOnTile(b_bishop1);

        player2.player_pieces_update(board, b_queen);
        board.GameBoard[7][3].setPieceOnTile(b_queen);

        player2.player_pieces_update(board, b_king);
        board.GameBoard[7][4].setPieceOnTile(b_king);

        player2.player_pieces_update(board, b_bishop2);
        board.GameBoard[7][5].setPieceOnTile(b_bishop2);

        player2.player_pieces_update(board, b_knight2);
        board.GameBoard[7][6].setPieceOnTile(b_knight2);

        player2.player_pieces_update(board, b_rook2);
        board.GameBoard[7][7].setPieceOnTile(b_rook2);


        for(int i=7; i>=0;  i--){
            for(int j=0; j<8; j++){
                if(board.GameBoard[i][j].pieceOnTile != null) {
                    squares[i][j].setIcon(new ImageIcon(getClass().getResource(board.GameBoard[i][j].pieceOnTile.image_path)));
                }
            }
        }
    }

    public boolean is_checkmate(){
        return true;
    }
    private void show_board(Board board){
        System.out.println();
        System.out.println();
        for(int i=7; i>=0; i--){
            for(int j=0; j<8; j++){
                String s;
                if(board.GameBoard[i][j].getPieceOnTile() != null) {
                    s = board.GameBoard[i][j].getPieceOnTile().name + " (" + board.GameBoard[i][j].getPieceOnTile().piecePosition_x + "," + board.GameBoard[i][j].getPieceOnTile().piecePosition_y + ")";
                }
                else{
                    s = "--------- (" + i + "," + j + ")";
                }
                System.out.print(s + "     ");
            }
            System.out.println();
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    private boolean in_Available(int i, int j){
        for(int q=0; q<available_moves.size(); q++){
            if(available_moves.get(q).src_x == i && available_moves.get(q).src_y == j){
                System.out.println("In Available " + i + ", " + j);
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        Game Game = new Game();
        Game.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Scanner S = new Scanner(System.in);
        Game.show_board(Game.board);
        Game.turn = 0;
    }

    public class ButtonHandler implements ActionListener{
        int check1 = 0;
        int in_check = 0;
        boolean is_checkmate = false;
        int check_selected = 0;
        int flag = 0;
        ArrayList<Move> move_of_ij = new ArrayList<Move>();
        @Override
        public void actionPerformed(ActionEvent e){
            Object src = e.getSource();

            if(is_checkmate){
                if(turn == 0) {
                    JOptionPane.showMessageDialog(null, "CheckMate Black Won");
                }
                else{
                    JOptionPane.showMessageDialog(null, "CheckMate White Won");
                }
                return;
            }
            if(in_check == 1){
                //return;

                for (int i = 7; i >= 0; i--) {
                    for (int j = 0; j < 8; j++) {
                        if (squares[i][j] == src) {


                            for (int q = 0; q < move_of_ij.size(); q++) {

                                int src_x = move_of_ij.get(q).src_x;
                                int src_y = move_of_ij.get(q).src_y;

                                int des_x = move_of_ij.get(q).des_x;
                                int des_y = move_of_ij.get(q).des_y;

                                if (i == des_x && j == des_y) {
                                    //move
                                    if (turn == 0) {

                                        Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                        Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                        if (des_piece != null) {
                                            //remove_piece(int x, int y);
                                            board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                            player2.player_remove_piece(board, des_piece);
                                        }
                                        board.GameBoard[src_x][src_y].removePieceOnTile();
                                        board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                        turn = 1;
                                    }
                                    else {

                                        Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                        Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                        if (des_piece != null) {
                                            //remove_piece(int x, int y);
                                            board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                            player1.player_remove_piece(board, des_piece);
                                        }

                                        board.GameBoard[src_x][src_y].removePieceOnTile();
                                        board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                        turn = 0;

                                    }
                                    for (int qi = 7; qi >= 0; qi--) {
                                        for (int qj = 0; qj < 8; qj++) {
                                            if (board.GameBoard[qi][qj].pieceOnTile != null) {
                                                squares[qi][qj].setIcon(new ImageIcon(getClass().getResource(board.GameBoard[qi][qj].pieceOnTile.image_path)));
                                            } else {
                                                squares[qi][qj].setIcon(null);
                                            }
                                            board.GameBoard[qi][qj].deselect_tile1(squares);
                                        }
                                    }

                                    if(turn == 0){
                                        King k1 = (King) player2.getKing();
                                        System.out.println("X = " + k1.piecePosition_x + " Y = " + k1.piecePosition_y);
                                        boolean check = k1.is_in_check(board);
                                        if(check) {
                                            k1.desetHighlight_danger(squares);
                                        }
                                    }
                                    else{
                                        King k1 = (King) player1.getKing();
                                        System.out.println("X = " + k1.piecePosition_x + " Y = " + k1.piecePosition_y);
                                        boolean check = k1.is_in_check(board);
                                        if(check) {
                                            k1.desetHighlight_danger(squares);
                                        }
                                    }


                                    in_check = 0;
                                    check_selected = 0;
                                    check1 = 0;
                                    move_of_ij.clear();
                                    return;
                                }
                            }


                            for(int q=7; q>=0; q--){
                                for(int q1=0; q1<8; q1++){
                                    if(board.GameBoard[q][q1].is_highlighted){
                                        board.GameBoard[q][q1].dehighlight_tile(squares);
                                    }
                                    board.GameBoard[q][q1].deselect_tile1(squares);
                                }
                            }
                            check1 = 0;
                            check_selected = 0;
                            move_of_ij.clear();
                        }
                    }
                }
            }
            if(check_selected == 1) {
                System.out.println("In Check Selected.");
                for (int i = 7; i >= 0; i--) {
                    for (int j = 0; j < 8; j++) {
                        if (squares[i][j] == src) {

                            if(highlighted_moves.size() > 0) {
                                for (int q = 0; q < highlighted_moves.size(); q++) {

                                    int src_x = highlighted_moves.get(q).src_x;
                                    int src_y = highlighted_moves.get(q).src_y;

                                    int des_x = highlighted_moves.get(q).des_x;
                                    int des_y = highlighted_moves.get(q).des_y;

                                    if (i == des_x && j == des_y) {
                                        System.out.println("Highlighted Tile");
                                        if (turn == 0) {

                                            Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                            Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                            if (des_piece != null) {
                                                //remove_piece(int x, int y);
                                                board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                                player2.player_remove_piece(board, des_piece);
                                            }
                                            board.GameBoard[src_x][src_y].removePieceOnTile();
                                            board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                            turn = 1;
                                        }
                                        else {

                                            Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                            Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                            if (des_piece != null) {
                                                //remove_piece(int x, int y);
                                                board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                                player1.player_remove_piece(board, des_piece);
                                            }

                                            board.GameBoard[src_x][src_y].removePieceOnTile();
                                            board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                            turn = 0;

                                        }
                                        for (int qi = 7; qi >= 0; qi--) {
                                            for (int qj = 0; qj < 8; qj++) {
                                                if (board.GameBoard[qi][qj].pieceOnTile != null) {
                                                    squares[qi][qj].setIcon(new ImageIcon(getClass().getResource(board.GameBoard[qi][qj].pieceOnTile.image_path)));
                                                } else {
                                                    squares[qi][qj].setIcon(null);
                                                }
                                                board.GameBoard[qi][qj].deselect_tile1(squares);
                                            }
                                        }

                                        if(turn == 0){
                                            King k1 = (King) player2.getKing();
                                            System.out.println("X = " + k1.piecePosition_x + " Y = " + k1.piecePosition_y);
                                            k1.desetHighlight_danger(squares);
                                        }
                                        else{
                                            King k1 = (King) player1.getKing();
                                            System.out.println("X = " + k1.piecePosition_x + " Y = " + k1.piecePosition_y);
                                            k1.desetHighlight_danger(squares);
                                        }

                                        check_selected = 0;
                                        check1 = 0;
                                        for(int qi=7; qi>=0;  qi--){
                                            for(int qj=0; qj<8; qj++){
                                                if((qi + qj)%2 == 0){
                                                    squares[qi][qj].setBackground(Color.WHITE);
                                                }
                                                else{
                                                    squares[qi][qj].setBackground(Color.orange);
                                                }
                                                if(board.GameBoard[i][j].pieceOnTile != null) {
                                                    squares[i][j].setIcon(new ImageIcon(getClass().getResource(board.GameBoard[i][j].pieceOnTile.image_path)));
                                                }
                                            }
                                        }
                                        highlighted_moves.clear();
                                        return;
                                    }
                                }
                            }

                            for(int q=7; q>=0; q--){
                                for(int q1=0; q1<8; q1++){
                                    squares[q][q1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                                    board.GameBoard[q][q1].deselect_tile();
                                }
                            }
                            highlighted_moves.clear();
                            if(in_Available(i, j)){
                                board.GameBoard[i][j].select_tile1(squares);
                                for(int q=0; q<available_moves.size(); q++){
                                    if(available_moves.get(q).src_x == i && available_moves.get(q).src_y == j){
                                        highlighted_moves.add(available_moves.get(q));
                                        board.GameBoard[available_moves.get(q).des_x][available_moves.get(q).des_y].highlight_tile(squares);
                                    }
                                }
                                check_selected = 1;
                                return;
                            }

                            show_board(board);
                            return;
                        }
                    }
                }
                return;
            }
            //if king in danger
            if(check1 == 1){
                System.out.println("King is in danger 491");
                int flag = 0;
                for(int i=7; i>=0; i--){
                    for(int j=0; j<8; j++){
                        if(squares[i][j] == src){
                            highlighted_moves.clear();
                            if(in_Available(i, j)){
                                board.GameBoard[i][j].select_tile1(squares);
                                for(int q=0; q<available_moves.size(); q++){
                                    if(available_moves.get(q).src_x == i && available_moves.get(q).src_y == j){
                                        highlighted_moves.add(available_moves.get(q));
                                        board.GameBoard[available_moves.get(q).des_x][available_moves.get(q).des_y].highlight_tile(squares);
                                    }
                                }
                                check_selected = 1;
                                return;
                            }
                        }
                    }
                }
                return;
            }
            // to check for king in danger
            if(turn == 0){
                King k1 = (King) player1.getKing();
                boolean check = k1.is_in_check(board);
                int dan_size = k1.danger_list.size();
                if(check){
                    check1 = 1;
                    k1.setHighlight_danger(squares);
                    available_moves.clear();
                    ArrayList<Piece> player1_pieces = player1.get_pieces();
                    for(int i=0; i<player1_pieces.size(); i++){
                        //Piece p = player2_pieces.get(i);
                        ArrayList<Move> move_of_p = player1_pieces.get(i).calculate_move(board);
                        for(int j=0; j<move_of_p.size(); j++){
                            if(k1.removes_check(move_of_p.get(j), board)){
                                available_moves.add(move_of_p.get(j));
                            }
                        }
                    }
                    if(available_moves.size() > 0){
                        System.out.println("Calculated Available moves!");
                    }
                    else{
                        is_checkmate = true;
                    }
                    return;
                }
            }
            else{
                King k1 = (King) player2.getKing();
                boolean check = k1.is_in_check(board);
                if(check){
                    check1 = 1;
                    k1.setHighlight_danger(squares);
                    available_moves.clear();
                    ArrayList<Piece> player2_pieces = player2.get_pieces();
                    System.out.println("Calculating Available moves");
                    for(int i=0; i<player2_pieces.size(); i++){
                        //Piece p = player2_pieces.get(i);
                        ArrayList<Move> move_of_p = player2_pieces.get(i).calculate_move(board);
                        for(int j=0; j<move_of_p.size(); j++){
                            if(k1.removes_check(move_of_p.get(j), board)){
                                available_moves.add(move_of_p.get(j));
                            }
                        }
                    }
                    if(available_moves.size() > 0){
                        System.out.println("Calculated Available moves!");
                    }
                    else{
                        is_checkmate = true;
                    }
                    return;
                }
            }
            //if no check
            int flag = 0;
            for(int i=7; i>=0; i--){
                if(flag == 1){
                    break;
                }
                for(int j=0; j<8; j++){
                    if(squares[i][j] == src){
                        //King not in check.
                        //if this move lets self's king in check so return
                        if(board.GameBoard[i][j].getPieceOnTile() != null && board.GameBoard[i][j].getPieceOnTile().color == turn) {
                            if (turn == 0) {
                                King k1 = (King) player1.getKing();
                                boolean leave_king_in_check;
                                move_of_ij.clear();
                                ArrayList<Move> temp_move = board.GameBoard[i][j].getPieceOnTile().calculate_move(board);
                                for (int qi = 0; qi < temp_move.size(); qi++) {
                                    Move move = temp_move.get(qi);
                                    int x1 = move.src_x;
                                    int y1 = move.src_y;
                                    int x2 = move.des_x;
                                    int y2 = move.des_y;
                                    System.out.println(x1 + ", " + y1 + " to " + x2 + ", " + y2);
                                }
                                for (int qi = 0; qi < temp_move.size(); qi++) {
                                    Move move = temp_move.get(qi);
                                    int src_x = move.src_x;
                                    int src_y = move.src_y;
                                    int des_x = move.des_x;
                                    int des_y = move.des_y;
                                    Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                    Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                    if (des_piece != null) {
                                        board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                    }
                                    board.GameBoard[src_x][src_y].removePieceOnTile();
                                    board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                    //code for checking if check removed or not
                                    boolean check = k1.is_in_check(board);
                                    if (check) {
                                        leave_king_in_check = true;
                                    } else {
                                        leave_king_in_check = false;
                                    }
                                    //temporary alter board undo
                                    board.GameBoard[des_x][des_y].removePieceOnTile();
                                    board.GameBoard[src_x][src_y].setPieceOnTile(src_piece);
                                    if (des_piece != null) {
                                        board.GameBoard[des_x][des_y].setPieceOnTile(des_piece);
                                    }
                                    if (leave_king_in_check == false) {
                                        move_of_ij.add(move);
                                    }
                                }
                                if(move_of_ij.size() != temp_move.size()) {
                                    in_check = 1;
                                    if(move_of_ij.size() == 0) {
                                    }
                                    else{
                                        board.GameBoard[i][j].select_tile1(squares);
                                        check_selected = 1;
                                        for (int qi = 0; qi < move_of_ij.size(); qi++) {
                                            Move move = move_of_ij.get(qi);
                                            int x1 = move.src_x;
                                            int y1 = move.src_y;
                                            int x2 = move.des_x;
                                            int y2 = move.des_y;
                                            board.GameBoard[x2][y2].highlight_tile(squares);
                                        }
                                    }
                                    return;
                                }

                            }
                            else {
                                King k1 = (King) player2.getKing();
                                boolean leave_king_in_check;
                                move_of_ij.clear();
                                ArrayList<Move> temp_move = board.GameBoard[i][j].getPieceOnTile().calculate_move(board);
                                for (int qi = 0; qi < temp_move.size(); qi++) {
                                    Move move = temp_move.get(qi);
                                    int src_x = move.src_x;
                                    int src_y = move.src_y;
                                    int des_x = move.des_x;
                                    int des_y = move.des_y;
                                    Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                    Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                    if (des_piece != null) {
                                        //remove_piece(int x, int y);
                                        board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                    }
                                    board.GameBoard[src_x][src_y].removePieceOnTile();
                                    board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                    //code for checking if check removed or not
                                    boolean check = k1.is_in_check(board);
                                    if (check) {
                                        leave_king_in_check = true;
                                    } else {
                                        leave_king_in_check = false;
                                    }
                                    //temporary alter board undo
                                    board.GameBoard[des_x][des_y].removePieceOnTile();
                                    board.GameBoard[src_x][src_y].setPieceOnTile(src_piece);
                                    if (des_piece != null) {
                                        board.GameBoard[des_x][des_y].setPieceOnTile(des_piece);
                                    }
                                    if (leave_king_in_check == false) {
                                        move_of_ij.add(move);
                                    }
                                }
                                if(move_of_ij.size() != temp_move.size()) {
                                    if(move_of_ij.size() == 0) {
                                    }
                                    else{
                                        in_check = 1;
                                        board.GameBoard[i][j].select_tile1(squares);
                                        check_selected = 1;
                                        System.out.println("move_of_ij after = ");
                                        for (int qi = 0; qi < move_of_ij.size(); qi++) {
                                            Move move = move_of_ij.get(qi);
                                            int x1 = move.src_x;
                                            int y1 = move.src_y;
                                            int x2 = move.des_x;
                                            int y2 = move.des_y;
                                            System.out.println(x1 + ", " + y1 + " to " + x2 + ", " + y2);

                                            board.GameBoard[x2][y2].highlight_tile(squares);
                                        }
                                    }
                                    return;
                                }

                            }
                        }
                        for(int q=0; q<highlighted_moves.size(); q++){
                            int src_x = highlighted_moves.get(q).src_x;;
                            int src_y = highlighted_moves.get(q).src_y;;
                            int des_x = highlighted_moves.get(q).des_x;
                            int des_y = highlighted_moves.get(q).des_y;
                            if(i == des_x && j == des_y){
                                //Clicked on a Highlighted Tile
                                System.out.println("Clicked on a Highlighted Tile");
                                if(turn == 0) {
                                    Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                    Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                    if (des_piece != null) {
                                        //remove_piece(int x, int y);
                                        board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                        player2.player_remove_piece(board, des_piece);
                                    }
                                    board.GameBoard[src_x][src_y].removePieceOnTile();
                                    board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                    turn = 1;
                                }
                                else{
                                    Piece src_piece = board.GameBoard[src_x][src_y].getPieceOnTile();
                                    Piece des_piece = board.GameBoard[des_x][des_y].getPieceOnTile();
                                    if (des_piece != null) {
                                        board.GameBoard[des_x][des_y].removePieceOnTile();  //removes destination piece
                                        player1.player_remove_piece(board, des_piece);
                                    }

                                    board.GameBoard[src_x][src_y].removePieceOnTile();
                                    board.GameBoard[des_x][des_y].setPieceOnTile(src_piece);
                                    turn = 0;
                                }
                                for(int qi=7; qi>=0;  qi--){
                                    for(int qj=0; qj<8; qj++){
                                        if(board.GameBoard[qi][qj].pieceOnTile != null) {
                                            squares[qi][qj].setIcon(new ImageIcon(getClass().getResource(board.GameBoard[qi][qj].pieceOnTile.image_path)));
                                        }
                                        else{
                                            squares[qi][qj].setIcon(null);
                                        }
                                        board.GameBoard[qi][qj].deselect_tile1(squares);
                                    }
                                }
                                highlighted_moves.clear();
                                if(turn == 0){
                                    King k1 = (King) player1.getKing();
                                    boolean check = k1.is_in_check(board);
                                    if(check){

                                        System.out.println("King in Danger 801");
                                        k1.setHighlight_danger(squares);
                                        return;
                                    }
                                }
                                else{
                                    King k1 = (King) player2.getKing();
                                    boolean check = k1.is_in_check(board);
                                    if(check){
                                        System.out.println("King in Danger 810");
                                        k1.setHighlight_danger(squares);
                                        return;
                                    }
                                }
                                return;
                            }
                        }
                        if(board.GameBoard[i][j].getPieceOnTile() != null) {
                            // if piece present
                            System.out.print("Piece Present ");
                            if (board.GameBoard[i][j].getPieceOnTile().color == turn) {
                                if (board.GameBoard[i][j].isselected()) {
                                    System.out.print("Clicked on already Selected Piece, so unselecting. \n");
                                    //if a selected board is selected
                                    for(int q=7; q>=0; q--){
                                        for(int q1=0; q1<8; q1++){
                                            squares[q][q1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                                            board.GameBoard[q][q1].deselect_tile();
                                        }
                                    }
                                    highlighted_moves.clear();
                                }
                                else{
                                    System.out.print("Clicked on not Selected Piece, so selecting. \n");
                                    //unselect all
                                    for(int q=7; q>=0; q--){
                                        for(int q1=0; q1<8; q1++){
                                            board.GameBoard[q][q1].deselect_tile1(squares);
                                        }
                                    }
                                    highlighted_moves.clear();
                                    //if a non-selected board is selected
                                    if(turn == 0){
                                        //player1 move
                                        Piece p1 = board.GameBoard[i][j].getPieceOnTile();
                                        if(player1.piece_of_player(p1)){
                                            highlighted_moves.clear();
                                            highlighted_moves = p1.calculate_move(board);
                                            if(highlighted_moves.size() == 0){
                                            }
                                            else {
                                                for (int k = 0; k < highlighted_moves.size(); k++) {
                                                    int x2 = highlighted_moves.get(k).des_x;
                                                    int y2 = highlighted_moves.get(k).des_y;
                                                    board.GameBoard[x2][y2].highlight_tile(squares);
                                                }
                                                board.GameBoard[i][j].select_tile1(squares);
                                            }
                                        }
                                    }
                                    else if(turn == 1){
                                        //player2 move
                                        Piece p1 = board.GameBoard[i][j].getPieceOnTile();
                                        if(player2.piece_of_player(p1)){
                                            highlighted_moves.clear();
                                            highlighted_moves = p1.calculate_move(board);
                                            if(highlighted_moves.size() == 0){
                                            }
                                            else {
                                                board.GameBoard[i][j].select_tile1(squares);
                                                for (int k = 0; k < highlighted_moves.size(); k++) {
                                                    int x2 = highlighted_moves.get(k).des_x;
                                                    int y2 = highlighted_moves.get(k).des_y;
                                                    board.GameBoard[x2][y2].highlight_tile(squares);
                                                }
                                            }
                                        }
                                    }
                                    board.GameBoard[i][j].select_tile();
                                }
                            }
                            else{
                                System.out.print("But Wrong Turn");
                            }
                        }
                        else{
                            System.out.println("No piece");
                            // if piece not present
                            for(int q=7; q>=0; q--){
                                for(int q1=0; q1<8; q1++){
                                    squares[q][q1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
                                    board.GameBoard[q][q1].deselect_tile();
                                }
                            }
                            highlighted_moves.clear();
                        }
                        flag = 1;
                        break;
                    }
                }
            }
        }
    }
}
