package com.techgear;

import java.util.ArrayList;
import java.lang.String;
import com.techgear.util.Logger;

/**
 * Classe que representa uma categoria de produtos.
 * @version 1.0
 * @since 2024-04-08
 * @author Felipe Gomes da Silva
 * @see Produto
 * @see Logger
 * @see ProdutoVirtual
 * @see ProdutoFisico
 **/
public class Categoria {
  /** Código da categoria. **/
  private int codigo; 
  /** Nome da categoria. **/
  private String nome;
  /** Descrição da categoria. **/
  private String descricao;
  /** Lista de produtos da categoria. **/
  private ArrayList<Produto> listaProdutos;
  
  /**
   * Construtor da classe Categoria.
   * @param codigo Código da categoria.
   * @param nome Nome da categoria.
   * @param descricao Descrição da categoria.
   **/
  public Categoria(int codigo, String nome, String descricao) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
    this.listaProdutos = new ArrayList<Produto>();
  }

  /**
   * Adiciona um produto na categoria.
   * @param produto Produto a ser adicionado.
   **/
  public void adicionarProduto(Produto produto) {
    if(!listaProdutos.contains(produto)) {
      listaProdutos.add(produto);
    }
    else {
      Logger.log(produto.getNome(), 4);
    }
  }

  /**
   * Remove um produto da categoria.
   * @param produto Produto a ser removido.
   **/
  public void removerProduto(Produto produto) {
    if(listaProdutos.contains(produto)) {
      listaProdutos.remove(produto);
    }
    else {
      Logger.log(produto.getNome(), 1);
    }
  }

  /**
   * Busca um produto na categoria.
   * @param id ID do produto a ser buscado.
   * @return Produto encontrado.
   **/
  public Produto buscarProduto(int id) {
    for(Produto produto : listaProdutos) {
      if(produto.getId() == id)
      return produto;
    }
    return null;
  }

  /**
   * Busca um produto na categoria.
   * @param nome Nome do produto a ser buscado.
   * @return Produto encontrado.
   **/
  public Produto buscarProduto(String nome) {
    for(Produto produto : listaProdutos) {
      if(produto.getNome().equals(nome))
      return produto;
    }
    return null;
  }

  /**
   * Lista os produtos da categoria.
   **/
  public void listarProdutos() {
    System.out.println("------->Produtos da categoria "+nome+":");
    if(listaProdutos.isEmpty()) {
      System.out.println("Nenhum produto cadastrado.");
      return;
    }
    for(Produto produto : listaProdutos) {
      System.out.println(">"+produto.getId()+" - "+produto.getNome()+" - "+produto.getPreco());
    }
  }

  /**
   * atualiza o codigo 
   * @param codigo Codigo da categoria
   */
  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  /**
   * atualiza o nome
   * @param nome Nome da categoria
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * atualiza a descricao
   * @param descricao Descricao da categoria
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
   * atualiza a lista de produtos
   * @param listaProdutos Lista de produtos da categoria
   */
  public void setListaProdutos(ArrayList<Produto> listaProdutos) {
    this.listaProdutos = listaProdutos;
  }

 /** 
   * retorna o codigo
   * @return Codigo da categoria
   */
  public int getCodigo() {
    return codigo;
  }
  /**
   * retorna o nome
   * @return Nome da categoria
   */
  public String getNome() {
    return nome;
  }
  /**
   * retorna a descricao
   * @return Descricao da categoria
   */
  public String getDescricao() { 
    return descricao;
  }
  /**
   * retorna a lista de produtos
   * @return Lista de produtos da categoria
   */
  public ArrayList<Produto> getListaProdutos() {
    return listaProdutos;
  }
}
