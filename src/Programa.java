import entidade.Eletrodomestico;
import entidade.ListaEletrodomesticos;

import java.util.Optional;
import java.util.Scanner;

public class Programa {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ListaEletrodomesticos eletrodomesticos = new ListaEletrodomesticos();
        String nomeProduto;
        Optional<Eletrodomestico> produtoFiltrado;
        System.out.println("----CADASTRO DE PRODUTOS-----");
        boolean finalizar = false;
        while (!finalizar) {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar todos os produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Editar produto");
            System.out.println("5 - Remover produto");
            System.out.println("6 - Sair");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando produto...");
                    System.out.println("Informe o nome do produto:");
                    String nome = sc.nextLine();
                    System.out.println("Informe o valor do produto:");
                    double preco = sc.nextDouble();
                    System.out.println("Informe a quantidade do produto:");
                    int quantidade = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Informe a categoria do produto:");
                    String categoria = sc.nextLine();
                    System.out.println("Informe a cor do produto:");
                    String cor = sc.nextLine();
                    System.out.println("Informe a marca do produto:");
                    String marca = sc.nextLine();
                    Eletrodomestico novoEletrodomestico = new Eletrodomestico(nome, preco, quantidade, categoria, cor, marca);
                    System.out.println("Eletrodomestico " + novoEletrodomestico.getNome() + " cadastrado com sucesso!");
                    eletrodomesticos.atualizaListaDeProdutos(novoEletrodomestico);
                    if (!returnToMenu()) {
                        finalizar = true;
                    }
                    break;
                case 2:
                    System.out.println("Listando todos os produtos...");
                    eletrodomesticos.produtosOrdenadosPorPreco();
                    System.out.println();
                    if (!returnToMenu()) {
                        finalizar = true;
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome do produto:");
                    nomeProduto = sc.nextLine();
                    eletrodomesticos.filtraProduto(nomeProduto);
                    if (!returnToMenu()) {
                        finalizar = true;
                    }
                    break;
                case 4:
                    System.out.println("Informe o nome do produto que deseja editar:");
                    nomeProduto = sc.nextLine();
                    produtoFiltrado = eletrodomesticos.filtraProduto(nomeProduto);
                    if (produtoFiltrado.isPresent()) {
                        System.out.println("1 - Editar Preço");
                        System.out.println("2 - Editar Quantidade");
                        opcao = sc.nextInt();
                        sc.nextLine();
                        switch (opcao) {
                            case 1:
                                System.out.println("Digite o valor");
                                double novoPreco = sc.nextDouble();
                                sc.nextLine();
                                produtoFiltrado.get().setPreco(novoPreco);
                                break;
                            case 2:
                                System.out.println("Digite a quantidade:");
                                int novaQuantidade = sc.nextInt();
                                sc.nextLine();
                                produtoFiltrado.get().setQuantidade(novaQuantidade);
                                break;
                        }
                    }
                    if (!returnToMenu()) {
                        finalizar = true;
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome do produto que deseja remover:");
                    nomeProduto = sc.nextLine();
                    produtoFiltrado = eletrodomesticos.filtraProduto(nomeProduto);
                    if (produtoFiltrado.isPresent()) {
                        System.out.println("Deseja remover o produto? S/N");
                        String condicao = sc.nextLine();
                        if (condicao.equalsIgnoreCase("s")) eletrodomesticos.removeProduto(produtoFiltrado.get());
                    }
                    if (!returnToMenu()) {
                        finalizar = true;
                    }
                    break;
                case 6:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
    private static boolean returnToMenu() {
        System.out.println("Retornar para o Menu (S/N)?");
        String confirmacao = sc.nextLine();
        return confirmacao.equalsIgnoreCase("s");
    }
}
