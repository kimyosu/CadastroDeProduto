package application;

import model.entities.GerenciadorDeProduto;
import model.exceptions.CodeExist;
import model.exceptions.NameExist;
import model.exceptions.ProductNoExist;
import model.exceptions.ValueBelowZero;

import java.util.InputMismatchException;
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
                    listarProdutos(gerenciadorDeProduto);
                    break;
                case 3:
                    buscarProdutoPorCodigo(scanner, gerenciadorDeProduto);
                    break;

                case 4:
                    System.out.println("encerrando programa...");
                    System.exit(0);
                    break;
            }
        }

    }


        public static void cadastrarProduto(Scanner scanner, GerenciadorDeProduto gerenciadorDeProduto){
               try{
                   scanner.nextLine();
                   System.out.print("Nome do produto: ");
                   String nome = scanner.nextLine();
                   gerenciadorDeProduto.verificarNome(nome);

                   System.out.print("Codigo do produto: ");
                   int codigo = scanner.nextInt();
                   gerenciadorDeProduto.verificarCodigo(codigo);

                   System.out.print("Preço do produto: ");
                   double preco = scanner.nextDouble();
                   gerenciadorDeProduto.verificarPreco(preco);

                   System.out.print("Quantidade no estoque: ");
                   int quantidadeEstoque = scanner.nextInt();

                   gerenciadorDeProduto.cadastrarProduto(nome, codigo, preco, quantidadeEstoque);
                   System.out.println("Produto criado com sucesso!");

               }catch (CodeExist | NameExist | ValueBelowZero e){
                   System.out.println(e.getMessage());
               } catch (InputMismatchException e){
                   System.out.println("erro: " + e.getMessage());
               }
        }

        public static void listarProdutos(GerenciadorDeProduto gerenciadorDeProduto){
            try {
                gerenciadorDeProduto.listarProdutos();
            }catch (ProductNoExist e){
                System.out.println(e.getMessage());
            }
        }

        public static void buscarProdutoPorCodigo(Scanner scanner, GerenciadorDeProduto gerenciadorDeProduto){
            try {
                gerenciadorDeProduto.verificaLista();
                System.out.print("Insira o codigo do produto que deseja buscar: ");
                int codigo = scanner.nextInt();
                gerenciadorDeProduto.buscarPorCodigo(codigo);
            }catch (ProductNoExist e){
                System.out.println(e.getMessage());
            }catch (InputMismatchException e){
                System.out.println("error: " + e.getMessage());
            }


        }

        public static void menu(){
            System.out.println("""
                    1-Cadastrar um novo produto
                    2-Listar todos os produtos cadastrados
                    3-Buscar um produto pelo código
                    4-Sair do programa""");
        }
    }
