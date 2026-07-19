package app;

import interfaces.Registrable;
import model.Cliente;
import model.Direccion;
import model.Guia;
import utils.LectorArchivo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import utils.RutInvalidoExcepcion;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        // Lista polimórfica almacena clientes y guías
        List<Registrable> registros = new ArrayList<>();

        // Cargar datos desde el archivo de texto
        registros.addAll(LectorArchivo.cargarPersonasDesdeTxt("datos_turismo.txt"));

        int opcion = 0;
        do {
            System.out.println("\n🌿 ¡Bienvenido al Panel de Llanquihue Tour! 🌿");
            System.out.println("1. Inscribir un nuevo Cliente");
            System.out.println("2. Inscribir un nuevo Guía turístico");
            System.out.println("3. Ver todas las personas registradas");
            System.out.println("4. Buscar a alguien por su RUT");
            System.out.println("5. Ver listado exclusivo de Clientes");
            System.out.println("6. Salir de la aplicación");
            System.out.print("👉 ¿Qué te gustaría hacer hoy? Elige una opción: ");

            try {
                opcion = Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    String rutC = "";
                    boolean rutValido = false;

                    while (!rutValido) {
                        try {
                            System.out.print("¿Nos podrías indicar su número de RUT?: ");
                            rutC = entrada.nextLine();

                            // Se Valida que tenga guion
                            if (rutC == null || !rutC.contains("-")) {
                                throw new RutInvalidoExcepcion("El RUT ingresado debe incluir el guion.");
                            }

                            // Se Valida que no esté duplicado en el sistema
                            if (existeRut(rutC, registros)) {
                                throw new RutInvalidoExcepcion("El RUT ingresado ya se encuentra registrado en el sistema.");
                            }

                            // Si supera ambas pruebas, avanzamos
                            rutValido = true;

                        } catch (RutInvalidoExcepcion e) {
                            System.out.println("\n😜 ¡Ups! " + e.getMessage());
                            System.out.println("Por favor, asegúrate de escribirlo bien (ejemplo: 12345678-K)\n");
                        }
                    }
                    System.out.print("¿Cuál es el nombre completo de la persona?: ");
                    String nombreC = entrada.nextLine();
                    System.out.print("¿Cuál es la calle y número de su domicilio?: ");
                    String calleC = entrada.nextLine();
                    System.out.print("¿Y a qué comuna corresponde? (Presiona ENTER para dejarla por defecto): ");
                    String comunaC = entrada.nextLine();
                    Direccion dirC;

                    // Comuna por defecto si se presiona ENTER
                    if (comunaC.trim().isEmpty()) {
                        dirC = new Direccion(calleC);
                    } else {
                        dirC = new Direccion(calleC, comunaC); // Constructor normal con los dos datos
                    }

                    System.out.print("¿Cuál es su dirección de correo electrónico?: ");
                    String correo = entrada.nextLine();
                    Cliente nuevoCliente = new Cliente(rutC, nombreC, dirC, correo);
                    registros.add(nuevoCliente);
                    System.out.println("✨ ¡Excelente! El cliente ha sido registrado con éxito en el sistema. ✨");
                    break;

                case 2:
                    System.out.println("\n--- 📝 ¡Comencemos con la inscripción del guía! ---");
                    String rutG = "";
                    boolean rutGValido = false;

                    while (!rutGValido) {
                        try {
                            System.out.print("¿Nos podrías indicar su número de RUT?: ");
                            rutG = entrada.nextLine();

                            // Se Valida que tenga guion
                            if (rutG == null || !rutG.contains("-")) {
                                throw new RutInvalidoExcepcion("El RUT ingresado debe incluir el guion.");
                            }

                            // Se Valida que no esté duplicado en el sistema
                            if (existeRut(rutG, registros)) {
                                throw new RutInvalidoExcepcion("El RUT ingresado ya se encuentra registrado en el sistema.");
                            }

                            // Si supera ambas pruebas, avanzamos
                            rutGValido = true;

                        } catch (RutInvalidoExcepcion e) {
                            System.out.println("\n😜 ¡Ups! " + e.getMessage());
                            System.out.println("Por favor, asegúrate de escribirlo bien (ejemplo: 12345678-K)\n");
                        }
                    }

                    System.out.print("¿Cuál es el nombre completo de la persona?: ");
                    String nombreG = entrada.nextLine();
                    System.out.print("¿Cuál es la calle y número de su domicilio?: ");
                    String calleG = entrada.nextLine();
                    System.out.print("¿Y a qué comuna corresponde? (Presiona ENTER para dejarla por defecto): ");
                    String comunaG = entrada.nextLine();

                    Direccion dirG;

                    // Comuna por defecto si se presiona ENTER
                    if (comunaG.trim().isEmpty()) {
                        dirG = new Direccion(calleG);
                    } else {
                        dirG = new Direccion(calleG, comunaG);
                    }

                    System.out.print("¿Cuál es su dirección de correo electrónico?: ");
                    String correoG = entrada.nextLine();

                    // Pedimos la especialidad ANTES de crear
                    System.out.print("¿Cuál es la especialidad de este guía? (por ejemplo: Trekking, Gastronomía): ");
                    String especialidad = entrada.nextLine();

                    // Por esto (Pasando la especialidad directamente al constructor):
                    Guia nuevoGuia = new Guia(rutG, nombreG, dirG, correoG, especialidad);

                    registros.add(nuevoGuia);

                    System.out.println("✨ ¡Excelente! El guía turístico ha sido registrado con éxito en el sistema. ✨");
                    // Fin del caso
                    break;

                case 3:
                    System.out.println("\n--- 📋 Aquí tienes el listado general del sistema ---");
                    if (registros.isEmpty()) {
                        System.out.println("📌 Aún no tenemos personas registradas en el sistema. ¿Te gustaría registrar a alguien primero?");
                    } else {
                        // Muestra los datos de cada uno
                        for (Registrable reg : registros) {
                            System.out.println(reg.mostrarDatos());
                        }
                    }
                    break;

                case 4:
                    System.out.println("\n--- 🔍 ¡Vamos a buscar a alguien por su RUT! ---");
                    String rutBuscar = "";

                    while (true) {
                        try {
                            System.out.print("Ingrese el RUT de la persona a buscar (con guion): ");
                            rutBuscar = entrada.nextLine();

                            // Se Valida que tenga guion
                            if (!rutBuscar.contains("-")) {
                                throw new RutInvalidoExcepcion("El RUT ingresado no es válido. Recuerde incluir el guion (ej: 12345678-9).");
                            }

                            // Si pasa la validación, salimos del bucle
                            break;

                        } catch (RutInvalidoExcepcion e) {
                            // Valida el RUT en la búsqueda
                            System.out.println("❌ Error: " + e.getMessage());
                            System.out.println("Por favor, intente nuevamente.\n");
                        }
                    }

                    // Lógica para buscar registros

                    boolean encontrado = false;
                    for (Registrable reg : registros) {

                        if (reg.getRut().equals(rutBuscar)) {
                            System.out.println("\n✨ ¡Persona encontrada! ✨");
                            System.out.println(reg.toString());
                            encontrado = true;
                            break;
                        }
                    }

                    if (!encontrado) {
                        System.out.println("❌ No se encontró ninguna persona registrada con el RUT: " + rutBuscar);
                    }
                    break;

                case 5:
                    System.out.println("\n--- 👥 Aquí tienes el listado exclusivo de nuestros clientes ---");
                    int cantClientes = 0;
                    for (Registrable reg : registros) {
                        // Verificar si es un Cliente o un Guía
                        if (reg instanceof Cliente) {
                            System.out.println(reg.mostrarDatos());
                            cantClientes++;
                        }
                    }
                    if (cantClientes == 0) {
                        System.out.println("👋 ¡Hola! Por el momento la lista está vacía y no tenemos ningún cliente registrado en el sistema.");
                    }
                    break;

                case 6:
                    System.out.println("\n🏔️ ¡Muchas gracias por viajar con Llanquihue Tour App! Esperamos verte muy pronto en una nueva aventura. ¡Que tengas un excelente viaje! 👋");
                    break;

                default:
                    System.out.println("🤔 ¡Ups! Esa opción no se encuentra en el menú. ¿Podrías intentar con otra, por favor?");
            }
        } while (opcion != 6);

        entrada.close();
    }

    private static boolean existeRut(String rut, java.util.List<interfaces.Registrable> lista) {
        for (interfaces.Registrable reg : lista) {
            if (reg.getRut().equals(rut)) {
                return true;
            }
        }
        return false;
    }

}