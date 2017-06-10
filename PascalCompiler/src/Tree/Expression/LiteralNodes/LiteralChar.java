package Tree.Expression.LiteralNodes;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.CharNode;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class LiteralChar extends ExpressionNode {
     public  char Id ;
    public  LiteralChar( char  cahrVariable){
        this.Id = cahrVariable;
    }
    @Override
    public Semantic.BaseType ValidateSemmantic() {
        return new CharNode();
    }

    @Override
    public String GenerateTreeDimensions() {
        return String.valueOf(Id);
    }
}
