package entidade;

/**
 * classe eletrodomestico que herda da classe abstrata produto
 * */
public class Eletrodomestico extends Produto {
    private String cor;
    private String marca;

    public Eletrodomestico(String nome, Double preco, Integer quantidade, String categoria, String cor, String marca) {
        super(nome, preco, quantidade, categoria);
        this.cor = cor;
        this.marca = marca;
    }
/**
 * getters e setters
 * */
    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * toString de eletrodomestico
     * */

    @Override
    public String toString() {
        return super.toString().replace("]", ",") + " cor='" + cor + '\''
                + ", marca='" + marca + '\'' + "]";

    }
}
