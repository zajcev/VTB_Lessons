package vtb.workspace.lesson_9;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Mikhail Zaitsev
 * data<Имя,Map<Тип,Значение>>
 */
public class AnnotationProcessor {
    private static Map<String, Map<String, Object>> data = new HashMap<>();
    // Создаю конструктор просто что бы посмотреть как оно работает.
    public static void start(Class classForDb) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        Object object = makeConstructor(classForDb);
        AnnotationProcessor.addFields(object);
        AnnotationProcessor.addPrivateFields(object);
        AnnotationProcessor.takeFromGetter(object);
        AnnotationProcessor.takeFromPrivateGetter(object);
        MainDB.connect();
        MainDB.createTable(classForDb.getSimpleName(), data);
        data.clear();
        MainDB.disconnect();
    }

    private static void addFields(Object object) throws IllegalAccessException {
        Map<String, Object> memory = new HashMap<>();
        Field[] fields = object.getClass().getFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PublicField.class)) {
                memory.put(field.getType().getSimpleName(), field.get(object));
                if (data.containsKey(field.getName())) {
                    Map<String, Object> res = Stream.of(memory, data.get(field.getName()))
                            .flatMap(m -> m.entrySet().stream())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    data.put(field.getName(), res);
                } else {
                    Map<String, Object> other = new HashMap<>();
                    other.put(field.getType().getSimpleName(), field.get(object));
                    data.put(field.getName(), other);
                }
            }
        }
    }


    private static void addPrivateFields(Object object) throws IllegalAccessException {
        Map<String, Object> memory = new HashMap<>();
        Field[] privateFields = object.getClass().getDeclaredFields();
        for (Field privateField : privateFields) {
            if (privateField.isAnnotationPresent(PrivateField.class)) {
                privateField.setAccessible(true);
                memory.put(privateField.getType().getSimpleName(), privateField.get(object));
                if (data.containsKey(privateField.getName())) {
                    Stream.of(memory, data.get(privateField.getName()))
                            .flatMap(m -> m.entrySet().stream())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                } else {
                    Map<String, Object> other = new HashMap<>();
                    other.put(privateField.getType().getSimpleName(), privateField.get(object));
                    data.put(privateField.getName(), other);
                }


            }
        }
    }

    private static void takeFromGetter(Object object) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> memory = new HashMap<>();
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Getter.class)) {
                Object invoke = method.invoke(object, null);
                memory.put(invoke.getClass().getSimpleName(), invoke);
                if (data.containsKey(method.getName() + "Method")) {
                    Map<String, Object> res = Stream.of(memory, data.get(method.getName() + "Method"))
                            .flatMap(m -> m.entrySet().stream())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    data.put(method.getName() + "Method", res);
                } else {
                    Map<String, Object> other = new HashMap<>();
                    other.put(invoke.getClass().getSimpleName(), invoke);
                    data.put(method.getName() + "Method", other);
                }
            }
        }

    }

    private static void takeFromPrivateGetter(Object object) throws InvocationTargetException, IllegalAccessException {
        Map<String, Object> memory = new HashMap<>();
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(PrivateGetter.class)) {
                method.setAccessible(true);
                Object invoke = method.invoke(object, null);
                memory.put(invoke.getClass().getSimpleName(), invoke);
                if (data.containsKey(method.getName() + "Method")) {
                    Map<String, Object> res = Stream.of(memory, data.get(method.getName() + "Method"))
                            .flatMap(m -> m.entrySet().stream())
                            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
                    data.put(method.getName() + "Method", res);
                } else {
                    Map<String, Object> other = new HashMap<>();
                    other.put(invoke.getClass().getSimpleName(), invoke);
                    data.put(method.getName() + "Method", other);
                }
            }
        }

    }

    private static Object makeConstructor(Class forConstructor) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Constructor constructor = forConstructor.getConstructor(String.class, int.class);
        return constructor.newInstance("TEST", 1);
    }
}
