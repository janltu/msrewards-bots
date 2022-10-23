package Interaction.Command;

import java.util.function.Consumer;

class Command {
    public String Trigger;
    public String Description;
    public Consumer<Integer> CallbackFunction;

    public Command(String _triggerForExecution, String _description, Consumer<Integer> _callbackFunction){
        Trigger = _triggerForExecution;
        Description = _description;
        CallbackFunction = _callbackFunction;
    }
}
