package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.ArrayType;
import Tree.Expression.SentencesNode;
import sun.awt.Symbol;

/**
 * Created by Sequeirios on 01/06/2017.
 */
public class ArrayDeclaration extends SentencesNode
{
   String Name;
   ExpressionNode FirstRange;
   ExpressionNode SecondRange;
   BaseType Type;
    public ArrayDeclaration (String name, ExpressionNode firstRange, ExpressionNode secondRange, BaseType type, SemanticSymbol symbol){
            this.Name = name;
            this.FirstRange = firstRange;
            this.SecondRange = secondRange;
            Type = type;
          //  Symbol = symbol;
   }

    @Override
    public void ValidateSemantic() {
        SymbolTable.getInstance().declareVariable(Name, new ArrayType(FirstRange,SecondRange,Type));
    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        return siguiente;
    }


}
