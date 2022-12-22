package hlc.ud04.ejemplos.auth.app;

/**
 * Factoria para crear objetos dependientes del mecanismo de autenticación
 * Hay que crear una implementación por cada mecanismo
 * @author mmontoro
 *
 */
public interface Factoria {
  
  Usuarios getUsuarios();
  
  Autenticador getAutenticador(Usuario usuario);

}
