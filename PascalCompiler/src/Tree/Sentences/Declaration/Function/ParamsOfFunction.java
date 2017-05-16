package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;

/**
 * Created by Sequeirios on 16/05/2017.
 */
public class ParamsOfFunction {

    public boolean Reference;
    public String NameOfId;
    public BaseType TypeOfParam;

     public  ParamsOfFunction(boolean reference, String id, BaseType typeOfParam ){
         this.Reference = reference;
         this.NameOfId = id;
         this.TypeOfParam = typeOfParam;
     }
}
