package model;

import interfaces.Registrable;
import utils.RutInvalidoExcepcion;

public abstract class Persona implements Registrable {
    private String rut;
    private String nombre;
    private Direccion direccion; // Composición
    private String correo;

    public Persona(String rut, String nombre, Direccion direccion, String correo) {
        this.rut = rut;
        this.nombre = nombre;
        this.direccion = direccion;
        this.correo = correo;
    }

    public String getRut() { return rut; }
    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public void setRut(String rut) throws RutInvalidoExcepcion {
        if (rut == null || rut.trim().length() < 8) {
            throw new RutInvalidoExcepcion("El RUT ingresado no es válido. Por favor, verifica el número y el dígito verificador.");
        }
        this.rut = rut;
    }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Direccion getDireccion() { return direccion; }
    public void setDireccion(Direccion direccion) { this.direccion = direccion; }

    @Override
    public String toString() {
        return "RUT: " + rut + " | Nombre: " + nombre + " | Correo: " + correo + " | Dirección: [" + direccion + "]";
    }
}