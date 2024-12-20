package modelo;

public class Cabagna extends Hospederia {
    private boolean chimenea;

    public Cabagna(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int capacidad, boolean esFumador, boolean chimenea) {
        super(datosCliente, tipoTemporada, valorBaseNoche, cantidadNoches, capacidad, esFumador);
        this.chimenea = chimenea;
    }

    public boolean isChimenea() {
        return chimenea;
    }

    public void setChimenea(boolean chimenea) {
        this.chimenea = chimenea;
    }

    // incrementaValorBase: aumenta el valor base en un 18% si la capacidad de la cabaña es superior a 5.
    public int incrementaValorBase(){
        int incremento=0;
        if (capacidad > 5) {
            incremento= getValorBaseNoche() * 18 /100;
            setValorBaseNoche(getValorBaseNoche() + incremento);

        }
        return valorBaseNoche;
    }



}

