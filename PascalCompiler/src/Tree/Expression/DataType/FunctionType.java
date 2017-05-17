package Tree.Expression.DataType;

import Semantic.BaseType;
import Tree.Expression.SentencesNode;
import Tree.Sentences.Declaration.DeclarationNode;
import Tree.Sentences.Declaration.Function.ParamsOfFunction;

import java.util.List;

/**
 * Created by Sequeirios on 17/05/2017.
 */
public class FunctionType extends BaseType {

    public List<ParamsOfFunction> ListParam;
    public  BaseType TypeToReturn;
    public List<SentencesNode> ListOfSentences;
    public DeclarationNode LocalDeclaration;
    public  String NameOfFunction;


    public  FunctionType(List<ParamsOfFunction> listParam, BaseType typeToReturn, List<SentencesNode> listOfSentences, DeclarationNode localDeclaration, String nameOfFunction){
        this.ListParam = listParam;
        this.TypeToReturn = typeToReturn;
        this.ListOfSentences = listOfSentences;
        this.LocalDeclaration = localDeclaration;
        NameOfFunction = nameOfFunction;
    }
    @Override
    public boolean IsAssignable(BaseType otherType) {
        return false;
    }
}
