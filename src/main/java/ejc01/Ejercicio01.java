
package ejc01;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio01 {

    public static void main(String[] args) {
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idfichero = "matriz.txt";

        // Array a escribir
        // int numeros[][] = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {11, 12, 13, 14, 15}};
        String[][] escribir = {{"100\t","101\t","102\t","103\t"},{"200\t","201\t","202\t","203\t"},
                                {"300\t","301\t","302\t","303\t"},{"400\t","401\t","402\t","403\t"}};


        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(idfichero))) {

            for (String[] is : escribir) {
                for (String i : is) {
                    // Usamos metodo write() para escribir en el buffer
                    flujo.write(i);
                }
                // Metodo newLine() añade línea en blanco
                flujo.newLine();
            }
            // Metodo flush() guarda cambios en disco 
            flujo.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
