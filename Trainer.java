import java.util.ArrayList;
import cs1.Keyboard;

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
    private ArrayList<Pokemon> getPokeOnMe(){
	return onMePokemon;
    }
    private int getNumPokeOnMe(){
	return onMePokemon.size();
    }
    private ArrayList<Pokemon> getPokeInLab(){
	return inLabPokemon;
    }
    private int getNumPokeInLab(){
	return inLabPokemon.size();
    }
    private String getPotions(){
	String retStr= "";
	for(int i= 0;i<Potions.size(); i+=2){
	    retStr+= ((i/2+1) + "- " );
	    retStr+= Potions.get(i)+": ";
	    retStr+= Potions.get(i+1)+"\n";
	}
	return retStr;
    }
     private String getPokeballs(){
	String retStr= "";
	for(int i= 0;i<Pokeballs.size(); i+=2){
	    retStr+= ((i/2+1) + "- " );
	    retStr+= Pokeballs.get(i)+ ": ";
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
	Pokeballs.add("Pokeballs");
	Pokeballs.add(5);
	Pokeballs.add("Great Balls");
	Pokeballs.add(0);
	Pokeballs.add("Ultra Balls");
	Pokeballs.add(0);
	Pokeballs.add("Master");
	Pokeballs.add(0);
    }
    //Trainers starts with 10 Potions, 5 Super Potions, 0 Hyper Potions, and 0 Full Potions
    private void createPotions(){
	Potions= new ArrayList();
	Potions.add("Potions");
	Potions.add(10);
	Potions.add("Super Potions");
	Potions.add(5);
	Potions.add("Hyper Potions");
	Potions.add(0);
	Potions.add("Full Potions");
	Potions.add(0);
    }

    //thows Pokeball. Catches Pokemon depending on the stats
    private void throwPokeball(Pokemon pokemonToCatch){
	System.out.println("Which Pokeball do you want to use?\nYour backpack:");
	System.out.println(getPokeballs());
	String PokeChoiceStr = Keyboard.readString();

	//if input is not within "1234", return message and recurse
	if ("1234".indexOf(PokeChoiceStr) == -1){
	    System.out.println("Please enter a number between 1-4 inclusive");
	    throwPokeball(pokemonToCatch);
	}
	int PokeChoice= Integer.parseInt(PokeChoiceStr);
	//if there are <= 0 of that Pokeball, return message and recurse
	if ((Integer)(Pokeballs.get((PokeChoice*2)-1)) <=0 ){
	    System.out.println("You are out of "+ (String)(Pokeballs.get((PokeChoice*2)-2)));
	    throwPokeball(pokemonToCatch);
	    }
	else{
	    setPokeballs(PokeChoice, -1);
	    if (blinkingPokeball(pokemonToCatch, PokeChoice)){
		System.out.println("You caught a  "+pokemonToCatch.getName()+"!");
		catchPokemon(pokemonToCatch);
	    }else{
		System.out.println("Awww. "+ pokemonToCatch.getName()+ " escaped from the pokeball.");
	    }
	}
    }

    //calculates the possibility of catching the Pokemon
    private Boolean blinkingPokeball(Pokemon pokemonToCatch, int pokeball){
	//System.out.println("Your original chance of failing: " + ((pokemonToCatch.getHP()+0.00)/pokemonToCatch.getMaxHP()));*/
	double chanceFail= (pokemonToCatch.getHP()*3.0)/(pokemonToCatch.getMaxHP()*2.0);
	//System.out.println("Your chance of failing after adjustment: "+ chanceFail);
	if (pokeball==1)
	    chanceFail*= 1;
	else if (pokeball==2)
	    chanceFail/= 1.5;
	else if (pokeball==3)
	    chanceFail/= 2;
	else if (pokeball==4)
	    chanceFail= 0;
	//System.out.println("Your chance of failing after Pokeball: "+ chanceFail);

	double randNum= Math.random();
        return randNum >= chanceFail;
    }
    
    //Sends newly caught Pokemon to your backpack or lab depending on how many Pokemon you're carrying
    private void catchPokemon(Pokemon newPokemon){
	if (getNumPokeOnMe()> 5){
	    inLabPokemon.add(newPokemon);
	    System.out.println("Max number of Pokemon you can carry was reached, so "+newPokemon.getName() +" was sent to lab.");
	}else{
	    onMePokemon.add(newPokemon);
	    System.out.println(newPokemon.getName()+ " was sent to your backpack. You now have "+getNumPokeOnMe()+" Pokemon on you.");
	}
	
    }

    private void fight(){
	
    }

    //Returns a string of all your Pokeballs and Potions.
    private String checkBag(){
	return "These are the items in your backpack:\n"+
	    "Here are your Potions:\n"+getPotions()+
	    "\nHere are your Pokeballs:\n"+getPokeballs();
    }

    private void chooseStarter(){
	System.out.println("Which starter Pokemon do you choose?");
	System.out.println("1: Charmander");
	System.out.println("2: Squirtle");
	System.out.println("3: Bulbsaur");
	int choice = Keyboard.readInt();
	Pokemon starter;
	if (choice == 1)
	    starter= new Pokemon("Charmander");
	else if (choice == 2)
	    starter= new Pokemon("Squirtle");
	else 
	    starter= new Pokemon("Bulbsaur");
	catchPokemon(starter);
    }
    //================================================

    
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	
	System.out.println("Your name is Trainer "+test.getName());
	System.out.println("You have "+test.getNumPokeOnMe()+" Pokemon on you");
	System.out.println("You have a total of "+(test.getNumPokeOnMe()+test.getNumPokeInLab()) + " Pokemon");	
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	System.out.println("These are the Pokemon in your lab:\n" +test.getPokeInLab().toString());

	System.out.println();
        System.out.println(test.checkBag());
	System.out.println("Bought 10 more potions.");
	test.setPotions(1, 10);
	System.out.println(test.checkBag());

	System.out.println("You have "+test.getMoney()+ " PokeDollars");
	System.out.println("You bought 10 MasterBalls");
	test.setPokeballs(4, 10);
	test.setMoney(test.getMoney()-200);
	System.out.println("PokeDollars: "+ test.getMoney());
	System.out.println(test.getPokeballs());


	Pokemon test2= new Pokemon("Eevee");
	test2.setHP(1);
	test2.setMaxHP(3);
	System.out.println("Testing thow Pokeball================");
	test.throwPokeball(test2);
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	System.out.println("The name of your first Pokemon is "+test.getPokeOnMe().get(0).getName());

	System.out.println("Choosing starter Pokemon");
	test.chooseStarter();
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
    }
} 
