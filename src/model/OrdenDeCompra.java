package model;
import java.util.ArrayList;
import java.util.List;

// Clase OrdenDeCompra (Para solucionar la gestión manual de reservas)
public class OrdenDeCompra {
    private String idOrden;
    private Cliente cliente;
    private List<Producto> productos;

    public OrdenDeCompra(String idOrden, Cliente cliente) {
        this.idOrden = idOrden;
        this.cliente = cliente;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) { this.productos.add(p); }

    @Override
    public String toString() {
        return "Orden N°" + idOrden + " | Cliente: " + cliente.getNombre() + " | Ítems: " + productos.size();
    }
}