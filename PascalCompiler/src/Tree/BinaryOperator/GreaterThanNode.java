package Tree.BinaryOperator;

import Semantic.SymbolTable;
import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import javafx.util.Pair;
import sun.reflect.generics.tree.BaseType;

import java.util.HashMap;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class GreaterThanNode extends BinaryOperatorNode {
    public GreaterThanNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }



}
