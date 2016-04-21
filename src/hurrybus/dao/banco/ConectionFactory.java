package hurrybus.dao.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dener
 * @update Arthur Silveira
 * 
 */
public class ConectionFactory {
    
    String driver = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/HurryBus";
    private final String USUARIO = "postgres";
    private final String SENHA = "admin";

    public Connection getConnetion(){
        try {
            Class.forName(driver);
            return DriverManager.getConnection(URL, USUARIO, SENHA);
        	}catch (SQLException | ClassNotFoundException erro) {
        		System.out.println("Erro ao tenta conectar!");
        		throw new RuntimeException(erro);
        		}
    	}
}
