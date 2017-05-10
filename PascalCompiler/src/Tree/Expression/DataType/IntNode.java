package Tree.Expression.DataType;

import Tree.Expression.BaseType.DataType;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class IntNode extends DataType{

   int value;

   public  IntNode (int value){
       this.value = value;
   }
    @Override
    public BaseType ValidateSemmantic() {
        return null;
    }
}
