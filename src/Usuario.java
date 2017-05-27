/**
 * Created by QSM on 18/5/17.
 */
import java.util.*;

public class Usuario implements Comparable<Usuario> {
    private int target, password;
    private String nombre, apellidos;
    private int saldo = 0;
    private Map<String, String> movimientos = new HashMap<String, String>();
    private String resultado;

    public Usuario(int target, int password) {
        this.target = target;
        this.password = password;
    }

    public Usuario(){}

    public Usuario(String nombre, String apellidos, int target, int password){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.target = target;
        this.password = password;
    }

    public int getSaldo(){
        return saldo;
    }

    public void ingresarSaldo(int s){
        saldo += s;
    }

    public void retirarSaldo(int s){
        saldo -= s;
    }

    public void setMovimiento(String s, String gastado){
        movimientos.put(s, gastado);
    }


    public void setOrder(int n){
        ArrayList<String> aux = new ArrayList<String>();
        resultado = "";

        if (n==0) { // ordenar por alfabeto
            for (Map.Entry<String, String> entry : movimientos.entrySet()) {
                    aux.add(entry.getKey() + " " + entry.getValue());
            }
            Collections.sort(aux);
            for (String j : aux) {
                    resultado += "     " + j + "\n";
            }

        } else if (n==1) { //  mostrar lo invertido
            for (Map.Entry<String, String> entry : movimientos.entrySet()) {

                if (entry.getValue().contains("+")) {
                    aux.add(entry.getKey() + " " + entry.getValue());
                }
            }

            for (String j : aux) {
                resultado += "     " + j + "\n";
            }


            // lo invertido tiene un + delante



        } else if (n==2) { // mostrar lo retirado
            for (Map.Entry<String, String> entry : movimientos.entrySet()) {
                    if (entry.getValue().contains("-")) {
                        aux.add(entry.getKey() + " " + entry.getValue());
                    }

            }

            for (String j : aux) {
                resultado += "     " + j + "\n";
            }
        } 

    }

    public String getOrden(){
        return resultado;
    }



    public String getName(){
        return nombre;
    }

    public int getTarget(){
        return target;
    }

    public int getPassword(){
        return password;
    }

    public boolean equals(Usuario user){
        return (user.getTarget() == target && user.getPassword() == password);
    }
    
    public int compareTo(Usuario u){
        if (u.getName().compareTo(nombre)<0) {
            return -1;
        } else if (u.getName().compareTo(nombre)>0)  {
            return 1;
        }
        return 0;
    }

    public String toString(){
        return getName() + " " + apellidos;
    }



}
