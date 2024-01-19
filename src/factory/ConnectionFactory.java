package factory;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
   
    public Connection getConnection(){
        try {
            // se erro coloque senha root e colocar o connector na libraries
            return DriverManager.getConnection("jdbc:mysql://localhost/cadastropessoas","root","");
                   
        } catch (Exception excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
