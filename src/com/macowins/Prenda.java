package com.macowins;

enum tipoPrenda {SACO, CAMISA, PANTALON};

enum estado {NUEVO, PROMOCION, LIQUIDACION};

class PromocionInvalidaExcepcion extends Exception {

    public PromocionInvalidaExcepcion(String mensaje) {
        super(mensaje);
    }
    public PromocionInvalidaExcepcion() {super();}
}

public class Prenda {

    private int costo;
    private int precio;
    private int promocion;
    private estado estadoPrenda;
    private tipoPrenda tipo;

    public Prenda(int costo, int precio, int promocion, estado estadoPrenda, tipoPrenda tipo) {

        this.costo = costo;
        this.precio = precio;
        this.promocion = promocion;  //Qué hago si la promoción es mayor que el precio?
        this.estadoPrenda = estadoPrenda;
        this.tipo = tipo;

    }

    public tipoPrenda getTipo() {
        return tipo;
    }

    public int getCosto() {
        return costo;
    }


    //javadoc
    public double calcularPrecio() /* throws PromocionInvalidaExcepcion */ {
        switch (estadoPrenda) {
            case NUEVO:
                return precio;
            //  break;
            case PROMOCION:
             //   if (precio < promocion) throw new PromocionInvalidaExcepcion("Descuento inválido");
                return precio - promocion;
            case LIQUIDACION:
                return precio * 0.5;
            default: return -1;
        }
    }
    }

