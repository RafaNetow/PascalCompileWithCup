package Tree.Sentences.Bucles;

import Tree.Expression.BaseType.ExpressionNode;

import Tree.Expression.DataType.BooleanType;
import Tree.Expression.SentencesNode;

import java.util.List;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public class WhileNode extends SentencesNode {

    public ExpressionNode WhileCondition;
    public List<SentencesNode> ListSentences;




    @Override
    public void ValidateSemantic() {

     // if(WhileCondition.ValidateSemmantic() instanceof BooleanType){
          for (SentencesNode sentencesNode : ListSentences
                  ) {
              sentencesNode.ValidateSemantic();
          }
      //}else{

        //  System.out.println("Operation is not allowed");
      //}


    }

    public  WhileNode(ExpressionNode expressionnode, List<SentencesNode> listasecuencia){
        WhileCondition = expressionnode;
        ListSentences = listasecuencia;

    }
}
