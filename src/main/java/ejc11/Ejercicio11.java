
package ejc11;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Ejercicio11 {

    public static void main(String[] args) throws IOException {
        ArrayList<App> lista = new ArrayList();
        
        for (int i = 0; i < 50; i++) {
            lista.add(new App());
        }
        
        crearDirectorio("./appstxt");
        
        crearFicherotxt("./appstxt/aplicacionestxt.txt", lista);
        
        crearDirectorio("./appsjson");
        
        crearFicheroJSON("./appsjson/aplicacionesxml.json", lista);
        
        crearDirectorio("./copias");
        
        copiarFicheros("./appstxt/aplicacionestxt.txt", "./copias/aplicacionestxt.txt");
        copiarFicheros("./appsjson/aplicacionesxml.json", "./copias/aplicacionesxml.json");
        
        crearDirectorio("./aplicaciones");
        escribirAppsEnFicheroTxt(lista);
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
    
    public static void copiarFicheros(String rutaOrigen, String rutaDestino) {
        Path origen = Paths.get(rutaOrigen);
        Path destino = Paths.get(rutaDestino);

        try {
            if (!Files.exists(destino)) {
                Files.copy(origen, destino);
                System.out.println("Se han copiado los archivos");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void escribirAppsEnFicheroTxt(ArrayList<App> listaApp) {
        for (App app : listaApp) {
            try (BufferedWriter flujo = new BufferedWriter(new FileWriter("./aplicaciones/"+app.getNombre()+".txt"))) {

                flujo.write(app.toString());
                flujo.flush();
                System.out.println("Fichero aplicaciones " +app.getNombre()  + " creado correctamente.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
    
    // recorrer un map 
    
//    public String toString() {
//        String texto;
//        texto=nombre+"\n";
//        
//        for(String incial: notas.keySet()){
//            texto=texto+"["+incial+": "+notas.get(incial)+"] ";
//        }
//        
//        return texto;
//    }
}
