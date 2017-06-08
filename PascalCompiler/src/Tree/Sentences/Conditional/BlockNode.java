package Tree.Sentences.Conditional;

import Tree.Expression.SentencesNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.GotoWay;
import TreeWaysCode.IfWay;
import TreeWaysCode.TagWay;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sequeirios on 12/05/2017.
 */
public class BlockNode extends SentencesNode {
    List<SentencesNode> TrueBlock ;
    BlockNode ElseBlock;
    String Condition;



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

    public  void SetCondition( String condition){
        this.Condition = condition;
    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        String trueTag = CuadrupleTable.getInstance().GetNextTag();
        String falseTag = CuadrupleTable.getInstance().GetNextTag();

        CuadrupleTable.getInstance().AddCuadruplo(new IfWay("if",Condition,trueTag,"",""));
        CuadrupleTable.getInstance().AddCuadruplo(new GotoWay("goto",falseTag));


        CuadrupleTable.getInstance().AddCuadruplo((new TagWay("label",trueTag)));
        for (SentencesNode sn : TrueBlock
             ) {
            sn.GenrarTresDirecciones(siguiente);
        }
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",falseTag));
        if(ElseBlock!= null)
         ElseBlock.GenrarTresDirecciones(siguiente);


         return  siguiente;

    }
}
