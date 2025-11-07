package entidade;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        ListaEletrodosmeticos eletrodosmeticos = new ListaEletrodosmeticos();
        System.out.println("----CADASTRO DE PRODUTOS-----");
        Scanner sc = new Scanner(System.in);
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
            String confirmacao;
            String nomeProduto;
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando produto....");
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
                    System.out.println("Informe a marca do produto");
                    String marca = sc.nextLine();
                    Eletrodomestico novoEletrodomestico = new Eletrodomestico(nome, preco, quantidade, categoria, cor, marca);
                    System.out.println("Eletrodomestico " + novoEletrodomestico.getNome() + " cadastrado com sucesso!");
                    eletrodosmeticos.atualizaLista(novoEletrodomestico);
                    System.out.println("Deseja voltar para o Menu? S/N");
                    confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("N")) {
                        finalizar = true;
                    }
                    break;
                case 2:
                    System.out.println("Listando todos os produtos...");
                    eletrodosmeticos.mostraLista();
                    System.out.println();
                    System.out.println("Voltar para o Menu? S/N");
                    confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("N")) {
                        finalizar = true;
                    }
                    break;
                case 3:
                    System.out.println("Informe o nome do produto:");
                    nomeProduto = sc.nextLine();
                    eletrodosmeticos.buscaProduto(nomeProduto);
                    System.out.println("Voltar para o Menu? S/N");
                    confirmacao = sc.nextLine();
                    if (confirmacao.equalsIgnoreCase("N")) {
                        finalizar = true;
                    }
                    break;
                case 4:
                    System.out.println("Informe o nome do produto que deseja editar:");
                    nomeProduto = sc.nextLine();
                    Eletrodomestico eletrodomesticoFiltrado = eletrodosmeticos.buscaProduto(nomeProduto);
                    if (eletrodomesticoFiltrado == null) {
                        System.out.println("Voltar para o Menu? S/N");
                        confirmacao = sc.nextLine();
                        if (confirmacao.equalsIgnoreCase("N")) {
                            finalizar = true;
                        }
                    } else {
                        System.out.println("1 - Alterar preço");
                        System.out.println("2 - Alterar quantidade");
                        int alteraDado = sc.nextInt();
                        switch (alteraDado) {
                            case 1:
                                System.out.println("Informe o novo valor:");
                                double alteraPreco = sc.nextDouble();
                                eletrodomesticoFiltrado.setPreco(alteraPreco);
                                System.out.println("Preço editado com sucesso!");
                                break;
                            case 2:
                                System.out.println("Informe a quantidade:");
                                alteraDado = sc.nextInt();
                                eletrodomesticoFiltrado.setQuantidade(alteraDado);
                                System.out.println("Quantidade editada com sucesso!");
                                break;
                        }
                    }
                    break;
                case 5:
                    System.out.println("Informe o nome do produto deseja remover:");
                    nomeProduto = sc.nextLine();
                    eletrodomesticoFiltrado = eletrodosmeticos.buscaProduto(nomeProduto);
                    if (eletrodomesticoFiltrado == null) {
                        System.out.println("Voltar para o Menu? S/N");
                        confirmacao = sc.nextLine();
                        if (confirmacao.equalsIgnoreCase("N")) {
                            finalizar = true;
                        }
                    } else {
                        System.out.println("Tem certeza que deseja remover: " + nomeProduto.toUpperCase() + "? S/N?");
                        confirmacao = sc.nextLine();
                        eletrodosmeticos.removeProduto(nomeProduto, confirmacao);
                        System.out.println("Voltar para o Menu? S/N");
                        confirmacao = sc.nextLine();
                        if (confirmacao.equalsIgnoreCase("N")) {
                            finalizar = true;
                        }
                    }
                    break;
                case 6:
                    finalizar = true;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
