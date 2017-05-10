package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class NumberNode extends ExpressionNode {

    float value;

     public  NumberNode ( float value){
         this.value = value;
     }

    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
