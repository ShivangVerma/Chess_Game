package board;
import pieces.Piece;
import java.util.ArrayList;

public class Player {
    private String name;
    private int gamesplayed, gameswon;
    private int totalgames;
    private int color;
    private ArrayList<Piece> piecesofplayer = new ArrayList<Piece>();
    ArrayList<Piece> get_pieces(){
        return piecesofplayer;
    }
    Piece getKing(){
        for(int i=0; i<piecesofplayer.size(); i++){
            if(piecesofplayer.get(i).name.equals("w_king___") || piecesofplayer.get(i).name.equals("b_king___")){
                return piecesofplayer.get(i);
            }
        }
        return null;
    }
    Player(String name, int color){
        this.name = name;
        this.color = color;
        this.gamesplayed = 0;
        this.gameswon = 0;
        this.totalgames = 0;
    }
    public String getName(){
        return name;
    }
    boolean piece_of_player(Piece piece){
        for(int i=0; i<piecesofplayer.size(); i++){
            if(piecesofplayer.get(i) == piece){
                return true;
            }
        }
        return false;
    }
    void player_pieces_update(Board board, Piece piece){
        piecesofplayer.add(piece);
    }
    void player_remove_piece(Board board, Piece piece){
        piece.availability = false;
        piecesofplayer.remove(piece);
    }
}
