package ejercicioStock;

public class Packaging extends Aplicable {

    private String tipoPackaging;
    private double precioPackaging;

    public Packaging(Producto productoDecorado, String tipoPackaging, double precioPackaging) {
        super(productoDecorado);
        this.tipoPackaging = tipoPackaging;
        this.precioPackaging = precioPackaging;
    }

    public String getTipoPackaging() {
        return tipoPackaging;
    }

    @Override
    public double getPrecio() {
        return getProductoDecorado().getPrecio() + precioPackaging;
    }
}
