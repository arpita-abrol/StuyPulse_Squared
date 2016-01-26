import java.util.*;
import cs1.Keyboard;

public class Town4Celadon {

    public boolean gym( Trainer player ) {

	System.out.println("Welcome to the Vermillion City Gym. The Gym Leader is Erika. \nTo prove that you are worthy of challenging the gym leader, Erika, you must first beat some fellow Pokemon Trainers. Good luck, Trainer.");
	
	System.out.println("! \nHunter Ernie challenges you to a battle!");
	Pokemon SS1 = new Pokemon( "Bellsprout",22 );
	player.battlePokemonT(SS1);
	if(!player.stillAlive() ) {
	    System.out.println("Hunter Ernie says: My Pokemon are my best friends!");
	    return false;
	}
	Pokemon SS2 = new Pokemon("Oddish",18);
	player.battlePokemon(SS2);
	if(!player.stillAlive() ) {
	    System.out.println("Hunter Ernie says: My Pokemon are my best friends!");
	    return false;
	}
	player.setMoney( player.getMoney() + 450 );
	System.out.println("You have defeated Hunter Ernie. You win 450 PokeDollars! \nHunter Ernie says: My precious pokemon...");

	
	System.out.println(" ! \nStudent Matt challenges you to a battle!");
	Pokemon SB1 = new Pokemon("Weepinbell",19);
	player.battlePokemonT(SB1);
	if(!player.stillAlive() ) {
	    System.out.println("Student Matt says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB2 = new Pokemon("Venonat",23);
	player.battlePokemonT(SB2);
	if(!player.stillAlive() ) {
	    System.out.println("Student Matt says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB3 = new Pokemon("Paras",15);
	player.battlePokemonT(SB3);
	if(!player.stillAlive() ) {
	    System.out.println("Student Matt says: Water Pokemon are the best!");
	    return false;
	}
	player.setMoney( player.getMoney() + 500 );
	System.out.println("You have defeated Student Matt. You win 500 PokeDollars! \nStudent Matt says: H-how could this be... ");

	
	System.out.println("You have defeated all other trainers. \nYou have challenged Gym Leader Erika!");
	Pokemon GLM1 = new Pokemon("Vileplume",28);
	player.battlePokemonT(GLM1);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Erika says: Better luck next time, kid");
	    return false;
	}
	Pokemon GLM2 = new Pokemon("Tangela",24);
	player.battlePokemonT(GLM2);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Erika says: Better luck next time, kid");
	    return false;
	}
		Pokemon GLM3 = new Pokemon("Victreebel",30);
	player.battlePokemonT(GLM3);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Erika says: Better luck next time, kid");
	    return false;
	}
	player.setMoney( player.getMoney() + 1000 );
	System.out.println("Good job, kid. Take this Rainbow Badge; you deserve it.");

	return true;
	
    }
    
} //end class
