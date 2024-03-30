package com.techgear;

import java.lang.String;

abstract class Produto {
  private int id;
  private String nome;
  private double preco;
  private String descricao;
  private String marca;
  private int estoque;
  private static int contadorId = 0;
  private Categoria categoria; 

  public Produto() {
    
  }

  public Produto(String nome, double preco, String descricao, String marca) {
    this.nome = nome;
    this.preco = preco;
    this.descricao = descricao;
    this.marca = marca;
    this.id = gerarId();
  }

  private int gerarId() {
    int novoId = ++Produto.contadorId;
    System.out.println("Id gerado: "+novoId);
    // criar um método para ids aleatórios
    return novoId;
  }

  abstract public void atualizarEstoque(Produto produto, int estoque);
  abstract public void atualizarPreco(Produto produto, double preco);

  public void setId(int id) {
    this.id = id;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setPreco(double preco) {
    this.preco = preco;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public void setMarca(String marca) {
    this.marca = marca;
  }
  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  public int getId() {
    return id;
  }
  public String getNome() {
    return nome;
  }
  public double getPreco() {
    return preco;
  }
  public String getDescricao() {
    return descricao;
  }
  public String getMarca() {
    return marca;
  }
  public int getEstoque() {
    return estoque;
  }
}
