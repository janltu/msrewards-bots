package Command;

class CommandCatalog {

    public static Command[] commandList = new Command[] {
            new Command("help", "Lists all available commands", i -> Help()),
            new Command("quit", "Quits the application", i -> Quit())
    };

    public static void Help(){
        System.out.println("|");
        System.out.println("|" + '\t' + "Type one of the commands commands for execution: " + '\n');

        for (Command com: commandList){
            System.out.println("|" + '\t' + com.Trigger + "\t" + com.Description);
        }
    }

    public static void Quit(){
        System.exit(0);
    }
}
