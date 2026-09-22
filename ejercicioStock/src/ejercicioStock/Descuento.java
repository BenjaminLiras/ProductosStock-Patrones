package ejercicioStock;

public class Descuento extends Aplicable {

    private final double montoDescuento;

    public Descuento(Producto productoDecorado, double montoDescuento) {
        super(productoDecorado);
        this.montoDescuento = montoDescuento;
    }

    @Override
    public double getPrecio() {
        return getProductoDecorado().getPrecio() - montoDescuento;
    }
}
