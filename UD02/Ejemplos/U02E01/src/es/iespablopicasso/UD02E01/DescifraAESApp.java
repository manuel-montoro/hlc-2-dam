package es.iespablopicasso.UD02E01;

public class DescifraAESApp {
  // Valor de salt para generar la clave de 256 bits a partir de la contraseña
  // Este valor es necesario y se puede usar uno aleatorio o fijo. En este caso es fijo
  static String SAL = "Sal y Pimienta";
  // Iteraciones para generar la clave
  static int ITERACIONES = 500;
  // Longitud de la clave
  static int LONGITUDCLAVE = 256;

  public static void main(String[] args) throws Throwable{
    // El mensaje es el primer argumento o el valor por defecto Hola Caracola
    String mensajeCifrado = (args.length > 0) ? args[0] : "0AHF661MRpNDy1p8dKt64A==";
    // La password es el segundo argumento o la cadena 123456789
    String password = (args.length > 1) ? args[1] : "123456789";
    
    // Creamos el algoritmo de desccifrado. Los parametros deben ser los mismos empleados en el cifrado
    AlgoritmoCifrado algoritmo = new AlgoritmoCifradoAES(password, SAL, ITERACIONES, LONGITUDCLAVE);
    
    // Obtenemos el resultado
    String resultado = algoritmo.desencriptaDesdeBase64(mensajeCifrado);
    
    // Y lo imprimimos
    System.out.println("El mensaje descifrado es " + resultado);
  }
}
