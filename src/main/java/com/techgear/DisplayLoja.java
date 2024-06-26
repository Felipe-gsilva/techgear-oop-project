package com.techgear;

import java.io.*;
import com.techgear.util.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Classe que exibe a interface CLI da loja.
 * @version 1.0
 * @since 2024-04-08
 * @author Felipe Gomes da Silva
 * @see Loja
 **/
public class DisplayLoja {
  private final Loja loja = new Loja("TechGear", "123456789", "Rua de Verdade, 128");
  private ArrayList<Produto> carrinho = new ArrayList<>();

/**
 *  Construtor vazio para a classe displayLoja
 */
  public DisplayLoja(){
  }

  /**
   * Exibe a tela de usuário.
   */
  public void telaUsuario() {
    try {
      /** instancia o objeto fileHandler, responsavel por gerenciar os arquivos */
      FileHandler fileHandler = new FileHandler();
      fileHandler.loadFiles(loja);
      /** instancia o objeto scanner para receber a entrada do usuario */
      Scanner sc = new Scanner(System.in);
      /** variavel op recebe a opção escolhida pelo usuario */
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

        switch (op) {
          case 1:
          gerenciarProduto(); 
          break;
          case 2:
          gerenciarCategoria();
          break;
          case 3:
          loja.listarProdutos();
          break;
          case 4:
          loja.listarCategorias();
          break;
          case 8:
          System.out.println("Nome: " + loja.getNome());
          System.out.println("CNPJ: " + loja.getCnpj());
          System.out.println("Endereço: " + loja.getEndereco());
          break;
          case 9:
          gerenciarCarrinho();
          break;
          case 0:
          System.out.println("Saindo...");
          break;
          default: 
          System.out.println("Opção inválida.");
          break;
        }
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
      telaUsuario();
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
        System.out.println("6 - Listar categorias");
        System.out.println("0 - Voltar");
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

          if(produto.getEstoque() > quantidade) {
            for (int i = 0; i < quantidade; i++) {
              adicionarAoCarrinho(produto);
            }
          }
          else 
          throw new Exception("Estoque insuficiente");
          break;
          case 3:
          System.out.println("Digite o id do produto que deseja remover: ");
          idProduto = sc.nextInt();
          sc.nextLine();
          produto = loja.buscarProduto(idProduto);
          removerDoCarrinho(produto);
          break;
          case 4:
          realizarCompra(carrinho);
          break;
          case 5:
          loja.listarProdutos();
          break;
          case 6:
          loja.listarCategorias();
          case 0:
          break;
          default:
          System.out.println("Opção inválida.");
          break;
        }
      }
    } catch (Exception e) {
      System.err.println("Erro ao gerenciar carrinho: " + e.getMessage());
      gerenciarCarrinho();
    }
  }

  /** 
   * Realiza a compra dos produtos no carrinho.
   * @param carrinho ArrayList de produtos
   */
  private void realizarCompra(ArrayList<Produto> carrinho) throws Exception {
    /** variavel out recebe o caminho do arquivo onde será salvo o arquivo de compras */
    if (carrinho.isEmpty()) {
      throw new Exception("Carrinho vazio.");
    }

    double totalFrete = 0;
    double totalBruto = 0;
    File out = new File("./bd/compras.txt");

    out.delete();
    for (Produto produto : carrinho) {
      totalBruto += produto.getPreco(); 
      if (produto instanceof ProdutoFisico) {
        totalFrete += ((ProdutoFisico) produto).calcularFrete(produto);
      }
      String dados = "ID: " + produto.getId() + "| Arquivo: " + produto.getNome() +"\n" + produto.getDescricao() + "\n";
      produto.setEstoque(produto.getEstoque()-1);
      FileHandler.writeToFile(out, dados);
    }

    System.out.println("Preço bruto dos produtos: " + totalBruto);
    System.out.println("Frete: " + totalFrete);
    System.out.println("Total da compra: " + (totalBruto + totalFrete));
    FileHandler.writeToFile(out, "Total da compra: " + (totalBruto + totalFrete));
    carrinho.clear();
  }

  /**
   * Exibe a tela de gerenciamento de produtos.
   */
  public void gerenciarProduto() {
    try {
      /** instancia o objeto scanner para receber a entrada do usuario */
      Scanner sc = new Scanner(System.in);
      /** variavel opProduto recebe a opção escolhida pelo usuario */
      int opProduto = -1;

      /** variaveis para receber os dados do produto */
      int idProduto = 0;
      int idCategoria = 0;
      String nomeProduto = "";
      double precoProduto = 0.0;
      String descricaoProduto = "";
      String marca = "";
      Categoria categoria; 
      int estoque;

      while(opProduto != 0) {
        System.out.println("----------Produtos----------");
        System.out.println("1 - Adicionar produto fisico");
        System.out.println("2 - Adicionar produto virtual");
        System.out.println("3 - Remover produto");
        System.out.println("4 - Listar produtos");
        System.out.println("5 - Buscar produto");
        System.out.println("6 - Atualizar estoque");
        System.out.println("7 - Atualizar preço");
        System.out.println("8 - Listar categorias");
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
          System.out.println("Digite a altura, a largura e a profundidade do produto: (ex: 45.00x35.02x99.99)");
          dimensoes = sc.nextLine();
          System.out.println("Insira a quantidade do produto no estoque");
          estoque = sc.nextInt();
          sc.nextLine();


          int check = 0;
          for(int i = 0; i < dimensoes.length(); i++) {
            if('x' == dimensoes.charAt(i))
            check++;
            // se tiver um x do lado de outro, exceção lançada 
            if('x' == dimensoes.charAt(i) && 'x' == dimensoes.charAt(i+1))
            throw new Exception("Nao coloque um separador x ao lado de outro");
            // se tiver uma , exceção lançada 
            if(',' == dimensoes.charAt(i))
            throw new Exception("Use '.' ao invés de ','");
          }

          // se nao tiver 3 x's, exceção é lançada
          if(check != 2)
          throw new Exception("Dimensoes mal inseridas!");
          /** 
           * Cria o objeto produto fisico e adiciona na loja.
           */
          ProdutoFisico produtoFisico = new ProdutoFisico(idProduto, nomeProduto, precoProduto, descricaoProduto, marca,categoria, peso, dimensoes);
          produtoFisico.setEstoque(estoque);
          loja.adicionarProduto(produtoFisico.getCategoria(), produtoFisico);
          break;
          case 2:

          /** 
           * Variaveis para receber os dados do produto virtual.
           */
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
          System.out.println("Informe o estoque:");
          estoque = sc.nextInt();
          sc.nextLine();

          /** 
           * Cria o objeto produto virtual e adiciona na loja.
           */
          Produto produtoVirtual = new ProdutoVirtual(idProduto, nomeProduto, precoProduto, descricaoProduto, marca,categoria, tamanho, formato);
          produtoVirtual.setEstoque(estoque);
          loja.adicionarProduto(produtoVirtual.getCategoria(), produtoVirtual);
          break;
          case 3:
          /** 
           * Remove um produto.
           */
          System.out.println("Digite o id do produto que deseja remover: ");
          idProduto = sc.nextInt();
          if(loja.buscarProduto(idProduto) == null) {
            throw new Exception("Produto não encontrado.");
          }

          loja.removerProduto(idProduto);
          break;

          /** 
           * Lista os produtos.
           */
          case 4: 
          loja.listarProdutos();
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

          if(quantidade > 0) 
          loja.buscarProduto(idProduto).atualizarEstoque(quantidade);
          else 
          throw new Exception("Estoque inválido");
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

          if(precoProduto > 0)
          loja.buscarProduto(idProduto).atualizarPreco(precoProduto);
          else 
          throw new Exception("Preço inválido");

          break;
          case 8:
          loja.listarCategorias();
          break;
          case 0:
          break;
          default:
          System.out.println("Opção inválida.");
          break;
        }
      } 
    }catch (Exception e) {
      System.err.println("Erro ao gerenciar produto: " + e.getMessage());
      gerenciarProduto();
    }
  }

  /**
   * Exibe a tela de gerenciamento de categorias.
   */
  public void gerenciarCategoria() {
    try {
      /** instancia o objeto scanner para receber a entrada do usuario */
      Scanner sc = new Scanner(System.in);
      /** variavel opCategoria recebe a opção escolhida pelo usuario */
      int opCategoria = -1;
      /** variaveis para receber os dados da categoria */
      int idCategoria;
      String nomeCategoria;
      String descricaoCategoria;

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
          sc.nextLine();
          if(loja.buscarCategoria(idCategoria) == null) {
            throw new Exception("Categoria não encontrada.");
          }
          loja.removerCategoria(idCategoria);
          break;
          case 3:
          loja.listarCategorias();
          break;
          case 0: 
          break;
          default:
          System.out.println("Opção inválida.");
          break;
        }
      }
    } catch (Exception e) {
      System.err.println("Erro ao gerenciar categoria: " + e.getMessage()); 
      gerenciarCategoria();
    }
  }

  /**
     * Busca um produto.
     */
  private void buscarProduto() {
    /** instancia o objeto scanner para receber a entrada do usuario */
    Scanner sc = new Scanner(System.in);
    System.out.println("Digite o nome do produto que deseja buscar: ");
    String nomeProduto = sc.nextLine(); 
    Produto produto = loja.buscarProduto(nomeProduto);
    if (produto != null) {
      System.out.println(produto.getNome());
    } else {
      Logger.log(nomeProduto, 1);
    }
  }

  /**
     * Adiciona um produto ao carrinho.
     * @param produto Produto
     */
  private boolean adicionarAoCarrinho(Produto produto) {
    boolean check = false;
    if(carrinho.add(produto)) {
      check = true;
    } else {
      Logger.log(produto.getNome(), 2);
      check = false;
    }
    return check;
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

/**
     * Atualiza o carrinho 
     * @param carrinho ArrayList de produtos 
     */
  public void setCarrinho(ArrayList<Produto> carrinho) {
    this.carrinho = carrinho;
  }

/**
     * Retorna o carrinho.
     * @return ArrayList de produtos
     */
  public ArrayList<Produto> getCarrinho() {
    return carrinho;
  }
}
