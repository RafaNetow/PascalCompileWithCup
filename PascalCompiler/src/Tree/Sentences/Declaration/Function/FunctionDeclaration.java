package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Tree.Expression.SentencesNode;
import Tree.Sentences.Declaration.DeclarationNode;

import java.util.List;

/**
 * Created by Sequeirios on 16/05/2017.
 */
public class FunctionDeclaration extends SentencesNode {

       public    BaseType TypeOfFunction;
       public List<ParamsOfFunction> ListOfParams;
       public List<SentencesNode> ListOfSentences;
       public DeclarationNode LocalDeclaration;

        public  FunctionDeclaration( List<ParamsOfFunction> list,BaseType type, List<SentencesNode> listOfSentences, SentencesNode declaration){
            TypeOfFunction = type;
            ListOfParams = list;
            ListOfSentences= listOfSentences;
            LocalDeclaration = (DeclarationNode) declaration;
        }

    @Override
    public void ValidateSemantic() {

    }
}
