package Tree.Sentences.Declaration;

import Semantic.BaseType;

import Semantic.SymbolTable;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class DeclarationNode extends SentencesNode {
     public BaseType Type;
     public  List<String> ListOfIds;


     public  DeclarationNode(List<String> listOfId, BaseType type){
            this.ListOfIds = listOfId;
            this.Type = type;
     }

     public  DeclarationNode(){};
    @Override
    public void ValidateSemantic() {

       for(String item: ListOfIds){
           SymbolTable.getInstance().declareVariable(item, Type);

       }

    }
}
