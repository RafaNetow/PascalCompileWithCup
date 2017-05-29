package Tree.BinaryOperator;

import Semantic.BaseType;
import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.IntNode;
import Tree.Expression.DataType.StringNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.Cuadruplo;
import TreeWaysCode.SumWay;
import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class SumNode extends BinaryOperatorNode {

    public SumNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);

    }

    @Override
    public String GenerateTreeDimensions() {
        SumWay sw;
        String nameLabel = CuadrupleTable.getInstance().newLabel();
        sw = new SumWay("+", this.RightOperand.GenerateTreeDimensions(), this.LeftOperand.GenerateTreeDimensions(), nameLabel);
        CuadrupleTable.getInstance().AddCuadruplo(sw);
        return nameLabel;
    }
}
