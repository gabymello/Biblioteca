
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class ConexaoDAO {
       public static Connection conector(){
        java.sql.Connection conexao = null;
        
        String driver = "com.mysql.jdbc.Driver";
        
        String url = "jdbc:mysql://localhost:3306/BibliotecaProjeto";
        String user = "root";
        String password = "gaby2008";
        
        try {
            Class.forName(driver);
            conexao = DriverManager.getConnection(url, user, password);
            return conexao;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Conexão" + e);
            return null;
        }
    }
    
}
