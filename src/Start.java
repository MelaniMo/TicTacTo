import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start extends JFrame {
    private JLabel text;
    private JTextField palyer;
    private JButton inizia;
    private JPanel panel;
    private String labelText="Chi inizia a giocare: X o O";
    private GlobalVar v = new GlobalVar();



    public Start() {
        setLocation(300, 400);
        setSize(300, 150);
        panel = new JPanel();
        if (v.nPlay <= 1 ) {
            labelText="Chi inizia a giocare: X o O";
            text = new JLabel(labelText);
            palyer = new JTextField(10);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setVisible(true);

            Action a = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    text.setText(labelText);
                    String s = palyer.getText();
                    System.out.println(s);
                    if (s.equals("X")) {
                        v.player = 1;
                        setVisible(false);
                        dispose();
                    } else if (s.equals("O")) {
                        v.player = 10;
                        setVisible(false);
                        dispose();
                    }
                    text.setText(text.getText() + " Errore reinserisci");
                }
            };
        palyer.getInputMap().put(KeyStroke.getKeyStroke('\n'), a);
        panel.add(text);
        panel.add(palyer);
        }
        else {
            text=new JLabel("Inizia il Vincitore");
            v.player=v.winner;
            inizia=new JButton("Inizia");
            panel.add(text);
            panel.add(inizia);
        }
        add(panel);
    }
    public String getPalyer() {
        return palyer.getText();
    }
}
