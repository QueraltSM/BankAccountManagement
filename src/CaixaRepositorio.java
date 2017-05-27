/**
 * Created by QSM on 18/5/17.
 */
import java.util.*;

public class CaixaRepositorio {
    private SortedSet <Usuario> usuarios = new TreeSet<Usuario>();

    public void darAlta(Usuario u){
        usuarios.add(u);
    }

    public ArrayList<Usuario> getUsuarios(){
        ArrayList <Usuario> res = new ArrayList<>();
        for (Usuario i : usuarios) {
            res.add(i);
        }
        return res;
    }

}
