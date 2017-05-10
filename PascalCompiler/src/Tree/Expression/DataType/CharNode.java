package Tree.Expression.DataType;

import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 08/05/2017.
 */
public class CharNode extends Semantic.BaseType {

    @Override
    public boolean IsAssignable(Semantic.BaseType otherType) {
        return otherType instanceof  StringNode;
    }
}