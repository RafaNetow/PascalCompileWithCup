package Tree.Sentences.Declaration;

import Semantic.BaseType;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;
import java_cup.runtime.Symbol;

import java.util.List;
import java.util.Objects;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class DeclarationNode extends SentencesNode {
     public BaseType Type;
     public  List<String> ListOfIds;
     public Object Symbol;


     public  DeclarationNode(List<String> listOfId, BaseType type, Object symbol){
            this.ListOfIds = listOfId;
            this.Type = type;
            this.Symbol = symbol;
     }

     public  DeclarationNode(){};
    @Override
    public void ValidateSemantic() {

       for(String item: ListOfIds){
           Context.getInstance().Stack.peek()._table.put(item, Type);

       }

    }
}
