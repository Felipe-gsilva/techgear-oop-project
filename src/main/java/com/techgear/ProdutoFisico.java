package com.techgear;

public class ProdutoFisico extends Produto {
  private double peso;
  private double[] dimensoes = new double[3];
  private double frete;
  
  public ProdutoFisico() {
    super();
  }

  public ProdutoFisico(String nome, double preco, String descricao, String marca, double peso, double[] dimensoes) {  
  super(nome, preco, descricao, marca);
    this.peso = peso;
    this.dimensoes = dimensoes;  
  }

  public void atualizarEstoque(Produto produto, int estoque) {
    ProdutoFisico produtoFisico = (ProdutoFisico) produto;
    /* set this method later*/
    produto.setEstoque(estoque);
  }

  public void atualizarPreco(Produto produto, double preco) {
    ProdutoFisico produtoFisico = (ProdutoFisico) produto;
    /* set this method later*/
    produto.setPreco(preco);
  }
  
  public void calcularFrete(Produto produto) {   
    ProdutoFisico produtoFisico = (ProdutoFisico) produto;
    double peso = produtoFisico.getPeso();
    double[] dimensoes = produtoFisico.getDimensoes();

    double multiplicador = 0;
    double baseFrete = 5;
    double score = 0;
    double dimensoesUnificadas = dimensoes[0]*dimensoes[1]*dimensoes[2];

    if(peso >= 30)
      multiplicador += 2;
    else {
      score = peso*1.5;
      score = (score + 4)/20; 
    } 

    if(dimensoesUnificadas > 200) // maior valor entregue pelo sedex
      multiplicador += 5;
    else {
      score = (score + dimensoesUnificadas)/10;
    }

    if(score < 1)
      multiplicador += score;
    else {
      score = (score/10) + 1;
      multiplicador += score;
    }

    produtoFisico.setFrete(multiplicador * baseFrete);
  }

  // getters e setters
  public void setPeso(double peso) {
    this.peso = peso;
  }
  public void setDimensoes(double[] dimensoes) {
    this.dimensoes = dimensoes;
  }
  public void setFrete(double frete) {
    this.frete = frete;
  }
  public double getPeso() {
    return peso;
  }
  public double[] getDimensoes(){
    return dimensoes;
  }
  public double getFrete() {
    return frete;
  }
}
