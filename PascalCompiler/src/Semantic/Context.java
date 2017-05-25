package Semantic;

import java.util.HashMap;
import java.util.Stack;
import java.util.UUID;

/**
 * Created by Sequeirios on 23/05/2017.
 */
public class Context {
    public  static Context _context;
    static {
        _context = new Context();
    }
    public Stack<SymbolTable> Stack = new Stack<SymbolTable>();
    public HashMap<UUID, SymbolTable> TableToRemind = new HashMap<UUID, SymbolTable>();

    public  static  Context getInstance(){
        return  _context;
    }


    public Context (){
        Stack.push(new SymbolTable());
    }



}
