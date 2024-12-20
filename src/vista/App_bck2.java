package vista;

import controlador.EmpresaTurismo;
import modelo.Cabagna;
import modelo.Carpa;
import modelo.DatosCliente;
import modelo.Hotel;

import java.util.ArrayList;

public class App_bck2 {

    /*public static void main(String[] args) {
        int opcion;
        String nroRut;

        //tiendaCalzado = alquilerViviendas
        //  TiendaCalzado  = EmpresaTurismo
        // Calzado = MedioDeAlojamiento

        EmpresaTurismo alquilerViviendas = new EmpresaTurismo(new ArrayList<>()); //colección que almacena 0 calzados

        do {
            opcion = menu();
            String xnroRut;
            switch (opcion) {
                case 1:
                    nroRut = pideCodigo(); //codigo
                     if (alquilerViviendas.buscarVivienda(nroRut) == -1) {
                        //no existe, solicito la info del cliente
                        System.out.println("¿Nombre del Cliente?");
                        String xnombre = Leer.dato();

                        int respuesta;
                        do{
                            System.out.println("Favor indicar tipo de temporada: 1)Alta    2)Media    3)Baja");
                            System.out.println("Favor ingrese una opción para continuar (1,2 ó 3)");
                            respuesta = Leer.datoInt(); //2
                        }while(respuesta < 1 || respuesta >3);
                        String xtipoTemporada="Alta";
                        if (respuesta == 2) {
                            xtipoTemporada="Media";
                        }
                        if (respuesta == 3) {
                            xtipoTemporada="Baja";
                        }
                        System.out.println("¿Cantidad de noches?");
                        int xCantidadNoches = Leer.datoInt();
                        System.out.println("¿Valor base x noche?");
                        int xValorBaseNoche = Leer.datoInt();
                        // Carpa, Hotel o Cabaña
                        int respuesta2;
                        do{
                            System.out.println("Favor indicar tipo de alojamiento: 1)Carpa    2)Hotel    3)Cabaña");
                            System.out.println("Favor ingrese una opción para continuar (1,2 ó 3)");
                            respuesta2 = Leer.datoInt(); //2
                        }while(respuesta2 < 1 || respuesta2 >3);
                        int fum=0;
                        int xCapacidad =0;
                        boolean xEsFumador=false;
                        if (respuesta2 != 1) {
                            System.out.println("¿Capacidad del alojamiento?");
                            xCapacidad = Leer.datoInt();
                            do{
                            System.out.println("¿Fumador? 1)Si  2)No");
                            fum = Leer.datoInt();
                            }while(fum < 1 || fum >2);

                            if (fum == 1) {
                                xEsFumador= true;
                            }
                        }
                        switch (respuesta2) {
                            case 1:
                                //Carpa
                                System.out.println("¿Cantidad de personas?");
                                int xCantidadPersonas = Leer.datoInt();
                                //tiendaCalzado.ingresarCalzadoMujer(new Mujer(new Producto(codigoCalzado,stock,valorBase),diaVenta,numero,color,alturaTaco));
                                // System.out.println("Se registra calzado formal de mujer correctamente...");
                                //     public Carpa(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int cantidadPersonas)
                                alquilerViviendas.ingresarCarpa(new Carpa(new DatosCliente(nroRut,xnombre),xtipoTemporada,xValorBaseNoche,xCantidadNoches,xCantidadPersonas ));
                                System.out.println("Se registra ingreso Cliente en Carpa correctamente...");
                                break;
                            case 2:
                                //Hotel
                                int desay =0;
                                do{
                                    System.out.println("¿Con desayuno? 1)Si  2)No");
                                    desay = Leer.datoInt();
                                }while(desay < 1 || desay >2);
                                boolean xConDesayuno= false;
                                if (desay == 1) {
                                    xConDesayuno= true;
                                }
                                //public Hotel(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int capacidad, boolean esFumador, boolean conDesayuno)
                                alquilerViviendas.ingresarHotel(new Hotel(new DatosCliente(nroRut,xnombre),xtipoTemporada,xValorBaseNoche,xCantidadNoches,xCapacidad,xEsFumador,xConDesayuno ));
                                System.out.println("Se registra ingreso Cliente en Hotel correctamente...");
                                break;
                            case 3:
                                //Cabaña
                                int chime =0;
                                boolean xChimenea= false;
                                do{
                                    System.out.println("¿Con chimenea? 1)Si  2)No");
                                    chime = Leer.datoInt();
                                }while(chime < 1 || chime >2);
                                if (chime == 1) {
                                    xChimenea= true;
                                }
                                // public Cabagna(DatosCliente datosCliente, String tipoTemporada, int valorBaseNoche, int cantidadNoches, int capacidad, boolean esFumador, boolean chimenea)
                                alquilerViviendas.ingresarCabagna(new Cabagna(new DatosCliente(nroRut,xnombre),xtipoTemporada,xValorBaseNoche,xCantidadNoches,xCapacidad,xEsFumador,xChimenea ));
                                System.out.println("Se registra ingreso Cliente en Cabaña correctamente...");
                                break;
                        }
                    }
                case 2:
                    //("2.\tMostrar medios de alojamiento");
                    System.out.println("2.\tMostrar medios de alojamiento");
                    System.out.println(alquilerViviendas.mostrarAlojamientos());

                    break;
                case 3:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("3.\tDatos de un cliente X ");

                    xnroRut = pideCodigo(); //codigo
                    System.out.println(alquilerViviendas.buscarPorCliente(xnroRut));
                    break;
                case 4:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("4.\tTotal adicional");
                    xnroRut = pideCodigo(); //codigo
                    System.out.println("El valor adicional para el alojamiento del cliente "+xnroRut+ " es $"+alquilerViviendas.calcularTotalAdicional(xnroRut));

                    break;
                case 5:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("5.\tTotal bono descuento");

                    break;
                case 6:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("6.\tCantidad medios de alojamiento X");

                    break;
                case 7:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("7.\tValor a cancelar por un cliente X ");

                    break;
                case 8:
                    //("3.\tDatos de un cliente X ");
                    System.out.println("8.\tAplicar incremento del valor base");

                    break;

            }

        }while(opcion!=9);
    }

    public static String pideCodigo(){
        System.out.println("Favor ingrese Rut del cliente");
        return Leer.dato();
    }

    public static int menu(){
        System.out.println("----        Sistema Turismo     ----");
        System.out.println("------------------------------------");
        System.out.println("1.\tIngresar Medio de Alojamiento (Carpa/Cabaña/Hotel)");
        System.out.println("2.\tMostrar medios de alojamiento");
        System.out.println("3.\tDatos de un cliente X ");
        System.out.println("4.\tTotal adicional");
        System.out.println("5.\tTotal bono descuento");
        System.out.println("6.\tCantidad medios de alojamiento X");
        System.out.println("7.\tValor a cancelar por un cliente X ");
        System.out.println("8.\tAplicar incremento del valor base");
        System.out.println("9.\tSalir.");
        System.out.println("------------------------------------");
        System.out.println("Favor ingrese una opción para continuar...");
        return Leer.datoInt();
    }*/
}