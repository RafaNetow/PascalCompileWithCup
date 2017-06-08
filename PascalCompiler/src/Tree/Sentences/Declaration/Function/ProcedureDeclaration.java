package Tree.Sentences.Declaration.Function;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.DataType.FunctionType;
import Tree.Expression.DataType.ProcedureType;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 19/05/2017.
 */
public class ProcedureDeclaration extends SentencesNode
{
    public List<ParamsOfFunction> ListOfParams;
    public  String NameOfProcedure;
    public List<SentencesNode> ListOfSentences;


    public ProcedureDeclaration(List<ParamsOfFunction> listOfParams,String nameOfProcedure, List<SentencesNode> listOfSentences){

            this.ListOfParams = listOfParams;
            this.NameOfProcedure = nameOfProcedure;
            this.ListOfSentences = listOfSentences;
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
