public class NodoLista {
    private Ticket ticket;
    private NodoLista siguiente;

    public NodoLista(Ticket nodo){
        this.ticket = nodo;
        this.siguiente = null;
    }

    public Ticket getTicket(){
        return ticket;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }

    public NodoLista getSiguiente(){
        return siguiente;
    }

    public void setSiguiente(NodoLista siguiente){
        this.siguiente = siguiente;
    }

    public String toString(){
        return ticket.toString();
    }
}
