package hlc.ud04.ejemplos.auth.user;

import hlc.ud04.ejemplos.auth.otp.GeneradorHOTP;

/**
 * Aplicación que puede usar un usuario para calcular su clave HOTP
 * Se podría hacer más amigable si fuera almacenando automáticamente el contador
 * @author mmontoro
 *
 */
public class CalculadoraHOTP {

  private static final String DEFAULT_SECRETO = "0FF4103BBB01B6CD";
  private static final long DEFAULT_CONTADOR = 0;
  private static final int DEFAULT_DIGITOS = 6;
  
  public static void main(String[] args) {
    /**
     * Se pueden pasar por línea de comandos tanto el secreto (número de 16 dígitos hexadecimales)
     * el contador a usar (por defecto cero)
     * y el número de dígitos a generar (Por defecto 6)
     * 
     */
    String secreto = (args.length > 0) ? args[0] : DEFAULT_SECRETO;
    long contador = DEFAULT_CONTADOR;
    int digitos = DEFAULT_DIGITOS;
    try {
      contador = (args.length > 1) ? Long.parseLong(args[1]) : DEFAULT_CONTADOR;
    } catch (Exception e) {}
    try {
      digitos = (args.length > 2) ? Integer.parseInt(args[2]) : DEFAULT_DIGITOS;
    } catch (Exception e) {}
    
    GeneradorHOTP generador = new GeneradorHOTP(digitos);
    System.out.println("La clave generada es: " + generador.genera(secreto, contador));
  }
}
