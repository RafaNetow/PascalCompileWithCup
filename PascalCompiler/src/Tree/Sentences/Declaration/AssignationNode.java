package Tree.Sentences.Declaration;

import Semantic.BaseType;
import Semantic.Context;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;
import TreeWaysCode.AssigantionWay;
import TreeWaysCode.CuadrupleTable;
import sun.awt.Symbol;

/**
 * Created by Sequeirios on 05/05/2017.
 */
public class AssignationNode extends SentencesNode {

    public  String Id;

    public ExpressionNode ExpressionToAssign;


    public  AssignationNode (String id, ExpressionNode exp, SemanticSymbol sym){
        this.Id = id;
        this.ExpressionToAssign= exp;
        this.Symbol = sym;
    }


    @Override
    public void ValidateSemantic() {

       if(Context.getInstance().Stack.peek().foundVariable(this.Id)){
            if(!(Context.getInstance().Stack.peek().getVariable(Id).IsAssignable(ExpressionToAssign.ValidateSemmantic()))){
                System.out.println(ExpressionToAssign.GetPositionError()+" Allocation is not allowed to Id: "+Id+"\n");
            }
       }else{

          System.out.println(GetPositionError()+" "+this.Id+" doesn't exist\n");
       }


    }

    @Override
    public String GenrarTresDirecciones() {
        AssigantionWay aw = new AssigantionWay("=", this.ExpressionToAssign.GenerateTreeDimensions(), this.Id);
        CuadrupleTable.getInstance().AddCuadruplo(aw);
        return Id;
    }
}
