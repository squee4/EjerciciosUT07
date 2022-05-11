
package ejc06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Ejercicio06 {

    public static void main(String[] args) {
        // Fichero a leer
        String idFichero = "lineas.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;

        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {
            int suma = 0;
            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine(); //Se lee la línea
                tokens = linea.split(";"); // separa las líneas
                
                for (String token : tokens) {
                    suma = suma + Integer.parseInt(token); //por cada token se suma a "suma"

                }
                
            }
            
            System.out.println("La suma de la matriz equivale a "+suma);
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
