import java.util.HashMap;
import java.util.Map;

public class Controller {

	private Map<String, Command> commandList;
	private Model model = new Model();

	/*
	 * initialize commandManager with a list of commands
	 */
		
	public Controller() {
		commandList = new HashMap<>();
		//setup all default commands 
		this.commandList.put("newCustomer", new Command.newCustomer());
		this.commandList.put("newEmployee", new Command.newEmployee());
		this.commandList.put("newAdmin", new Command.newAdmin());
		this.commandList.put("newTheater", new Command.newTheater());	
		this.commandList.put("newShowtime", new Command.newShowtime());
		this.commandList.put("deleteAccount", new Command.deleteAccount());
		this.commandList.put("deleteTheater", new Command.deleteTheater());
		this.commandList.put("deleteShowtime", new Command.deleteShowtime());
		this.commandList.put("listAccounts", new Command.listAccounts());
		this.commandList.put("listTheaters", new Command.listTheaters());
		this.commandList.put("listShowtimes", new Command.listShowtimes());
		this.commandList.put("viewAccount", new Command.viewAccount());
		this.commandList.put("viewTheater", new Command.viewTheater());
		this.commandList.put("viewShowtime", new Command.viewShowtime());
		this.commandList.put("purchaseTicket", new Command.purchaseTicket());
		this.commandList.put("addBalance", new Command.addBalance());
		this.commandList.put("clearAccountData", new Command.clearAccountData());
		this.commandList.put("clearTheaterData", new Command.clearTheaterData());
		this.commandList.put("clearShowtimeData", new Command.clearShowtimeData());
		this.commandList.put("updateAccountData", new Command.updateAccountData());
		this.commandList.put("updateShowtimeData", new Command.updateShowtimeData());
		this.commandList.put("updateTheaterData", new Command.updateTheaterData());
		this.commandList.put("login", new Command.login());
		this.commandList.put("logout", new Command.logout());
		this.commandList.put("exit", new Command.exit());
		this.commandList.put("help", new Command.help());
	}

	public void interpret(String command) {
		command = (command).trim();
		if(!commandList.containsKey(command)){
			System.out.println("Invalid command entered! Please type \"help\" for a list of commands.");
		}else{
			//parse arguments out of command
			String[] parsedCommand = command.split(" ", 2);
			if(parsedCommand.length == 1){
				String[] params = {""};
				runCommand(command, model, params);
			}else{
				runCommand(command, model, parsedCommand[1].split(" ", 2));
			}
		}
	}

	private void runCommand(String command, Model model, String[] params){
		commandList.get(command).execute(model, params);
	}
}
