package controlador;

import modelo.*;
import java.util.ArrayList;
import java.util.Objects;

public class EmpresaTurismo {

    // Atributo
    private ArrayList<MedioDeAlojamiento> alquilerViviendas;

    // Constructor
    public EmpresaTurismo(ArrayList<MedioDeAlojamiento> alquilerViviendas) {
        this.alquilerViviendas = alquilerViviendas;
    }

    // Getters y Setters
    public ArrayList<MedioDeAlojamiento> getEmpresaTurismo() {
        return alquilerViviendas;
    }

    public void setEmpresaTurismo(ArrayList<MedioDeAlojamiento> alquilerViviendas) {
        this.alquilerViviendas = alquilerViviendas;
    }

    // Métodos para ingresar alojamientos
    public MedioDeAlojamiento getAlojamiento(int index) {
        return alquilerViviendas.get(index);
    }


    public void ingresarAlojamiento(MedioDeAlojamiento alojamiento) {
        if (buscarVivienda(alojamiento.getDatosCliente().getRut()) == -1) {
            alquilerViviendas.add(alojamiento);
        } else {
            System.out.println("El cliente ya tiene un alojamiento asignado.");
        }
    }

    // Buscar vivienda por RUT
    public int buscarVivienda(String rut) {
        for (int i = 0; i < alquilerViviendas.size(); i++) {
            if (alquilerViviendas.get(i).getDatosCliente().getRut().equalsIgnoreCase(rut)) {
                return i;
            }
        }
        return -1;
    }

