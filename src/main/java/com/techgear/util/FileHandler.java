package com.techgear.util;

import java.util.Scanner;
import java.io.*;
import com.techgear.*;

public class FileHandler {
  private File categorias = new File("./bd/categorias.txt");
  private File produtosFisicos = new File("./bd/produtoFisico.txt");
  private File produtosVirtuais = new File("./bd/produtoVirtual.txt");

  public void loadFiles(Loja loja) throws FileNotFoundException {
    loadCategorias(getCategorias(), loja);
    loadProdutosFisicos(getProdutosFisicos(), loja);
    loadProdutosVirtuais(getProdutosVirtuais(), loja);
  }
  public void loadCategorias(File categorias, Loja loja) {
    try {
      Scanner scanner = new Scanner(categorias);
      String linha = scanner.nextLine(); 
      String[] dados;
      while(scanner.hasNextLine()) {
        linha = scanner.nextLine();
        dados = linha.split("#");
        Categoria categoria = new Categoria(Integer.valueOf(dados[0]), dados[1], dados[2]);
        loja.adicionarCategoria(categoria);
      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
      e.printStackTrace();
    }
  } 

  public void loadProdutosFisicos(File produtosFisicos, Loja loja) {
    try {
      Scanner scanner = new Scanner(produtosFisicos);
      String linha = scanner.nextLine(); 
      String[] dados;
      while(scanner.hasNextLine()) {
        linha = scanner.nextLine();
        dados = linha.split("#");
        Categoria categoria = loja.buscarCategoria(Integer.valueOf(dados[5]));
        ProdutoFisico produtoFisico = new ProdutoFisico(Integer.valueOf(dados[0]), dados[1], Double.valueOf(dados[2]), dados[3], dados[4], categoria, Double.valueOf(dados[6]), dados[7]);
        loja.adicionarProduto(categoria, produtoFisico);

      }
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
      e.printStackTrace();
    }
  } 
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
    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
      e.printStackTrace();
    }
  } 

  public static void writeToFile(File file, String data) {
    try {
      java.io.FileWriter out = new java.io.FileWriter(file, true);
      out.write(data);
      out.close();
    } catch (Exception e) {
      Logger.log(e.getMessage() ,7);
    }
  }


  public void setCategoria(File categorias) {
    this.categorias = categorias;
  }
  public void setProdutosFisicos(File produtosFisicos) {
    this.produtosFisicos = produtosFisicos;
  }
  public void setProdutosVirtuais(File produtosVirtuais) {
    this.produtosVirtuais = produtosVirtuais;
  }

  public File getCategorias() {
    return categorias;
  }
  public File getProdutosFisicos() {
    return produtosFisicos;
  }
  public File getProdutosVirtuais() {
    return produtosVirtuais;
  }
}
