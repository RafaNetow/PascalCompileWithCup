package Tree.Sentences.Declaration;

import Semantic.Context;
import Semantic.SemanticSymbol;
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

    public ConstNode(String id, ExpressionNode literal, SemanticSymbol sym){
        this.Id = id;
        this.Literal= literal;
        this.Symbol = sym;
    }

    @Override
    public void ValidateSemantic() {
        Context.getInstance().Stack.peek()._table.put(Id, new ConstType(Literal));
    }

    @Override
    public String GenrarTresDirecciones() {
        return null;
    }
}
