
package ejc04;

import java.util.Random;

public abstract class Vehiculo {
    Random rnd = new Random();
    private static String[] listaMarcas = {"Ford","Mercedes","Mitsubishi","Opel","Tesla","Chevrolet","Renault","Seat"};
    private static String[] listaModelos = {"Modelo1","Modelo2","Modelo3","Modelo4","Modelo5"};
    private static String[] listaColores = {"Blanco","Rojo","Negro","Azul","Amarillo"};

    private String matricula,marca,modelo,color;
    
    public Vehiculo() {
        this.matricula = creaMatricula();
        this.marca = listaMarcas[rnd.nextInt(listaMarcas.length)];
        this.modelo = listaModelos[rnd.nextInt(listaModelos.length)];
        this.color = listaColores[rnd.nextInt(listaColores.length)];
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        String texto = "";
        if (this instanceof Turismo){
            texto = "0 - ";
        } else if (this instanceof Deportivo) {
            texto = "1 - ";
        } else {
            texto = "2 - ";
        }
        
        return texto + matricula + ":" + marca + ":" + modelo + ":" + color;
    }
    
    
    
    private String creaMatricula(){
        String retorno = "";
        Random rnd = new Random();
        String letras = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < 4; i++) {
            retorno = retorno + rnd.nextInt(10);
        }
        retorno = retorno + letras.charAt(rnd.nextInt(letras.length()));
        
        return retorno;
    }
}
