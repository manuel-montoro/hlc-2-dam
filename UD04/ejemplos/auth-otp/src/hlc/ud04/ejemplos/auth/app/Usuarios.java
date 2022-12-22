package hlc.ud04.ejemplos.auth.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Base de datos de usuarios
 * @author mmontoro
 *
 */
public class Usuarios {

  // Usamos un mapa donde la clave es el identificador y el valor el mismo objeto
  private Map<String, Usuario> usuarios;
  
  /**
   * Crea una base vacía
   */
  public Usuarios() {
    usuarios = new HashMap<>();
  }
  
  /**
   * Localiza a un usuario por su identificador
   * @param identificacion Identificador del usuario
   * @return Usuario si se encuentra. null si no se encuentra
   */
  public Usuario buscaPorIdentificacion(String identificacion) {
    return usuarios.get(identificacion);
  }
  
  /**
   * Añade un nuevo usuario a la base. Si el usuario ya existe no se hace nada
   * @param usuario Usuario a añadir
   */
  public void addUsuario(Usuario usuario) {
    if (!usuarios.containsKey(usuario.getIdentificacion())) {
      usuarios.put(usuario.getIdentificacion(), usuario);
    }
  }
  
  /**
   * Elimina a un usuario de la base. Si el usuario no está en la base no hace nada
   * @param usuario Usuario a eliminar
   */
  public void removeUsuario(Usuario usuario) {
    usuarios.remove(usuario.getIdentificacion());
  }
}
