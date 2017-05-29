package TreeWaysCode;

import java.util.List;

/**
 * Created by Daniela Odileth on 29/05/2017.
 */
public class CuadrupleTable {
    static CuadrupleTable instance;

    static {
        instance = new CuadrupleTable();
    }

    public static CuadrupleTable getInstance() { return instance;}

    public CuadrupleTable(){
    }

    public List<Cuadruplo> tabla;
    public int num = 1;

    public void AddCuadruplo(Cuadruplo cuadruplo){
        tabla.add(cuadruplo);

    }

    public String newLabel(){
        String nueva = "t"+num;
        num++;
        return nueva;
    }
}
