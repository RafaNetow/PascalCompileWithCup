package Tree.Expression.DataType;


import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class IdNode extends ExpressionNode {

 public String value;
   public  IdNode (String id){
            value = id;

   }

    @Override
    public Semantic.BaseType ValidateSemmantic() {
        return Context.getInstance().Stack.peek().getType(value);
    }

}

