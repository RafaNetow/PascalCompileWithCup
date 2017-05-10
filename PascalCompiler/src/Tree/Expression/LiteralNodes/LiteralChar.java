package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class LiteralChar extends ExpressionNode {
     public  char Id ;
    public  LiteralChar( char  cahrVariable){
        this.Id = cahrVariable;
    }
    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
