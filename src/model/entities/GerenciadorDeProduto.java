package model.entities;

import model.exceptions.CodeExist;
import model.exceptions.NameExist;
import model.exceptions.ProductNoExist;
import model.exceptions.ValueBelowZero;

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

    //Verifica se o nome já existe na lista
    public void verificarNome(String nome){

        verificaLista();

        for (int i = 0; i < produtoArrayList.size(); i++){
            if (produtoArrayList.get(i).getNome().equals(nome)){
                throw new NameExist("Esse nome já existe no banco de dados");
            }
        }
    }

    //Verifica se o codigo já existe na list
    public  void verificarCodigo(int codigo){

        verificaLista();

        for (int i = 0; i < produtoArrayList.size(); i++){
            if (produtoArrayList.get(i).getCodigo() == codigo){
                throw new CodeExist("Esse codigo já existe");
            }
        }
    }

    //Lista todos os produtos na lista
    public void listarProdutos() {

        verificaLista();

        //imprima todos os produtos que estão na lista
        for (int i = 0; i < produtoArrayList.size(); i++) {
            System.out.println(produtoArrayList.get(i).toString());
        }
    }

    public void buscarPorCodigo(int codigo){

        verificaLista();

        //percorra todos os objetos da lista
        for (int i = 0; i < produtoArrayList.size(); i++) {
            if (codigo == produtoArrayList.get(i).getCodigo()){
                System.out.println(produtoArrayList.get(i).toString());
                return;
            }
        }

        //caso não seja encontrado nenhum produto no for acima
        System.out.println("não foi encontrado o produto");
    }

    //Verifica se o valor é negativo
    public void verificarPreco(double preco){
        if (preco < 1){
            throw  new ValueBelowZero("Insira um valor positivo.");
        }
    }

    //Verifica se a lista esta vazia
    public void verificaLista(){
        if (produtoArrayList.isEmpty()){
            throw new ProductNoExist("Não existe produtos cadastrados");
        }
    }

}
