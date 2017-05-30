package revenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnector {
    
    private static Connection connection;
    
    public static Connection getConnection(){
        return connection;
    }

    public static void connect() {
        connection = null;

        try {
            // Carregando o JDBC Driver padrão
            String driverName = "com.mysql.jdbc.Driver";
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            //Driver não encontrado
            System.out.println("O driver expecificado nao foi encontrado.");
            return;
        }

        //IP do servidor do BD
        String hostname = "localhost";

        //Nome do banco
        String database = "revenda";

        //URL de conexão com o banco
        String url = "jdbc:mysql://" + hostname + "/" + database;

        //username do DB
        String username = "root";

        //senha do DB
        String password = "root";

        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            //Erro na conexão, printa a porra toda
            ex.printStackTrace();
        }
    }
    
    

    public static void disconnect() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Ocorreu um erro ao tentar desconectar o banco.");
        }
    }
    
}
