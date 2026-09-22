package ejercicioStock;

import java.util.ArrayList;
import java.util.List;

public class Combo implements Producto {

    private String nombre;
    private ArrayList<Producto> productos = new ArrayList<>();

    public Combo(String nombre) {
        this.nombre = nombre;
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public double getPrecio() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    @Override
    public int getStock() {
        if (productos.isEmpty()) {
            return 0;
        }
        int stockDisponible = productos.get(0).getStock();
        for (int i = 1; i < productos.size(); i++) {
            int stockProducto = productos.get(i).getStock();
            if (stockProducto < stockDisponible) {
                stockDisponible = stockProducto;
            }
        }
        return stockDisponible;
    }
}
