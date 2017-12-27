package board;
public class Move {
    public int src_x, des_x;
    public int src_y, des_y;
    public Move(int src_x, int src_y, int des_x, int des_y){
        this.src_x = src_x;
        this.src_y = src_y;
        this.des_x = des_x;
        this.des_y = des_y;
    }
}
