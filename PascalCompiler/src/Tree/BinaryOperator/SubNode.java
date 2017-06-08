package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.SubWay;
import TreeWaysCode.SumWay;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class SubNode extends BinaryOperatorNode {
    public SubNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }

    @Override
    public String GenerateTreeDimensions() {
        SubWay sw;
        String nameLabel = CuadrupleTable.getInstance().newLabel();
        String newTag = CuadrupleTable.getInstance().GetNextTag();
        sw = new SubWay("+", this.RightOperand.GenerateTreeDimensions(), newTag,
                this.LeftOperand.GenerateTreeDimensions(), nameLabel);
        CuadrupleTable.getInstance().AddCuadruplo(sw);
        return nameLabel;
    }
}
