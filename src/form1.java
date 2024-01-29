import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class form1 {
    private JTextField userField;
    private JButton signInButton;
    private JPasswordField passwordField;
    public JPanel Sesion;
    static JFrame frame2 = new JFrame("Biografia");

    public form1() {
        signInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String driver = "com.mysql.cj.jdbc.Driver";
                String dbURL="jdbc:mysql://localhost:3306/informacion";
                String dbusername="root";
                String dbpassword="141211";
                Connection connection =null;
                Statement st = null;
                ResultSet rs = null;
                boolean ingreso = false;
                try{
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    connection = DriverManager.getConnection(dbURL, dbusername,dbpassword);
                    st = connection.createStatement();
                    rs = st.executeQuery("Select * from descripcion");

                    while (rs.next()){
                        String passwordUser =  rs.getString("Password");

                        char[] passenter = passwordField.getPassword();
                        String passenterString = new String(passenter);

                        if (userField.getText().equals(rs.getString(2))&&String.valueOf(passwordField.getPassword()).equals(rs.getString(3))){
                            frame2.setContentPane(new form2(userField.getText()).biografia);
                            frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                            frame2.setLocationRelativeTo(Main.frame);
                            frame2.setSize(600, 450);
                            frame2.setVisible(true);
                            Main.frame.dispose();
                            ingreso = true;


                        }
                    }
                    if (ingreso == false){
                        JOptionPane.showMessageDialog(null,"Credenciales incorrectas");
                    }

                }catch (Exception ex){
                    System.out.println(ex);
                }
            }
        });
    }
}
