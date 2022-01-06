import java.util.Scanner;

public class View {
	private static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {
		Controller controller = new Controller();
		String command = "";
		welcome();
		while (!command.equals("exit")){ 
			System.out.println("Awaiting command...");
			command = reader.nextLine();
			System.out.printf("You entered %s %n", command);
			System.out.println("Evaluating...");
			controller.interpret(command);
		}
		//exit command was entered, exit the system
		System.out.println("Goodbye.");
		reader.close();
		System.exit(0);
	}

	/*
	 * method for printing welcome message
	 */
	public static void welcome(){
        StringBuilder stars = new StringBuilder();
        for(int i = 0; i < 40; i++){
            stars.append("*");
        }
        stars.append("\n");
        System.out.println(stars);
        System.out.println("Welcome To TheaterCLI 2.0");
        System.out.println("A backend CLI theater management system!");
        System.out.println("For a list of commands, enter \"help\"");
        System.out.println(stars);
    }
}

