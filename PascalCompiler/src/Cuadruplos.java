import Semantic.BaseType;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Daniela Odileth on 25/05/2017.
 */
public class Cuadruplos {

    static Cuadruplos instance;

    static{
        instance = new Cuadruplos();
    }

    public static Cuadruplos getInstance(){
        return  instance;
    }

    private Cuadruplos(){
    }

    public String operador;
    public String argum1;
    public String argum2;
    public String etiq;
    public List<Cuadruplos> ListCuadrupos;

    public Cuadruplos(String op, String a1, String a2, String et){
        operador = op;
        argum1 = a1;
        argum2 = a2;
        etiq = et;
    }

    public void addCuadruplo(Cuadruplos nuevo){
        ListCuadrupos.add(nuevo);
    }

}
