package Semantic;

import Tree.Expression.DataType.DefaultType;
import Tree.Expression.DataType.StringNode;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sequeirios on 09/05/2017.
 */
public class SymbolTable {
    static SymbolTable instance;

int a = 10;
    static {
        instance = new SymbolTable();
    }

    public  static  SymbolTable getInstance(){
        return  instance;
    }

    public   SymbolTable(){

    }

    public HashMap<String, BaseType> _table = new HashMap<String, BaseType>();


    public boolean declareVariable(String name, BaseType type){

      if(Context.getInstance().Stack.peek()._table.containsKey(name)){
          System.out.printf("Variable "+name+" already exist\n");
          return false;
      }else{
          Context.getInstance().Stack.peek()._table.put(name,type);
          return  true;
      }


    }

    public boolean declareVariable(String name, BaseType type, SemanticSymbol symbol){

        if(Context.getInstance().Stack.peek()._table.containsKey(name)){
            System.out.printf("Error line " + symbol.Row + "column " +symbol.Column +  " Variable "+name+" already exist\n");
            return false;
        }else{
            Context.getInstance().Stack.peek()._table.put(name,type);
            return  true;
        }


    }

    public boolean foundVariable(String variableName)
    {
        List<SymbolTable> stackList = new ArrayList<>(Context.getInstance().Stack);
        Collections.reverse(stackList);
        for (SymbolTable stack : stackList){
         if (stack._table.containsKey(variableName))
         {
             return  true;
         }
     }

        return  false ;
    }

    public  BaseType getVariable(String name){
        List<SymbolTable> stackList = new ArrayList<>(Context.getInstance().Stack);
        Collections.reverse(stackList);
        for (SymbolTable stack : stackList){
            if (stack._table.containsKey(name))
            {
                return  stack._table.get(name);
            }
        }

        return  new DefaultType() ;
    }

    public  BaseType getType(String name){


        for (SymbolTable table: Context.getInstance().Stack
             ) {
             if( table._table.containsKey(name))
                 return  table._table.get(name);
        }

        System.out.println("variable:  "+name+" doesn't exist\n");
        return new DefaultType();

    }

    public  BaseType getType(String name, SemanticSymbol sym){


        for (SymbolTable table: Context.getInstance().Stack
                ) {
            if( table._table.containsKey(name))
                return  table._table.get(name);
        }

        System.out.println("Error : Linea:" + sym.Row + " "+ " Column:"+sym.Column+  " The variable "+ name+" doesn't exist\n");
        return new DefaultType();

    }



}


