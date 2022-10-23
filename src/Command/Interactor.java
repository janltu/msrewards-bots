package Command;

import Debug.ConsoleOut;
import java.util.function.Consumer;

public class Interactor {
    public static void EvaluateInput(String inputs){
        // If nothing was passed in list help
        if (inputs.isEmpty()){
            ExecuteCommand( CommandCatalog.commandList[0].CallbackFunction ); // Execute help command
            return;
        }

        // Find corresponding command & execute
        for (Command com : CommandCatalog.commandList) {

            // Check if command trigger is the same as input
            if (inputs.equals(com.Trigger)){
                ExecuteCommand(com.CallbackFunction); // Execute triggered command
                return;
            }
        }

        ConsoleOut.Warning("No valid command was passed in!");
    }

    private static void ExecuteCommand(Consumer<Integer> action){
        action.accept(0);
    }
}
