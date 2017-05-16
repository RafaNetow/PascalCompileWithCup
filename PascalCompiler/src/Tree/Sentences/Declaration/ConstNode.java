package Tree.Sentences.Declaration;

import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.ConstType;
import Tree.Expression.DataType.IdNode;
import Tree.Expression.SentencesNode;

/**
 * Created by Sequeirios on 10/05/2017.
 */
public class ConstNode extends SentencesNode {
    String Id;
    ExpressionNode Literal;

    public ConstNode(String id, ExpressionNode literal){
        this.Id = id;
        this.Literal= literal;
    }

    @Override
    public void ValidateSemantic() {
        SymbolTable.getInstance().declareVariable(Id, new ConstType(Literal));
    }
}
