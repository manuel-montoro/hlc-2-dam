package hlc.ud04.ejemplos.auth.app.hotp;

import hlc.ud04.ejemplos.auth.app.Autenticador;
import hlc.ud04.ejemplos.auth.otp.GeneradorHOTP;

/**
 * Implementación HOTP de autenticador
 * @author mmontoro
 *
 */
public class AutenticadorHOTP implements Autenticador {

  // Creenciales para metodo HOTP
  private CredencialesHOTP credenciales;
  
  /**
   * Crea el autenticador
   * @param credenciales Credenciales HOTP del usuario
   */
  public AutenticadorHOTP(CredencialesHOTP credenciales) {
    this.credenciales = credenciales;
  }

  @Override
  public String desafio() {
    return null;
  }

  @Override
  public boolean autentifica(String respuesta) {
    // Inicializa el generador con el número de dígitos almacenado en el usuario
    GeneradorHOTP generador = new GeneradorHOTP(credenciales.getDigitosClave());
    // Obtiene el valor actual del contador
    long contador = credenciales.getContador();
    // Si la clave proporcionada coincide con la generada
    if (generador.genera(credenciales.getSecreto(), contador).equalsIgnoreCase(respuesta)) {
      // Actualiza el contador
      credenciales.setContador(contador + 1);
      // Y devolvemos exito
      return true;
    } else {
      // Usuario no autenticado
      return false;
    }
  }

}
