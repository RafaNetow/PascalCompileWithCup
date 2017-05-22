package Tree.BinaryOperator;

import Semantic.BaseType;
import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.IntNode;
import Tree.Expression.DataType.StringNode;
import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class SumNode extends BinaryOperatorNode {


    public SumNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);

    }
}
