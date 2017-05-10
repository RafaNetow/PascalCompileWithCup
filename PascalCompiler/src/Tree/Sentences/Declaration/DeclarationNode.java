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
   public  List<String> ListOfIds;


     public  DeclarationNode(List<String> listOfId, DataType type){
            this.ListOfIds = listOfId;
            this.Type = type;
     }


    @Override
    public void ValidateSemantic() {

    }
}
