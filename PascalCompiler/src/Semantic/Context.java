package Semantic;

import java.util.Stack;

/**
 * Created by Sequeirios on 23/05/2017.
 */
public class Context {
    public  static Context _context;
    public Stack<SymbolTable> Stack = new Stack<>();
    public  static  Context getInstance(){
        return  _context;
    }


    public Context (){
        Stack.push(new SymbolTable());
    }



}
