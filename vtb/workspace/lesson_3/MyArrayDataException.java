package vtb.workspace.lesson_3;

public class MyArrayDataException extends Exception {
    public MyArrayDataException(int line, int column){super("В ячейке "+line+" "+column+" не число");}
}
