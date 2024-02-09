import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Clase Doctor
class Doctor {
    private String id;
    private String nombreCompleto;
    private String especialidad;

    public Doctor(String id, String nombreCompleto, String especialidad) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.especialidad = especialidad;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getEspecialidad() {
        return especialidad;
    }
}

// Clase Paciente
class Paciente {
    private String id;
    private String nombreCompleto;

    public Paciente(String id, String nombreCompleto) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
}

// Clase Cita
class Cita {
    private String id;
    private LocalDateTime fechaHora;
    private String motivo;
    private Doctor doctor;
    private Paciente paciente;

    public Cita(String id, LocalDateTime fechaHora, String motivo, Doctor doctor, Paciente paciente) {
        this.id = id;
        this.fechaHora = fechaHora;
        this.motivo = motivo;
        this.doctor = doctor;
        this.paciente = paciente;
    }

    // Getters
    public String getId() {
        return id;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public String getMotivo() {
        return motivo;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Paciente getPaciente() {
        return paciente;
    }
}

// Clase Administrador para control de acceso
class Administrador {
    private String username;
    private String password;

    public Administrador(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Main {
    private static Map<String, Doctor> doctores = new HashMap<>();
    private static Map<String, Paciente> pacientes = new HashMap<>();
    private static Map<String, Administrador> administradores = new HashMap<>();
    private static int citaCounter = 1;

    public static void main(String[] args) {
        // Agregar administradores
        administradores.put("Erickadmin1", new Administrador("Erickadmin1", "12345"));
        administradores.put("admin2", new Administrador("Erickadmin2", "12345"));

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre de usuario:");
        String username = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String password = scanner.nextLine();

        if (validarCredenciales(username, password)) {
            System.out.println("Inicio de sesión exitoso.");
            mostrarMenu();
        } else {
            System.out.println("Credenciales incorrectas. El programa se cerrará.");
        }
    }

    // Método para validar credenciales de administrador
    private static boolean validarCredenciales(String username, String password) {
        Administrador admin = administradores.get(username);
        return admin != null && admin.getPassword().equals(password);
    }

    // Método para mostrar el menú de opciones
    private static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Dar de alta doctor");
            System.out.println("2. Dar de alta paciente");
            System.out.println("3. Crear cita");
            System.out.println("4. Salir");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    darAltaDoctor();
                    break;
                case 2:
                    darAltaPaciente();
                    break;
                case 3:
                    crearCita();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);
    }

    // Método para dar de alta un doctor
    private static void darAltaDoctor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del doctor:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre completo del doctor:");
        String nombreCompleto = scanner.nextLine();
        System.out.println("Ingrese la especialidad del doctor:");
        String especialidad = scanner.nextLine();

        Doctor doctor = new Doctor(id, nombreCompleto, especialidad);
        doctores.put(id, doctor); // Agregar doctor al mapa
        System.out.println("Doctor agregado con éxito.");
    }

    // Método para dar de alta un paciente
    private static void darAltaPaciente() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del paciente:");
        String id = scanner.nextLine();
        System.out.println("Ingrese el nombre completo del paciente:");
        String nombreCompleto = scanner.nextLine();

        Paciente paciente = new Paciente(id, nombreCompleto);
        pacientes.put(id, paciente); // Agregar paciente al mapa
        System.out.println("Paciente agregado con éxito.");
    }

    // Método para crear una cita
    private static void crearCita() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el ID del doctor:");
        String idDoctor = scanner.nextLine();
        Doctor doctor = doctores.get(idDoctor);
        if (doctor == null) {
            System.out.println("El doctor no existe. Por favor, agregue al doctor primero.");
            return;
        }

        System.out.println("Ingrese el ID del paciente:");
        String idPaciente = scanner.nextLine();
        Paciente paciente = pacientes.get(idPaciente);
        if (paciente == null) {
            System.out.println("El paciente no existe. Por favor, agregue al paciente primero.");
            return;
        }

        System.out.println("Ingrese la fecha y hora de la cita (YYYY-MM-DD HH:MM):");
        String fechaHoraStr = scanner.nextLine();
        LocalDateTime fechaHora;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            fechaHora = LocalDateTime.parse(fechaHoraStr, formatter);
        } catch (Exception e) {
            System.out.println("Formato de fecha y hora incorrecto. Por favor, use el formato indicado.");
            return;
        }

        System.out.println("Ingrese el motivo de la cita:");
        String motivo = scanner.nextLine();

        Cita cita = new Cita("CITA" + citaCounter++, fechaHora, motivo, doctor, paciente);
        System.out.println("Cita creada con éxito.");
    }
}
