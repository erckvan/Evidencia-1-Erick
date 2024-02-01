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
        administradores.put("erickadmin1", new Administrador("erickadmin1", "12345"));
        administradores.put("erickadmin2", new Administrador("erickadmin2", "12345"));

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
