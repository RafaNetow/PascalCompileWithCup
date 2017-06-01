package Tree.Sentences.Conditional;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;

import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;
import TreeWaysCode.AssigantionWay;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.IfWay;
import TreeWaysCode.SumWay;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class IfNode extends SentencesNode {
    ExpressionNode Condition;

    BlockNode BlockCode;


    public IfNode(ExpressionNode condition, BlockNode blockCode){
            Condition = condition;
        BlockCode = blockCode;
    }

    @Override
    public void ValidateSemantic() {
        Context.getInstance().Stack.push(new SymbolTable());
        if(!(Condition.ValidateSemmantic() instanceof  BooleanType))
            System.out.println("Expression at if is no boolean");
       this.BlockCode.ValidateSemantic();
        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());


    }

    @Override
    public String GenrarTresDirecciones() {
        String newTag = CuadrupleTable.getInstance().GetNextTag();
        String newid = CuadrupleTable.getInstance().newLabel();
        IfWay iw = new IfWay("if", this.Condition.GenerateTreeDimensions(), newid
                ,this.BlockCode.GenrarTresDirecciones(), newTag);
        CuadrupleTable.getInstance().AddCuadruplo(iw);
        return newid;
    }
}
