package entidade;

public class Eletrodomestico extends Produto {
    private String cor;
    private String dimensao;

    public Eletrodomestico(String nome, Double preco, Integer quantidade, String categoria, String cor, String dimensao) {
        super(nome, preco, quantidade, categoria);
        this.cor = cor;
        this.dimensao = dimensao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getDimensao() {
        return dimensao;
    }

    public void setDimensao(String dimensao) {
        this.dimensao = dimensao;
    }

    @Override
    public String toString() {
        return super.toString().replace("]", ",") + " cor='" + cor + '\''
                + ", dimensão='" + dimensao + '\'' + "]";

    }
}
