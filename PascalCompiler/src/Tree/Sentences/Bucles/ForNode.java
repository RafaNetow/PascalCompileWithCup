package Tree.Sentences.Bucles;

import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class ForNode extends SentencesNode {
    public ExpressionNode FirstCondition;
    public  ExpressionNode SecondCondition;
    public ExpressionNode ThirdCondition;

    public List<SentencesNode> listOfSentences ;

    public  ForNode(ExpressionNode exp1, ExpressionNode exp2, ExpressionNode exp3, List<SentencesNode> list){

    }

    @Override
    public void ValidateSemantic() {

        for (SentencesNode sentence: listOfSentences
             ) {
            sentence.ValidateSemantic();

        }
    }
}
