package Tree.Sentences.Conditional;

import Semantic.Context;
import Semantic.SemanticSymbol;
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

    public IfNode(ExpressionNode condition, BlockNode blockCode, SemanticSymbol symbol){
            Condition = condition;
           BlockCode = blockCode;
           this.Symbol = symbol;
    }

    @Override
    public void ValidateSemantic() {
        Context.getInstance().Stack.push(new SymbolTable());
        if(!(Condition.ValidateSemmantic() instanceof  BooleanType))
            System.out.println(Condition.GetPositionError()+" Expression at if is no boolean");
       this.BlockCode.ValidateSemantic();
        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());
    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        String newTag = CuadrupleTable.getInstance().GetNextTag();

       BlockCode.SetCondition( Condition.GenerateTreeDimensions());
        return BlockCode.GenrarTresDirecciones(newTag);
    }
}
