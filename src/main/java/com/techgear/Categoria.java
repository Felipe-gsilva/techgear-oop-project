package com.techgear;

import java.util.ArrayList;
import java.lang.String;
import com.techgear.util.Logger;

/**
 * Classe que representa uma categoria de produtos.
 * @version 1.0
 * @since 2024-04-08
 **/
public class Categoria {
  private int codigo;
  private String nome;
  private String descricao;
  private ArrayList<Produto> listaProdutos = new ArrayList<>();  
  
  public Categoria(int codigo, String nome, String descricao) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
  }

  /**
   * Adiciona um produto na categoria.
   * @param produto Produto a ser adicionado.
   **/
  public void adicionarProduto(Produto produto) {
    Categoria categoria = produto.getCategoria();
    if(categoria == null) {
      produto.setCategoria(this);
    }
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
    Categoria categoria = produto.getCategoria();
    if(categoria != null) {
      produto.setCategoria(null);
    }
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

  public void setCodigo(int codigo) {
    this.codigo = codigo;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public void setListaProdutos(ArrayList<Produto> listaProdutos) {
    this.listaProdutos = listaProdutos;
  }

  public int getCodigo() {
    return codigo;
  }
  public String getNome() {
    return nome;
  }
  public String getDescricao() { 
    return descricao;
  }
  public ArrayList<Produto> getListaProdutos() {
    return listaProdutos;
  }
}
