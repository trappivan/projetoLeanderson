import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Fabrica / Factory
// Singleton
public class FabricaDeConexoes {

    private static FabricaDeConexoes instancia;

    // Impede de outras classes criar um objeto do tipo Fabrica
    private FabricaDeConexoes(){
    }

    public synchronized static FabricaDeConexoes obterInstancia(){
        if(instancia == null){
            instancia = new FabricaDeConexoes();
        }
        return instancia;
    }

    public Connection conexao(){
        Connection c = null;
        try{
            c = DriverManager.getConnection("jdbc:sqlite:meu_banco.sql");
        }catch (SQLException e){
            new RuntimeException("Erro ao conectar no banco de dados.",e);
        }
        return c;
    }

}
