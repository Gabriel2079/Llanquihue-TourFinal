package model;

public class Cliente extends Persona {

    public Cliente(String rut, String nombre, Direccion direccion, String correo) {
        super(rut, nombre, direccion, correo); // Pasa los 4 parámetros a Persona
    }

    @Override
    public String mostrarDatos() {
        return "[CLIENTE] " + super.toString();
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}