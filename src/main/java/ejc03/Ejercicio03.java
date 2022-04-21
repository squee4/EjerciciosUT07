
package ejc03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String idfichero = "lineas.txt";

        try ( BufferedWriter fichero = new BufferedWriter(new FileWriter(idfichero))) {
            for (int i = 0; i < 75; i++) {
                fichero.write(creaLinea());
                fichero.newLine();
            }
            fichero.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private static String creaLinea(){
        Random rnd = new Random();
        String retorno = "";
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int posicion;
        
        do{
            posicion = rnd.nextInt(letras.length());
            retorno = retorno + letras.charAt(posicion);
            
        } while (posicion!=6 && posicion!=32);
        
        
        return retorno;
    }
    
}
