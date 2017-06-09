package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.MultiWay;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class MultNode extends BinaryOperatorNode {


    public MultNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }


    @Override
    public String GenerateTreeDimensions() {
        String newId = CuadrupleTable.getInstance().newLabel();

        MultiWay mw = new MultiWay("*", RightOperand.GenerateTreeDimensions(), LeftOperand.GenerateTreeDimensions(),
                newId);
        CuadrupleTable.getInstance().AddCuadruplo(mw);
        return newId;
    }
}
