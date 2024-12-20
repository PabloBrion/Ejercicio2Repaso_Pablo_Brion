package modelo;

public class DatosCliente {
    private String rut;
    private String nombre;



    //{Pablo,23376456}

    public DatosCliente(String rut, String nombre) {
        this.rut = rut;
        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
