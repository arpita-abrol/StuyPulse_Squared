import java.util.ArrayList;

public class Trainer{
    //=============Instance Vars===================================
    public String TrainerName;
    
    private ArrayList<Pokemon> onMePokemon;//Array of the Pokemon on you
    private ArrayList<Pokemon> inLabPokemon;//Array of Pokemon stored in the lab
    private ArrayList Pokeballs;//Array of your Pokeballs-Pokeball, Great Ball, Super Ball, Master Ball
    private ArrayList Potions;//Array of your Potions- Potion, Super Potion,Ultra Potion,  Full Potion
    private int Money;
    private int numPokeOnMe;
    private int numPokeInLab;
    //================================================

    //===============Constructors=================================
    public Trainer(){
	TrainerName= "Pokemon Trainer";
	onMePokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	inLabPokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	numPokeOnMe= onMePokemon.size();
	numPokeInLab= inLabPokemon.size();
	createPokeballs();
	createPotions();
	Money= 500;//Trainer starts with 500 money
    }

    public Trainer(String Name){
	this();
	TrainerName= Name;
    }
    //================================================

    //==============Methods==================================
    //Trainers starts with 20 Pokeball, 10 Great Ball, 0 Super Ball, and 0 Master Ball
    private void createPokeballs(){
	Pokeballs= new ArrayList();
	Pokeballs.add("Pokeballs: ");
	Pokeballs.add(20);
	Pokeballs.add("Great Balls: ");
	Pokeballs.add(10);
	Pokeballs.add("Super Balls: ");
	Pokeballs.add(0);
	Pokeballs.add("Master: ");
	Pokeballs.add(0);
    }
    //Trainers starts with 20 Potions, 10 Super Potions, 5 Ultra Potions, and 0 Full Potions
    private void createPotions(){
	Potions= new ArrayList();
	Potions.add("Potions: ");
	Potions.add(20);
	Potions.add("Super Potions: ");
	Potions.add(10);
	Potions.add("Ultra Potions: ");
	Potions.add(5);
	Potions.add("Full Potions: ");
	Potions.add(0);
    }
    //================================================

    //=============Accessors===================================
    private String getName(){
	return TrainerName;
    }
    private ArrayList getPokeOnMe(){
	return onMePokemon;
    }
    private int getNumPokeOnMe(){
	return numPokeOnMe;
    }
    private ArrayList getPokeInLab(){
	return inLabPokemon;
    }
    private int getNumPokeInLab(){
	return numPokeInLab;
    }
    private String getPotions(){
	String retStr= "";
	for(int i= 0;i<Potions.size(); i+=2){
	    retStr+= Potions.get(i);
	    retStr+= Potions.get(i+1)+"\n";
	}
	return retStr;
    }
     private String getPokeballs(){
	String retStr= "";
	for(int i= 0;i<Pokeballs.size(); i+=2){
	    retStr+= Pokeballs.get(i);
	    retStr+= Pokeballs.get(i+1)+"\n";
	}
	return retStr;
    }
    private int getMoney(){
	return Money;
    }
    //================================================

    //================Mutators================================
    /*Trainer chooses to buy:
    1: Potion
    2: Super Potion
    3: Ultra Potion
    4: Full Potion
    name is the number they choose and num is the amount they bought*/
    private void setPotions(int name, int num){
	name*=2;
	name-=1;
	Potions.set(name, ((Integer)(Potions.get(name)))+num);
    }

    

    //================================================
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	System.out.println("Your name is Trainer "+test.getName());
	System.out.println("You have "+test.getNumPokeOnMe()+" Pokemon on you");
	System.out.println("You have a total of "+(test.getNumPokeOnMe()+test.getNumPokeInLab())+" Pokemon on you");	
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	System.out.println("These are the Pokemon in your lab:\n" +test.getPokeInLab().toString());
	System.out.println(test.getPotions());
	System.out.println(test.getPokeballs());
	System.out.println("Bought 10 more potions.");
	test.setPotions(1, 10);
	System.out.println(test.getPotions());
    }
}
