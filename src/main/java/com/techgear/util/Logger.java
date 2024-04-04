package com.techgear.util;

public class Logger { 

  public static void log(String nome, int code) {
    System.out.println("Error code: " + code + " - " + nome);
    switch (code) {
      case 1:
        System.out.println("Não encontrado");
        break;
      case 2:
        System.out.println("Erro ao adicionar");
        break; 
      case 3:
        System.out.println("Erro ao remover");
        break;
    }
  }
}
