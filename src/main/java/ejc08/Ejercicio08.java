
package ejc08;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ejercicio08 {

    public static void main(String[] args) throws IOException {
        // Realiza una modificación sobre el programa del ejercicio 7 para que divida la única lista 
        // de objetos Vehiculo en tres listas específicas de objetos Turismo, Deportivo y Furgoneta. 
        // Una vez generadas las tres listas, guarda en tres ficheros binarios (turismos.dat, 
        // deportivos.dat y furgonetas.dat) los vehículos correspondientes a cada lista. 
        // Intenta abrir con el editor de texto algún fichero *.dat. ¿Qué se ve?
        
        
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
                    lista.add(new Turismo(tokens[0], tokens[1], tokens[2], tokens[3]));

                } else if (sinNum[0].equals("1")) {
                    lista.add(new Deportivo(tokens[0], tokens[1], tokens[2], tokens[3]));

                } else {
                    lista.add(new Furgoneta(tokens[0], tokens[1], tokens[2], tokens[3]));

                }
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
            
            //crear 3 sublistas
            
            ArrayList<Turismo> listaTurismos = new ArrayList();
            ArrayList<Deportivo> listaDeportivos = new ArrayList();
            ArrayList<Furgoneta> listaFurgonetas = new ArrayList();
            
            for (Vehiculo vehiculo : lista) {
                if (vehiculo instanceof Turismo) {
                    listaTurismos.add((Turismo)vehiculo);
                    
                } else if (vehiculo instanceof Deportivo) {
                    listaDeportivos.add((Deportivo)vehiculo);
                    
                } else{
                    listaFurgonetas.add((Furgoneta)vehiculo);
                }
            }
            
            //con stream ???¿?
            
//            List<Vehiculo> listaTurismos = new ArrayList();
//            ArrayList<Vehiculo> listaDeportivos = new ArrayList();
//            ArrayList<Vehiculo> listaFurgonetas = new ArrayList();
//            
//            listaTurismos =  lista.stream()
//                    .filter(v -> v instanceof Turismo)
//                    .collect(Collectors.toList());
            
            
            //Mostrar resultado por consola
            for (Turismo a : listaTurismos) {
                System.out.println(a.toString());
            }
            
            for (Deportivo a : listaDeportivos) {
                System.out.println(a.toString());
            }

            for (Furgoneta a : listaFurgonetas) {
                System.out.println(a.toString());
            }
            
            //escribir las 3 listas en ficheros
            // Fichero a crear. Ruta relativa a la carpeta raíz del proyecto
            String turismocsv = "turismo.csv";

            try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(turismocsv))) {
                for (Turismo t : listaTurismos) {
                    flujo.write(t.toString());
                    flujo.newLine();
                }
            
                // Metodo flush() guarda cambios en disco 
                flujo.flush();
                System.out.println("Fichero " + turismocsv + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            
        
    }
    
}
