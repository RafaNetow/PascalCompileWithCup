package Tree.Expression.BaseType;

import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class BinaryOperatorNode extends ExpressionNode{

    public ExpressionNode RightOperand;
    public  ExpressionNode LeftOperand;


    public  BinaryOperatorNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
         this.RightOperand = rightOperand;
         this.LeftOperand = leftOperand;
    }

    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
