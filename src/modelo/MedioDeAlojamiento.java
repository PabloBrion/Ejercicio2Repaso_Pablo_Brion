package modelo;

// ojo que esta era abstract
public abstract class MedioDeAlojamiento {
    //atributos
    // valorBaseNoche, cantidad de noches, DatosCliente y tipoTemporada
    protected DatosCliente datosCliente; //{Pablo,23376456}
    protected String tipoTemporada; // (alta, media o baja)  Media
    protected int valorBaseNoche; //  1000
    protected int cantidadNoches;  // 3

    public MedioDeAlojamiento(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches) {
        this.datosCliente = datosCliente;
        this.tipoTemporada = tipoTemporada;
        this.valorBaseNoche = valorBaseNoche;
        this.cantidadNoches = cantidadNoches;
    }

    public DatosCliente getDatosCliente() {
        return datosCliente;
    }

    public void setDatosCliente(DatosCliente datosCliente) {
        this.datosCliente = datosCliente;
    }

    public String getTipoTemporada() {
        return tipoTemporada;
    }

    public void setTipoTemporada(String tipoTemporada) {
        this.tipoTemporada = tipoTemporada;
    }

    public int getValorBaseNoche() {
        return valorBaseNoche;
    }

    public void setValorBaseNoche(int valorBaseNoche) {
        this.valorBaseNoche = valorBaseNoche;
    }

    public int getCantidadNoches() {
        return cantidadNoches;
    }

    public void setCantidadNoches(int cantidadNoches) {
        this.cantidadNoches = cantidadNoches;
    }




//• valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el adicional, donde corresponda.
//• incrementaValorBase: aumenta el valor base en un 18% si la capacidad de la cabaña es superior a 5.

    //• subtotal: devolverá el subtotal a cancelar el cual será cantidad de noches por el valorBaseNoche
    public int subtotal(){
        return this.valorBaseNoche* this.cantidadNoches;
    }

    // bonoDescuento: devolverá el valor a descontar sabiendo que es un 25% del subTotal si el tipo de temporada es baja o es de un 12.5% si el tipo Temporada es media.
    public int bonoDescuento(){
        int bonoDescuento=0;
        if (tipoTemporada.compareToIgnoreCase("Baja")==0) {
            bonoDescuento= this.subtotal() / 4;
        }
        if (tipoTemporada.compareToIgnoreCase("Media")==0)  {
            bonoDescuento= this.subtotal() / 8;
        }
        return bonoDescuento;
    }

    //• valorACancelar: devolverá el valor a cancelar, el cual al subtotal se le debe descontar el bono y sumar el adicional, donde corresponda.
    public int valorACancelar(){
        return subtotal() - bonoDescuento();
    }

}

