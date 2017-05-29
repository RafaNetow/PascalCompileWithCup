package Tree.Expression.BaseType;

import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public abstract class ExpressionNode {

    public abstract  Semantic.BaseType ValidateSemmantic();
    public  abstract  String    GenerateTreeDimensions();

}
