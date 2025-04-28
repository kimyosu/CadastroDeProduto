package entities;

import java.util.ArrayList;
import java.util.Scanner;

public class GerenciadorDeProduto {
    ArrayList<Produto> produtoArrayList = new ArrayList<>();
    Produto produto;


    public GerenciadorDeProduto(){

    }

    public ArrayList<Produto> getProdutoArrayList() {
        return produtoArrayList;
    }

    public  void cadastrarProduto(String nome, int codigo, double preco, int quantidadeEstoque) {

        produtoArrayList.add(new Produto(nome, codigo, preco, quantidadeEstoque));

    }

    public void listarProdutos() {

        if (produtoArrayList.isEmpty()) { //caso esteja vazio
            System.out.println("não existe nenhum produto cadastrado");
            return;
        }

        //imprima todos os produtos que estão na lista
        for (int i = 0; i < produtoArrayList.size(); i++) {
            System.out.println(produtoArrayList.get(i).toString());
        }
    }

    public void buscarPorCodigo(int codigo){

        //percorra todos os objetos da lista
        for (int i = 0; i < produtoArrayList.size(); i++) {
            if (codigo == produtoArrayList.get(i).getCodigo()){
                System.out.println(produtoArrayList.get(i).toString());
                return;
            }
        }

        //caso não seja encontrado nenhum produto no for acima
        System.out.println("não foi encontrado o produto");
        return;

    }

}
