public class Produto {
    private long id;
    private String nome;
    private double valor;
    private long quantidade;

    public Produto(){}
    public Produto(long id, String nome, double valor, long quantidade) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public long getId(){
        return this.id;
    }
    public long getQuantidade(){
        return this.quantidade;
    }

    public double getValor(){
        return this.valor;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
         this.nome = nome;
    }

    public void setId(long id){
        this.id= id;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", valor=" + valor +
                ", quantidade=" + quantidade +
                '}';
    }

    public void setValor(double valor){
        this.valor= valor;
    }

    public void setQuantidade(long quantidade){
        this.quantidade = quantidade;
    }
}
