package Semantic;

import java.lang.reflect.Type;
import java.util.HashMap;

/**
 * Created by Sequeirios on 09/05/2017.
 */
public class SymbolTable {
    static SymbolTable instance;

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

        if(_table.containsKey(name)){
            System.out.printf("Variable "+name+" already exist\n");
            return false;
        }else {
            _table.put(name,type);
            return  true;
        }

    }

    public  BaseType getType(String name){
        if(_table.containsKey(name)){
            return  _table.get(name);
        }

        System.out.println("Base Type "+name+"+ doesn't exist\n");
        return null;

    }



}


