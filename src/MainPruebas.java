/**
 * Created by QSM on 18/5/17.
 */
public class MainPruebas {
    private static CaixaRepositorio cr;

    public static CaixaRepositorio getRepositorio(){
        return cr;
    }

    public static void main(String[] args){
        cr = new CaixaRepositorio();
        Usuario u1 = new Usuario("Carlota", "Pérez", 1, 1);
        cr.darAlta(u1);
        u1.setMovimiento("Compra", "+12.40");
        u1.setMovimiento("Vendió la moto", "-123.456");
        u1.setOrder(0);
        System.out.print(u1.getOrden());
        System.out.print("----\n\n");
        u1.setOrder(1);
        System.out.print(u1.getOrden());
        System.out.print("----\n\n");
        u1.setOrder(2);
        System.out.print(u1.getOrden());
        System.out.print("----\n\n");




    }
}
