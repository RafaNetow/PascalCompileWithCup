package Tree.Sentences.Declaration;

import Tree.Expression.BaseType.DataType;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class DeclarationNode extends SentencesNode {
     public DataType Type;
     List<IdNode> listOfIds;


    @Override
    public void ValidateSemantic() {

    }
}
