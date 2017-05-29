package TreeWaysCode;

/**
 * Created by Daniela Odileth on 29/05/2017.
 */
public class AssigantionWay extends Cuadruplo{
    public String assigment;

    public AssigantionWay(String operand, String argm1) {
        super(operand, argm1);
    }

    public AssigantionWay(String operand, String argm1, String assigment) {
        super(operand, argm1);
        this.assigment = assigment;
    }
}
