package com.techgear;

/**
 * Classe abstrata que representa um produto.
 * @version 1.0
 * @author Felipe Gomes da Silva
 * @since 2024-04-08
 * @see Categoria
 * @see Produto
 * @see ProdutoFisico
 * @see ProdutoVirtual
 */
public abstract class Produto {
  /**
   * Identificador do produto.
   */
  private int id;
  /**
   * Nome do produto.
   */
  private String nome;
  /**
   * Preco do produto.
   */
  private double preco;
  /**
   * Descricao do produto.
   */
  private String descricao;
  /**
   * Marca do produto.
   */
  private String marca;
  /**
   * Estoque do produto.
   */
  private int estoque;
  /**
   * Contador de identificadores.
   */
  private static int contadorId = 0;
  /**
   * Categoria do produto.
   */
  private Categoria categoria; 

  /**
   * Construtor vazio da classe Produto que incrementa o contador de identificadores.
   */
  public Produto() {
    contadorId++; 
  }

  /**
   * Construtor da classe Produto.
   * @param id Identificador do produto.
   * @param nome Nome do produto.
   * @param preco Preco do produto.
   * @param descricao Descricao do produto.
   * @param marca Marca do produto.
   * @param categoria Categoria do produto.
   */
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

  /**
   * Atualiza o estoque do produto.
   * @param estoque Novo estoque do produto.
   */
  public void atualizarEstoque(int estoque) {
    this.setEstoque(estoque);
  }

  /**
   * Atualiza o preco do produto.
   * @param preco Novo preco do produto.
   */
  public void atualizarPreco(double preco) {
    this.setPreco(preco);
  }

  /**
   * Atualiza o id do produto.
   * @param id Novo id do produto. 
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Atualiza o nome do produto.
   * @param nome Novo nome do produto.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * Atualiza o preco do produto.
   * @param preco Novo preco do produto.
   */
  public void setPreco(double preco) {
    this.preco = preco;
  }

  /**
   * Atualiza a descricao do produto.
   * @param descricao Nova descricao do produto.
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  /**
   * Atualiza a marca do produto.
   * @param marca Nova marca do produto.
   */
  public void setMarca(String marca) {
    this.marca = marca;
  }

  /**
   * Atualiza o estoque do produto.
   * @param estoque Novo estoque do produto.
   */
  public void setEstoque(int estoque) {
    this.estoque = estoque;
  }

  /**
   * Atualiza a categoria do produto.
   * @param categoria Nova categoria do produto.
   */
  public void setCategoria(Categoria categoria) {
    this.categoria = categoria;
  }

  /**
   * Retorna o identificador do produto.
   * @return Identificador do produto.
   */
  public int getId() {
    return id;
  }

  /**
   * Retorna o nome do produto.
   * @return Nome do produto.
   */
  public String getNome() {
    return nome;
  }

  /**
   * Retorna o preco do produto.
   * @return Preco do produto.
   */
  public double getPreco() {
    return preco;
  }

  /**
   * Retorna a descricao do produto.
   * @return Descricao do produto.
   */
  public String getDescricao() {
    return descricao;
  }

  /**
   * Retorna a marca do produto.
   * @return Marca do produto.
   */
  public String getMarca() {
    return marca;
  }

  /**
   * Retorna o estoque do produto.
   * @return Estoque do produto.
   */
  public int getEstoque() {
    return estoque;
  }

  /**
   * Retorna a categoria do produto.
   * @return Categoria do produto.
   */
  public Categoria getCategoria() {
    return categoria;
  }
}

