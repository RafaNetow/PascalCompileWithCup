package Tree.BinaryOperator;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class DivNode extends BinaryOperatorNode {
    public DivNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);

    }
}
