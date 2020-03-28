package com.macowins;

public class Main {

    public static void main(String[] args) {

        Prenda camisaFloreada = new Prenda(150,400, 0, estado.NUEVO, tipoPrenda.CAMISA);
        Prenda camisaNegra = new Prenda(190,600, 100, estado.PROMOCION, tipoPrenda.CAMISA);
        Prenda pantalonAzul = new Prenda(420,900, 0, estado.LIQUIDACION, tipoPrenda.PANTALON);
        Prenda sacoVerde = new Prenda(500,1200, 0, estado.NUEVO, tipoPrenda.SACO);

        Venta primeraVenta = new Venta(0.3, false, 2);
        Venta segundaVenta = new Venta(0, true, 1);
        Venta terceraVenta = new Venta(0, false, 1);

        primeraVenta.agregarPrenda(camisaFloreada);
        primeraVenta.agregarPrenda(camisaFloreada);
        primeraVenta.agregarPrenda(camisaFloreada);

        segundaVenta.agregarPrenda(sacoVerde);
        segundaVenta.agregarPrenda(pantalonAzul);
        segundaVenta.agregarPrenda(camisaNegra);

        terceraVenta.agregarPrenda(sacoVerde);


        Dia ventasLunes = new Dia();

        ventasLunes.agregarVenta(primeraVenta);
        ventasLunes.agregarVenta(segundaVenta);
        ventasLunes.agregarVenta(terceraVenta);

        //Saber el precio de venta de una prenda y sus tipos
        //El precio de la prenda se modifica según el estado

        System.out.println("Precio del producto: " + camisaFloreada.calcularPrecio() + " tipo de producto: " + camisaFloreada.getTipo());
        System.out.println("Precio del producto: " + camisaNegra.calcularPrecio() + " tipo de producto: " + camisaNegra.getTipo());
        System.out.println("Precio del producto: " + pantalonAzul.calcularPrecio() + " tipo de producto: " + pantalonAzul.getTipo());

        //Se necesita saber las ganancias de un día

        System.out.println("Ganancias del lunes: " + ventasLunes.gananciasDelDia());

        //Se aplica un recargo según la cantidad de cuotas

        System.out.println("Valor de la venta con recargo: " + primeraVenta.totalVenta());
        System.out.println("Valor de la venta con recargo: " + segundaVenta.totalVenta());
        System.out.println("Valor de la venta con recargo: " + terceraVenta.totalVenta());


    }
}
