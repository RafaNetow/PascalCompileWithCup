package Tree.Sentences.Declaration.Function;

import Semantic.SymbolTable;
import Tree.Expression.BaseType.ExpressionNode;
import Tree.Expression.DataType.DefaultType;
import Tree.Expression.DataType.FunctionType;
import sun.reflect.generics.tree.BaseType;

import java.util.List;

/**
 * Created by Sequeirios on 19/05/2017.
 */
public class CallFunctionExpression extends ExpressionNode {
    public String NameOfFunction;
    public List<ExpressionNode> ListOfParams;

    public CallFunctionExpression(String name, List<ExpressionNode> listOfParams){
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
    public Semantic.BaseType ValidateSemmantic() {
        Semantic.BaseType type =  SymbolTable.getInstance().getType(NameOfFunction);

        int postOfParams =0;
        boolean breakFor = false;

        if(type instanceof FunctionType){
            FunctionType function = (FunctionType)type;

            if(getCantOfParams(function.ListParam)== ListOfParams.size()) {
                for (int i = 0; i < function.ListParam.size() && !breakFor; i++) {

                    for (int o = 0; o < function.ListParam.get(i).listId.size(); o++) {
                        if ((ListOfParams.get(postOfParams)).ValidateSemmantic().IsAssignable(function.ListParam.get(i).TypeOfParam)) {

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
            return  ((FunctionType)type).TypeToReturn;
        }else{
            System.out.println(this.GetPositionError()+" "+ NameOfFunction+" is not a procedure");
        }
        return new DefaultType();
    }

    @Override
    public String GenerateTreeDimensions() {
        return null;
    }
}
