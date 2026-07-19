package model;

// Clase Producto (Para representar los Tours o Excursiones)
public class Producto {
    private String id;
    private String nombre;
    private double precio;

    public Producto(String id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters, Setters y toString()
    @Override
    public String toString() {
        return "Producto: " + nombre + " ($" + precio + ")";
    }
}