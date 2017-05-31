package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Semantic.SemanticSymbol;

import java.util.List;

/**
 * Created by Sequeirios on 16/05/2017.
 */
public class ParamsOfFunction {

    public boolean Reference;
    public List<String> listId;
    public BaseType TypeOfParam;
    public  SemanticSymbol Symbol;

     public  ParamsOfFunction(boolean reference, List<String> Id, BaseType typeOfParam, SemanticSymbol sym){
         this.Reference = reference;
         this.listId = Id;
         this.TypeOfParam = typeOfParam;
         this.Symbol = sym;
     }
}
