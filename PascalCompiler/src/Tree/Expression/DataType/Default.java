package Tree.Expression.DataType;

import Semantic.BaseType;

/**
 * Created by Sequeirios on 21/05/2017.
 */
public class Default extends BaseType {
    @Override
    public boolean IsAssignable(BaseType otherType) {
        return false;
    }
}
