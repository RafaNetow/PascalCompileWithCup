package Tree.Sentences.Bucles;

import Semantic.Context;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;
import TreeWaysCode.CuadrupleTable;
import TreeWaysCode.GotoWay;
import TreeWaysCode.IfWay;
import TreeWaysCode.TagWay;

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
            System.out.println(this.GetPositionError()+" Expression is not boolean");
        } Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());
    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {


        String  nextJump = CuadrupleTable.getInstance().GetNextTag();
        String  repeatLogic = CuadrupleTable.getInstance().GetNextTag();
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",siguiente));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",repeatLogic));
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",repeatLogic));
      String currentSiguiente=  CuadrupleTable.getInstance().GetNextTag();

        for (SentencesNode sentencesNode : ListSentences){
       currentSiguiente=sentencesNode.GenrarTresDirecciones(currentSiguiente);
        }
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",currentSiguiente));
        String conditionResul = Condition.GenerateTreeDimensions();
        CuadrupleTable.getInstance().AddCuadruplo( new IfWay("if",conditionResul,"",siguiente));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",nextJump));



        return nextJump;
    }
}

