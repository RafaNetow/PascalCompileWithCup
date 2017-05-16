package Tree.Sentences.Conditional;

import Tree.Expression.BaseType.ExpressionNode;

import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;
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

        if(true/*Condition.ValidateSemmantic() instanceof BooleanType*/){
            BlockCode.ValidateSemantic();
        }else{
            System.out.println("Expression is not a boolean");
        }


    }
}
