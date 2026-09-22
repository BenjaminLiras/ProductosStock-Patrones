import ejercicioStock.Combo;
import ejercicioStock.Descuento;
import ejercicioStock.Packaging;
import ejercicioStock.Producto;
import ejercicioStock.ProductoSimple;

public class Main {
    public static void main(String[] args) {
        // Productos simples de un local de motos
        ProductoSimple casco = new ProductoSimple("Casco", 50000, 10);
        ProductoSimple guantes = new ProductoSimple("Guantes", 15000, 20);
        ProductoSimple chaleco = new ProductoSimple("Chaleco", 20000, 15);

        // Combo simple: guantes + casco + chaleco
        Combo comboProteccion = new Combo("Combo Protección");
        comboProteccion.agregarProducto(casco);
        comboProteccion.agregarProducto(guantes);
        comboProteccion.agregarProducto(chaleco);

        System.out.println(comboProteccion.getNombre() + " - precio: " + comboProteccion.getPrecio()
                + " - stock: " + comboProteccion.getStock());

        // Combo de combos: se arma con otro combo + un producto simple
        ProductoSimple piloto = new ProductoSimple("Piloto (traje)", 80000, 8);
        Combo comboCompleto = new Combo("Combo Completo");
        comboCompleto.agregarProducto(comboProteccion);
        comboCompleto.agregarProducto(piloto);

        System.out.println(comboCompleto.getNombre() + " - precio: " + comboCompleto.getPrecio()
                + " - stock: " + comboCompleto.getStock());

        // Decorators: descuentos acumulables (se apilan) + packaging
        Producto comboConDescuentos = new Descuento(
                new Descuento(comboCompleto, 5000),
                3000);
        Producto comboFinal = new Packaging(comboConDescuentos, "Caja premium", 2500);

        System.out.println(comboFinal.getNombre() + " - precio final: " + comboFinal.getPrecio()
                + " - stock: " + comboFinal.getStock());
    }
}