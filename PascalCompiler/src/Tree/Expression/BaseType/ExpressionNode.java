package Tree.Expression.BaseType;

import Semantic.SemanticSymbol;
import sun.awt.Symbol;
import sun.reflect.generics.tree.BaseType;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public abstract class ExpressionNode {

    public abstract  Semantic.BaseType ValidateSemmantic();
    public  abstract  String    GenerateTreeDimensions();
    public SemanticSymbol Symbol;
    public  String GetPositionError(){
        return  "Error in Line : "+Symbol.Row+" Column: "+Symbol.Column ;
    }

    public  void AddSymbol(SemanticSymbol symbol){
            Symbol = symbol;
    }

}
