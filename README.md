# Primera Practica de Estructura de Datos <img width="111" height="90" alt="Logo Cenfotec Actual (1)" src="https://github.com/user-attachments/assets/23fa2a20-73d0-40c5-bd8b-21313c280e62" />


## Descripción
Aplicación de consola (CLI) para la gestión de tickets de soporte en línea. Permite a usuarios crear tickets y consultar su estado, y a administradores visualizar y resolver los tickets pendientes.

---

## Estructura del proyecto

| Archivo | Descripción |
|---|---|
| `Ticket.java` | Clase que representa un ticket con sus atributos y lógica de ID automático |
| `NodoLista.java` | Nodo de la lista enlazada, contiene un ticket y referencia al siguiente nodo |
| `ListaTickets.java` | Lista enlazada simple que almacena los tickets resueltos |
| `ColaTickets.java` | Cola de prioridad que almacena los tickets pendientes |
| `Menu.java` | Clase que gestiona la interfaz de usuario por consola |
| `Main.java` | Punto de entrada del programa |

---

## Estructuras de datos utilizadas

- **Cola de prioridad** (`ColaTickets`): almacena los tickets pendientes ordenados por prioridad (alta → media → baja). Ante igual prioridad, se respeta el orden de llegada.
- **Lista enlazada simple** (`ListaTickets`): almacena los tickets ya resueltos, permitiendo búsqueda por ID.

---

## Funcionalidades

### Menú Usuario
- **Crear ticket:** ingresa nombre, descripción y prioridad. El sistema asigna un ID único automáticamente.
- **Buscar ticket:** busca un ticket resuelto por ID. Si el ticket aún no fue resuelto, indica que está pendiente.

### Menú Administrador
- **Ver ticket al frente:** muestra el ticket con mayor prioridad sin removerlo de la cola.
- **Resolver ticket:** remueve el ticket al frente de la cola, registra la fecha de resolución ingresada por el administrador y lo pasa a la lista de resueltos.

---

## Ciclo de vida de un ticket

```
Usuario crea ticket → Cola de prioridad → Administrador resuelve → Lista de resueltos
```

---

## Autor
Fabián Vargas Hidalgo
