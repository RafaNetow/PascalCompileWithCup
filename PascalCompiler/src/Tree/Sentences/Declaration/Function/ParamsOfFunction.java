package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;

import java.util.List;

/**
 * Created by Sequeirios on 16/05/2017.
 */
public class ParamsOfFunction {

    public boolean Reference;
    public List<String> listId;
    public BaseType TypeOfParam;

     public  ParamsOfFunction(boolean reference, List<String> Id, BaseType typeOfParam ){
         this.Reference = reference;
         this.listId = Id;
         this.TypeOfParam = typeOfParam;
     }
}
