package Tree.Sentences.Bucles;

import Semantic.Context;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.BooleanType;
import Tree.Expression.DataType.IntNode;
import Tree.Expression.SentencesNode;
import TreeWaysCode.*;
import javafx.beans.binding.IntegerExpression;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class ForNode extends SentencesNode {
    public ExpressionNode FirstCondition;
    public  ExpressionNode SecondCondition;
    public List<SentencesNode> listOfSentences ;
    public  String Id;

    public  ForNode(String id,ExpressionNode exp1, ExpressionNode exp2, List<SentencesNode> list, SemanticSymbol sym){
        FirstCondition = exp1;
        SecondCondition = exp2;
        listOfSentences = list;
        this.Symbol = sym;
        this.Id = id;
    }

    @Override
    public void ValidateSemantic() {

        Context.getInstance().Stack.push( new SymbolTable());
        if(FirstCondition.ValidateSemmantic() instanceof IntNode) {

        }else{
            System.out.println(FirstCondition.GetPositionError()+" Condicion no int");
        }
        if(SecondCondition.ValidateSemmantic() instanceof IntNode){

        }else{
            System.out.println(SecondCondition.GetPositionError()+"Condicion no int");
        }
        for (SentencesNode sentence: listOfSentences
             ) {
            sentence.ValidateSemantic();

        }

        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());

    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {


        String nextJump = CuadrupleTable.getInstance().GetNextTag();
        String trueLabel = CuadrupleTable.getInstance().GetNextTag();
        String count = CuadrupleTable.getInstance().newLabel();
        CuadrupleTable.getInstance().AddCuadruplo( new InitCount("count",count,FirstCondition.GenerateTreeDimensions()));
        CuadrupleTable.getInstance().AddCuadruplo(new TagWay("label",siguiente));
        String resultCondition = CuadrupleTable.getInstance().newLabel();
        CuadrupleTable.getInstance().AddCuadruplo( new LessThanWay("<",count,SecondCondition.GenerateTreeDimensions(),resultCondition));

        CuadrupleTable.getInstance().AddCuadruplo( new IfWay("if",resultCondition,"",trueLabel));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",nextJump));

        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",trueLabel));
        String currentSig = CuadrupleTable.getInstance().GetNextTag();
        for (SentencesNode sentences: this.listOfSentences
                ) {
            currentSig=  sentences.GenrarTresDirecciones(currentSig);
        }
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",currentSig));
        CuadrupleTable.getInstance().AddCuadruplo(new SumWay("+",count,"1",count));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",siguiente));


        return nextJump;
    }
}
