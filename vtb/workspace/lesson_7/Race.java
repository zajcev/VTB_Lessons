package vtb.workspace.lesson_7;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Mikhail Zaitsev
 */
public class Race {
    private ArrayList<Stage> stages;
    public ArrayList<Stage> getStages() { return stages; }
    public Race(Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
    }

}
