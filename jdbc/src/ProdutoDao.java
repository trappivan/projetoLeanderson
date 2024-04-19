import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDao extends BaseDAO{

    private final static String CRIAR_TABELA = """
            create table  IF NOT EXISTS produto(
                                 id INTEGER PRIMARY KEY
                                ,nome text, valor float, quantidade int);
            """;

    public void criarTabela(){
        try(var con = conexao();
            var stat = con.createStatement()){
            stat.execute(CRIAR_TABELA);
        }catch (SQLException e){
            System.out.println("Erro ao criar tabela.");
            e.printStackTrace();
        }
    }
    public void inserir(Produto p){
        String inserir = """
                    insert into produto(nome,valor, quantidade) values( ?, ?, ?);
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(inserir)){
            stat.setString(1,p.getNome());
            stat.setDouble(2,p.getValor());
            stat.setLong(3,p.getQuantidade());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao inserir tabela.");
            e.printStackTrace();
        }
    }

    public void atualizar(Produto p){
        String sql = """
                    update produto set nome = ?, set valor = ?, set quantidade = ? where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setString(1,p.getNome());
            stat.setDouble(2,p.getValor());
            stat.setLong(3,p.getQuantidade());
            stat.setLong(4,p.getId());
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar produto.");
            e.printStackTrace();
        }
    }

    public void deletar(long id){
        String sql = """
                    delete produto where id = ?;
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            stat.setLong(1,id);
            stat.execute();
        }catch (SQLException e){
            System.out.println("Erro ao excluir produto.");
            e.printStackTrace();
        }
    }

    public List<Produto> obterTodos(){
        List<Produto> lista = new ArrayList<>();
        String sql = """
                    select nome,valor,quantidade from produto 
                    """;
        try(var con = conexao();
            var stat = con.prepareStatement(sql)){
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            while(rs.next()){
                Produto p = new Produto();
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setQuantidade(rs.getLong("quantidade"));
                lista.add(p);
            }
        }catch (SQLException e){
            System.out.println("Erro ao consultar todas os produtos.");
            e.printStackTrace();
        }
        return lista;
    }
}
