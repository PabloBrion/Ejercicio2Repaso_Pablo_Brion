package modelo;

//una clase abstracta es aquella de la que no se instancian objetos
public class Hospederia extends MedioDeAlojamiento{
    //capacidad	esFumador
    protected int capacidad; //verde
    protected boolean esFumador;

    public Hospederia(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int capacidad, boolean esFumador) {
        super(datosCliente, tipoTemporada, valorBaseNoche, cantidadNoches);
        this.capacidad = capacidad;
        this.esFumador = esFumador;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isEsFumador() {
        return esFumador;
    }

    public void setEsFumador(boolean esFumador) {
        this.esFumador = esFumador;
    }

}

