import javax.swing.*;
import java.awt.*;

public class Main {

    static JFrame frame = new JFrame("Inicio de Sesion");
    public static void main(String[] args) {
        frame.setContentPane(new form1().Sesion);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(400,400);
        frame.setVisible(true);
    }
}