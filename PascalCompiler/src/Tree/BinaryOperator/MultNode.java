package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class MultNode extends BinaryOperatorNode {


    public MultNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }

    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
