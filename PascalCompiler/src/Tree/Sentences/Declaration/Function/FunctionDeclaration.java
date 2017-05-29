package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.DataType.FunctionType;
import Tree.Expression.SentencesNode;
import Tree.Sentences.Declaration.DeclarationNode;

import javax.print.attribute.standard.MediaSize;
import java.util.List;

/**
 * Created by Sequeirios on 16/05/2017.
 */
public class FunctionDeclaration extends SentencesNode {

       public    BaseType TypeOfFunction;
       public List<ParamsOfFunction> ListOfParams;
       public List<SentencesNode> ListOfSentences;
       public DeclarationNode LocalDeclaration;
       public  String NameOfFunction;

        public  FunctionDeclaration( List<ParamsOfFunction> list,BaseType type, List<SentencesNode> listOfSentences, SentencesNode declaration, String nameOfFunction){
            TypeOfFunction = type;
            ListOfParams = list;
            ListOfSentences= listOfSentences;
            LocalDeclaration = (DeclarationNode) declaration;
            NameOfFunction = nameOfFunction;
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
        if(Context.getInstance().Stack.peek().declareVariable(NameOfFunction, new FunctionType(ListOfParams,TypeOfFunction,ListOfSentences,LocalDeclaration,NameOfFunction))){

        }else{

        }
    }

    @Override
    public String GenrarTresDirecciones() {
        return null;
    }
}
