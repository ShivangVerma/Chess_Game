package board;

import pieces.Piece;
import javax.swing.*;
import java.awt.*;

public class Tile {
    private int x, y;
    Piece pieceOnTile;
    private boolean is_occupied;
    private boolean is_selected;
    boolean is_highlighted;
    Tile(int x, int y, Piece pieceonTile, boolean is_occupied, boolean is_selected){
        this.x = x;
        this.y = y;
        this.pieceOnTile = pieceonTile;
        this.is_occupied = is_occupied;
        this.is_selected = is_selected;
    }
    void deselect_tile(){
        is_selected = false;
    }
    void highlight_tile(JButton[][] squares){
        squares[x][y].setBorder(BorderFactory.createLineBorder(Color.blue, 10));
        is_highlighted = true;
    }
    void dehighlight_tile(JButton[][] squares){
        squares[x][y].setBorder(BorderFactory.createLineBorder(Color.white, 10));
        is_highlighted = false;
    }
    void select_tile(){
        is_selected = true;
    }
    boolean isselected(){
        if(is_selected){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean isOccupied(){
        if(is_occupied){
            return true;
        }
        else{
            return false;
        }
    }
    public Piece getPieceOnTile(){
        if(pieceOnTile != null) {
            return pieceOnTile;
        }
        else{
            return null;
        }
    }
    public void removePieceOnTile(){
        //System.out.println("Set x = y = -1");
        if(pieceOnTile == null) {
            return;
        }
        else{
            pieceOnTile.piecePosition_x = -1;
            pieceOnTile.piecePosition_y = -1;
            this.pieceOnTile = null;
        }
        is_occupied = false;
    }
    public void setPieceOnTile(Piece pieceOnTile){
        pieceOnTile.piecePosition_x = this.x;
        pieceOnTile.piecePosition_y = this.y;
        if(pieceOnTile != null) {
            this.pieceOnTile = pieceOnTile;
        }
        else{
            this.pieceOnTile = null;
        }
        is_occupied = true;
    }
    void select_tile1(JButton[][] squares){
        squares[x][y].setBorder(BorderFactory.createLineBorder(Color.RED, 10));
        is_selected = true;
    }
    void deselect_tile1(JButton[][] squares){
        squares[x][y].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
        is_selected = false;
    }
}
