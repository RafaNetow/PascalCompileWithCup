package Tree.Expression.DataType;

import Semantic.BaseType;
import Tree.Expression.BaseType.ExpressionNode;

/**
 * Created by Sequeirios on 05/06/2017.
 */
public class ArrayType extends BaseType {
    ExpressionNode FirstNumber;
    ExpressionNode SecondNumber;
    BaseType Type;

    public  ArrayType (ExpressionNode firstNumber, ExpressionNode secondNumber, BaseType type ){
        this.FirstNumber = firstNumber;
        this.SecondNumber = secondNumber;
        this.Type = type;
    }

    @Override
    public boolean IsAssignable(BaseType otherType) {
        return Type == otherType;
    }
}
