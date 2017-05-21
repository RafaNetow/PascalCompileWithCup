package Tree.Expression.DataType;

import Semantic.BaseType;

/**
 * Created by Sequeirios on 19/05/2017.
 */
public class DefaultType extends BaseType {
    @Override
    public boolean IsAssignable(BaseType otherType) {
        return false;
    }
}
