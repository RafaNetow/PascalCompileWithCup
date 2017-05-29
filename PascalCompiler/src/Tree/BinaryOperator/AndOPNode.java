package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.*;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.Cuadruplo;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class AndOPNode extends BinaryOperatorNode {
    public AndOPNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
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
        String nameLabel = CuadrupleTable.getInstance().newLabel();
        return nameLabel;
    }
}
