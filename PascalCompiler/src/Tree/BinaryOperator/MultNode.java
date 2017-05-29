package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class MultNode extends BinaryOperatorNode {


    public MultNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }


    @Override
    public String GenerateTreeDimensions() {
        return null;
    }
}
