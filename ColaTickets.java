import java.util.ArrayList;

public class ColaTickets {
    private ArrayList<Ticket>colaTickets;

    public ColaTickets(){
        colaTickets = new ArrayList<>();
    }

    private int valorPrioridad(String prioridad) {
        switch(prioridad.toLowerCase()){
            case "alta":
                return 3;
            case "media":
                return 2;
            case "baja":
                return 1;
            default:
                return 0;
        }
    }
    //Metodo que inserta en base al orden de prioridad
    public void insertar(Ticket ticket){
        if(colaTickets.isEmpty()){
            colaTickets.add(ticket);
            return;
        }
        int prioridadNuevo = valorPrioridad(ticket.getPrioridad());
        int i =0;
        while(i<colaTickets.size() && prioridadNuevo <= valorPrioridad(colaTickets.get(i).getPrioridad())){
            i++;
        }
        colaTickets.add(i, ticket);
    }
    
    //remover ticket del frente, es decir, el de mayor prioridad
    public Ticket remover(){
        if(colaTickets.isEmpty()){
            System.out.println("No existen tickets en cola");
            return null;
        }
        return colaTickets.removeFirst();
    }

    //Ver el ticket del frente sin removerlo
    public Ticket verFrente(){
        if(colaTickets.isEmpty()){
            System.out.println("No existen tickets en cola");
            return null;
        }
        return colaTickets.getFirst();
    }
}