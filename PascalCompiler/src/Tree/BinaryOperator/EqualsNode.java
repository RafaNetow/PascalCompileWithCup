package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.Cuadruplo;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class EqualsNode extends BinaryOperatorNode {
    public EqualsNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }

    @Override
    public String GenerateTreeDimensions() {
        String nameLabel = CuadrupleTable.getInstance().newLabel();
        return nameLabel;
    }
}
