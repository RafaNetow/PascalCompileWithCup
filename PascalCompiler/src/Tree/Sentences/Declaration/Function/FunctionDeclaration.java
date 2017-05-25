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
        for (SentencesNode sentence: ListOfSentences) {
            sentence.ValidateSemantic();
        }


        if(Context.getInstance().Stack.peek().declareVariable(NameOfFunction, new FunctionType(ListOfParams,TypeOfFunction,ListOfSentences,LocalDeclaration,NameOfFunction))){

        }else{

        }
        Context.getInstance().TableToRemind.put(CodeGuid, Context.getInstance().Stack.pop());
    }
}
