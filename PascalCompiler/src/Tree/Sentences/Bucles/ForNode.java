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
        if(SymbolTable.getInstance().getType(Id) instanceof  IntNode){
            System.out.println("Error line :"+Symbol.Row + "column: "+Symbol.Column +  " ID:"+ this.Id+ "Isn't a integer" );
        }

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
        String initFor = CuadrupleTable.getInstance().GetNextTag();

        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",siguiente));
        CuadrupleTable.getInstance().AddCuadruplo( new AssigantionWay("=",Id,FirstCondition.GenerateTreeDimensions()));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",initFor));

        CuadrupleTable.getInstance().AddCuadruplo(new TagWay("label",initFor));
        String resultCondition = CuadrupleTable.getInstance().newLabel();
        CuadrupleTable.getInstance().AddCuadruplo( new LessThanWay("<",Id,SecondCondition.GenerateTreeDimensions(),resultCondition));

        CuadrupleTable.getInstance().AddCuadruplo( new IfWay("if",resultCondition,"",trueLabel));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",nextJump));

        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",trueLabel));
        String currentSig = CuadrupleTable.getInstance().GetNextTag();
        for (SentencesNode sentences: this.listOfSentences
                ) {
            currentSig=  sentences.GenrarTresDirecciones(currentSig);
        }
        CuadrupleTable.getInstance().AddCuadruplo( new TagWay("label",currentSig));
        CuadrupleTable.getInstance().AddCuadruplo(new SumWay("+",Id,"1",Id));
        CuadrupleTable.getInstance().AddCuadruplo( new GotoWay("goto",initFor));


        return nextJump;
    }
}
