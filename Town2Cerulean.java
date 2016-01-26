import java.util.*;
import cs1.Keyboard;

public class Town2Cerulean {

    public boolean gym( Trainer player ) {

	System.out.println("Welcome to the Cerulean City Gym. The Gym Leader is Misty. \nTo prove that you are worthy of challenging Gym Leader Misty, you must first beat some fellow Pokemon Trainers. Good luck, Trainer.");
	
	System.out.println("! \nSailor Sabrina challenges you to a battle!");
	Pokemon SS1 = new Pokemon( "Goldeen",20 );
	player.battlePokemonT(SS1);
	if(!player.stillAlive() ) {
	    System.out.println("Sailor Sabrina says: My Pokemon are my best friends!");
	    return false;
	}
	Pokemon SS2 = new Pokemon("Tentacool",18);
	player.battlePokemon(SS2);
	if(!player.stillAlive() ) {
	    System.out.println("Sailor Sabrina says: My Pokemon are my best friends!");
	    return false;
	}
	player.setMoney( player.getMoney() + 250 );
	System.out.println("You have defeated Sailor Sabrina. You win 250 PokeDollars! \nSailor Sabrina says: NOOO, I must not be a big enough fan :(");

	
	System.out.println(" ! \nSailor Butch challenges you to a battle!");
	Pokemon SB1 = new Pokemon("Tentacool",15);
	player.battlePokemonT(SB1);
	if(!player.stillAlive() ) {
	    System.out.println("Sailor Butch says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB2 = new Pokemon("Tentacool",15);
	player.battlePokemonT(SB2);
	if(!player.stillAlive() ) {
	    System.out.println("Sailor Butch says: Water Pokemon are the best!");
	    return false;
	}
	Pokemon SB3 = new Pokemon("Tentacool",15);
	player.battlePokemonT(SB3);
	if(!player.stillAlive() ) {
	    System.out.println("Sailor Butch says: Water Pokemon are the best!");
	    return false;
	}
	player.setMoney( player.getMoney() + 500 );
	System.out.println("You have defeated Sailor Butch. You win 500 PokeDollars! \nSailor Butch says: H-how could this be... ");

	
	System.out.println("You have defeated all other trainers. \nYou have challenged Gym Leader Misty!");
	Pokemon GLM1 = new Pokemon("Goldeen",20);
	player.battlePokemonT(GLM1);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Misty says: Better luck next time, kid");
	    return false;
	}
	Pokemon GLM2 = new Pokemon("Starmie",25);
	player.battlePokemonT(GLM2);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Misty says: Better luck next time, kid");
	    return false;
	}
		Pokemon GLM3 = new Pokemon("Psyduck",23);
	player.battlePokemonT(GLM3);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Misty says: Better luck next time, kid");
	    return false;
	}
	player.setMoney( player.getMoney() + 1000 );
	System.out.println("Good job, kid. Take this Cascade Badge; you deserve it.");
	return true;
    }
    
} //end class
