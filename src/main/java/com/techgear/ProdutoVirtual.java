package com.techgear;

import java.lang.String;

public class ProdutoVirtual extends Produto {
  private int tamanho;
  private String formatoArquivo;

  public ProdutoVirtual() {
    super();
  }

  public ProdutoVirtual(String nome, double preco, String descricao, String marca, int tamanho, String formatoArquivo) {  
  super(nome, preco, descricao, marca);
    this.tamanho = tamanho;
    this.formatoArquivo = formatoArquivo;
  }
  

  public void atualizarEstoque(Produto produto, int estoque) {
    ProdutoVirtual produtoVirtual = (ProdutoVirtual) produto;
    /* set this method later*/
    produtoVirtual.setEstoque(estoque);
  }

  public void atualizarPreco(Produto produto, double preco) {
    ProdutoVirtual produtoVirtual = (ProdutoVirtual) produto;
    /* set this method later*/
    produtoVirtual.setPreco(preco);
  }

  public void setTamanho(int tamanho) {
    this.tamanho = tamanho;
  }
  public void setFormato(String formatoArquivo) {
    this.formatoArquivo= formatoArquivo;
  }
  public int getTamanho() {
    return tamanho;
  }
  public String getFormatoArquivo() {
    return formatoArquivo;
  }
}
