package com.techgear.util;

/**
 * Classe que implementa um logger para a aplicaçã, com valores padrões de erro baseados em códigos.
 * 1 - Não encontrado
 * 2 - Erro ao adicionar
 * 3 - Erro ao remover
 * 4 - ID ja existe
 * 5 - Erro ao atualziar 
 * 6 - Erro ao buscar 
   * 7 - Erro ao escrever no arquivo
 *
 * @version 1.0
 * @author Felipe Gomes da Silva
 * @since 2024-04-08
 */

public class Logger { 
  /**
   * Construtor vazio da classe Logger.
   */
  public Logger() {
  }

  /**
   * Método que imprime uma mensagem de erro baseada em um código.
   * @param nome Nome do objeto que gerou o erro.
   * @param code Código do erro.
   */
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
      case 4:
        System.out.println("ID ja existe");
        break;
      case 5:
        System.out.println("Erro ao atualizar");
        break;
      case 6:
        System.out.println("Erro ao buscar");
        break;
      case 7:
        System.out.println("Erro ao escrever no arquivo");
        break;
    }
  }
}
