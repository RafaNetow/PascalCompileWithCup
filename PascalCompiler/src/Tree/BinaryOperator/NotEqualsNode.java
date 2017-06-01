package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.*;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.NotEqualsWay;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class NotEqualsNode extends BinaryOperatorNode {
    public NotEqualsNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
        super(rightOperand, leftOperand);
    }

    public  Semantic.BaseType ValidateSemmantic(){
        if( this.LeftOperand.ValidateSemmantic() instanceof IntNode && this.RightOperand.ValidateSemmantic() instanceof  IntNode){
            return new BooleanType();
        }else if( this.LeftOperand.ValidateSemmantic() instanceof StringNode && this.RightOperand.ValidateSemmantic() instanceof  StringNode){
            return  new BooleanType();
        }else if( this.LeftOperand.ValidateSemmantic() instanceof CharNode && this.RightOperand.ValidateSemmantic() instanceof  CharNode){
            return new BooleanType();
        }else if( this.LeftOperand.ValidateSemmantic() instanceof BooleanType && this.RightOperand.ValidateSemmantic() instanceof  BooleanType){
            return new BooleanType();
        }
        System.out.printf("No se puede realziar esta operacion \n");
        return  new DefaultType();
    }

    @Override
    public String GenerateTreeDimensions() {
        String newId = CuadrupleTable.getInstance().newLabel();
        String newTag = CuadrupleTable.getInstance().GetNextTag();

        NotEqualsWay neway = new NotEqualsWay("!=", RightOperand.GenerateTreeDimensions(), newTag,
                LeftOperand.GenerateTreeDimensions(), newId);
        CuadrupleTable.getInstance().AddCuadruplo(neway);

        return  newId;
    }
}
