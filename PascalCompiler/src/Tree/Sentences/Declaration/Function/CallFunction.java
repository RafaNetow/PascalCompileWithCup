package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Semantic.SemanticSymbol;
import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.FunctionType;
import Tree.Expression.DataType.ProcedureType;
import Tree.Expression.SentencesNode;
import com.sun.org.apache.bcel.internal.generic.LLOAD;

import java.util.List;

/**
 * Created by Sequeirios on 17/05/2017.
 */
public class CallFunction extends SentencesNode {

    public String NameOfFunction;
    public  List<ExpressionNode> ListOfParams;


    public CallFunction(String name, List<ExpressionNode> listOfParams, SemanticSymbol sym){
        this.ListOfParams = listOfParams;
        this.NameOfFunction = name;
    }


    public  int getCantOfParams(List<ParamsOfFunction> params){
        int count=0;
        for (ParamsOfFunction param: params) {
            for (String id: param.listId
                 ) {
                count++;
            }
        }
        return count;
        
    }

    @Override
    public void ValidateSemantic() {
      BaseType type =  SymbolTable.getInstance().getType(NameOfFunction);

        int postOfParams =0;
        boolean breakFor = false;

      if(type instanceof ProcedureType){
          ProcedureType function = (ProcedureType)type;

          if(getCantOfParams(function.ListParam)== ListOfParams.size()) {
              for (int i = 0; i < function.ListParam.size() && !breakFor; i++) {

                  for (int o = 0; o < function.ListParam.get(i).listId.size(); o++) {
                      if (ListOfParams.get(postOfParams).ValidateSemmantic().IsAssignable(function.ListParam.get(i).TypeOfParam)) {

                      } else {
                          System.out.println(ListOfParams.get(postOfParams).GetPositionError()+" el paremtro no es del tipo esperado");
                      }

                      postOfParams++;

                      ///    function.ListParam.ge
                  }
              }
          }else{
              System.out.println(ListOfParams.get(0).GetPositionError()+" Numbers of params  are incorect");
          }

      }else{
          System.out.println(ListOfParams.get(0).GetPositionError()+" "+ NameOfFunction+" is not a procedure");
      }


    }

    @Override
    public String GenrarTresDirecciones(String siguiente) {
        return null;
    }
}
