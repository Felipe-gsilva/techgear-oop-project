package com.techgear;

import java.io.*;
import com.techgear.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que exibe a interface da loja.
 * @version 1.0
 * @since 2024-04-08
 **/
public class DisplayLoja {
  private Loja loja = new Loja("TechGear", "123456789", "Rua de Verdade, 128");
  private ArrayList<Produto> carrinho = new ArrayList<>();

  /**
   * Exibe a tela de usuário.
   */
  public void telaUsuario() {
    try {
      FileHandler fileHandler = new FileHandler();
      fileHandler.loadFiles(loja);
      Scanner sc = new Scanner(System.in);

      int op = -1;
      System.out.println("Bem-vindo à loja " + loja.getNome());
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
        /** 
         * Switch case para exibir as opções do menu.
         */
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
          break;
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
    } catch (Exception e) {
      System.out.println("Erro ao exibir tela de usuário." + e.getMessage());
    }
  }

  /**
   * Exibe a tela de gerenciamento do carrinho.
   */

  private void gerenciarCarrinho() {
    try {
      Scanner sc = new Scanner(System.in);
      int opCarrinho = -1; 
      Produto produto;
      while( opCarrinho != 0){
        System.out.println("----------Carrinho----------");
        System.out.println("1 - Exibir carrinho");
        System.out.println("2 - Adicionar ao carrinho");
        System.out.println("3 - Remover do carrinho");
        System.out.println("4 - Realizar compra");
        System.out.println("5 - Listar produtos disponíveis");
        System.out.println("0 - Sair");
        System.out.println("---------------------------");
        opCarrinho = sc.nextInt();
        sc.nextLine();
        switch (opCarrinho) {
          case 1:
          exibirCarrinho();
          break;
          case 2:
          System.out.println("Digite o id do produto que deseja adicionar: ");
          int idProduto = sc.nextInt(); 
          sc.nextLine();
          System.out.println("Digite a quantidade do produto que deseja adicionar: ");
          int quantidade = sc.nextInt();
          sc.nextLine();
          produto = loja.buscarProduto(idProduto);
          for (int i = 0; i < quantidade; i++) {
            adicionarAoCarrinho(produto);
          }
          break;
          case 3:System.out.println("Digite o nome do produto que deseja remover: ");
          String nomeProduto = sc.nextLine(); 
          produto = loja.buscarProduto(nomeProduto);
          removerDoCarrinho(produto);
          break;
          case 4:
          realizarCompra(carrinho);
          break;
          case 5:
          loja.listarProdutos();
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

  /** 
   * Realiza a compra dos produtos no carrinho.
   * @param carrinho ArrayList de produtos
   * @throws IOException
   * @throws FileNotFoundException
   */

  private void realizarCompra(ArrayList<Produto> carrinho) throws IOException, FileNotFoundException {
    /** variavel out recebe o caminho do arquivo onde será salvo o arquivo de compras */
    File out = new File("/home/felipe-gsilva/.dev/oop-project/bd/compras.txt");
    double total = 0.0;
    for (Produto produto : carrinho) {
      total += produto.getPreco();
      if (produto instanceof ProdutoFisico) {
        total += ((ProdutoFisico) produto).calcularFrete(produto);
      }
      FileHandler.writeToFile(out, produto.toString());
    }
    System.out.println("Total da compra: " + total);
    FileHandler.writeToFile(out, "Total da compra: " + total);
    carrinho.clear();
  }

  /**
   * Exibe a tela de gerenciamento de produtos.
   */
  public void gerenciarProduto() {
    try {
      Scanner sc = new Scanner(System.in);
      int opProduto = -1;

      int idProduto = 0;
      int idCategoria = 0;
      String nomeProduto = "";
      double precoProduto = 0.0;
      String descricaoProduto = "";
      String marca = "";
      Categoria categoria; 

      while(opProduto != 0) {
        System.out.println("----------Produtos----------");
        System.out.println("1 - Adicionar produto fisico");
        System.out.println("2 - Adicionar produto virtual");
        System.out.println("3 - Remover produto");
        System.out.println("4 - Listar produtos");
        System.out.println("5 - Buscar produto");
        System.out.println("6 - Atualizar estoque");
        System.out.println("7 - Atualizar preço");
        System.out.println("0 - Voltar");
        System.out.println("---------------------------");
        opProduto = sc.nextInt();
        sc.nextLine();
        switch (opProduto) {
          case 1:
          double peso = 0.0;
          String dimensoes = "";

          /** 
           * Recebe os dados do produto fisico.
           */
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

          /** 
           * Recebe os dados do produto virtual.
           */
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
          /** 
           * Remove um produto.
           */
          System.out.println("Digite o id do produto que deseja remover: ");
          idProduto = sc.nextInt();
          loja.removerProduto(idProduto);
          break;

          /** 
           * Lista os produtos.
           */
          case 4: 
          System.out.println("----------Produtos----------");
          loja.listarProdutos();
          System.out.println("----------------------------");
          break;
          case 5:
          /** 
           * Busca um produto.
           */
          buscarProduto();
          break;
          case 6:
          /** 
           * Atualiza o estoque de um produto.
           */
          System.out.println("Digite o id do produto que deseja atualizar o estoque: ");
          idProduto = sc.nextInt();
          sc.nextLine();
          System.out.println("Digite a quantidade que deseja adicionar: ");
          int quantidade = sc.nextInt();
          sc.nextLine();
          loja.buscarProduto(idProduto).atualizarEstoque(quantidade);
          break;
          case 7:
          /** 
           * Atualiza o preço de um produto.
           */
          System.out.println("Digite o id do produto que deseja atualizar o preço: ");
          idProduto = sc.nextInt();
          sc.nextLine();
          System.out.println("Digite o novo preço: ");
          precoProduto = sc.nextDouble();
          sc.nextLine();
          loja.buscarProduto(idProduto).atualizarPreco(precoProduto);
          break;
          default:
          System.out.println("Opção inválida.");
          break;
        }
      } 
    }catch (Exception e) {
      System.err.println("Erro ao gerenciar produto: " + e.getMessage());
    }
  }

  /**
   * Exibe a tela de gerenciamento de categorias.
   */
    public void gerenciarCategoria() {
      try {
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
          System.out.println("------------------------------");

          opCategoria = sc.nextInt();
          sc.nextLine();
          switch (opCategoria) {
            case 1:
            /** 
             * Adiciona uma categoria.
             */
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
            /** 
             * Remove uma categoria.
             */
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
      } catch (Exception e) {
        System.err.println("Erro ao gerenciar categoria: " + e.getMessage()); 
      }
    }

    /**
     * Busca um produto.
     */
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

    /**
     * Adiciona um produto ao carrinho.
     * @param produto Produto
     */
    private void adicionarAoCarrinho(Produto produto) {
      if(carrinho.add(produto)) {
        System.out.println("Produto adicionado ao carrinho.");
      } else {
        Logger.log(produto.getNome(), 2);
      }

    }

    /**
     * Remove um produto do carrinho.
     * @param produto Produto
     */
    private void removerDoCarrinho(Produto produto) {
      if(carrinho.remove(produto)) {
        System.out.println("Produto removido do carrinho.");
      } else {
        Logger.log(produto.getNome(), 3);
      }
    }

    /**
     * Exibe o carrinho.
     */
    private void exibirCarrinho() {
      System.out.println("Produtos no carrinho: ");
      int i = 0;
      for (Produto produto : carrinho) {
        System.out.println("- Produto " + i++ + ": - "+produto.getId()+": "+ produto.getNome() + " | Preço: " + produto.getPreco());
      }
    }
    
    public void setCarrinho(ArrayList<Produto> carrinho) {
      this.carrinho = carrinho;
    }

    public ArrayList<Produto> getCarrinho() {
    return carrinho;
  }
}
