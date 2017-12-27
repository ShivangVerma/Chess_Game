package pieces;

import board.*;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Piece {

    public int piecePosition_x;
    public int piecePosition_y;
    public int color;
    int Id;
    public String name;
    public String image_path;
    public boolean availability;

    ArrayList<Move> possible_moves = new ArrayList<Move>();
    public abstract ArrayList<Move> calculate_move(Board board);

    Piece(int color, int Id, String name, String image_path){
        this.color = color;
        this.Id = Id;
        this.name = name;
        this.image_path = image_path;
        this.availability = true;
    }

    public void setColor(int color){
        this.color = color;
    }

    public void setId(int Id){
        this.Id = Id;
    }

    public void setImage_path(String image_path){
        this.image_path = image_path;
    }

    public int getColor(){
        return color;
    }

    public int getId(){
        return Id;
    }

    public String getImage_Path(){
        return image_path;
    }

    public abstract Piece get_copy();

}


