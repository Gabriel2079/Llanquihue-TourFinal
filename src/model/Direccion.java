package model;

public class Direccion {
    private String calle;
    private String comuna;

    public Direccion(String calle, String comuna) {
        this.calle = calle;
        this.comuna = comuna;
    }
    public Direccion(String calle) {
        this.calle = calle;
        this.comuna = "Llanquihue "; // (Por defecto)
    }
    public String getCalle() { return calle; }
    public void setCalle(String calle) { this.calle = calle; }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    @Override
    public String toString() {
        return calle + ", " + comuna;
    }
}


