package com.techgear;

/**
 * Classe abstrata que representa um produto.
 * @version 1.0
 * @since 2024-04-08
 **/
public abstract class Produto {
  private int id;
  private String nome;
  private double preco;
  private String descricao;
  private String marca;
  private int estoque;
  private static int contadorId = 0;
  private Categoria categoria; 

  public Produto() {
    contadorId++; 
  }

  public Produto(int id, String nome, double preco, String descricao, String marca, Categoria categoria) {
    this.nome = nome;
    this.preco = preco;
    this.descricao = descricao;
    this.marca = marca;
    this.id = id;
    this.categoria = categoria;
    contadorId++;
    this.estoque = 0;
  }

  public void atualizarEstoque(int estoque) {
    this.setEstoque(estoque);
  }

  public void atualizarPreco(double preco) {
    this.setPreco(preco);
  }

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
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
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
  public Categoria getCategoria() {
    return categoria;
  }
}
