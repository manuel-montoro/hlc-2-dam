package hlc.ud04.ejemplos.auth.app.hotp;

import java.util.Scanner;
import hlc.ud04.ejemplos.auth.app.Factoria;
import hlc.ud04.ejemplos.auth.app.InterfazCredenciales;
import hlc.ud04.ejemplos.auth.app.Usuario;
import hlc.ud04.ejemplos.auth.app.Usuarios;

/**
 * Interfaz de usuario para obtener las credenciales HOTP
 * @author mmontoro
 *
 */
public class InterfazCredencialesHOTP implements InterfazCredenciales {

  @Override
  public void procesaCredenciales(String identidad, Usuarios usuarios, Factoria factoria) {
    // Localizamos el usuario en la base
    Usuario usuario = usuarios.buscaPorIdentificacion(identidad);
    // Si se encontro
    if (usuario != null) {
      // Creamos el autenticador
      CredencialesHOTP credenciales = (CredencialesHOTP)usuario.getCredenciales();
      AutenticadorHOTP autenticador = new AutenticadorHOTP(credenciales);
      // Solicita el OTP
      System.out.print("Introduzca el código OTP de "+ credenciales.getDigitosClave() + " dígitos (" + credenciales.getContador() + "): ");
      Scanner sc = new Scanner(System.in);
      String otp = sc.nextLine();
      if (autenticador.autentifica(otp)) {
        // Usuario autentificado
        System.out.println("Usuario autentificado!!!!");
      } else {
        System.err.println("Autenticación incorrecta");
      }
    } else {
      System.err.println("Usuario no existente");
    }
  }

}
