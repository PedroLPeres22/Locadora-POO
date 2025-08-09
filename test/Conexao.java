import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static void main(String[] args) {

        String url = "jdbc:mysql://sql10á.freesqldatabase.com:3306/sql10793746";
        String usuario = "sql10793746";
        String senha = "qytTuyhlZT";

        try {
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado");
            conexao.close();
        } catch (SQLException e) {
            System.out.println("Erro" + e.getMessage());
        }
    }
}


