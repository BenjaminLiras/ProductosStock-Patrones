package ejercicioStock;

public class ProductoSimple implements Producto {

    private final String nombre;
    private final double precioBase;
    private final int stock;

    public ProductoSimple(String nombre, double precioBase, int stock) {
        this.nombre = nombre;
        this.precioBase = precioBase;
        this.stock = stock;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public int getStock() {
        return stock;
    }
}
