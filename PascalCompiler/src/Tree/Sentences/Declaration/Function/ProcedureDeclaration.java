package Tree.Sentences.Declaration.Function;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.DataType.FunctionType;
import Tree.Expression.DataType.ProcedureType;
import Tree.Expression.SentencesNode;
import java_cup.runtime.Symbol;

import java.util.List;
import java.util.Objects;

/**
 * Created by Sequeirios on 19/05/2017.
 */
public class ProcedureDeclaration extends SentencesNode
{
    public List<ParamsOfFunction> ListOfParams;
    public  String NameOfProcedure;
    public List<SentencesNode> ListOfSentences;
    public  Object Symbol;


    public ProcedureDeclaration(List<ParamsOfFunction> listOfParams,String nameOfProcedure, List<SentencesNode> listOfSentences, Object sym){

            this.ListOfParams = listOfParams;
            this.NameOfProcedure = nameOfProcedure;
            this.ListOfSentences = listOfSentences;
            Symbol= sym;
    }
    @Override
    public void ValidateSemantic() {
        Context.getInstance().Stack.push( new SymbolTable());
        for (ParamsOfFunction param : ListOfParams) {
            for (String variable : param.listId) {
                SymbolTable.getInstance().declareVariable(variable, param.TypeOfParam);
            }
        }
        for (SentencesNode sentence: ListOfSentences) {
            sentence.ValidateSemantic();
        }


        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());
        if(Context.getInstance().Stack.peek().declareVariable(NameOfProcedure, new ProcedureType(ListOfParams,ListOfSentences,NameOfProcedure))){

        }else{

        }
    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        return null;
    }
}
