package hlc.ud04.ejemplos.auth.app;

/**
 * Algoritmo de autentificacion
 * @author mmontoro
 *
 */
public interface Autenticador {
  
  /**
   * Obtiene información adicional (opcional) para desafiar al usuario
   * @return Desafío. Puede ser null si no hay información adicional
   */
  String desafio();
  
  /**
   * Verifica la respuesta al desafío
   * @param respuesta Respuesta del usuario al desafío
   * @return true si el usuario ha superado la autentificación con exito. false en caso contrario
   */
  boolean autentifica(String respuesta);

}
