package com.techgear;

import java.io.*;
import com.techgear.util.FileHandler;

/**
 * Classe que representa um produto virtual e estende Produto.
 * @version 1.0
 * @author Felipe Gomes da Silva
 * @since 2024-04-08
 * @see Categoria
 * @see Produto
 * @see ProdutoFisico
 */

public class ProdutoVirtual extends Produto {
  /**
   * Tamanho do arquivo.
   */
  private double tamanhoArquivo;
  /**
   * Formato do arquivo.
   */
  private String formato;

  /**
   * Construtor da classe ProdutoVirtual.
   * @param id Identificador do produto.
   * @param nome Nome do produto.
   * @param preco Preco do produto.
   * @param descricao Descricao do produto.
   * @param marca Marca do produto.
   * @param categoria Categoria do produto.
   * @param tamanhoArquivo Tamanho do arquivo.
   * @param formato Formato do arquivo.
   */
  public ProdutoVirtual(int id, String nome, double preco, String descricao, String marca, Categoria categoria, double tamanhoArquivo, String formato) {  
    super(id, nome, preco, descricao, marca, categoria);
    this.tamanhoArquivo = tamanhoArquivo;
    this.formato = formato;
  }
  
  /**
   * Realiza o download de um arquivo.
   * @param produtoVirtual ProdutoVirtual a ser baixado.
   * @throws IOException Excecao de erro de IO.
   **/
  public void realizarDownload(ProdutoVirtual produtoVirtual) throws IOException {
    File arquivo = new File(produtoVirtual.getNome() + "." + produtoVirtual.getFormato());
    System.out.println("Realizando download do arquivo " + produtoVirtual.getNome() + "...");
    String string = "Arquivo: " + produtoVirtual.getNome() + "\n" + "Tamanho: " + produtoVirtual.getTamanhoArquivo() + "GB\n";
    FileHandler.writeToFile(arquivo, string);
    if(arquivo.exists()){
      System.out.println("Download do arquivo " + produtoVirtual.getNome() + " realizado com sucesso.");
    } 
    else {
      throw new IOException("Erro ao realizar download do arquivo.");
    }
  }


  /**
   * Atualiza o tamanho do arquivo.
   * @param tamanhoArquivo Tamanho do arquivo.
   */
  public void setTamanhoArquivo(double tamanhoArquivo) {
    this.tamanhoArquivo = tamanhoArquivo;
  }
  /**
   * Atualiza o formato do arquivo.
   * @param formato Formato do arquivo.
   */
  public void setFormato(String formato) {
    this.formato = formato;
  }
  /**
   * Retorna o tamanho do arquivo.
   * @return Tamanho do arquivo.
   */
  public double getTamanhoArquivo() {
    return tamanhoArquivo;
  }
  /**
   * Retorna o formato do arquivo.
   * @return Formato do arquivo.
   */
  public String getFormato() {
    return formato;
  }
}

