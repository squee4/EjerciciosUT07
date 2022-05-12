
package ejc13;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ejc11.App;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio13 {

    public static void main(String[] args) throws IOException {
        leerJson("appsJson/aplicacionesxml.json");
    }
    
    private static void leerJson(String idFichero) throws IOException{
         ObjectMapper mapeador = new ObjectMapper();
        mapeador.registerModule(new JavaTimeModule());
        
        ArrayList<App> lista = mapeador.readValue(new File(idFichero),
                    mapeador.getTypeFactory().constructCollectionType(ArrayList.class, App.class));
        System.out.println("---- Lista de Apps ----");
        for (App app : lista) {
            System.out.println(app);
        }
    }
    
}
