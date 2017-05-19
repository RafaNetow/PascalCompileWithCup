package Tree.Expression.DataType;


import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class IntNode extends Semantic.BaseType{

    public boolean IsAssignable(Semantic.BaseType otherType) {
        return otherType instanceof  IntNode;
    }
}
