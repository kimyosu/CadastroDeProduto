package entities;

public class Produto {
    private String nome;
    private int codigo;
    private double preco;
    private int quantidadeEstoque;


    public Produto(String nome, int codigo, double preco, int quantidadeEstoque){
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }

    //#region getters & setters

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }


    //#endregion


    @Override
    public String toString() {
        return "nome do produto: " + nome +
                "\ncodigo: " + codigo +
                "\npreço: " + preco +
                "\nquantidade no estoque: " + quantidadeEstoque;
    }
}
