package Tree.Expression;

import Semantic.SemanticSymbol;

import java.util.UUID;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public abstract class SentencesNode {

    public abstract void ValidateSemantic();
    public UUID CodeGuid = UUID.randomUUID();
    public  abstract  String GenrarTresDirecciones();
    public SemanticSymbol Symbol;

    public  String GetPositionError(){
        return  "Error in Line : "+Symbol.Row+" Column: "+Symbol.Column ;
    }
    public  void AddSymbol(SemanticSymbol symbol){
        Symbol = symbol;
    }
    //public  abstract  void GenerateTreeDirection();
}
