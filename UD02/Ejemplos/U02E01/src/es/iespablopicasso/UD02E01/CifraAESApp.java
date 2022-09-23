package es.iespablopicasso.UD02E01;

import java.security.Key;
import java.security.spec.KeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public class CifraAESApp {
  // Valor de salt para generar la clave de 256 bits a partir de la contraseña
  // Este valor es necesario y se puede usar uno aleatorio o fijo. En este caso es fijo
  static String SALT = "Sal y Pimienta";
  // Iteraciones para generar la clave
  static int ITERACIONES = 500;
  // Longitud de la clave
  static int LONGITUDCLAVE = 256;

  public static void main(String[] args) throws Throwable{
    
    // El mensaje es el primer argumento o el valor por defecto Hola Caracola
    String mensaje = (args.length > 0) ? args[0] : "Hola Caracola";
    // La password es el segundo argumento o la cadena 123456789
    String password = (args.length > 1) ? args[1] : "123456789";
    
    // Obtenemos una especificación de la clave a partir de la password
    Key clave = generaClaveDesdePassword(password);
    
    String resultado = encripta(clave, mensaje);
    
    // Y lo imprimimos
    System.out.println("El mensaje cifrado es" + resultado);
  }

  private static String encripta(Key clave, String mensaje) throws Throwable {

    // Iniciamos el algoritmo con la clave
    Cipher algoritmo = Cipher.getInstance("AES");
    algoritmo.init(Cipher.ENCRYPT_MODE, clave);
    
    // Ciframos
    byte[] mensajeCifrado = algoritmo.doFinal(mensaje.getBytes());
    
    // El resultado es una secuencia de bytes. Para que tenga un formato legible
    // Lo convertimos a Base 64 que es un formato que codifica secuencias binarias
    // usando caracteres imprimibles.
    return Base64.getEncoder().encodeToString(mensajeCifrado);
  }

  private static Key generaClaveDesdePassword(String password) throws Throwable {
    /* AES necesita una clave de 128, 224 o 256 bits. La contraseña tiene menos
     * Se necesita por lo tanto generar una clave de la longitud deseada a partir
     * de la contraseña. para ello se usa PBKDF2.... que genera el número de bits que
     * le digas haciendo un hash de la password
     */
    // Creamos la factoria
    SecretKeyFactory factory =
       SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
    // Generamos las especificaciones de la clave
    KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT.getBytes(), ITERACIONES, LONGITUDCLAVE);
    // Generamos la clave
    SecretKey tmp = factory.generateSecret(spec);
    // Y la convertimos a formato AES
    SecretKeySpec skey = new SecretKeySpec(tmp.getEncoded(), "AES");
    return skey;
  }
}
