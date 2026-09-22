package ejercicioStock;

public abstract class Aplicable implements Producto {

    private Producto productoDecorado;

    public Aplicable(Producto productoDecorado) {
        this.productoDecorado = productoDecorado;
    }

    public Producto getProductoDecorado() {
        return productoDecorado;
    }

    @Override
    public String getNombre() {
        return getProductoDecorado().getNombre();
    }

    @Override
    public int getStock() {
        return getProductoDecorado().getStock();
    }
}
