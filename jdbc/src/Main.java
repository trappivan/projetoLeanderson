import java.sql.*;

public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(1, "Banana", 5.5, 10);
        Produto p2 = new Produto(2, "Anana", 9.5, 12);
        ProdutoDao produtoDao = new ProdutoDao();
        // UUID
        produtoDao.criarTabela();

        produtoDao.inserir(p1);
        produtoDao.inserir(p2);

        for(Produto p : produtoDao.obterTodos()){
            System.out.println(p);
        }

        // lança os método professor só chama

    }
}