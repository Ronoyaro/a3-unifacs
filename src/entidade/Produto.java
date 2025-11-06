package entidade;

public class Produto {
    private static long contador = 0L;
    private long id;
    private String nome;
    private Double preco;
    private Integer quantidade;
    private String categoria;

    public Produto(String nome, Double preco, Integer quantidade, String categoria) {
        this.id = ++contador;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String novoNome) {
        this.nome = novoNome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(double novoPreco) {
     this.preco = novoPreco;
    }

    public Long getId() {
        return id;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "[" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", quantidade=" + quantidade +
                ", categoria='" + categoria + '\'' +
                ']';
    }
}
