package hlc.ud04.ejemplos.auth.app;

import java.util.Scanner;

/**
 * Aplicacion de autenticación
 * @author mmontoro
 *
 */
public class AplicacionAutenticacion {

  private Factoria factoria;
  private InterfazCredenciales interfaz;
  
  /**
   * Inicializa la aplicación
   * @param factoria Factoria a usar para crear los objetos que dependen del metodo de autenticacion
   * @param interfaz Interfaz a usar para obtener del usuario la información necesaria para la autenticacion
   */
  public AplicacionAutenticacion(Factoria factoria, InterfazCredenciales interfaz) {
    this.factoria = factoria;
    this.interfaz = interfaz;
  }
  
  /**
   * Punto de entrada de la aplicacion
   */
  public void run() {
    // Mostramos portada
    System.out.println("APLICACIÓN DE SIMULACIÓN DE AUTENTICACION");
    System.out.println("-----------------------------------------");
    System.out.println();
    // Obtenemos los usuarios. Es necesario hacerlo desde la factoria porque las credenciales dependen del
    // metodo de autenticacion
    Usuarios usuarios = factoria.getUsuarios();
    Scanner sc = new Scanner(System.in);
    String identidad;
    // Ciclo que lee identificadores hasta que se introduce uno vacio
    do {
      System.out.print("Introduzca la identidad del usuario a autenticar (vacío para salir): ");
      identidad = sc.nextLine();
      if ((identidad != null) && (identidad.length() > 0)) {
        // Usa interfaz para pedir las credenciales del usuario
        interfaz.procesaCredenciales(identidad, usuarios, factoria);
      }
    } while ((identidad != null) && (identidad.length() > 0));
    sc.close();
  }
}
