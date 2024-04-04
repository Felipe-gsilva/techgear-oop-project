package com.techgear;

import java.io.*;
import com.techgear.util.FileHandler;

public class DisplayLoja {
  private final Loja loja = new Loja();

  public DisplayLoja () {
    telaUsuario();
    FileHandler().loadFiles(loja);
  }

  public void telaUsuario() {
    try {

    } catch (FileNotFoundException e) {
      System.out.println("Arquivo não encontrado." + e.getMessage());
    }
  }

  private void buscarProduto() {
    System.out.println("Digite o nome do produto que deseja buscar: ");
    String nomeProduto = System.console().readLine();
    Produto produto = loja.buscarProduto(nomeProduto);
    if (produto != null) {
      System.out.println(produto.getNome());
    } else {
      System.out.println("Produto não encontrado.");
    }
  }

}
