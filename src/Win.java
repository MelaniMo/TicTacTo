import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Win extends JFrame implements ActionListener {
    private JLabel winner, ret;
    private JButton rePlay, stop;
    private JPanel panel;
    private GlobalVar v=new GlobalVar();
    private Board board;

    public Win(){
        setLocation(300, 400);
        setSize(300, 150);
        panel = new JPanel();
        winner=new JLabel("Ha vinto "+v.winner+"!");
        panel.add(winner);
        ret=new JLabel("Vuoi riprovare?");
        panel.add(ret);
        rePlay=new JButton("Si");
        rePlay.addActionListener(this);
        panel.add(rePlay);
        stop=new JButton("No");
        stop.addActionListener(this);
        panel.add(stop);
        add(panel);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void start(){
        board=new Board();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b= (JButton) e.getSource();
        if (b.getText().equals(rePlay.getText())){
            board.gameStart();
        }
        else if (b.getText().equals(stop.getText())){
            setVisible(false);
            dispose();
            board.dispose();
        }
    }
}
