import ejercicioStock.Combo;
import ejercicioStock.Descuento;
import ejercicioStock.Packaging;
import ejercicioStock.Producto;
import ejercicioStock.ProductoSimple;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE MÉTODOS ===");

        // 1) ProductoSimple: getNombre, getPrecio, getStock
        ProductoSimple casco = new ProductoSimple("Casco", 50000, 10);
        ProductoSimple guantes = new ProductoSimple("Guantes", 15000, 20);
        ProductoSimple chaleco = new ProductoSimple("Chaleco", 20000, 15);

        System.out.println("\nProducto simple:");
        System.out.println("Nombre: " + casco.getNombre());
        System.out.println("Precio: " + casco.getPrecio());
        System.out.println("Stock: " + casco.getStock());

        // 2) Combo vacío: getStock (caso sin productos)
        Combo comboVacio = new Combo("Combo Vacío");
        System.out.println("\nCombo vacío:");
        System.out.println("Nombre: " + comboVacio.getNombre());
        System.out.println("Precio: " + comboVacio.getPrecio());
        System.out.println("Stock: " + comboVacio.getStock());

        // 3) Combo con productos: agregarProducto, getNombre, getPrecio, getStock
        Combo comboProteccion = new Combo("Combo Protección");
        comboProteccion.agregarProducto(casco);
        comboProteccion.agregarProducto(guantes);
        comboProteccion.agregarProducto(chaleco);

        System.out.println("\nCombo con productos:");
        System.out.println("Nombre: " + comboProteccion.getNombre());
        System.out.println("Precio: " + comboProteccion.getPrecio());
        System.out.println("Stock (mínimo): " + comboProteccion.getStock());

        // 4) Decorator Descuento: getProductoDecorado, getNombre/getStock heredados, getPrecio sobrescrito
        Descuento comboConDescuento = new Descuento(comboProteccion, 5000);
        System.out.println("\nDescuento aplicado:");
        System.out.println("Decorado: " + comboConDescuento.getProductoDecorado().getNombre());
        System.out.println("Nombre: " + comboConDescuento.getNombre());
        System.out.println("Precio con descuento: " + comboConDescuento.getPrecio());
        System.out.println("Stock: " + comboConDescuento.getStock());

        // 5) Decorator Packaging: getTipoPackaging, getProductoDecorado, getPrecio
        Packaging comboConPackaging = new Packaging(comboConDescuento, "Caja premium", 2500);
        System.out.println("\nPackaging aplicado:");
        System.out.println("Tipo packaging: " + comboConPackaging.getTipoPackaging());
        System.out.println("Decorado: " + comboConPackaging.getProductoDecorado().getNombre());
        System.out.println("Nombre final: " + comboConPackaging.getNombre());
        System.out.println("Precio final: " + comboConPackaging.getPrecio());
        System.out.println("Stock final: " + comboConPackaging.getStock());

        // 6) Uso polimórfico por interfaz Producto
        Producto productoFinal = comboConPackaging;
        System.out.println("\nProducto (interfaz):");
        System.out.println("Nombre: " + productoFinal.getNombre());
        System.out.println("Precio: " + productoFinal.getPrecio());
        System.out.println("Stock: " + productoFinal.getStock());
    }
}