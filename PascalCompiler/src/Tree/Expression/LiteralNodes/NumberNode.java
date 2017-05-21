package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.IntNode;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class NumberNode extends ExpressionNode {

    float value;

     public  NumberNode ( float value){
         this.value = value;
     }

    @Override
    public Semantic.BaseType ValidateSemmantic() {
        return new IntNode();
    }
}
