
package ejc02;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio02 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String idfichero = "teclado.txt";
        String entrada;
        
        try ( BufferedWriter fichero = new BufferedWriter(new FileWriter(idfichero))) {

            do {
                System.out.println("Introduzca texto");
                entrada = sc.nextLine();
                fichero.write(entrada);
                fichero.newLine();
            } while (!(entrada.equals("EOF")));

            fichero.flush();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
