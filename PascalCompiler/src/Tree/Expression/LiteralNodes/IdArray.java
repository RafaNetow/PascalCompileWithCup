package Tree.Expression.LiteralNodes;

import Semantic.BaseType;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.*;
import TreeWaysCode.AssigantionWay;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.MultiWay;

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
        String saveResult =  CuadrupleTable.getInstance().newLabel();
        CuadrupleTable.getInstance().AddCuadruplo( new MultiWay("*",String.valueOf(Value.ValidateSemmantic()),GetValueForBase(),saveResult));
        String valueToReturn = CuadrupleTable.getInstance().newLabel();
        CuadrupleTable.getInstance().AddCuadruplo( new AssigantionWay("=",valueToReturn,value+"["+saveResult+"]"));
        return valueToReturn;
    }


    public String  GetValueForBase( ){
        if(this.ValidateSemmantic() instanceof CharNode)
            return  "2";
        if(this.ValidateSemmantic() instanceof IntNode){
            return  "4";
            if(this.ValidateSemmantic() instanceof  BooleanType)
            return  "2";
            if(this.ValidateSemmantic() instanceof  StringNode)
                return String.valueOf(((LiteralString) Value).value.length());

        }
    }
}
