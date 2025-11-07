package entidade;

import java.util.ArrayList;
import java.util.List;

public class ListaEletrodomesticos {

    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public ListaEletrodomesticos() {
        this.eletrodomesticos.add(new Eletrodomestico("TV", 3999.90, 10, "Smart TV 4K", "Preto-Fosco", "LG"));
        this.eletrodomesticos.add(new Eletrodomestico("Máquina de Lavar", 1999.90, 7, "Lava e Seca", "Branca", "Brastemp"));
        this.eletrodomesticos.add(new Eletrodomestico("Ferro de Passar", 299.90, 8, "A vapor", "Preto", "Black Decker"));
        this.eletrodomesticos.add(new Eletrodomestico("Geladeira", 3990.90, 15, "Duplex", "Branco", "Electrolux"));
        this.eletrodomesticos.add(new Eletrodomestico("Aspirador de Pó", 399.90, 20, "Vertical", "Vermelho", "Mondial"));
        this.eletrodomesticos.add(new Eletrodomestico("Fogão", 1799.90, 25, "5 Bocas", "Black-Piano", "Itatiaia"));
        this.eletrodomesticos.add(new Eletrodomestico("Batedeira", 1799.90, 25, "Manual", "Prateada", "Philco"));
    }

    public List<Eletrodomestico> getEletrodomesticos() {
        return eletrodomesticos;
    }

    public void produtosOrdenadosPorPreco() {
        eletrodomesticos.sort((e1, e2) -> e1.getPreco().compareTo(e2.getPreco()));
        System.out.println("----------------------");
        for (Eletrodomestico eletrodomestico : eletrodomesticos) {
            System.out.println("Produto: " + eletrodomestico.getNome());
            System.out.println("Marca: " + eletrodomestico.getMarca());
            System.out.println("Preço: R$ " + eletrodomestico.getPreco());
            System.out.println("Quantidade: " + eletrodomestico.getQuantidade());
            System.out.println("----------------------");
        }
    }

    public void atualizaListaDeProdutos(Eletrodomestico eletrodomestico) {
        this.eletrodomesticos.add(eletrodomestico);
    }


    public Eletrodomestico buscaProduto(String produto) {
        Eletrodomestico produtoFiltrado = this.eletrodomesticos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(produto))
                .findFirst()
                .orElse(null);

        if (produtoFiltrado != null) {
            System.out.println("---Produto encontrado---");
            System.out.println("Produto: " + produtoFiltrado.getNome());
            System.out.println("Marca: " + produtoFiltrado.getMarca());
            System.out.println("Preço: R$ " + produtoFiltrado.getPreco());
            System.out.println("Quantidade: " + produtoFiltrado.getQuantidade());
            System.out.println("Categoria: " + produtoFiltrado.getCategoria());
            return produtoFiltrado;
        } else {
            System.out.println("Produto não encontrado!");
            return null;
        }
    }

    public void removeProduto(String nomeProduto, String confirmacao) {
        if (confirmacao.equalsIgnoreCase("s")) {
            this.eletrodomesticos.removeIf(p -> p.getNome().equalsIgnoreCase(nomeProduto));
            System.out.println("Produto removido com sucesso!");
        } else if (confirmacao.equalsIgnoreCase("n")) {
            System.out.println("Retornando...");
        }
    }
}
