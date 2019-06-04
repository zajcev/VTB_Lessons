package vtb.workspace.lesson_9;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

/**
 * @author Mikhail Zaitsev
 */
public class TestMain {
    public static void main(String[] args) throws SQLException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        AnnotationProcessor.start(Human.class);
        AnnotationProcessor.start(Human2.class);
    }
}