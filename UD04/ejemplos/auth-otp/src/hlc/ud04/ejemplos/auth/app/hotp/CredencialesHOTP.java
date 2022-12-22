package hlc.ud04.ejemplos.auth.app.hotp;

import hlc.ud04.ejemplos.auth.app.Credenciales;
import hlc.ud04.ejemplos.auth.app.Usuario;

/**
 * Credenciales para el mecanismo HOTP
 * @author mmontoro
 *
 */
public class CredencialesHOTP implements Credenciales {

  // Cantidad de digitos que forman la 
  private int digitosClave;
  // Contador de clave generada
  private long contador;
  // Secreto compartido con el usuario
  private String secreto;
  
  /**
   * Constructor
   * @param digitosClave Numeros de digitos que tendrá la clave
   * @param contadorInicial Valor inicial del contador
   * @param secreto Secreto compartido con el usuario
   */
  public CredencialesHOTP(int digitosClave, long contadorInicial, String secreto) {
    this.digitosClave = digitosClave;
    this.contador = contadorInicial;
    this.secreto = secreto;
  }

  public long getContador() {
    return contador;
  }

  public void setContador(long contador) {
    this.contador = contador;
  }

  public int getDigitosClave() {
    return digitosClave;
  }

  public String getSecreto() {
    return secreto;
  }
  
}
