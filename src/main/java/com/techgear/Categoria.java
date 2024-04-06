package com.techgear;

import java.util.ArrayList;
import java.lang.String;

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
    ArrayList<Produto> lista = categoria.getListaProdutos();
    lista.add(produto);
  }

  public void removerProduto(Produto produto) {
    Categoria categoria = produto.getCategoria();
    ArrayList<Produto> lista = categoria.getListaProdutos();
    lista.remove(produto);
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
    for(Produto produto : listaProdutos) {
        System.out.println(">"+produto.getId()+" - "+produto.getNome());
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
