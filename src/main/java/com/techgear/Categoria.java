package com.techgear;

import java.util.ArrayList;
import java.lang.String;

public class Categoria {
  private int codigo;
  private String nome;
  private String descricao;
  private ArrayList<Produto> listaProdutos;  
  
  public Categoria() {

  }

  public Categoria(int codigo, String nome, String descricao) {

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
    // não sei se funciona
    for(Produto produto : listaProdutos) {
      if(produto.getId() == id)
        return produto;
    }
    return null;
  }
  
  public ArrayList<Produto> listarProdutos() {
    //
    // listar ai
    //
    return listaProdutos;  
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
