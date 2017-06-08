package Tree.Sentences.Bucles;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;

import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;

import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

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
         System.out.println("Type in while is not boolean");

         for (SentencesNode sentencesNode : ListSentences
                 ) {
             sentencesNode.ValidateSemantic();
         }

         Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());


    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        return null;
    }

    public  WhileNode(ExpressionNode expressionnode, List<SentencesNode> listasecuencia){
        WhileCondition = expressionnode;
        ListSentences = listasecuencia;

    }
}
