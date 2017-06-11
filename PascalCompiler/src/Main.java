
import java.io.*;

import java.util.List;

import Semantic.Context;
import Semantic.SymbolTable;
import Tree.Expression.SentencesNode;
import TreeWaysCode.CuadrupleTable;


public class Main {
 //Arreglar el main
    static public void main(String argv[]) {
        /* Start the parser */
        try {
            parser p = new parser(new Lexer(new FileReader("src/codeDeclaration.pas")));
            List<SentencesNode> result = (List<SentencesNode>) p.parse().value;
            String code = "";

            for (SentencesNode sentence:
                 result) {
                sentence.ValidateSemantic();
            }
         String currentTag=   CuadrupleTable.getInstance().GetNextTag();
            for (SentencesNode sentence:
                 result) {
               currentTag= sentence.GenrarTresDirecciones(currentTag);
            }
            Context table = Context.getInstance();
            CuadrupleTable ctable = CuadrupleTable.getInstance();
            System.out.println(code);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
