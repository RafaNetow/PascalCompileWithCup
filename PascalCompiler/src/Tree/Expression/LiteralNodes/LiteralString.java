package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class LiteralString extends ExpressionNode {
     String value;

     public LiteralString(String value){
          this.value = value;
     }
    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
