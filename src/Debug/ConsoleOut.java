package Debug;

public class ConsoleOut {

    public static void Info(String message){
        System.out.println("Info: " + message);
    }

    public static void Success(String message){
        System.out.println("Successful: " + message);
    }

    public static void Warning(String message){
        System.out.println("Warning!: " + message);
    }

    public static void Error(String message){
        System.out.print("ERROR: " + message);
    }
}
