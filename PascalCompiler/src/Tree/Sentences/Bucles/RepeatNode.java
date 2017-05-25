package Tree.Sentences.Bucles;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class RepeatNode extends SentencesNode {

    ExpressionNode Condition;
    List<SentencesNode> ListSentences;

    public RepeatNode(ExpressionNode condition, List<SentencesNode> sentences){
        this.Condition = condition;
        this.ListSentences = sentences;
    }
    @Override
    public void
    ValidateSemantic() {
        Context.getInstance().Stack.push(new SymbolTable());
        if(Condition.ValidateSemmantic() instanceof BooleanType){
            for (SentencesNode sentences:
                 ListSentences) {
                    sentences.ValidateSemantic();
            }
        }else{
            System.out.println("Expression is not boolean");
        } Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());
    }
}

