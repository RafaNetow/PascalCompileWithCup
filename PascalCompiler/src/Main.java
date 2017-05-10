
import java.io.*;
import java.util.HashMap;
import java.util.List;

import Tree.Expression.SentencesNode;


public class Main {

    static public void main(String argv[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("src/codeDeclaration.pas")));
            List<SentencesNode> result = (List<SentencesNode>) p.parse().value;
            String code = "";


            System.out.println(code);

        } catch (Exception e) {
            /* do cleanup here -- possibly rethrow e */
            e.printStackTrace();
        }
    }
}
