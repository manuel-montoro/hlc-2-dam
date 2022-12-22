package hlc.ud04.ejemplos.auth.app;

/**
 * Usuario del sistema
 * @author mmontoro
 *
 */
public class Usuario {
  
  // Identificador textual del usuario 
  private String identificacion;
  // Datos secretos usados para autenticar al usuario
  private Credenciales credenciales;
  
  /**
   * Crea al usuario con identificacion y credenciales
   * @param identificacion Identificador del usuario
   * @param credenciales Credenciales del usuario
   */
  public Usuario(String identificacion, Credenciales credenciales) {
    this.identificacion = identificacion;
    this.credenciales = credenciales;
  }
  
  /**
   * Obtiene la identificacion del usuario
   * @return
   */
  public String getIdentificacion() {
    return this.identificacion;
  }
  
  /**
   * Obtiene las credenciales del usuario
   * @return
   */
  public Credenciales getCredenciales() {
    return this.credenciales;
  }

}
