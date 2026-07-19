package model;

public class Guia extends Persona {
    private String especialidad; // Ej: "Trekking", "Gastronomía"

    public Guia(String rut, String nombre, Direccion direccion, String correo, String especialidad) {
        super(rut, nombre, direccion, correo);
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }
    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }

    @Override
    public String mostrarDatos() {
        return "[GUÍA] " + super.toString() + " | Especialidad: " + especialidad;
    }

    @Override
    public String toString() {
        return mostrarDatos();
    }
}