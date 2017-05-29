package Tree.Sentences.Conditional;

import Tree.Expression.SentencesNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sequeirios on 12/05/2017.
 */
public class BlockNode extends SentencesNode {
    List<SentencesNode> TrueBlock ;
    BlockNode ElseBlock;

//only one sentences
    public BlockNode (SentencesNode sentence){
        TrueBlock = new ArrayList<>();
        TrueBlock.add(sentence);

    }

    public  BlockNode (List<SentencesNode> blockSentences, BlockNode elseBlock){
        TrueBlock  = blockSentences;
        ElseBlock = elseBlock;
    }

    public  BlockNode (){
        TrueBlock  = new ArrayList<>();
        ElseBlock = null;
    }
    @Override
    public void ValidateSemantic() {
        for (SentencesNode sentences:
             TrueBlock) {
            sentences.ValidateSemantic();
        }
        if(ElseBlock !=null)
        ElseBlock.ValidateSemantic();
    }

    @Override
    public String GenrarTresDirecciones() {
        return null;
    }
}
