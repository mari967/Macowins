package com.macowins;

import java.util.ArrayList;

public class Dia {

    private ArrayList<Venta> listaVentas = new ArrayList<>();

    public void agregarVenta(Venta unaVenta) {
        listaVentas.add(unaVenta);
    }

    public double gananciasDelDia() {
        if(listaVentas.isEmpty())
            return 0;
        else return listaVentas.stream().mapToDouble(venta -> venta.gananciaVenta()).sum();

    }

}
