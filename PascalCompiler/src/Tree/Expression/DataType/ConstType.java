package Tree.Expression.DataType;

import Semantic.BaseType;
import Tree.Expression.BaseType.ExpressionNode;
import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;

/**
 * Created by Sequeirios on 11/05/2017.
 */
public class ConstType extends BaseType  {
   public ExpressionNode Literal;

    public ConstType(ExpressionNode literal){
        this.Literal = literal;
    }

    @Override
    public boolean IsAssignable(BaseType otherType) {
        return false;
    }
}
