Este é um pequeno projeto em Java feito por mim enquanto estou aprendendo programação.

## Objetivo
Esse programa tem como objetivo simples um cadastro de produtos, podendo:
- cadastrar produtos
- listar produtos
- buscar um produto pelo código/id
- encerrar programa

## Como Rodar
Clone o repositório e navegue até a pasta "src".  
Certifique-se de que o Java está instalado e configurado no seu sistema.

```bash
# Compile os arquivos .java
javac Main.java model/entities/Produto.java model/entities/GerenciadorDeProduto.java

# Execute o programa
java Main
```

## Estrutura do Projeto

```
src
├── Main.java
└── model
    ├── entities
    │   ├── GerenciadorDeProduto.java
    │   └── Produto.java
    └── exceptions
        ├── CodeExist.java
        ├── NameExist.java
        ├── ProductNoExist.java
        └── ValueBelowZero.java

```
