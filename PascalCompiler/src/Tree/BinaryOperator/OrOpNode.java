package Tree.BinaryOperator;

import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.*;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.OrOpWay;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class OrOpNode extends BinaryOperatorNode {
    public OrOpNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
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
        String newTag = CuadrupleTable.getInstance().GetNextTag();
        String newid = CuadrupleTable.getInstance().newLabel();

        OrOpWay oow = new OrOpWay("or", this.RightOperand.GenerateTreeDimensions(), newTag,
                this.LeftOperand.GenerateTreeDimensions(), newid);
        CuadrupleTable.getInstance().AddCuadruplo(oow);

        return newid;
    }
}
