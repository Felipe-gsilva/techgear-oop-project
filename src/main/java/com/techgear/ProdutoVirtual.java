package com.techgear;

public class ProdutoVirtual extends Produto {
  private double tamanhoArquivo;
  private String formato;

  public ProdutoVirtual() {
    super();
  }

  public ProdutoVirtual(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double tamanhoArquivo, String formato) {  
    super(id, nome, preco, descricao, marca, categoria);
    this.tamanhoArquivo = tamanhoArquivo;
    this.formato = formato;
  }
  
  public void realizarDownload(ProdutoVirtual produtoVirtual) {
    System.out.println("Realizando download do arquivo " + produtoVirtual.getNome() + "...");
    //implement this
  }


  public void setTamanhoArquivo(double tamanhoArquivo) {
    this.tamanhoArquivo = tamanhoArquivo;
  }
  public void setFormato(String formato) {
    this.formato = formato;
  }
  public double getTamanhoArquivo() {
    return tamanhoArquivo;
  }
  public String getFormato() {
    return formato;
  }
}