    // Mostrar todos los alojamientos
    public String mostrarAlojamientos() {
        if (alquilerViviendas.isEmpty()) {
            return "No hay alojamientos registrados.";
        }
        StringBuilder mensaje = new StringBuilder();
        for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
            mensaje.append(describirAlojamiento(alojamiento)).append("\n");
        }
        return mensaje.toString();
    }

    // Buscar alojamiento por cliente
    public String buscarPorCliente(String rut) {
        for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
            if (alojamiento.getDatosCliente().getRut().equalsIgnoreCase(rut)) {
                return describirAlojamiento(alojamiento);
            }
        }
        return "No hay alojamientos registrados para el RUT " + rut;
    }

    // Calcular total adicional por cliente
    public int calcularTotalAdicional(String rut) {
        int total = 0;
        //buscarPorCliente(rut);
        for (int i = 0; i < alquilerViviendas.size(); i++) {
            if (alquilerViviendas.get(i) instanceof Hotel) {
                Hotel hotel = null;
                hotel = (Hotel) alquilerViviendas.get(i);
                if (Objects.equals(hotel.getDatosCliente().getRut(), rut)) {
                    total += ((Hotel) alquilerViviendas.get(i)).adicional();
                }
            }
        }
        return total;
    }

    // Calcular total bono descuento por cliente
    public int calcularTotalBonoDescuento(String rut) {
        int total = 0;
        for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
            if (alojamiento.getDatosCliente().getRut().equalsIgnoreCase(rut)) {
                total += alojamiento.bonoDescuento();
            }
        }
        return total;
    }

    // Contabilizar cuantos alojamientos existen, por tipo
    public String contabilizarAlojamientos() {
        int cantidadCarpas = 0;
        int cantidadHoteles = 0;
        int cantidadCabagnas = 0;

        // Recorremos la lista de alquileres
        for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
            if (alojamiento instanceof Carpa) {
                cantidadCarpas++;
            } else if (alojamiento instanceof Hotel) {
                cantidadHoteles++;
            } else if (alojamiento instanceof Cabagna) {
                cantidadCabagnas++;
            }
        }
        // Construimos el mensaje con los resultados
        return "Cantidad por tipo de alojamiento:\n" +
                "Carpas: " + cantidadCarpas + "\n" +
                "Hoteles: " + cantidadHoteles + "\n" +
                "Cabañas: " + cantidadCabagnas;
    }



    // Método auxiliar para describir un alojamiento
    private String describirAlojamiento(MedioDeAlojamiento alojamiento) {
        StringBuilder descripcion = new StringBuilder();
        if (alojamiento instanceof Hotel) {
            Hotel hotel = (Hotel) alojamiento;
            descripcion.append("Hotel, RUT: ").append(hotel.getDatosCliente().getRut())
                    .append(", Nombre: ").append(hotel.getDatosCliente().getNombre())
                    .append(", Valor Alojamiento: ").append(hotel.getValorBaseNoche())
                    .append(", Cantidad de noches: ").append(hotel.getCantidadNoches())
                    .append(", Tipo de temporada: ").append(hotel.getTipoTemporada())
                    .append(", Capacidad: ").append(hotel.getCapacidad())
                    .append(", Fumador?: ").append(hotel.isEsFumador())
                    .append(", Desayuno?: ").append(hotel.isConDesayuno());
        } else if (alojamiento instanceof Cabagna) {
            Cabagna cabagna = (Cabagna) alojamiento;
            descripcion.append("Cabaña, RUT: ").append(cabagna.getDatosCliente().getRut())
                    .append(", Nombre: ").append(cabagna.getDatosCliente().getNombre())
                    .append(", Valor Alojamiento: ").append(cabagna.getValorBaseNoche())
                    .append(", Cantidad de noches: ").append(cabagna.getCantidadNoches())
                    .append(", Tipo de temporada: ").append(cabagna.getTipoTemporada())
                    .append(", Capacidad: ").append(cabagna.getCapacidad())
                    .append(", Fumador?: ").append(cabagna.isEsFumador())
                    .append(", Chimenea?: ").append(cabagna.isChimenea());
        } else if (alojamiento instanceof Carpa) {
            Carpa carpa = (Carpa) alojamiento;
            descripcion.append("Carpa, RUT: ").append(carpa.getDatosCliente().getRut())
                    .append(", Nombre: ").append(carpa.getDatosCliente().getNombre())
                    .append(", Valor Alojamiento: ").append(carpa.getValorBaseNoche())
                    .append(", Cantidad de noches: ").append(carpa.getCantidadNoches())
                    .append(", Tipo de temporada: ").append(carpa.getTipoTemporada())
                    .append(", Cantidad de personas: ").append(carpa.getCantidadPersonas());
        }
        return descripcion.toString();
    }
    //e. Incrementar valor base
    public void aplicarIncrementoValorBase() {
        for (MedioDeAlojamiento m : alquilerViviendas) {
            if (m instanceof Cabagna) {
                ((Cabagna) m).incrementaValorBase();
            }
        }
    }

    //7. Valor a cancelar por un cliente X (el cliente debe existir)
    //
    public int valorTotalCliente(String rut) {
        int total = 0;
        boolean clienteEncontrado = false;

        // Verificamos si la lista está vacía
        if (alquilerViviendas.isEmpty()) {
            System.out.println("No hay alojamientos registrados.");
            return total;
        }

        // Recorremos la lista para buscar el cliente por su RUT
        for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
            if (alojamiento.getDatosCliente().getRut().equalsIgnoreCase(rut)) {
                clienteEncontrado = true;

                // Sumamos el bonoDescuento y el costo total del alojamiento
                total += alojamiento.bonoDescuento(); // Si este método devuelve descuentos acumulativos
                total += alojamiento.valorACancelar(); // Método para calcular el costo total del alojamiento
            }
        }

        // Verificamos si el cliente fue encontrado
        if (!clienteEncontrado) {
            System.out.println("No existe un cliente registrado con el rut " + rut);
        }

        return total;
    }


// 8 incrementaValorBase
public void aplicarIncrementoCabanias(int porcentajeIncremento, int capacidadMinima) {
    if (alquilerViviendas.isEmpty()) {
        System.out.println("No hay alojamientos registrados.");
        return;
    }

    for (MedioDeAlojamiento alojamiento : alquilerViviendas) {
        // Verificamos si es una cabaña y si cumple con la capacidad mínima
        if (alojamiento instanceof Cabagna) {
            Cabagna cabania = (Cabagna) alojamiento; // Hacemos el cast
            if (cabania.getCapacidad() > capacidadMinima) {
                // Aplicamos el incremento
                int valorBaseActual = cabania.getValorBaseNoche();
                int incremento = (int) (valorBaseActual * (porcentajeIncremento / 100.0));
                cabania.setValorBaseNoche(valorBaseActual+incremento);
                        //setValorBase(valorBaseActual + incremento);

                System.out.println("Incremento aplicado a la cabaña del cliente: " + cabania.getDatosCliente().getNombre());
            }
        }
    }
}

}  // este es el final
