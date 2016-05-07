package hurrybus.dao.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *	Esta classe é responsável por estabelecer uma conexão com o banco de dados PostgreSQL
 * 
 * @author            Arthur Silveira
 * @author            Dener Kemele
 * 
 */
public class ConectionFactory {
    
    String driver = "org.postgresql.Driver";
    private final String URL = "jdbc:postgresql://localhost:5432/HurryBus";
    private final String USUARIO = "postgres";
    private final String SENHA = "admin";

    
    /**
     * Estabelece a conexão com o banco de dados
     * 
     * @return	Retorna um objeto do tipo Connection
     */
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
