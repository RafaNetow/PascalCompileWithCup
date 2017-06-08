package Tree.Sentences.Declaration;

import Semantic.Context;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.SentencesNode;
import TreeWaysCode.TagWay;
import TreeWaysCode.AssigantionWay;
import TreeWaysCode.CuadrupleTable;
import sun.awt.Symbol;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class AssignationNode extends SentencesNode {

    public  IdNode Id;

    public ExpressionNode ExpressionToAssign;


    public  AssignationNode (IdNode id, ExpressionNode exp, SemanticSymbol sym){
        this.Id = id;
        this.ExpressionToAssign= exp;
        this.Symbol = sym;
    }


    @Override
    public void ValidateSemantic() {

       if(Context.getInstance().Stack.peek().foundVariable(this.Id.value)){
            if(!(Context.getInstance().Stack.peek().getVariable(Id.value).IsAssignable(ExpressionToAssign.ValidateSemmantic()))){
                System.out.println(ExpressionToAssign.GetPositionError()+" Allocation is not allowed to Id: "+Id.value+"\n");
            }
       }else{

          System.out.println(GetPositionError()+" "+this.Id.value+" doesn't exist\n");
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
