package com.techgear;

import java.util.ArrayList;
import com.techgear.util.Logger;

public class Loja {
  private String nome;
  private String cnpj;
  private String endereco;
  private ArrayList<Categoria> listaCategorias = new ArrayList<>(); 

  public Loja() {
    
  }
  public Loja(String nome, String cnpj, String endereco) {
    this.nome = nome;
    this.cnpj = cnpj;
    this.endereco = endereco;
  }

  public void adicionarCategoria(Categoria categoria) {
    for(Categoria categoriaTeste : listaCategorias) {
      if(categoriaTeste.getNome().equals(categoria.getNome())) {
        Logger.log(categoria.getNome(), 1);
        return;
      }
    }
    listaCategorias.add(categoria);
  } 

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

  public void adicionarProduto(Categoria categoria, Produto produto) {
    for (Produto produtoTeste : categoria.getListaProdutos()) {
      if(produtoTeste.getNome().equals(produto.getNome()))
      return;
    }
    categoria.adicionarProduto(produto);
  }
  public Categoria buscarCategoria(int id) {
    for(Categoria categoria : listaCategorias) {
      if(categoria.getCodigo()== id)
      return categoria;
    }
    return null; 
  }

  public Produto buscarProduto(int id) {
    Produto produto = null;
    for(Categoria categoria : listaCategorias) {
      produto = categoria.buscarProduto(id);
      if(produto != null)
      return produto;
    }
    return null;
  }
  public Produto buscarProduto(String nome) {
    Produto produto = null;
    for(Categoria categoria : listaCategorias) {
      produto = categoria.buscarProduto(nome);
      if(produto != null)
      return produto;
    }
    return null;
  }

  public Categoria buscarCategoria(String nome) {
    for(Categoria categoria : listaCategorias) {
      if(categoria.getNome().equals(nome))
      return categoria;    
    }
    return null;
  }

  public void removerCategoria(int id) {
    Categoria categoria = buscarCategoria(id);
    if(categoria != null) {
      listaCategorias.remove(categoria);
    }
    else 
    Logger.log(getNome(), 3);
  }

  public void listarCategorias() {
    for(Categoria categoria : listaCategorias) {
      System.out.println(">"+categoria.getCodigo() + " - " + categoria.getNome());
    }
  }

  public void listarProdutos() {
    for(Categoria categoria : listaCategorias) {
      categoria.listarProdutos();
    }
  }

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
