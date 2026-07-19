package utils;

// Controla el formato del RUT al registrar
public class RutInvalidoExcepcion extends Exception {
    public RutInvalidoExcepcion(String mensaje) {
        super(mensaje);
    }
}