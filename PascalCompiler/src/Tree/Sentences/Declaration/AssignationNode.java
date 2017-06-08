package Tree.Sentences.Declaration;

import Semantic.Context;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.SentencesNode;
import TreeWaysCode.TagWay;
import TreeWaysCode.AssigantionWay;
import TreeWaysCode.CuadrupleTable;

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

       if(Context.getInstance().Stack.peek().foundVariable(this.Id)){
            if(!(Context.getInstance().Stack.peek().getVariable(Id).IsAssignable(ExpressionToAssign.ValidateSemmantic()))){
                System.out.println("Allocation is not allowed to Id: "+Id+"\n");
            }
       }else{

          System.out.println("Id "+this.Id+" doesnt exist\n");
       }


    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        String newTag = CuadrupleTable.getInstance().GetNextTag();
        CuadrupleTable.getInstance().AddCuadruplo(new TagWay("label", newTag));
        AssigantionWay aw = new AssigantionWay(":=", this.ExpressionToAssign.GenerateTreeDimensions(), this.Id );
        CuadrupleTable.getInstance().AddCuadruplo(aw);
        return newTag;
    }
}
