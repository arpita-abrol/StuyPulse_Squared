import java.util.*;
import cs1.Keyboard;

public class Towns {
	

    public boolean gym( Trainer player) {
	System.out.println("Welcome to the Pewter City Gym. The Gym Leader is Brock. \nTo prove that you are worthy of challenging Gym Leader Brock, you must first beat some fellow Pokemon Trainers. Good luck, Trainer.");
	
	System.out.println("! \nPokeFan Cassidy challenges you to a battle!");
	Pokemon PFC1 = new Pokemon( "Geodude",20 );
	player.battlePokemonT(PFC1);
	if(!player.stillAlive() ) {
	    System.out.println("PokeFan Cassidy says: HA! Only a true PokeFan could win!");
	    return false;
	}
	player.setMoney( player.getMoney() + 100 );
	System.out.println("You have defeated PokeFan Cassidy. You win 100 PokeDollars! \nPokeFan Cassidy says: NOOO, I must not be a big enough fan :(");

	
	System.out.println(" ! \n Miner Will challenges you to a battle!");
	Pokemon MW1 = new Pokemon("Onix",10);
	player.battlePokemonT(MW1);
	if(!player.stillAlive() ) {
	    System.out.println("Miner Will says: Rock Pokemon are the best!");
	    return false;
	}
	Pokemon MW2 = new Pokemon("Kabuto",15);
	player.battlePokemonT(MW2);
	if(!player.stillAlive() ) {
	    System.out.println("Miner Will says: Rock Pokemon are the best!");
	    return false;
	}
	player.setMoney( player.getMoney() + 100 );
	System.out.println("You have defeated Miner Will. \nMiner Will says: H-how could this be... ");

	
	System.out.println("Suddenly, a voice appears. Nice job, says the voice. Now, it's time to face me. \nYou have challenged Gym Leader Brock!");
	Pokemon GLB1 = new Pokemon("Geodude",15);
	player.battlePokemonT(GLB1);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Brock says: Better luck next time, kid");
	    return false;
	}
	player.setMoney( player.getMoney() +100 );
	Pokemon GLB2 = new Pokemon("Golem",18);
	player.battlePokemonT(GLB2);
	if(!player.stillAlive() ) {
	    System.out.println("Gym Leader Brock says: Better luck next time, kid");
	    return false;
	}
	player.setMoney( player.getMoney() + 100 );
	System/out.println("Good job, kid. Take this Boulder Badge; you deserve it.");
	
	return true;
    }
    

}
