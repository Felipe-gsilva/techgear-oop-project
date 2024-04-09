package com.techgear;

/**
 * Classe que representa um produto fisico e estende Produto.
 * @version 1.0
 * @author Felipe Gomes da Silva
 * @since 2024-04-08
 * @see Categoria
 * @see Produto
 * @see ProdutoVirtual
 */
public class ProdutoFisico extends Produto {
  /**
   * Peso do produto.
   */
  private double peso;
  /**
   * Dimensoes do produto.
   */
  private String dimensoes; 
  /**
   * Frete do produto.
   */
  private double frete;
  
  /**
   * Construtor da classe ProdutoFisico.
   * @param id Identificador do produto.
   * @param nome Nome do produto.
   * @param preco Preco do produto.
   * @param descricao Descricao do produto.
   * @param marca Marca do produto.
   * @param categoria Categoria do produto.
   * @param peso Peso do produto.
   * @param dimensoes Dimensoes do produto.
   */
  public ProdutoFisico(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double peso, String dimensoes) {
    super(id, nome, preco, descricao, marca, categoria);
    this.peso = peso;
    this.dimensoes = dimensoes;
  }
  
  /**
   * Calcula o frete de um produto físico de acordo com, e apenas, seu peso.
   * @param produto ProdutoFisico que tera seu frete calculado.
   * @return Frete calculado.
   **/
  public double calcularFrete(Produto produto) {   
    /**
     * Produto fisico.
     */
    ProdutoFisico produtoFisico = (ProdutoFisico) produto;
    /**
     * Peso do produto fisico.
     */
    double peso = produtoFisico.getPeso();
  
    /**
     * Multiplicador do frete.
     */
    double multiplicador = 0;
    /**
     * Valor base para o frete.
     */
    double baseFrete = 5;
    /**
     * Valor de pontuacao para o frete.
     */
    double score = 0;

    if(peso > 30) 
    multiplicador += 2; 
    else {
      score = peso*2;
      score = (score + 10)/45; 
    } 
    return multiplicador * baseFrete; 
  }

  /**
   * Atualiza o peso do produto.
   * @param peso Peso do produto.
   */
  public void setPeso(double peso) {
    this.peso = peso;
  }
  /**
   * Atualiza as dimensoes do produto.
   * @param dimensoes Dimensoes do produto.
   */
  public void setDimensoes(String dimensoes) {
    this.dimensoes = dimensoes;
  }
  /**
   * Atualiza o frete do produto.
   * @param frete Frete do produto.
   */
  public void setFrete(double frete) {
    this.frete = frete;
  }
  /**
   * Retorna o peso do produto.
   * @return Peso do produto.
   */
  public double getPeso() {
    return peso;
  }
  /**
   * Retorna as dimensoes do produto.
   * @return Dimensoes do produto.
   */
  public String getDimensoes(){
    return dimensoes;
  }
  /**
   * Retorna o frete do produto.
   * @return Frete do produto.
   */
  public double getFrete() {
    return frete;
  }
}

