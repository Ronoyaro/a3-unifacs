import entidade.Eletrodomestico;
import entidade.ListaEletrodomesticos;

import java.util.Optional;
import java.util.Scanner;

public class Programa {
    public static Scanner sc = new Scanner(System.in);
    public static ListaEletrodomesticos eletrodomesticos = new ListaEletrodomesticos();
    public static boolean finalizar = false;
    public static int senhaAdmin = 12345;
    public static String nomeProduto;
    public static Optional<Eletrodomestico> produtoFiltrado;

    public static void main(String[] args) {
        System.out.println("Seja Bem-vindo!");
        while (!finalizar) {
            System.out.println("Escolha uma das opções a seguir:");
            System.out.println("1 - Cliente");
            System.out.println("2 - Administrador");
            System.out.println("0 - Sair");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao) {
                case 1:
                    clienteArea();
                    break;
                case 2:
                    adminArea();
                    break;
                case 0:
                    finalizar = true;
            }

        }
        sc.close();
    }

    private static void clienteArea() {
        System.out.println("----AREA DO CLIENTE-----");
        System.out.println("1 - Comprar um produto");
        System.out.println("0 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();
        if (opcao == 1) {
            venderProduto();
            return;
        }
        finalizar = true;
    }

    private static void adminArea() {
        System.out.println("Digite sua senha de Admin");
        int senhaInserida = sc.nextInt();
        if (senhaInserida != senhaAdmin) {
            System.out.println("Você não tem permissão!");
            finalizar = true;
        }
        if (senhaInserida == senhaAdmin) {
            System.out.println("----CADASTRO DE PRODUTOS-----");
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
                    cadastrarProduto();
                    break;
                case 2:
                    listarProduto();
                    break;
                case 3:
                    buscarProduto();
                    break;
                case 4:
                    editarProduto();
                    break;
                case 5:
                    removerProduto();
                    break;
                case 6:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void venderProduto() {
        eletrodomesticos.ordenarPorPreco();
        System.out.println("Qual o nome do produto?");
        String nomeCompra = sc.nextLine();
        Optional<Eletrodomestico> produtoEmCompraEncontrado = eletrodomesticos.filtrarProduto(nomeCompra);
        produtoEmCompraEncontrado.ifPresent(p -> {
            System.out.println("Qual a quantidade desesejada?");
            int quantidadeCompra = sc.nextInt();
            sc.nextLine();
            if (quantidadeCompra <= p.getQuantidade()) {
                p.setQuantidade(p.getQuantidade() - quantidadeCompra);
                System.out.println("Você adquiriu " + quantidadeCompra + " " + p.getNome() + " com sucesso!");
                return;
            }
            System.out.println("Quantidade não permitida");
        });
        clienteArea();

    }

    private static void cadastrarProduto() {
        System.out.println("Cadastrando produto...");
        System.out.println("Informe o nome do produto:");
        String nome = sc.nextLine();
        System.out.println("Informe o valor do produto:");
        double preco = sc.nextDouble();
        System.out.println("Informe a quantidade do produto:");
        int quantidade = sc.nextInt();
        sc.nextLine(); //Limpar o buffer
        System.out.println("Informe a categoria do produto:");
        String categoria = sc.nextLine();
        System.out.println("Informe a cor do produto:");
        String cor = sc.nextLine();
        System.out.println("Informe a marca do produto:");
        String marca = sc.nextLine();
        Eletrodomestico novoEletrodomestico = new Eletrodomestico(nome, preco, quantidade, categoria, cor, marca);
        System.out.println("Eletrodomestico " + novoEletrodomestico.getNome() + " cadastrado com sucesso!");
        eletrodomesticos.atualizarProdutos(novoEletrodomestico);
        if (fecharMenu()) {
            finalizar = true;
        }
    }

    private static void listarProduto() {
        System.out.println("Listando todos os produtos...");
        eletrodomesticos.ordenarPorPreco();
        System.out.println();
        if (fecharMenu()) {
            finalizar = true;
        }
    }

    private static void buscarProduto() {
        System.out.println("Informe o nome do produto:");
        nomeProduto = sc.nextLine();
        eletrodomesticos.filtrarProduto(nomeProduto);
        System.out.println();
        if (fecharMenu()) {
            finalizar = true;
        }
    }

    private static void editarProduto() {
        System.out.println("Informe o nome do produto que deseja editar:");
        nomeProduto = sc.nextLine();
        produtoFiltrado = eletrodomesticos.filtrarProduto(nomeProduto);
        System.out.println();
        if (produtoFiltrado.isPresent()) {
            System.out.println("1 - Editar Preço");
            System.out.println("2 - Editar Quantidade");
            int confirmacao = sc.nextInt();
            sc.nextLine();
            switch (confirmacao) {
                case 1:
                    System.out.println("Digite o valor");
                    double novoPreco = sc.nextDouble();
                    sc.nextLine();
                    produtoFiltrado.get().setPreco(novoPreco);
                    System.out.println("O valor foi atualizado!");
                    break;
                case 2:
                    System.out.println("Digite a quantidade:");
                    int novaQuantidade = sc.nextInt();
                    sc.nextLine();
                    produtoFiltrado.get().setQuantidade(novaQuantidade);
                    System.out.println("A quantidade foi atualizada!");
                    break;
            }
        }
        if (fecharMenu()) {
            finalizar = true;
        }
    }

    public static void removerProduto() {
        System.out.println("Informe o nome do produto que deseja remover:");
        nomeProduto = sc.nextLine();
        produtoFiltrado = eletrodomesticos.filtrarProduto(nomeProduto);
        if (produtoFiltrado.isPresent()) {
            System.out.println("Deseja remover o produto? S/N");
            String condicao = sc.nextLine();
            if (condicao.equalsIgnoreCase("s"))
                eletrodomesticos.removerProduto(produtoFiltrado.get());
        }
        if (fecharMenu()) {
            finalizar = true;
        }
    }

    private static boolean fecharMenu() {
        System.out.println("Retornar para o Menu (S/N)?");
        String confirmacao = sc.nextLine();
        return !confirmacao.equalsIgnoreCase("s");
    }
}
