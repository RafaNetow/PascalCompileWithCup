package Tree.Expression;

import java.util.UUID;

/**
 * Created by Sequeirios on 04/05/2017.
 */
public abstract class SentencesNode {

    public abstract void ValidateSemantic();
    public UUID CodeGuid = UUID.randomUUID();
    public  abstract  String GenrarTresDirecciones();
    //public  abstract  void GenerateTreeDirection();
}
