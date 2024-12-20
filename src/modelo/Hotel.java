package modelo;

public class Hotel extends Hospederia {
    private boolean conDesayuno;

    public Hotel(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int capacidad, boolean esFumador, boolean conDesayuno) {
        super(datosCliente, tipoTemporada, valorBaseNoche, cantidadNoches, capacidad, esFumador);
        this.conDesayuno = conDesayuno;
    }

    public boolean isConDesayuno() {
        return conDesayuno;
    }

    public void setConDesayuno(boolean conDesayuno) {
        this.conDesayuno = conDesayuno;
    }

// adicional: devolverá el valor adicional, que corresponde al 30% del subtotal si es Fumador y con desayuno.
    public int adicional(){
        int adicional=0;
        if (conDesayuno == true && esFumador==true) {
            //subtotal()
            adicional= subtotal() * 30/100;
        }
        return adicional;
    }
//valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el adicional, donde corresponda.
    @Override
    public int valorACancelar() {
        return subtotal() - bonoDescuento()+adicional(); //solo para hotel
    }
}
