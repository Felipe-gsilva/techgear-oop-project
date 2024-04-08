package com.techgear;

public class ProdutoFisico extends Produto {
  private double peso;
  private String dimensoes; 
  private double frete;
  
  public ProdutoFisico() {
    super();
  }
  
  public ProdutoFisico(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double peso, String dimensoes) {
    super(id, nome, preco, descricao, marca, categoria);
    this.peso = peso;
    this.dimensoes = dimensoes;
  }
  
  /**
   * Calcula o frete de um produto físico de acordo com seu peso.
   * @param produto ProdutoFisico a ser calculado o frete.
   * @return Frete calculado.
   **/
  public double calcularFrete(Produto produto) {   
    ProdutoFisico produtoFisico = (ProdutoFisico) produto;
    double peso = produtoFisico.getPeso();
  
    double multiplicador = 0;
    double baseFrete = 5;
    double score = 0;

    if(peso > 30) 
    multiplicador += 2; 
    else {
      score = peso*2;
      score = (score + 10)/45; 
    } 
    return multiplicador * baseFrete; 
  }

  public void setPeso(double peso) {
    this.peso = peso;
  }
  public void setDimensoes(String dimensoes) {
    this.dimensoes = dimensoes;
  }
  public void setFrete(double frete) {
    this.frete = frete;
  }
  public double getPeso() {
    return peso;
  }
  public String getDimensoes(){
    return dimensoes;
  }
  public double getFrete() {
    return frete;
  }
}
