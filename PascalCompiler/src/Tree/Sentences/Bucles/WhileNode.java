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

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.Condition;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class WhileNode extends SentencesNode {

    public ExpressionNode WhileCondition;
    public List<SentencesNode> ListSentences;




    @Override
    public void ValidateSemantic() {

        Context.getInstance().Stack.push( new SymbolTable());
        if(!(WhileCondition.ValidateSemmantic() instanceof BooleanType))
         System.out.println(WhileCondition.GetPositionError()+" Type in while is not boolean");

         for (SentencesNode sentencesNode : ListSentences
                 ) {
             sentencesNode.ValidateSemantic();
         }

         Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());


    }

    @Override
    public String GenrarTresDirecciones(String siguiente)


    {
        String whileEtiqueta =    CuadrupleTable.getInstance().GetNextTag();
        String trueResult = CuadrupleTable.getInstance().GetNextTag();
          CuadrupleTable.getInstance().AddCuadruplo(new TagWay("label",whileEtiqueta));
          String whileResult=  this.WhileCondition.GenerateTreeDimensions();
          CuadrupleTable.getInstance().AddCuadruplo(new IfWay("if",whileResult,"",trueResult));
          CuadrupleTable.getInstance().AddCuadruplo(new GotoWay("goto",siguiente));
          CuadrupleTable.getInstance().AddCuadruplo(new TagWay("label",trueResult));
          String currentSig = siguiente;
        for (SentencesNode sentences: ListSentences
             ) {
              currentSig=  sentences.GenrarTresDirecciones(currentSig);
        }



        return null;
    }

    public  WhileNode(ExpressionNode expressionnode, List<SentencesNode> listasecuencia, SemanticSymbol symbol){
        WhileCondition = expressionnode;
        ListSentences = listasecuencia;
        this.Symbol = symbol;
    }
}
