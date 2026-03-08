import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
public class Menu {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private ListaTickets listaTickets;
    private ColaTickets colaTickets;
    private DateTimeFormatter formatoFecha;

    public Menu(ColaTickets colaTickets, ListaTickets listaTickets){
        this.colaTickets = colaTickets;
        this.listaTickets = listaTickets;
        this.formatoFecha = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    }

    public void menuPrincipal() throws IOException{
        int opcion = -1;
        while(opcion!=0) {
            System.out.println("\n--SISTEMA DE TICKETS--");
            System.out.println("1. Menú de Usuario");
            System.out.println("2. Menú de Administrador");
            System.out.println("0. Salir");
            System.out.println("Seleccione una opción");
            opcion = Integer.parseInt(reader.readLine());

            if(opcion == 1){
                menuUsuario();
            }else if(opcion == 2){
                menuAdministrador();
            }else if(opcion == 0){
                System.out.println("Saliendo del programa");
            }else{
                System.out.println("Opción invalida");
            }
        }
    }

    //Menu usuario
    private void menuUsuario() throws IOException{
        int opcion = -1;
        while(opcion != 0){
            System.out.println("\n--MENU USUARIO--");
            System.out.println("1. Crear ticket");
            System.out.println("2. Buscar ticket");
            System.out.println("0. salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(reader.readLine());

            if(opcion == 1){
                crearTicket(colaTickets);
            }else if(opcion ==2){
                buscarTicket(listaTickets);
            }else if(opcion == 0){
                System.out.println("Volviendo al menu general...\n");
            }else{
                System.out.println("Opción invalida");
            }
        }
    }
    private void imprimirTicket(Ticket ticket){
        System.out.println(ticket.toString());
    }

    private void crearTicket(ColaTickets colaTickets) throws IOException{
        System.out.println("\n--CREAR TICKET--");
        System.out.print("Nombre completo: ");
        String nombre = reader.readLine();

        System.out.print("Descripcion del problema: ");
        String descripcion = reader.readLine();

        String prioridad = "";
        while(!prioridad.equals("alta")&&!prioridad.equals("media")&&!prioridad.equals("baja")){
            System.out.println("Prioridad (alta/media/baja): ");
            prioridad = reader.readLine().toLowerCase();
            if(!prioridad.equals("alta")&&!prioridad.equals("media")&&!prioridad.equals("baja")){
                System.out.println("Prioridad invalida. ingresela de nuevo");
            }
        }
        Ticket nuevoTicket = new Ticket(descripcion, nombre, prioridad);
        colaTickets.insertar(nuevoTicket);
        System.out.println("\nTicket creado existosamente");
        imprimirTicket(nuevoTicket);
    }

    private void buscarTicket(ListaTickets listaTickets) throws IOException{
        System.out.println("\n--BUSCAR TICKET--");
        System.out.println("Ingrese el ID del ticket: ");
        int id = Integer.parseInt(reader.readLine());

        NodoLista resultado = listaTickets.buscar(id);
        if(resultado !=null){
            imprimirTicket(resultado.getTicket());
        }
    }

    private void menuAdministrador()throws IOException{
        int opcion =-1;
        while(opcion !=0){
            System.out.println("\n--MENU ADMINISTRADOR--");
            System.out.println("1. Ver ticket");
            System.out.println("2. Resolver ticket");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = Integer.parseInt(reader.readLine());

            if(opcion ==1){
                verFrente(colaTickets);
            }else if(opcion == 2){
                resolverTicket(colaTickets, listaTickets);
            }else if(opcion ==0){
                System.out.println("Volviendo al menu general...\n");
            }else{
                System.out.println("Opcion invalida");
            }
        }
    }
    //Ver el ticket con mayor priorizacion
    private void verFrente(ColaTickets colaTickets){
        System.out.println("\n--Ticket con mayor prioridad--");
        Ticket frente = colaTickets.verFrente();
        if(frente !=null){
            imprimirTicket(frente);
        }
    }

    private void resolverTicket(ColaTickets colaTickets, ListaTickets listaTickets) throws IOException{
        System.out.println("\n--RESOLVER TICKET--");
        Ticket frente = colaTickets.verFrente();
        if(frente == null){
            return;
        }
        System.out.println("Ticket a resolver: ");
        imprimirTicket(frente);

        LocalDate fechaResolucion = null;
        while(fechaResolucion == null){
            System.out.println("\nIngrese la fecha de resolucion (yyy/MM/dd)");
            String entrada = reader.readLine();
            try {
                fechaResolucion = LocalDate.parse(entrada, formatoFecha);
            } catch (DateTimeParseException e) {
                System.out.println("Formato invalido. Ejemplo: 2026/06/25");
            }
        }

        Ticket ticketResuelto = colaTickets.remover();
        ticketResuelto.setFechaResolucion(fechaResolucion);
        listaTickets.insertarNodoFinal(ticketResuelto);
        System.out.println("\nTicket resuelto. Informacion actualizada:");
        imprimirTicket(ticketResuelto);
    }
}
