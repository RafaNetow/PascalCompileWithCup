package Tree.Expression.LiteralNodes;

import Semantic.BaseType;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.ArrayType;
import Tree.Expression.DataType.DefaultType;
import Tree.Expression.DataType.IdNode;

/**
 * Created by Sequeirios on 05/06/2017.
 */
public class IdArray extends IdNode {

    ExpressionNode Value;

    public  IdArray ( String name, ExpressionNode value){
        super(name);
            this.Value = value;
    }

    @Override
    public BaseType ValidateSemmantic() {
        BaseType Type = SymbolTable.getInstance().getType(this.value);
        if(Type instanceof ArrayType){

            return     ((ArrayType) Type).GetType();
        }

        return new DefaultType();
    }

    @Override
    public String GenerateTreeDimensions() {
        return null;
    }
}
