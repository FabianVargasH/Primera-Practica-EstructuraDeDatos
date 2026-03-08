import java.io.IOException;
public class Main{
    public static void main(String[] args)throws IOException {
        ColaTickets colaTickets = new ColaTickets();
        ListaTickets listaTickets = new ListaTickets();
        Menu menu = new Menu(colaTickets, listaTickets);
        menu.menuPrincipal();
    }
}