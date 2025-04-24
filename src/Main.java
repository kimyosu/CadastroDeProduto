import entities.Produto;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        scanner.useLocale(Locale.US);

        ArrayList<Produto> produtoArrayList = new ArrayList<>();


        while (true) {
            menu();
            System.out.print("➤");
            int input = scanner.nextInt();

            switch (input) {
                case 1:
                    cadastrarProduto(scanner, produtoArrayList);
                    break;
                case 2:
                    listarProdutos(scanner, produtoArrayList);
                    break;
                case 3:
                    buscarPorCodigo(scanner, produtoArrayList);
                    break;

                case 4:
                    System.out.println("encerrando programa...");
                    System.exit(0);
                    break;
            }
        }

    }

    public static void buscarPorCodigo(Scanner scanner, ArrayList<Produto> produtoArrayList) {

        if (produtoArrayList.isEmpty()){
            System.out.println("não existe produtos cadastrado no banco de dados");
            return;
        }


        System.out.print("insira o codigo do produto que queira buscar: ");
        int codigo = scanner.nextInt();

        for (int i = 0; i < produtoArrayList.size(); i++) {
            if (codigo == produtoArrayList.get(i).getCodigo()){
                System.out.println(produtoArrayList.get(i).toString());
                return;
            }
        }
        System.out.println("não foi encontrado o produto");
        return;

    }


    public static void cadastrarProduto(Scanner scanner, ArrayList<Produto> produtoArrayList) {
        scanner.nextLine();
        System.out.print("insira o nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("insira o codigo do produto: ");
        int codigo = scanner.nextInt();
        if (!produtoArrayList.isEmpty()) { //caso NÂO esteja vazia
            for (int i = 0; i < produtoArrayList.size(); i++) {
                if (produtoArrayList.get(i).getCodigo() == codigo) {
                    System.out.println("ja existe um produto com esse codigo\ntente novamente.");
                    return;
                }
            }
        }
            System.out.print("insira o preço do produto: ");
            double preco = scanner.nextDouble();
            System.out.print("insira a quantidade no estoque: ");
            int quantidadeEstoque = scanner.nextInt();
            produtoArrayList.add(new Produto(nome, codigo, preco, quantidadeEstoque));

    }

        public static void listarProdutos(Scanner scanner, ArrayList<Produto> produtoArrayList){
            if (produtoArrayList.isEmpty()) { //caso esteja vazio{
                System.out.println("não existe produtos cadastrados");
                return;
            }
            for (int i = 0; i < produtoArrayList.size(); i++) {
                System.out.println(produtoArrayList.get(i).toString());
            }

        }


        public static void menu(){
            System.out.println("1-Cadastrar um novo produto\n" +
                    "2-Listar todos os produtos cadastrados\n" +
                    "3-Buscar um produto pelo código\n" +
                    "4-Sair do programa");
        }
    }
