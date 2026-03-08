public class ListaTickets {
    private NodoLista primero;

    public ListaTickets(){
        primero = null;
    }

    public NodoLista getPrimero(){
        return primero;
    }

    public void setPrimero(NodoLista nuevoPrimero){
        primero = nuevoPrimero;
    }

    //Insertar ticket al final de la lista (Para los ticket que ya estan resueltos)
    public void insertarNodoFinal(Ticket ticket){
        NodoLista nodoInsertar = new NodoLista(ticket);
        if(primero == null){
            setPrimero(nodoInsertar);
            return;
        }
        NodoLista temp = primero;
        while(temp.getSiguiente()!=null){
            temp = temp.getSiguiente();
        }
        temp.setSiguiente(nodoInsertar);
    }
    // Buscar ticket resuelto por ID 
    public NodoLista buscar(int id) {
        if (primero == null) {
            System.out.println("No hay tickets resueltos aun");
            return null;
        }
        NodoLista temp = primero;
        while (temp != null && temp.getTicket().getId() != id) {
            temp = temp.getSiguiente();
        }
        if (temp == null) {
            System.out.println("El ticket con ID " + id + " esta pendiente");
        } else {
            System.out.println("Ticket resuelto encontrado");
        }
        return temp;
    }
    public void mostrarLista(){
        if(primero == null){
            System.out.println("No hay tickets resueltos");
            return;
        }
        NodoLista temp = primero;
        int contador =1;
        while(temp!= null){
            System.out.println("Ticket " + contador + ":" + temp.getTicket());
            temp = temp.getSiguiente();
            contador++;
        }
    }

    public String toString() {
        return "Primer ticket: " + primero;
    }
}