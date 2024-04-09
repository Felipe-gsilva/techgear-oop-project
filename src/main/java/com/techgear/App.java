package com.techgear;

/** 
 * Classe principal que inicia a aplicação.
 * 
 * @version 1.0
 * @author Felipe Gomes da Silva
 * @since 2024-04-08
 * @see DisplayLoja
 */
public class App {
  /**
   * Construtor da classe App.
   */
  public App() {
  }
  /**
   * Método principal que inicia a aplicação.
   * 
   * @param args Argumentos passados por linha de comando.
   * @see DisplayLoja
   */
  public static void main( String[] args ) {

    /**
    * instancia unica de displayLoja 
    */
    DisplayLoja displayLoja = new DisplayLoja();
    displayLoja.telaUsuario();
  }
}
