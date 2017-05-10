package Tree.Sentences.Bucles;

import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class RepeatNode extends SentencesNode {

    List<SentencesNode> listSentences;
    @Override
    public void ValidateSemantic() {
        for (SentencesNode sentence: listSentences
             ) {
                sentence.ValidateSemantic();
        }
    }
}
