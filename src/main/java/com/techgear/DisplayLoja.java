package com.techgear;

import java.io.*;
import com.techgear.util.FileHandler;
import java.util.ArrayList;
import java.util.Scanner;

public class DisplayLoja {
  private Loja loja = new Loja("TechGear", "123456789", "Rua dos Bobos, 0");
  private ArrayList<Produto> carrinho = new ArrayList<>();

  public DisplayLoja () {
  }

  public void telaUsuario() {
    try {
      FileHandler fileHandler = new FileHandler();
      fileHandler.loadFiles(loja);
      System.out.println("Bem-vindo à loja " + loja.getNome());

        Scanner sc = new Scanner(System.in);
        int op = -1;
        while (op != 0) {
        System.out.println("1 - Gerenciar produtos");
      System.out.println("2 - Gerenciar categorias");
      System.out.println("3 - Listar produtos");
      System.out.println("4 - Listar categorias");

      System.out.println("8 - Informações da loja");
      System.out.println("9 - Gerenciar carrinho");
      System.out.println("0 - Sair");
      op = sc.nextInt();
      sc.nextLine();
      switch (op) {
        case 1:
        gerenciarProduto(); 
        break;
        case 2:
        gerenciarCategoria();
        break;
        case 3:
        System.out.println("----------Produtos----------");
        loja.listarProdutos();
        System.out.println("----------------------------");
        break;
        case 4:
        System.out.println("----------Categorias----------");
        loja.listarCategorias();
        System.out.println("------------------------------");
        case 8:
        System.out.println("Nome: " + loja.getNome());
        System.out.println("CNPJ: " + loja.getCnpj());
        System.out.println("Endereço: " + loja.getEndereco());
        break;
        case 9:
        gerenciarCarrinho();
        break;
        default: 
        System.out.println("Opção inválida.");
        break;
      }
    }

  } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
    }
  }

  private void buscarProduto() {
    System.out.println("Digite o nome do produto que deseja buscar: ");
    String nomeProduto = System.console().readLine();
    Produto produto = loja.buscarProduto(nomeProduto);
    if (produto != null) {
      System.out.println(produto.getNome());
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

  private void adicionarAoCarrinho(Produto produto) {
    carrinho.add(produto);
  }

  private void removerDoCarrinho(Produto produto) {
    carrinho.remove(produto);
  }

  private void exibirCarrinho() {
    System.out.println("Produtos no carrinho: ");
    int i = 0;
    for (Produto produto : carrinho) {
      System.out.println("- Produto" + i++ + ": "+ produto.getNome() + "| Preço: " + produto.getPreco());
    }
  }


  private void gerenciarCarrinho() {
    try {
      Scanner sc = new Scanner(System.in);
      int opCarrinho = -1; 
      while( opCarrinho != 0){
        System.out.println("----------Carrinho----------");
        System.out.println("1 - Exibir carrinho");
        System.out.println("2 - Remover do carrinho");
        System.out.println("3 - Adicionar ao carrinho");
        System.out.println("0 - Sair");
        opCarrinho = sc.nextInt();
        sc.nextLine();
        switch (opCarrinho) {
          case 1:
          exibirCarrinho();
          break;
          case 2:
          System.out.println("Digite o nome do produto que deseja remover: ");
          String nomeProduto = sc.nextLine(); 
          Produto produto = loja.buscarProduto(nomeProduto);
          removerDoCarrinho(produto);
          break;
          case 3:
          System.out.println("Digite o nome do produto que deseja adicionar: ");
          nomeProduto = sc.nextLine(); 
          produto = loja.buscarProduto(nomeProduto);
          adicionarAoCarrinho(produto);
          break;
          default:
          System.out.println("Opção inválida.");
          break;
        }      
      }
    } catch (Exception e) {
      System.err.println("Erro ao gerenciar carrinho: " + e.getMessage());
    }
  }


  public void gerenciarProduto() {

    Scanner sc = new Scanner(System.in);
    int opProduto = -1;
    int idProduto = 0;
    int idCategoria = 0;
    String nomeProduto = "";
    double precoProduto = 0.0;
    String descricaoProduto = "";
    String marca = "";
    Categoria categoria = new Categoria();

    while(opProduto != 0) {
      System.out.println("----------Produtos----------");
      System.out.println("1 - Adicionar produto fisico");
      System.out.println("2 - Adicionar produto virtual");
      System.out.println("3 - Remover produto");
      System.out.println("4 - Listar produtos");
      System.out.println("5 - Buscar produto");
      System.out.println("0 - Voltar");
      opProduto = sc.nextInt();
      sc.nextLine();
      switch (opProduto) {
        case 1:
        double peso = 0.0;
        String dimensoes = "";

        System.out.println("Digite o ID do produto:");
        idProduto = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do produto:");
        nomeProduto = sc.nextLine();
        System.out.println("Digite o preço do produto:");
        precoProduto = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a descrição do produto:");
        descricaoProduto = sc.nextLine();
        System.out.println("Digite a marca do produto:");
        marca = sc.nextLine();
        System.out.println("Digite o ID da categoria do produto:");
        idCategoria = sc.nextInt();
        categoria = loja.buscarCategoria(idCategoria);
        sc.nextLine();
        System.out.println("Digite o peso do produto:");
        peso = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a altura, a largura e a profundidade do produto:");
        dimensoes = sc.nextLine();

        ProdutoFisico produtoFisico = new ProdutoFisico(idProduto, nomeProduto, precoProduto, descricaoProduto, marca,categoria, peso, dimensoes);
        loja.adicionarProduto(produtoFisico.getCategoria(), produtoFisico);
        break;
        case 2:
        double tamanho = 0.0;
        String formato = "";

        System.out.println("Digite o ID do produto:");
        idProduto = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome do produto:");
        nomeProduto = sc.nextLine();
        System.out.println("Digite o preço do produto:");
        precoProduto = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite a descrição do produto:");
        descricaoProduto = sc.nextLine();
        System.out.println("Digite a marca do produto:");
        marca = sc.nextLine();
        System.out.println("Digite o ID da categoria do produto:");
        idCategoria = sc.nextInt();
        categoria = loja.buscarCategoria(idCategoria);
        sc.nextLine();
        System.out.println("Digite o tamanho do produto:");
        tamanho = sc.nextDouble();
        sc.nextLine();
        System.out.println("Digite o formato:");
        formato = sc.nextLine();

        Produto produtoVirtual = new ProdutoVirtual(idProduto, nomeProduto, precoProduto, descricaoProduto, marca,categoria, tamanho, formato);
        loja.adicionarProduto(produtoVirtual.getCategoria(), produtoVirtual);
        break;
        case 3:
        System.out.println("Digite o id do produto que deseja remover: ");
        idProduto = sc.nextInt();
        loja.removerProduto(idProduto);
        break;

        case 4: 
        System.out.println("----------Produtos----------");
        loja.listarProdutos();
        System.out.println("----------------------------");
        break;
        case 5:
        buscarProduto();
        default:
        System.out.println("Opção inválida.");
        break;
      }
    }
  }

  public void gerenciarCategoria() {
    Scanner sc = new Scanner(System.in);
    int opCategoria = -1;
    int idCategoria = 0;
    String nomeCategoria = "";
    String descricaoCategoria = "";

    while(opCategoria != 0) {
      System.out.println("----------Categorias----------");
      System.out.println("1 - Adicionar categoria");
      System.out.println("2 - Remover categoria");
      System.out.println("3 - Listar categorias");
      System.out.println("0 - Voltar");

      opCategoria = sc.nextInt();
      sc.nextLine();
      switch (opCategoria) {
        case 1:
        System.out.println("Digite o ID da categoria:");
        idCategoria = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o nome da categoria:");
        nomeCategoria = sc.nextLine();
        System.out.println("Digite a descrição da categoria:");
        descricaoCategoria = sc.nextLine();
        Categoria categoria = new Categoria(idCategoria, nomeCategoria, descricaoCategoria);
        loja.adicionarCategoria(categoria);
        break;
        case 2:
        System.out.println("Digite o id da categoria que deseja remover: ");
        idCategoria = sc.nextInt();
        loja.removerCategoria(idCategoria);
        break;
        case 3:
        System.out.println("----------Categorias----------");
        loja.listarCategorias();
        System.out.println("----------------------------");
        break;
        default:
        System.out.println("Opção inválida.");
        break;
      }
    }
  }

  public void setCarrinho(ArrayList<Produto> carrinho) {
    this.carrinho = carrinho;
  }

  public ArrayList<Produto> getCarrinho() {
    return carrinho;
  }
}
