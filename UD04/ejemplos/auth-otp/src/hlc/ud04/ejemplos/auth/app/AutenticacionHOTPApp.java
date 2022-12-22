package hlc.ud04.ejemplos.auth.app;

import hlc.ud04.ejemplos.auth.app.hotp.FactoriaHOTP;
import hlc.ud04.ejemplos.auth.app.hotp.InterfazCredencialesHOTP;

/**
 * Aplicacion que simula autenticacion mediante HOTP (OTP basado en contador)
 * @author mmontoro
 *
 */
public class AutenticacionHOTPApp {
  
  public static void main(String[] args) {
    // Crea la factoria y el interfaz de credenciales
    Factoria factoria = new FactoriaHOTP();
    InterfazCredenciales interfaz = new InterfazCredencialesHOTP();
    // Lanza la aplicacion con estos 
    AplicacionAutenticacion aplicacion = new AplicacionAutenticacion(factoria, interfaz);
    aplicacion.run();
  }
}
