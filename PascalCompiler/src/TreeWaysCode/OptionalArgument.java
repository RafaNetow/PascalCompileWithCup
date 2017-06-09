package TreeWaysCode;

/**
 * Created by Daniela Odileth on 29/05/2017.
 */
public class OptionalArgument extends Cuadruplo {
    public String argm2;
    public String Label;


    public OptionalArgument(String operand, String argm1, String argm2, String label) {
        super(operand, argm1);
        this.argm2 = argm2;
        this.Label = label;
    }
}