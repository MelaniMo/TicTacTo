import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JFrame implements ActionListener {
    private JPanel board;
    private JButton[][] ab=new JButton[Dim][Dim];
    private JLabel label;
    private Tris tris;
    private GlobalVar v;
    private Start start;
    private char player;
    private static final int Dim = 3;

    public Board(){
        setSize(450,400);
        setLocation(300, 400);
        board=new JPanel(new GridLayout(3, 3));

        for (int i=0; i<Dim; i++){
            for (int j=0; j<Dim; j++) {
                ab[i][j] = new JButton();
                ab[i][j].addActionListener(this);
                board.add(ab[i][j]);
            }
        }
        label=new JLabel("Inizio partita");
        add(label);
        add(board);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        gameStart();
    }
    public void gameStart(){
        start=new Start();
        player=v.getcharPlayer();
        label.setText("Gioca: "+player);
        tris=new Tris();
    }
    private int[] search(JButton b){
        int[] pos=new int[2];
        pos[0]=-1;
        pos[1]=-1;
        for (int i=0; i < Dim; i++){
            for (int j=0; j< Dim; j++){
                if (ab[i][j].equals(b)){
                    pos[0]=i;
                    pos[1]=j;
                }
            }
        }
        return pos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b;
        b=(JButton)e.getSource();
        int[] pos=search(b);
        if (pos[0] == -1)
            return;
        if (player=='X'){
            b.setText("X");
            b.setBackground(new Color(255,89,89));
            b.setEnabled(false);
            player='O';
        }
        else if (player == 'O'){
            b.setText("O");
            b.setBackground(new Color(174,247,91));
            b.setEnabled(false);
            player = 'X';
        }
        tris.play(pos[0], pos[1]);
    }

    public static void main(String[] args) {
        Game game=new Game();
    }
}
