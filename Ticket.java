import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Ticket{
    //Atributos
    private String descripcion;
    private String nombreCreador;
    private String prioridad;
    private LocalDate fechaCreacion; 
    private LocalDate fechaResolucion; 
    private static int cantidad = 0;
    private int id; 

    //Constructor 
    public Ticket(String descripcion, String nombreCreador, String prioridad){
        this.descripcion = descripcion;
        this.nombreCreador = nombreCreador;
        this.prioridad = prioridad;
        this.fechaCreacion = LocalDate.now();
        this.fechaResolucion = null;
        this.id = ++cantidad;
    }

    //getters
    public String getDescripcion(){
        return descripcion;
    }
    public String nombreCreador(){
        return nombreCreador;
    }
    public String getPrioridad(){
        return prioridad;
    }
    public LocalDate getFechaCreacion(){
        return fechaCreacion;
    }
    public LocalDate getFechaResolucion(){
        return fechaResolucion;
    }
    public int getId(){
        return id;
    }
    public static int getCantidad(){
        return cantidad;
    }
    //setters
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    public void setNombreCreador(String nombreCreador){
        this.nombreCreador = nombreCreador;
    }
    public void setPrioridad(String prioridad){
        this.prioridad = prioridad;
    }
    public void setFechaResolucion(LocalDate fechaResolucion){
        this.fechaResolucion = fechaResolucion;
    }

    //toString()
    public String toString(){
        DateTimeFormatter formatear = DateTimeFormatter.ofPattern("yyyy/MM/dd"); //Usado para formatear la fecha
        String fechaRes;
        if(fechaResolucion == null){
            fechaRes = "Pendiente";
        }else{
            fechaRes = fechaResolucion.format(formatear);
        }
        return "ID: " + id + 
                "\nUsuario: " + nombreCreador + 
                "\nPrioridad: " + prioridad + 
                "\nDescripción: " + descripcion + 
                "\nFecha creacion: " + fechaCreacion + 
                "\nFecha Resolucion: " + fechaRes;
    }
}