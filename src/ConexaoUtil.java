import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

import com.mysql.*;

public class ConexaoUtil {

	
	private String caminho = "localhost";
	private String porta = "3306";
	private String nome = "wiggle";
	private String usuario = "root";
	private String senha = "";
	
	private String URL = "jdbc:mysql://"+caminho+":"+ porta + "/" + nome+ 
			"?useTimezone=true&serverTimezone=GMT";
	
	
	
	
	public static ConexaoUtil getConnection() {
		ConexaoUtil conexaoUtil = null;
		conexaoUtil = new ConexaoUtil();
		return conexaoUtil;
	}
	
	public void Conn() {
		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				DriverManager.getConnection(URL, usuario, senha);
				JOptionPane.showMessageDialog(null,"Conectado");
		}catch (Exception ex) {
					System.err.println("Erro ao conectar ao BD: \n" + ex);
					ex.printStackTrace();
				}
		
		
	}
}
