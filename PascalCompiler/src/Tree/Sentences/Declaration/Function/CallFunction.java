package Tree.Sentences.Declaration.Function;

import Semantic.BaseType;
import Semantic.SymbolTable;
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
    public List<String> ListOfParams;

    public CallFunction(String name, List<String> listOfParams){
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
      BaseType type =  SymbolTable.getInstance()._table.get(NameOfFunction);

        int postOfParams =0;
        boolean breakFor = false;

      if(type instanceof ProcedureType){
          ProcedureType function = (ProcedureType)type;

          if(getCantOfParams(function.ListParam)== ListOfParams.size()) {
              for (int i = 0; i < function.ListParam.size() && !breakFor; i++) {

                  for (int o = 0; o < function.ListParam.get(i).listId.size(); o++) {
                      if (SymbolTable.getInstance()._table.get(ListOfParams.get(postOfParams)).IsAssignable(function.ListParam.get(i).TypeOfParam)) {

                      } else {
                          System.out.println("el paremtro no es del tipo esperado");
                      }

                      postOfParams++;

                      ///    function.ListParam.ge
                  }
              }
          }else{
              System.out.println("Numbers of params  are incorect");
          }

      }else{
          System.out.println(NameOfFunction+" is not a procedure");
      }


    }
}
