
package ejc11;

import java.util.Random;

public class App {
    private int codigo, numDescargas;
    private Double tamanio;
    private String nombre, descripcion;
    
    private Random rnd = new Random();
    private static int contador = 1;
    private static String[] listaDescripciones = {"Productividad","Salud","Juegos","Cocina","Música","Vídeo","Fotografía","Finanazas","Estilo de vida","Educación",};
    
    public App(String nombre, String descripcion, double tamanio, int numDescargas) {
        this.codigo = contador++;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tamanio = tamanio;
        this.numDescargas = numDescargas;
    }
    
    public App() {
        this.codigo = contador++;
        this.nombre = "app" + this.codigo + letraAZ();
        this.descripcion = listaDescripciones[rnd.nextInt(listaDescripciones.length)];
        this.tamanio = rnd.doubles(1, 100.0, 1024.0).sum();
        this.numDescargas = rnd.ints(1, 0, 50000).sum();
        
    }

    public int getCodigo() {
        return codigo;
    }

    public int getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(int numDescargas) {
        this.numDescargas = numDescargas;
    }

    public Double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + descripcion + ";" + tamanio + ";" + numDescargas ;
    }
    
    private String letraAZ(){
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        String retorno = "";
        
        retorno = retorno + alfabeto.charAt(rnd.nextInt(alfabeto.length()));
        
        return retorno;
    }
}
