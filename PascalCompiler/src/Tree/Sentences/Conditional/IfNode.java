package Tree.Sentences.Conditional;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.SentencesNode;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class IfNode extends SentencesNode {
    ExpressionNode Condition;
    List<SentencesNode> listOfSentences;

    public IfNode(ExpressionNode exp1, ExpressionNode exp2, ExpressionNode exp3){

    }

    @Override
    public void ValidateSemantic() {
        for (SentencesNode sentence: listOfSentences
             ) {
         sentence.ValidateSemantic();
        }
    }
}
