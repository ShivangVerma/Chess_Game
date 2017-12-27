package board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Grid_Layout extends JFrame{
    public JFrame game_frame;
    private Container contents;
    private JButton[][] squares = new JButton[8][8];
    private Grid_Layout(){
        super("Chess");
        contents = getContentPane();
        contents.setLayout(new GridLayout(8,8));
        ButtonHandler buttonHandler = new ButtonHandler();
        for(int i=7; i>=0;  i--){
            for(int j=0; j<8; j++){
                squares[i][j] = new JButton();
                if((i + j)%2 == 0){
                    squares[i][j].setBackground(Color.BLACK);
                }
                else{
                    squares[i][j].setBackground(Color.WHITE);
                }
                contents.add(squares[i][j]);
                squares[i][j].addActionListener(buttonHandler);
            }
        }
        setSize(900, 900);
        setResizable(false);
        setVisible(true);
    }

    public static void main(String args[]){
        Grid_Layout game_board = new Grid_Layout();
    }

    private void process_click(int i, int j) {
        JOptionPane.showMessageDialog(null, "Selected " + i + " " + j);
        squares[i][j].setIcon(new ImageIcon(getClass().getResource("images.png")));
    }

    private class ButtonHandler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            Object src = e.getSource();
            for(int i=7; i>=0; i--){
                for(int j=0; j<8; j++){
                    if(squares[i][j] == src){
                        process_click(i, j);
                    }
                }
            }
        }
    }

}