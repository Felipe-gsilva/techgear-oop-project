package com.techgear.util;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;
import com.techgear.Categoria;
import com.techgear.ProdutoFisico;
import com.techgear.ProdutoVirtual;
import com.techgear.Loja;

public class FileHandler {
  private File categorias = new File("/home/felipe-gsilva/.dev/oop-project/bd/categorias.txt");
  private File produtosFisicos = new File("/home/felipe-gsilva/.dev/oop-project/bd/produtoFisico.txt");
  private File produtosVirtuais = new File("/home/felipe-gsilva/.dev/oop-project/bd/produtoVirtual.txt");

  public FileHandler() {
  }
  
  public static void loadFiles(Loja loja) throws FileNotFoundException {
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
