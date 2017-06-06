package Tree.Expression.DataType;

import Semantic.BaseType;
import Tree.Expression.BaseType.ExpressionNode;

/**
 * Created by Sequeirios on 05/06/2017.
 */
public class ArrayType extends BaseType {
    public ExpressionNode FirstNumber;
   public ExpressionNode SecondNumber;
  public   BaseType Type;

    public  ArrayType (ExpressionNode firstNumber, ExpressionNode secondNumber, BaseType type ){
        this.FirstNumber = firstNumber;
        this.SecondNumber = secondNumber;
        this.Type = type;
    }

    public  BaseType GetType(){
        return  Type;
    }

    @Override
    public boolean IsAssignable(BaseType otherType) {
        if( otherType instanceof  IntNode && Type instanceof  IntNode)
            return  true;
        if( otherType instanceof  CharNode && Type instanceof  CharNode)
            return  true;
        if( otherType instanceof  StringNode && Type instanceof  StringNode)
            return  true;
        if( otherType instanceof  BooleanType && Type instanceof  BooleanType)
            return  true;
        return  false;

    }
}
