import cs1.Keyboard;
import java.util.*;

public class PokemonDriver {
    public static void main(String[] args){
	System.out.println(".-------------.  .-------------.  .-------------.  .-------------.  .-------------.  .-------------.  .-------------.");
	System.out.println("|   ______     | |     ____     | |  ___  ____   | |  _________   | | ____    ____ | |     ____     | | ____  _____  |");
	System.out.println("|  |_   __ \\   | |   .'    `.   | | |_  ||_  _|  | | |_   ___  |  | ||_   \\  /   _|| |   .'    `.   | ||_   \\|_   _| |");
	System.out.println("|    | |__) |  | |  /  .--.  \\  | |   | |_/ /    | |   | |_  \\_|  | |  |   \\/   |  | |  /  .--.  \\  | |  |   \\ | |   |");
	System.out.println("|    |  ___/   | |  | |    | |  | |   |  __'.    | |   |  _|  _   | |  | |\\  /| |  | |  | |    | |  | |  | |\\ \\| |   |");
	System.out.println("|   _| |_      | |  \\  `--'  /  | |  _| |  \\ \\_  | |  _| |___/ |  | | _| |_\\/_| |_ | |  \\  `--'  /  | | _| |_\\   |_  |");
	System.out.println("|  |_____|     | |   `.____.'   | | |____||____| | | |_________|  | ||_____||_____|| |   `.____.'   | ||_____|\\____| |");
	System.out.println("|              | |              | |              | |              | |              | |              | |              |");
	System.out.println("'-------------'  '-------------'  '-------------'  '-------------'  '-------------'  '-------------'  '-------------'");
	System.out.println("Please enter your name");
	String TrainerName= Keyboard.readString();
	System.out.println("Welcome Trainer "+ TrainerName+"!\n");
    
	Trainer test= new Trainer(TrainerName);
	Maps testing= new Maps();
	test.chooseStarter();
	//test.move(testing);

	boolean canProgress = false;
	
	Towns town = new Towns();
	while( !canProgress) {
	    lock.lock();
	    try {
		town.gym(test);
	    }
	    finally {
		lock.unlock();
	    }
	}
	
    
    }

}//end class

