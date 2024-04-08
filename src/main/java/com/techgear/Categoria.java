package com.techgear;

import java.util.ArrayList;
import java.lang.String;
import com.techgear.util.Logger;

public class Categoria {
  private int codigo;
  private String nome;
  private String descricao;
  private ArrayList<Produto> listaProdutos = new ArrayList<Produto>();  
  
  public Categoria() {
  }

  public Categoria(int codigo, String nome, String descricao) {
    this.codigo = codigo;
    this.nome = nome;
    this.descricao = descricao;
  }

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

  public Produto buscarProduto(int id) {
    for(Produto produto : listaProdutos) {
      if(produto.getId() == id)
      return produto;
    }
    return null;
  }

  public Produto buscarProduto(String nome) {
    for(Produto produto : listaProdutos) {
      if(produto.getNome().equals(nome))
      return produto;
    }
    return null;
  }

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
