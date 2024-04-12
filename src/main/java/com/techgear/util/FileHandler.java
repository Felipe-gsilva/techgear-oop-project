package com.techgear.util;

import java.util.Scanner;
import java.io.*;
import com.techgear.*;

/**
 * Classe que manipula os arquivos.
 * @version 1.0
 * @since 2024-04-08
 * @see Loja
 * @see Categoria
 * @see ProdutoFisico
 * @see ProdutoVirtual
 * @see Logger
 */
public class FileHandler {
  /**
   * Arquivo que contem as categorias.
   */
  private File categorias = new File("./bd/categorias.txt");
  /**
   * Arquivo que contem os produtos fisicos. 
   */
  private File produtosFisicos = new File("./bd/produtoFisico.txt");
  /**
   * Arquivo que contem os produtos virtuais.
   */
  private File produtosVirtuais = new File("./bd/produtoVirtual.txt");

  /**
   * Construtor vazio da classe FileHandler.
   */
  public FileHandler() {
  }

  /**
   * Carrega os arquivos de categorias, produtos fisicos e produtos virtuais.
   * @param loja Loja a ser carregada.
   * @throws FileNotFoundException Excecao de arquivo nao encontrado.
   */

  public void loadFiles(Loja loja) throws FileNotFoundException {
    loadCategorias(getCategorias(), loja);
    loadProdutosFisicos(getProdutosFisicos(), loja);
    loadProdutosVirtuais(getProdutosVirtuais(), loja);
  }

/**
   * Carrega as categorias de um arquivo.
   * @param categorias Arquivo de categorias.
   * @param loja Loja a ser carregada.
   */

  public void loadCategorias(File categorias, Loja loja) {
    try {
      Scanner sc = new Scanner(categorias);
      String linha = sc.nextLine(); 
      String[] dados;
      while(sc.hasNextLine()) {
        linha = sc.nextLine();
        dados = linha.split("#");
        Categoria categoria = new Categoria(Integer.parseInt(dados[0]), dados[1], dados[2]);
        loja.adicionarCategoria(categoria);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
    }
  } 

  /**
   * Carrega os produtos fisicos de um arquivo.
   * @param produtosFisicos Arquivo de produtos fisicos.
   * @param loja Loja a ser carregada.
   */
  public void loadProdutosFisicos(File produtosFisicos, Loja loja) {
    try {
      Scanner sc = new Scanner(produtosFisicos);
      String linha = sc.nextLine(); 
      String[] dados;
      while(sc.hasNextLine()) {
        linha = sc.nextLine();
        dados = linha.split("#");
        Categoria categoria = loja.buscarCategoria(Integer.parseInt(dados[5]));
        ProdutoFisico produtoFisico = new ProdutoFisico(Integer.parseInt(dados[0]), dados[1], Double.parseDouble(dados[2]), dados[3], dados[4], categoria, Double.parseDouble(dados[6]), dados[7]);
        loja.adicionarProduto(categoria, produtoFisico);

      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
    }
  } 

  /**
   * Carrega os produtos virtuais de um arquivo.
   * @param produtosVirtuais Arquivo de produtos virtuais.
   * @param loja Loja a ser carregada.
   */
  public void loadProdutosVirtuais(File produtosVirtuais, Loja loja) {
    try {
      Scanner scanner = new Scanner(produtosVirtuais);
      String linha = scanner.nextLine(); 
      String[] dados;
      while(scanner.hasNextLine()) {
        linha = scanner.nextLine();
        dados = linha.split("#");
        Categoria categoria = loja.buscarCategoria(Integer.valueOf(dados[5]));
        dados[6] = dados[6].substring(0, dados[6].length() - 2);
        ProdutoVirtual produtoVirtual = new ProdutoVirtual(Integer.valueOf(dados[0]), dados[1], Double.valueOf(dados[2]), dados[3], dados[4], categoria, Double.valueOf(dados[6]), dados[7]);
        loja.adicionarProduto(categoria, produtoVirtual);

      }
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
    }
  } 

  /**
   * Escreve em um arquivo enviado como argumento.
   * @param file Arquivo a ser escrito.
   * @param data Dados a serem escritos.
   */
  public static void writeToFile(File file, String data) {
    try {
      java.io.FileWriter out = new java.io.FileWriter(file, true);
      out.write(data);
      out.close();
    } catch (IOException e) {
      Logger.log(e.getMessage() ,7);
    }
  }


  /**
   * Atualiza o arquivo de categorias.
   * @param categorias Arquivo de categorias.
   */
  public void setCategoria(File categorias) {
    this.categorias = categorias;
  }
  /**
   * Atualiza o arquivo de produtos fisicos.
   * @param produtosFisicos Arquivo de produtos fisicos.
   */
  public void setProdutosFisicos(File produtosFisicos) {
    this.produtosFisicos = produtosFisicos;
  }
  /**
   * Atualiza o arquivo de produtos virtuais.
   * @param produtosVirtuais Arquivo de produtos virtuais.
   */
  public void setProdutosVirtuais(File produtosVirtuais) {
    this.produtosVirtuais = produtosVirtuais;
  }

  /**
   * Retorna o arquivo de categorias.
   * @return Arquivo de categorias.
   */
  public File getCategorias() {
    return categorias;
  }
  /**
   * Retorna o arquivo de produtos fisicos.
   * @return Arquivo de produtos fisicos.
   */
  public File getProdutosFisicos() {
    return produtosFisicos;
  }

  /**
   * Retorna o arquivo de produtos virtuais.
   * @return Arquivo de produtos virtuais.
   */
  public File getProdutosVirtuais() {
    return produtosVirtuais;
  }
}
