import java.util.*;
import cs1.Keyboard;

public class Town3Vermillion {

    public boolean gym( Trainer player ) {

	System.out.println("Welcome to the Vermillion City Gym. The Gym Leader is Misty. \nTo prove that you are worthy of challenging the gym leader, Lt. Surge, you must first beat some fellow Pokemon Trainers. Good luck, Trainer.");
	
	System.out.println("! \nElectrician Ernie challenges you to a battle!");
	Pokemon SS1 = new Pokemon( "Pikachu",16 );
	player.battlePokemonT(SS1);
	if(!player.stillAlive() ) {
	    System.out.println("Electrician Ernie says: My Pokemon are my best friends!");
	    return false;
	}
	Pokemon SS2 = new Pokemon("Electabuzz",18);
	player.battlePokemon(SS2);
	if(!player.stillAlive() ) {
	    System.out.println("Electrician Ernie says: My Pokemon are my best friends!");
	    return false;
	}
	player.setMoney( player.getMoney() + 450 );
	System.out.println("You have defeated Electrician Ernie. You win 450 PokeDollars! \nElectrician Ernie says: My precious pokemon...");

	
	System.out.println(" ! \nElectrician Ernie challenges you to a battle!");
	Pokemon SB1 = new Pokemon("Magnemite",10);
	player.battlePokemonT(SB1);
	if(!player.stillAlive() ) {
	    System.out.println("Student Sally says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB2 = new Pokemon("Magnemite",13);
	player.battlePokemonT(SB2);
	if(!player.stillAlive() ) {
	    System.out.println("Student Sally says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB3 = new Pokemon("Magnemite",15);
	player.battlePokemonT(SB3);
	if(!player.stillAlive() ) {
	    System.out.println("Student Sally says: Water Pokemon are the best!");
	    return false;
	}
	player.setMoney( player.getMoney() + 500 );
	System.out.println("You have defeated Student Sally. You win 500 PokeDollars! \nStudent Sally says: H-how could this be... ");

	
	System.out.println("You have defeated all other trainers. \nYou have challenged Gym Leader Misty!");
	Pokemon GLM1 = new Pokemon("Voltorb",18);
	player.battlePokemonT(GLM1);
	if(!player.stillAlive() ) {
	    System.out.println("Lt. Surge says: Better luck next time, kid");
	    return false;
	}
	Pokemon GLM2 = new Pokemon("Pikachu",20);
	player.battlePokemonT(GLM2);
	if(!player.stillAlive() ) {
	    System.out.println("Lt. Surge says: Better luck next time, kid");
	    return false;
	}
		Pokemon GLM3 = new Pokemon("Raichu",28);
	player.battlePokemonT(GLM3);
	if(!player.stillAlive() ) {
	    System.out.println("Lt. Surge says: Better luck next time, kid");
	    return false;
	}
	player.setMoney( player.getMoney() + 1000 );
	System.out.println("Good job, kid. Take this Thunder Badge; you deserve it.");

	return true;
    }
    
} //end class
