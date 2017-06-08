package Tree.BinaryOperator;

import Semantic.SymbolTable;
import Tree.Expression.BaseType.BinaryOperatorNode;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.*;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.Cuadruplo;
import TreeWaysCode.GreaterThanWay;
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
        System.out.printf(this.GetPositionError()+" No se puede realziar esta operacion \n");
        return  new DefaultType();
    }

    @Override
    public String GenerateTreeDimensions() {
        String nameLabel = CuadrupleTable.getInstance().newLabel();
        String newTag = CuadrupleTable.getInstance().GetNextTag();
        GreaterThanWay gtw = new GreaterThanWay(">", RightOperand.GenerateTreeDimensions(), newTag, LeftOperand.GenerateTreeDimensions(), nameLabel);
        CuadrupleTable.getInstance().AddCuadruplo(gtw);
        return nameLabel;
    }

}
