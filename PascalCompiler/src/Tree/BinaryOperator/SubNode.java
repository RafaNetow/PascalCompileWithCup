package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class SubNode extends BinaryOperatorNode {
    public SubNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }

    @Override
    public String GenerateTreeDimensions() {
        return null;
    }
}
