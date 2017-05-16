package Tree.Expression.BaseType;

import javafx.util.Pair;
import sun.reflect.generics.tree.BaseType;

import java.util.Dictionary;
import java.util.HashMap;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public  abstract class BinaryOperatorNode extends ExpressionNode{

    public ExpressionNode RightOperand;
    public  ExpressionNode LeftOperand;
    public HashMap<Pair<BaseType, BaseType>, BaseType> Validation;

    public  BinaryOperatorNode(ExpressionNode rightOperand, ExpressionNode leftOperand) {
         this.RightOperand = rightOperand;
         this.LeftOperand = leftOperand;
    }

    public  BaseType ValidateSemmantic(){
        BaseType leftType = RightOperand.ValidateSemmantic();
        BaseType righftType = RightOperand.ValidateSemmantic();

//  if( Validation.containsKey(new Pair<>(leftType, righftType))){

  //    return Validation.get(new Pair<>(leftType, righftType));
  //}

    //    System.out.printf("No se peude realziar esta operacion");
            return  null;


        }

    };



