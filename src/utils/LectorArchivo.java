package utils;

import model.Cliente;
import model.Direccion;
import model.Guia;
import interfaces.Registrable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {

    public static List<Registrable> cargarPersonasDesdeTxt(String rutaArchivo) {
        List<Registrable> listaCargada = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Saltar líneas vacías
                if (linea.trim().isEmpty()) continue;

                // Estructura interna del archivo de texto (.txt):
                // Campos separados por punto y coma (;)
                String[] datos = linea.split(";");
                if (datos.length < 6) continue;

                String tipo = datos[0].trim();
                String rut = datos[1].trim();
                String nombre = datos[2].trim();
                String calle = datos[3].trim();
                String comuna = datos[4].trim();
                String extra = datos[5].trim();

                Direccion dir = new Direccion(calle, comuna);

                if (tipo.equalsIgnoreCase("CLIENTE")) {
                    listaCargada.add(new Cliente(rut, nombre, dir, extra));
                } else if (tipo.equalsIgnoreCase("GUIA")) {
                    listaCargada.add(new Guia(rut, nombre, dir, extra,"Especialidad General" ));
                }
            }
            System.out.println(">> Archivo '" + rutaArchivo + "' cargado con éxito.");
        } catch (IOException e) {
            System.out.println(">> Nota: No se encontró el archivo '" + rutaArchivo + "'. Iniciando con lista vacía.");
        }

        return listaCargada;
    }
}