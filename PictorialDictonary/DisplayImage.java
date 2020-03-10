package PictorialDictonary;

import java.awt.*;
import java.sql.*;

import javax.swing.*;

public class DisplayImage extends JFrame {

Connection connection = null;
PreparedStatement statement = null;

ResultSet result;

public DisplayImage() {
    super("Image Display");
    setSize(600, 600);
    connection = getConnection();
    try { // table name:image and second image is field name
        statement = connection
                .prepareStatement("select * from  dictionary ");
        result = statement.executeQuery();

        
        
        
        
        byte[] image = null;
        while (result.next()) 
        {
            image = result.getBytes("img_data");

        }
        Image img = Toolkit.getDefaultToolkit().createImage(image);
        ImageIcon icon = new ImageIcon(img);
        JLabel lPhoto = new JLabel();
        lPhoto.setIcon(icon);
        add(lPhoto);

    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    setVisible(true);
}

public Connection getConnection() {
    Connection connection = null;

    try {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(
                // user name:root and password:blank
                "jdbc:mysql://localhost:3306/pictorialdictionary", "root",
                "");

    } catch (Exception e) {
        System.out.println("Error Occured While Getting the Connection: - "
                + e);
    }
    return connection;
}

public static void main(String[] args) {
    new DisplayImage();
}
}