package Tree.Sentences.Declaration;

import Semantic.BaseType;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class AssignationNode extends SentencesNode {

    public  String Id;

    public ExpressionNode ExpressionToAssign;


    public  AssignationNode (String id, ExpressionNode exp){
        this.Id = id;
        this.ExpressionToAssign= exp;
    }


    @Override
    public void ValidateSemantic() {

       if(SymbolTable.getInstance()._table.containsKey(this.Id)){
            if(!(SymbolTable.getInstance().getType(this.Id).IsAssignable((BaseType) ExpressionToAssign.ValidateSemmantic()))){
                System.out.println("Allocation is not allowed\n");
            }
       }else{
           SymbolTable table = SymbolTable.getInstance();
          System.out.println("Id "+this.Id+" doesnt exist\n");
       }


    }
}
