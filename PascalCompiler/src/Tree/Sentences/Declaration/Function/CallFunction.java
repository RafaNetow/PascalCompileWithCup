package Tree.Sentences.Declaration.Function;

import Tree.Expression.SentencesNode;
import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.util.List;

/**
 * Created by Sequeirios on 17/05/2017.
 */
public class CallFunction extends SentencesNode {

    public String NameOfFunction;
    public List<String> ListOfParams;

    public CallFunction(String name, List<String> listOfParams){
        this.ListOfParams = listOfParams;
        this.NameOfFunction = name;
    }
    @Override
    public void ValidateSemantic() {
        

    }
}
