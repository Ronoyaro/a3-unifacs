package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        System.out.printf("%-10s %-15s %-10s %-10s%n", "Id", "Nome", "Preço", "Quantidade");
        for (Eletrodomestico e : eletrodomesticos) {
            System.out.printf("%-5d %-20s %-15.2f %-10d%n", e.getId(), e.getNome(), e.getPreco(), e.getQuantidade());
        }
    }

    public void atualizaListaDeProdutos(Eletrodomestico eletrodomestico) {
        this.eletrodomesticos.add(eletrodomestico);
    }

    public Optional<Eletrodomestico> filtraProduto(String produto) {
        Optional<Eletrodomestico> eletrodomesticoFiltrado = this.eletrodomesticos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(produto))
                .findFirst();
        eletrodomesticoFiltrado.ifPresentOrElse((e -> {
            System.out.println("---Produto encontrado---");
            System.out.println("Produto: " + e.getNome());
            System.out.println("Preço: " + e.getPreco());
            System.out.println("Quantidade: " + e.getQuantidade());
        }), () -> System.out.println("Não encontrado"));
        return eletrodomesticoFiltrado;
    }

    public void removeProduto(Eletrodomestico nomeProduto) {
        this.eletrodomesticos.remove(nomeProduto);
        System.out.println("Produto removido com sucesso!");
    }
}
