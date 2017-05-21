package Tree.Expression.DataType;

import Semantic.BaseType;
import Tree.Expression.SentencesNode;
import Tree.Sentences.Declaration.DeclarationNode;
import Tree.Sentences.Declaration.Function.ParamsOfFunction;

import java.util.List;

/**
 * Created by Sequeirios on 21/05/2017.
 */
public class ProcedureType extends BaseType {
    public List<ParamsOfFunction> ListParam;
    public List<SentencesNode> ListOfSentences;
    public  String NameOfFunction;


    public  ProcedureType(List<ParamsOfFunction> listParam, List<SentencesNode> listOfSentences, String nameOfFunction){
        this.ListParam = listParam;
        this.ListOfSentences = listOfSentences;
        NameOfFunction = nameOfFunction;
    }

    @Override
    public boolean IsAssignable(BaseType otherType) {
        return false;
    }
}
