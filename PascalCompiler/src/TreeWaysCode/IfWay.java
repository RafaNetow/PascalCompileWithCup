package TreeWaysCode;

/**
 * Created by Daniela Odileth on 30/05/2017.
 */
public class IfWay extends Cuadruplo{
    public String Armg2;
    public String TagToJump;

    public IfWay(String operand, String argm1,  String armg2, String tagToJump) {
        super(operand, argm1);
        Armg2 = armg2;
        this.TagToJump = tagToJump;
        
    }
}
