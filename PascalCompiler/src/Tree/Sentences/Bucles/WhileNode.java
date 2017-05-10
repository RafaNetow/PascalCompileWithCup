package Tree.Sentences.Bucles;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class WhileNode extends SentencesNode {

    public ExpressionNode WhileCondition;
    public List<SentencesNode> ListSentences;




    @Override
    public void ValidateSemantic() {

        for (SentencesNode sentencesNode : ListSentences
             ) {
            sentencesNode.ValidateSemantic();
        }
    }
}
