package TreeWaysCode;

/**
 * Created by Daniela Odileth on 29/05/2017.
 */
public class OptionalArgument extends Cuadruplo {
    public String argm2;
    public String tag;

    public OptionalArgument(String operand, String argm1, String tag, String argm2, String label) {
        super(operand, argm1, tag);
        this.argm2 = argm2;
        this.tag = tag;
    }
}