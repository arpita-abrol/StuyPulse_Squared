import java.util.ArrayList;

public class Trainer{
    //=============Instance Vars===================================
    public String TrainerName;
    
    private ArrayList<Pokemon> onMePokemon;//Array of the Pokemon on you
    private ArrayList<Pokemon> inLabPokemon;//Array of Pokemon stored in the lab
    private ArrayList Pokeballs;//Array of your Pokeballs-Pokeball, Great Ball, Ultra Ball, Master Ball
    private ArrayList Potions;//Array of your Potions- Potion, Super Potion, Hyper Potion,  Full Potion
    private int PokeDollars;
    private int numPokeOnMe;
    private int numPokeInLab;
    //================================================

    //===============Constructors=================================
    public Trainer(){
	TrainerName= "Pokemon Trainer";
	onMePokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	inLabPokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	createPokeballs();
	createPotions();
	PokeDollars= 500;//Trainer starts with 500 money
    }

    public Trainer(String Name){
	this();
	TrainerName= Name;
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
	return onMePokemon.size();
    }
    private ArrayList getPokeInLab(){
	return inLabPokemon;
    }
    private int getNumPokeInLab(){
	return inLabPokemon.size();
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
	return PokeDollars;
    }
    //================================================

    //================Mutators================================
    /*Trainer chooses to buy:
    1: Potion
    2: Super Potion
    3: Hyper Potion
    4: Full Potion
    name is the number they choose and num is the amount they bought*/
    private void setPotions(int name, int num){
	name*=2;
	name-=1;
	Potions.set(name, ((Integer)(Potions.get(name)))+num);
    }
    /*Trainer chooses to buy:
    1: Pokeball
    2: Great Ball
    3: Ultra Ball
    4: Master Ball
    name is the number they choose and num is the amount they bought*/
    private void setPokeballs(int name, int num){
	name*=2;
	name-=1;
	Pokeballs.set(name, ((Integer)(Pokeballs.get(name)))+num);
    }
    private void setMoney(int newMoney){
	PokeDollars= newMoney;
    }
    //================================================

    //==============Methods==================================
    //Trainers starts with 5 Pokeball, 0 Great Ball, 0 Ultra Ball, and 0 Master Ball
    private void createPokeballs(){
	Pokeballs= new ArrayList();
	Pokeballs.add("Pokeballs: ");
	Pokeballs.add(5);
	Pokeballs.add("Great Balls: ");
	Pokeballs.add(0);
	Pokeballs.add("Ultra Balls: ");
	Pokeballs.add(0);
	Pokeballs.add("Master: ");
	Pokeballs.add(0);
    }
    //Trainers starts with 10 Potions, 5 Super Potions, 0 Hyper Potions, and 0 Full Potions
    private void createPotions(){
	Potions= new ArrayList();
	Potions.add("Potions: ");
	Potions.add(10);
	Potions.add("Super Potions: ");
	Potions.add(5);
	Potions.add("Hyper Potions: ");
	Potions.add(0);
	Potions.add("Full Potions: ");
	Potions.add(0);
    }
    //Sends newly caught Pokemon to your backpack or lab depending on how many Pokemon you're carrying
    private void catchPokemon(Pokemon newPokemon){
	if (getNumPokeOnMe()> 5){
	    inLabPokemon.add(newPokemon);
	    System.out.println("Max number of Pokemon you can carry was reached, so Pokemon caught was sent to lab.");
	}else{
	    onMePokemon.add(newPokemon);
	    System.out.println("Pokemon caught was sent to your backpack. You now have "+getNumPokeOnMe()+" Pokemon on you.");
	}
	
    }
    //================================================

    
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	System.out.println("Your name is Trainer "+test.getName());
	System.out.println("You have "+test.getNumPokeOnMe()+" Pokemon on you");
	System.out.println("You have a total of "+(test.getNumPokeOnMe()+test.getNumPokeInLab()) + " Pokemon");	
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	System.out.println("These are the Pokemon in your lab:\n" +test.getPokeInLab().toString());
	System.out.println(test.getPotions());
	System.out.println(test.getPokeballs());
	System.out.println("Bought 10 more potions.");
	test.setPotions(1, 10);
	System.out.println(test.getPotions());

	System.out.println("You have "+test.getMoney()+ " PokeDollars");
	System.out.println("You bought 10 MasterBalls");
	test.setPokeballs(4, 10);
	test.setMoney(test.getMoney()-200);
	System.out.println("PokeDollars: "+ test.getMoney());
	System.out.println(test.getPokeballs());
    }
} 
