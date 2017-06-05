package Tree.Expression.DataType;

import Semantic.BaseType;

/**
 * Created by Sequeirios on 05/06/2017.
 */
public class ArrayType extends BaseType {
    BaseType Type;

    @Override
    public boolean IsAssignable(BaseType otherType) {
        return Type == otherType;
    }
}
