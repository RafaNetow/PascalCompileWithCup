package Tree.Sentences.Declaration.Function;

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

        if(SymbolTable.getInstance().declareVariable(NameOfProcedure, new ProcedureType(ListOfParams,ListOfSentences,NameOfProcedure))){

        }else{

        }
    }
}