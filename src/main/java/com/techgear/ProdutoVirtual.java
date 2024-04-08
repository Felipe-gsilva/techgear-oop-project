package com.techgear;

import java.io.*;
import com.techgear.util.FileHandler;

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
  
  /**
   * Realiza o download de um arquivo.
   * @param produtoVirtual ProdutoVirtual a ser baixado.
   **/
  public void realizarDownload(ProdutoVirtual produtoVirtual) throws IOException {
    File arquivo = new File(produtoVirtual.getNome() + "." + produtoVirtual.getFormato());
    System.out.println("Realizando download do arquivo " + produtoVirtual.getNome() + "...");
    String string = "Arquivo: " + produtoVirtual.getNome() + "\n" + "Tamanho: " + produtoVirtual.getTamanhoArquivo() + "GB\n";
    FileHandler.writeToFile(arquivo, string);
    if(arquivo.exists()){
      System.out.println("Download do arquivo " + produtoVirtual.getNome() + " realizado com sucesso.");
    } {
      throw new IOException("Erro ao realizar download do arquivo.");
    }
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
