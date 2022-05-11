
package ejc04;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio04 {

    public static void main(String[] args) {
        ArrayList<Vehiculo> lista = new ArrayList();
        
        for (int i = 0; i < 30; i++) {
            if(i <10){
                lista.add(new Turismo());
            } else if (i<20){
                lista.add(new Deportivo());
            } else {
                lista.add(new Furgoneta());
            }
        }
        
        // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
        String idFichero = "vehiculos.txt";

        // Si se utiliza el constructor FileWriter(idFichero, true) entonces se anexa información
        // al final del fichero idFichero
        // Estructura try-with-resources. Instancia el objeto con el fichero a escribir
        // y se encarga de cerrar el recurso "flujo" una vez finalizadas las operaciones
        try (BufferedWriter flujo = new BufferedWriter(new FileWriter(idFichero))) {
            for (Vehiculo vehiculo : lista) {
                flujo.write(vehiculo.toString());
                flujo.newLine();
            }
            // Metodo fluh() guarda cambios en disco 
            flujo.flush();
            System.out.println("Fichero " + idFichero + " creado correctamente.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
