import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class form2 {
    private JTextArea textArea;
    private JComboBox comboBox;
    public JPanel biografia;

    public form2(String usuario) {
        String driver = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/informacion";
        String dbusername="root";
        String dbpassword="141211";
        Connection connection =null;
        Statement st = null;
        ResultSet rs = null;
        String biographyUser = "";

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Configurar el diseño del panel
        biografia.setLayout(new BorderLayout());
        biografia.add(scrollPane, BorderLayout.CENTER);
        biografia.add(comboBox, BorderLayout.NORTH);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, dbusername,dbpassword);
            st = connection.createStatement();
            rs = st.executeQuery("Select * from descripcion where User = " + "'"+usuario + "'");
            while (rs.next()){
                biographyUser = rs.getString("Biography");

            }
        }catch (Exception ex){
            System.out.println(ex);
        }
        textArea.setText(biographyUser);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (e.getSource()==comboBox){
                    int seleccionado = comboBox.getSelectedIndex(); //obtiene el indice seleccionado en el combobox
                    if(seleccionado==0){
                        textArea.setText("");
                    } else if (seleccionado==1) {
                        Main.frame.setContentPane(new form1().Sesion); //se crea un nuevo objeto de la clase form1
                        Main.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);;
                        Main.frame.setSize(400,400);
                        Main.frame.setVisible(true);
                        form1.frame2.dispose();

                    }


                }

            }
        });
    }
}

