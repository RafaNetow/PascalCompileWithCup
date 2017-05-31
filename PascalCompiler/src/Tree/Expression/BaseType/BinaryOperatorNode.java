package Tree.Expression.BaseType;

import Semantic.BaseType;
import Tree.Expression.DataType.*;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.IntType;
import javafx.util.Pair;

import java.util.HashMap;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public  abstract class BinaryOperatorNode extends ExpressionNode{

    public ExpressionNode RightOperand;
    public  ExpressionNode LeftOperand;


    public  BinaryOperatorNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
         this.RightOperand = rightOperand;
         this.LeftOperand = leftOperand;
    }

    public  Semantic.BaseType ValidateSemmantic(){
        Semantic.BaseType leftType = RightOperand.ValidateSemmantic();
        Semantic.BaseType righftType = RightOperand.ValidateSemmantic();

  if( leftType instanceof IntNode && righftType instanceof  IntNode){
      return new IntNode();
  }else if( leftType instanceof StringNode && righftType instanceof  StringNode){
      return  new StringNode();
  }else if( leftType instanceof CharNode && righftType instanceof  CharNode){
      return new CharNode();
  }else if( leftType instanceof BooleanType && righftType instanceof  BooleanType){
      return new BooleanType();
  }
        System.out.printf(this.GetPositionError()+" No se puede realziar esta operacion \n");
            return  new DefaultType();


        }

    };



