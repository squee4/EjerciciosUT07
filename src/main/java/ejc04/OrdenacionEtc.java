
package ejc04;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class OrdenacionEtc {

    public static void main(String[] args) {
//        Vehiculo[] lista = new Vehiculo[30];
        ArrayList<Vehiculo> lista = new ArrayList();
        Comparator <Vehiculo> color = (v1,v2)->v1.getColor().compareTo(v2.getColor());
        Comparator <Vehiculo> matricula = (v1,v2)->v1.getMatricula().compareTo(v2.getMatricula());
        
        for (int i = 0; i < 30; i++) {
            if(i <10){
                lista.add(new Turismo());
            } else if (i<20){
                lista.add(new Deportivo());
            } else {
                lista.add(new Furgoneta());
            }
        }
        
//        List<String> lista2 = lista.stream()
        List<Vehiculo> lista2 = lista.stream()
//                .filter(v1 -> v1.getColor().equals("Rojo")) //filtrar solo vehiculos rojos
//                .map(m1 -> m1.getMarca())
                .distinct()
                .sorted(color.thenComparing(matricula)) // ordenar por color y despues matricula
                .collect(Collectors.toList());
        
        
        for (Vehiculo string : lista2) {
            System.out.println(string.toString());
        }
        lista.sort(color);
//            for (Vehiculo vehiculo : lista) {
//                System.out.println(vehiculo.toString());
//            }
    }
    
}
