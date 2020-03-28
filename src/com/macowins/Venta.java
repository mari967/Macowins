package com.macowins;

import java.time.Instant;
import java.util.LinkedList;

public class Venta {

  private double coeficienteRecargo;
  private long fechaVenta;
  private Boolean pagoEfectivo;
  private int cuotas;
  private int cantPantalones = 0;
  private int cantCamisas = 0;
  private int cantSacos = 0;


  private LinkedList<Prenda> prendasVendidas = new LinkedList<>();

    public Venta(double coeficienteRecargo, Boolean pagoEfectivo, int cuotas) {
        this.coeficienteRecargo = coeficienteRecargo;
        this.pagoEfectivo = pagoEfectivo;

        if(pagoEfectivo)
            this.cuotas = 1;
        else this.cuotas = cuotas;

        fechaVenta = Instant.now().getEpochSecond();
    }

    public void agregarPrenda(Prenda prendaVendida) {

        prendasVendidas.add(prendaVendida);
        switch (prendaVendida.getTipo()) {
            case SACO: cantSacos++;
            case CAMISA: cantCamisas++;
            case PANTALON: cantPantalones++;
        }

    }


    public int getCantPantalones() {
        return cantPantalones;
    }

    public int getCantCamisas() {
        return cantCamisas;
    }

    public int getCantSacos() {
        return cantSacos;
    }

    public double recargo() {
     if (cuotas == 1)
         return 0;
     else return (cuotas * coeficienteRecargo) + (totalVentaSinRecargo() * 0.01);

    }

    //******************************************************
    //Acá tengo dos métodos practicamente iguales, no se me ocurre como hacer para que no se repitan
    private double totalVentaSinRecargo() {
        if(prendasVendidas.isEmpty())
            return 0;

        return  prendasVendidas.stream().mapToDouble(prenda -> prenda.calcularPrecio()).sum();
    }

    private double totalCosto() {
        if(prendasVendidas.isEmpty())
            return 0;

        return  prendasVendidas.stream().mapToDouble(prenda -> prenda.getCosto()).sum();
    }

//************************************************************

    public double totalVenta() {
        return totalVentaSinRecargo() + recargo();
    }

    double gananciaVenta() {
        return totalVenta() - totalCosto();
    }

}
