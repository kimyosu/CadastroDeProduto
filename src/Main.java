import com.sun.tools.attach.AgentInitializationException;
import entities.GerenciadorDeProduto;
import entities.Produto;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);

        GerenciadorDeProduto gerenciadorDeProduto = new GerenciadorDeProduto();



        while (true) {
            menu();
            System.out.print("➤");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    cadastrarProduto(scanner, gerenciadorDeProduto);
                    break;
                case 2:
                    listarProdutos(scanner, gerenciadorDeProduto);
                    break;
                case 3:
                    buscarPorCodigo(scanner, gerenciadorDeProduto);
                    break;

                case 4:
                    System.out.println("encerrando programa...");
                    System.exit(0);
                    break;
            }
        }

    }


    public static void cadastrarProduto(Scanner scanner, GerenciadorDeProduto gerenciadorDeProduto){
        scanner.nextLine();
        System.out.print("Insira o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Insira o código do produto: ");
        int codigo = scanner.nextInt();
        boolean verifica = verificarCodigo(codigo, gerenciadorDeProduto);

        /*verifica:
        * se o codigo ja existe
        * se o numero é negativo
        */
        if (verifica){
            return;
        }

        System.out.print("Insira o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Insira a quantidade em estoque: ");
        int quantidade  = scanner.nextInt();

        gerenciadorDeProduto.cadastrarProduto(nome, codigo, preco, quantidade);

        System.out.println("cadastro feito com sucesso!");
    }

    public static void buscarPorCodigo(Scanner scanner, GerenciadorDeProduto gerenciadorDeProduto) {

        //isEmpty -> retorna true caso esteja vazia
        if (gerenciadorDeProduto.getProdutoArrayList().isEmpty()){  //verifica se a lista esta vazia
            System.out.println("não existe produtos cadastrados no banco de dados");
            return;
        }

        System.out.print("insira o codigo do produto: ");
        int codigo = scanner.nextInt();
        gerenciadorDeProduto.buscarPorCodigo(codigo);
    }




    public static void listarProdutos(Scanner scanner, GerenciadorDeProduto gerenciadorDeProduto){
        gerenciadorDeProduto.listarProdutos();
    }

    public static boolean verificarCodigo(int codigo, GerenciadorDeProduto gerenciadorDeProduto){

        if (codigo < 0){
            System.out.println("numero invalido");
            return true;
        }


        //verificando se o codigo ja existe
        if (!gerenciadorDeProduto.getProdutoArrayList().isEmpty()) { //caso NÂO esteja vazia

            for (int i = 0; i < gerenciadorDeProduto.getProdutoArrayList().size(); i++) {

                if (gerenciadorDeProduto.getProdutoArrayList().get(i).getCodigo() == codigo) {
                    System.out.println("ja existe um produto com esse codigo\ntente novamente.");
                    return true;
                }

            }

        }
        return false;
    }



        public static void menu(){
            System.out.println("1-Cadastrar um novo produto\n" +
                    "2-Listar todos os produtos cadastrados\n" +
                    "3-Buscar um produto pelo código\n" +
                    "4-Sair do programa");
        }
    }
