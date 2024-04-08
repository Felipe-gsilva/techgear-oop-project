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
  private ArrayList<Categoria> listaCategorias;

  public Loja(String nome, String cnpj, String endereco) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
    this.listaCategorias = new ArrayList<Categoria>();
  }

  /**
   * Adiciona uma categoria à lista de categorias da loja.
   * @param categoria Categoria a ser adicionada.
   **/
  public void adicionarCategoria(Categoria categoria) {
    for(Categoria categoriaTeste : listaCategorias) {
      if(categoriaTeste.getNome().equals(categoria.getNome())) {
        Logger.log(categoria.getNome(), 1);
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
        if(produtoTeste.getNome().equals(produto.getNome())) {
          Logger.log(produto.getNome(), 1);
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
   * @param nomeCategoria Nome da categoria onde o produto será adicionado.
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
   * Remove uma categoria da loja.
   * @param nome Nome da categoria a ser removida.
   **/
  public void listarCategorias() {
    for(Categoria categoria : listaCategorias) {
      System.out.println(">"+categoria.getCodigo() + " - " + categoria.getNome());
    }
  }

  /**
   * Lista os produtos de todas as categorias.
   **/
  public void listarProdutos() {
    for(Categoria categoria : listaCategorias) {
      categoria.listarProdutos();
    }
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

  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }
  public void setEndereco(String endereco) {
    this.endereco = endereco;
  }
  public void setListaCategorias(ArrayList<Categoria> listaCategorias) {
    this.listaCategorias = listaCategorias;
  }
  public String getNome() {
    return nome;
  }
  public String getCnpj() {
    return cnpj;
  }
  public String getEndereco() {
    return endereco;
  }
  public ArrayList<Categoria> getListaCategorias() {
    return listaCategorias;
  }
}
