
package ejc11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ejc08.Turismo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ejercicio11 {

    public static void main(String[] args) {
        ArrayList<App> lista = new ArrayList();
        
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        
        crearDirectorio("./appstxt");
        
        crearFicherotxt("./appstxt/aplicacionestxt.txt", lista);
        
        crearDirectorio("./copias");
        
        crearDirectorio("./aplicaciones");
    }
    
    public static void crearDirectorio(String ruta) {

        Path directory = Paths.get(ruta);
        try {
            Files.createDirectory(directory);
        } catch (FileAlreadyExistsException faee) {
            System.out.println("No se puede crear " + ruta + " porque ya existe");
        } catch (AccessDeniedException ade) {
            System.out.println("No tiene permisos para crear " + ruta);
        } catch (IOException e) {
            System.out.println("Problema creando el directorio " + ruta);
            System.out.println("Seguramente la ruta está mal escrita o no existe");
        }

    }
    
    
    public static void crearFicherotxt(String nombre, ArrayList<App> lista){

            try ( BufferedWriter flujo = new BufferedWriter(new FileWriter(nombre))) {
                for (App t : lista) {
                    flujo.write(t.toString());
                    flujo.newLine();
                }
            
                // Metodo flush() guarda cambios en disco 
                flujo.flush();
                System.out.println("Fichero " + nombre + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());            
        }
    }
    
    public static void crearFicheroJSON(String nombre, ArrayList<App> lista) throws IOException{
        ObjectMapper mapeador = new ObjectMapper();

        // Permite a mapeador usar fechas según java time
        mapeador.registerModule(new JavaTimeModule());

        // Formato JSON bien formateado. Si se comenta, el fichero queda minificado
        mapeador.configure(SerializationFeature.INDENT_OUTPUT, true); //sin indent output minifica

        // Escribe en un fichero JSON el catálogo de muebles
        mapeador.writeValue(new File(nombre), lista);
    }
}
