
package ejc07;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio07 {

    public static void main(String[] args) {
        // Realiza un programa que lea los datos del ejercicio 4. 
//        Para ello creará una lista de objetos de tipo Vehículo. 
//        El programa irá almacenando en la lista los objetos leídos desde el archivo de texto “vehículos.txt”. 
//        Una vez cargados todos los datos en la lista, ordena los vehículos por Marca y muestra el resultado por consola.
    
        // Fichero a leer
        String idFichero = "vehiculos.txt";

        // Variables para guardar los datos que se van leyendo
        String[] tokens;
        String linea;
        ArrayList<Vehiculo> lista = new ArrayList();
        
        System.out.println("Leyendo el fichero: " + idFichero);

        // Inicialización del flujo "datosFichero" en función del archivo llamado "idFichero"
        // Estructura try-with-resources. Permite cerrar los recursos una vez finalizadas
        // las operaciones con el archivo
        try ( Scanner datosFichero = new Scanner(new FileReader(idFichero))) {

            // Mientras haya líneas por leer
            while (datosFichero.hasNextLine()) {

                linea = datosFichero.nextLine(); //Se lee la línea
                String[] sinNum = linea.split(" - ");
                tokens = sinNum[1].split(":");
                
                if (sinNum[0].equals("0")) {
                    lista.add(new Turismo(tokens[0],tokens[1],tokens[2],tokens[3]));
                    
                } else if (sinNum[0].equals("1")) {
                    lista.add(new Deportivo(tokens[0],tokens[1],tokens[2],tokens[3]));
                    
                } else {
                    lista.add(new Furgoneta(tokens[0],tokens[1],tokens[2],tokens[3]));
                    
                }
                
            }
            
            //Ordenar por marca
            
            lista.sort((v1,v2) -> v1.getMarca().compareTo(v2.getMarca()));
            
            
            //Mostrar resultado por consola
            for (Vehiculo vehiculo : lista) {
                System.out.println(vehiculo.toString());
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    
    }
    
}
