package com.techgear;

import java.lang.String;

public class ProdutoVirtual extends Produto {
  private int tamanhoArquivo;
  private String formato;

  public ProdutoVirtual() {
    super();
  }

  public ProdutoVirtual(String nome, double preco, String descricao, String marca, int tamanhoArquivo, String formato) {  
  super(nome, preco, descricao, marca);
    this.tamanhoArquivo = tamanhoArquivo;
    this.formato = formato;
  }
  
  public void realizarDownload() {
    //implement this

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

  public void setTamanhoArquivo(int tamanhoArquivo) {
    this.tamanhoArquivo = tamanhoArquivo;
  }
  public void setFormato(String formato) {
    this.formato = formato;
  }
  public int getTamanhoArquivo() {
    return tamanhoArquivo;
  }
  public String getFormato() {
    return formato;
  }
}
