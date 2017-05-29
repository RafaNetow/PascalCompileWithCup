package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.StringNode;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class LiteralString extends ExpressionNode {
     String value;

     public LiteralString(String value){
          this.value = value;
     }
    @Override
    public Semantic.BaseType ValidateSemmantic() {
        return new StringNode();
    }

    @Override
    public String GenerateTreeDimensions() {
        return null;
    }
}
