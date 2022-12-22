package hlc.ud04.ejemplos.auth.app;

/**
 * Interfaz de usuario para obtener y validar las credenciales del usuario
 * @author mmontoro
 *
 */
public interface InterfazCredenciales {
  
  /**
   * Obtiene del usuario (por consola, por ejemplo) las credenciales y las utiliza para autenticar al usuario
   * También muestra el resultado de la autenticación por pantalla
   * @param identidad Identificador del usuario
   * @param usuarios Base de usuarios
   * @param factoria Factoria para crear objetos dependientes del mecanismo de autenticacion
   */
  void procesaCredenciales(String identidad, Usuarios usuarios, Factoria factoria);

}
