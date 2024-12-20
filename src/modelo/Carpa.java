package modelo;

//• Carpa tiene valorBaseNoche, cantidad de noches, DatosCliente y tipoTemporada (alta, media o baja) y cantidadPersonas.
public class Carpa extends MedioDeAlojamiento{

    private int cantidadPersonas; //3

    public Carpa(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int cantidadPersonas) {
        super(datosCliente, tipoTemporada, valorBaseNoche, cantidadNoches);
        this.cantidadPersonas = cantidadPersonas;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {
        this.cantidadPersonas = cantidadPersonas;
    }

}
