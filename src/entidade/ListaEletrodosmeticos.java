package entidade;

import java.util.ArrayList;
import java.util.List;

public class ListaEletrodosmeticos {

    private List<Eletrodomestico> eletrodomesticos = new ArrayList<>();

    public ListaEletrodosmeticos() {
        this.eletrodomesticos.add(new Eletrodomestico("Televisão", 3999.90, 10, "Smart TV 4K", "Preto-Fosco", "169x111"));
        this.eletrodomesticos.add(new Eletrodomestico("Máquina de Lavar", 1999.90, 7, "Lava e Seca", "Branca", "135x90"));
        this.eletrodomesticos.add(new Eletrodomestico("Ferro de Passar", 299.90, 8, "Black Decker", "Preto", "60x25"));
        this.eletrodomesticos.add(new Eletrodomestico("Geladeira", 3990.90, 15, "Duplex", "Branco", "180x90"));
        this.eletrodomesticos.add(new Eletrodomestico("Aspirador de Pó", 399.90, 20, "Vertical", "Vermelho", "130x85"));
        this.eletrodomesticos.add(new Eletrodomestico("Fogão", 1799.90, 25, "CockTop", "BlackPiano", "50x90"));
        this.eletrodomesticos.add(new Eletrodomestico("Batedeira", 1799.90, 25, "CockTop", "BlackPiano", "40x40"));
    }

    public List<Eletrodomestico> getEletrodomesticos() {
        return eletrodomesticos;
    }

    public void mostraLista() {
        eletrodomesticos.sort((e1, e2) -> e1.getPreco().compareTo(e2.getPreco()));
        for (Eletrodomestico eletrodomestico : eletrodomesticos) {
            System.out.println(eletrodomestico);
        }
    }

    public void formataLista() {
        System.out.println("Produtos encontrados: ");
        for (Eletrodomestico eletrodomestico : eletrodomesticos) {
            System.out.println(eletrodomestico.getNome());
        }
    }

    public void atualizaLista(Eletrodomestico eletrodomestico) {
        eletrodomesticos.add(eletrodomestico);
    }

    public Eletrodomestico buscaPorNome(String produto) {
        return this.eletrodomesticos.stream()
                .filter(p -> p.getNome().equalsIgnoreCase(produto))
                .findFirst()
                .orElse(null);
    }

    public void buscaProduto(String produto) {
        Eletrodomestico produtoFiltrado = buscaPorNome(produto);
        if (produtoFiltrado != null) {
            System.out.println(produtoFiltrado);
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    public void removeProduto(String produto, String sOrN) {
        if (sOrN.equalsIgnoreCase("s")) {
            this.eletrodomesticos.removeIf(p -> p.getNome().equalsIgnoreCase(produto));
            System.out.println("Produto removido com sucesso!");
        } else if (sOrN.equalsIgnoreCase("n")) {
            System.out.println("Retornando...");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }
}
