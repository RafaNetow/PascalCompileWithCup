package Tree.Sentences.Bucles;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.BooleanType;
import Tree.Expression.DataType.IntNode;
import Tree.Expression.SentencesNode;
import javafx.beans.binding.IntegerExpression;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class ForNode extends SentencesNode {
    public ExpressionNode FirstCondition;
    public  ExpressionNode SecondCondition;
    public List<SentencesNode> listOfSentences ;


    public  ForNode(ExpressionNode exp1, ExpressionNode exp2, List<SentencesNode> list){
        FirstCondition = exp1;
        SecondCondition = exp2;
        listOfSentences = list;
    }

    @Override
    public void ValidateSemantic() {

        Context.getInstance().Stack.push( new SymbolTable());
        if(FirstCondition.ValidateSemmantic() instanceof IntNode) {

        }else{
            System.out.println("Condicion no int");
        }
        if(SecondCondition.ValidateSemmantic() instanceof IntNode){

        }else{
            System.out.println("Condicion no int");
        }
        for (SentencesNode sentence: listOfSentences
             ) {
            sentence.ValidateSemantic();

        }

        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());

    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        return null;
    }
}
