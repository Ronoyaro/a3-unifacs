package entidade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * classe que manipula a lista, para adicionar, lista, editar e remover
 * */

public class ListaEletrodomesticos {

    private final List<Eletrodomestico> eletrodomesticos = new ArrayList<>(); //ArrayList que recebe os produtos.

    /**
     *Quando instanciamos o objeto ListaEletrodomesticos ele cadastra automaticamente 7 produtos
     */

    public ListaEletrodomesticos() {
        eletrodomesticos.add(new Eletrodomestico("TV", 3999.90, 10, "Smart TV 4K", "Preto-Fosco", "LG"));
        eletrodomesticos.add(new Eletrodomestico("Lavadora", 1999.90, 7, "Lava e Seca", "Branca", "Brastemp"));
        eletrodomesticos.add(new Eletrodomestico("Ferro", 299.90, 8, "A vapor", "Preto", "Black Decker"));
        eletrodomesticos.add(new Eletrodomestico("Geladeira", 3990.90, 15, "Duplex", "Branco", "Electrolux"));
        eletrodomesticos.add(new Eletrodomestico("Aspirador", 399.90, 20, "Vertical", "Vermelho", "Mondial"));
        eletrodomesticos.add(new Eletrodomestico("Fogao", 1799.90, 25, "5 Bocas", "Black-Piano", "Itatiaia"));
        eletrodomesticos.add(new Eletrodomestico("Batedeira", 1799.90, 25, "Manual", "Prateada", "Philco"));

    }

    /**
     * getEletrodomestico retorna uma lista de Eletrodomesticos
     **/

    public List<Eletrodomestico> getEletrodomesticos() {
        return eletrodomesticos;
    }


    /**
     * metodo ordenaPorPreco lista os nossos produtos ordenados por preço, formatado pelo printf utilizando o loop for, e o metodo sort ordena os produtos por preço do menor para o maior.
     **/
    public void ordenarPorPreco() {
        eletrodomesticos.sort((e1, e2) -> e1.getPreco().compareTo(e2.getPreco()));
        System.out.printf("%-10s %-15s %-10s %-10s%n", "Id", "Nome", "Preço", "Quantidade");
        for (Eletrodomestico e : eletrodomesticos) {
            System.out.printf("%-5d %-20s %-15.2f %-10d%n", e.getId(), e.getNome(), e.getPreco(), e.getQuantidade());
        }
    }
/**
 * atualiza lista de produtos é chamado quando a gente cadastra um produto novo.
 **/
    public void atualizarProdutos(Eletrodomestico eletrodomestico) {
        eletrodomesticos.add(eletrodomestico);
    }
    /**
     *Busca um produto e retorna um Optional<Eletrodomestico> que encontra o primeiro produto da lista que bate com o valor que o usuario digitou.
     **/
    public Optional<Eletrodomestico> filtrarProduto(String produto) {
        Optional<Eletrodomestico> eletrodomesticoFiltrado = eletrodomesticos.stream()
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
    /**
     *Remove o produto que o usuario digitou
     * */
    public void removerProduto(Eletrodomestico nomeProduto) {
        eletrodomesticos.remove(nomeProduto);
        System.out.println("Produto removido com sucesso!");
    }
}
