import Debug.ConsoleOut;
import Command.Interactor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Interactor.EvaluateInput("help");
            while (true) {
                String input = scanner.nextLine().toLowerCase();
                Interactor.EvaluateInput(input);
            }
        } catch (Exception e) {
            // System.in has been closed
            ConsoleOut.Error("Exception: " + e);
            ConsoleOut.Warning("System.in was closed; exiting");
        }
    }
}