package hlc.ud04.ejemplos.auth.app.hotp;

import hlc.ud04.ejemplos.auth.app.Autenticador;
import hlc.ud04.ejemplos.auth.app.Factoria;
import hlc.ud04.ejemplos.auth.app.Usuario;
import hlc.ud04.ejemplos.auth.app.Usuarios;

/**
 * Factoria de objetos para el metodo HOTP (Datos de usuario de prueba)
 * @author mmontoro
 *
 */
public class FactoriaHOTP implements Factoria {

  @Override
  public Usuarios getUsuarios() {
    Usuarios usuarios = new Usuarios();
    usuarios.addUsuario(new Usuario("usuario1", new CredencialesHOTP(6, 0, "DD4A187A16FF0099")));
    usuarios.addUsuario(new Usuario("usuario2", new CredencialesHOTP(6, 0, "7BF7E69AF9574274")));
    return usuarios;
  }

  @Override
  public Autenticador getAutenticador(Usuario usuario) {
    return new AutenticadorHOTP((CredencialesHOTP)usuario.getCredenciales());
  }

}
