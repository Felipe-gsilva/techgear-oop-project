package com.techgear;

import java.util.ArrayList;
import com.techgear.util.Logger;

/**
 * Classe que representa uma loja.
 * 
 * @version 1.0
 * @since 2024-04-08
 **/
public class Loja {
  private String nome;
  private String cnpj;
  private String endereco;
  private ArrayList<Categoria> listaCategorias = new ArrayList<Categoria>();


/**
 *  Construtor da clase loja
 *  @param nome Representa o nome da loja
 *  @param cnpj Representa o cnpj da loja
 *  @param endereco Representa o endereco da loja
 */
  public Loja(String nome, String cnpj, String endereco) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }

  /**
   * Adiciona uma categoria à lista de categorias da loja.
   * @param categoria Categoria a ser adicionada.
   **/
  public void adicionarCategoria(Categoria categoria) {
    for(Categoria categoriaTeste : listaCategorias) {
      if(categoriaTeste.getCodigo() == categoria.getCodigo()) {
        Logger.log(categoria.getNome(), 4);
        return;
      }
    }
    listaCategorias.add(categoria);
  } 

  /**
   * Adiciona um produto em uma categoria.
   * @param idCategoria ID da categoria onde o produto será adicionado.
   * @param produto Produto a ser adicionado.
   **/
  public void adicionarProduto(int idCategoria, Produto produto) {
    Categoria categoria = buscarCategoria(idCategoria);
    if(categoria != null) {
      for(Produto produtoTeste : categoria.getListaProdutos()) {
        if(produto.getId() == produtoTeste.getId()) {
          Logger.log(produto.getNome(), 4);
          return;
        }
      }
      categoria.adicionarProduto(produto);
    }
    else
      Logger.log(produto.getNome(), 2);
  }

  /**
   * Adiciona um produto em uma categoria.
   * @param categoria Referencia à categoria.
   * @param produto Produto a ser adicionado.
   **/
  public void adicionarProduto(Categoria categoria, Produto produto) {
    for (Produto produtoTeste : categoria.getListaProdutos()) {
      if(produtoTeste.getNome().equals(produto.getNome()))
      return;
    }
    categoria.adicionarProduto(produto);
  }
  /**
   * Busca uma categoria pelo ID.
   * @param id ID da categoria a ser buscada.
   * @return Categoria encontrada.
   **/
  public Categoria buscarCategoria(int id) {
    for(Categoria categoria : listaCategorias) {
      if(categoria.getCodigo()== id)
      return categoria;
    }
    return null; 
  }

  /**
   * Busca um produto pelo ID.
   * @param id ID do produto a ser buscado.
   * @return Produto encontrado.
   **/
  public Produto buscarProduto(int id) {
    Produto produto = null;
    for(Categoria categoria : listaCategorias) {
      produto = categoria.buscarProduto(id);
      if(produto != null)
      return produto;
    }
    return null;
  }
  /**
   * Busca um produto pelo nome.
   * @param nome Nome do produto a ser buscado.
   * @return Produto encontrado.
   **/
  public Produto buscarProduto(String nome) {
    Produto produto = null;
    for(Categoria categoria : listaCategorias) {
      produto = categoria.buscarProduto(nome);
      if(produto != null)
      return produto;
    }
    return null;
  }

  /**
   * Busca uma categoria pelo nome.
   * @param nome Nome da categoria a ser buscada.
   * @return Categoria encontrada.
   **/
  public Categoria buscarCategoria(String nome) {
    for(Categoria categoria : listaCategorias) {
      if(categoria.getNome().equals(nome))
      return categoria;    
    }
    return null;
  }

  /**
   * Remove uma categoria da loja.
   * @param id ID da categoria a ser removida.
   **/
  public void removerCategoria(int id) {
    Categoria categoria = buscarCategoria(id);
    if(categoria != null) {
      listaCategorias.remove(categoria);
    }
    else 
    Logger.log(getNome(), 3);
  }

  /**
   * Lista todas as categorias
   **/
  public void listarCategorias() {

    System.out.println("----------Categorias----------");
    for(Categoria categoria : listaCategorias) {
      System.out.println(">"+categoria.getCodigo() + " - " + categoria.getNome());
    }
    System.out.println("------------------------------");
  }

  /**
   * Lista os produtos de todas as categorias.
   **/
  public void listarProdutos() {

    System.out.println("----------Produtos----------");
    for(Categoria categoria : listaCategorias) {
      categoria.listarProdutos();
    }
    System.out.println("----------------------------");
  }

  /**
   * Remove um produto da loja.
   * @param id ID do produto a ser removido.
   **/
  public void removerProduto(int id) {
    Produto produto = buscarProduto(id);
    if(produto != null) {
      Categoria categoria = produto.getCategoria();
      categoria.removerProduto(produto);
    }
    else 
    Logger.log(getNome(), 3);
  }

/**
 * Responsável por atualizar o valor do nome
 * @param nome variável que atualizará o valor atual 
 */
  public void setNome(String nome) {
    this.nome = nome;
  }
/**
 * Responsável por atualizar o valor do cnpj 
 * @param cnpj variável que atualizará o valor atual 
 */
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
/**
 * Responsável por atualizar o valor do endereco 
 * @param endereco variável que atualizará o valor atual 
 */
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
/**
 * Responsável por atualizar o valor da lista de catogorias da loja 
 * @param listaCategorias variável nome que atualizará o valor atual 
 */
  public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }

/**
 *  Responsável por retornar o valor atual da variavel nome
 *  @return nome
 */
  public String getNome() {
    return nome;
  }
/**
 *  Responsável por retornar o valor atual da variavel cnpj 
 *  @return cnpj 
 */
  public String getCnpj() {
    return cnpj;
  }
  /**
 *  Responsável por retornar o valor atual da variavel nome
 *  @return endereco 
 */ 
  public String getEndereco() {
    return endereco;
  }
/**
 *  Responsável por retornar o valor atual da variavel nome
 *  @return listaCategorias  
 */
  public ArrayList<Categoria> getListaCategorias() {
    return listaCategorias;
  }
}

