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
    public String getTrainerName(){
	return TrainerName;
    }
    public ArrayList<Pokemon> getPokeOnMe(){
	return onMePokemon;
    }
    public int getNumPokeOnMe(){
	return onMePokemon.size();
    }
    public ArrayList<Pokemon> getPokeInLab(){
	return inLabPokemon;
    }
    public int getNumPokeInLab(){
	return inLabPokemon.size();
    }
    public ArrayList getPotions(){
	return Potions;
    }
    public String getPotionsStr(){
	String retStr= "";
	for(int i= 0;i<Potions.size(); i+=2){
	    retStr+= ((i/2+1) + "- " );
	    retStr+= Potions.get(i)+": ";
	    retStr+= Potions.get(i+1)+"\n";
	}
	return retStr;
    }
    public ArrayList getPokeballs(){
	return Pokeballs;
    }
    public String getPokeballsStr(){
	String retStr= "";
	for(int i= 0;i<Pokeballs.size(); i+=2){
	    retStr+= ((i/2+1) + "- " );
	    retStr+= Pokeballs.get(i)+ ": ";
	    retStr+= Pokeballs.get(i+1)+"\n";
	}
	return retStr;
    }
    public int getMoney(){
	return PokeDollars;
    }

    public String getName(ArrayList arr, int choice){
	choice*=2;
	choice-=2;
	return (String)(arr.get(choice));
    }

    public int getAmount(ArrayList arr, int choice){
	choice*=2;
	choice-=1;
	return (Integer)(arr.get(choice));
    }
    //================================================

    //================Mutators================================
    /*Trainer chooses to buy:
      1: Potion
      2: Super Potion
      3: Hyper Potion
      4: Full Potion
      choice is the number they choose and num is the amount they bought*/
    public void setPotions(int choice, int num){
	Potions.set(choice*2-1, (getAmount(Potions, choice)+num));
    }
    /*Trainer chooses to buy:
      1: Pokeball
      2: Great Ball
      3: Ultra Ball
      4: Master Ball
      name is the number they choose and num is the amount they bought*/
    public void setPokeballs(int choice, int num){
	Pokeballs.set(choice*2-1, getAmount(Pokeballs, choice)+num);
    }
    public void setMoney(int newMoney){
	PokeDollars= newMoney;
    }
    //================================================

    //==============Methods==================================
    //Trainers starts with 5 Pokeball, 0 Great Ball, 0 Ultra Ball, and 0 Master Ball
    public void createPokeballs(){
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
    public void createPotions(){
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
    public void throwPokeball(Pokemon pokemonToCatch){
	System.out.println("Which Pokeball do you want to use?\nYour backpack:");
	System.out.println(getPokeballsStr());
	String PokeChoiceStr = Keyboard.readString();

	//if input is not within "1234", return message and recurse
	if (!isNum(PokeChoiceStr)){
	    System.out.println("Please enter a number between 1-4 inclusive");
	    throwPokeball(pokemonToCatch);
	}else{
	
	    int PokeChoice= Integer.parseInt(PokeChoiceStr);
	    if (!(PokeChoice >0 && PokeChoice<5)){
		System.out.println("Please enter a number between 1-4 inclusive");
		throwPokeball(pokemonToCatch);
	    }
	
	    //if there are <= 0 of that Pokeball, return message and recurse
	    else if (getAmount(Pokeballs, PokeChoice) < 1 ){
		System.out.println("You are out of "+ getName(Pokeballs, PokeChoice));
		throwPokeball(pokemonToCatch);
	    }else{
	
		setPokeballs(PokeChoice, -1);
		if (blinkingPokeball(pokemonToCatch, PokeChoice)){
		    System.out.println("You caught a  "+pokemonToCatch.getName()+"!");
		    catchPokemon(pokemonToCatch);
		}else{
		    System.out.println("Awww. "+ pokemonToCatch.getName()+ " escaped from the pokeball.");
		}
	    }
	}
    }
    
    //calculates the possibility of catching the Pokemon
    public Boolean blinkingPokeball(Pokemon pokemonToCatch, int pokeball){
	//System.out.println("Your original chance of failing: " + ((pokemonToCatch.getHP()+0.00)/pokemonToCatch.getMaxHP()));*/
	
	double chanceFail= (pokemonToCatch.getHP()*3.0)/(pokemonToCatch.getMaxHP()*2.0);
	//System.out.println("Your chance of failing after adjustment: "+ chanceFail);
	
	if (pokeball==1)
	    chanceFail/= 1;
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
    public void catchPokemon(Pokemon newPokemon){
	if (getNumPokeOnMe()> 5){
	    inLabPokemon.add(newPokemon);
	    System.out.println("Max number of Pokemon you can carry was reached, so "+newPokemon.getName() +" was sent to lab.");
	}else{
	    onMePokemon.add(newPokemon);
	    System.out.println(newPokemon.getName()+ " was sent to your backpack. You now have "+getNumPokeOnMe()+" Pokemon on you.");
	}
    }

    public void fight(){
	
    }

    //Returns a string of all your Pokeballs and Potions.
    public String checkBag(){
	return "These are the items in your backpack:\n"+
	    "Here are your Potions:\n"+getPotionsStr()+
	    "\nHere are your Pokeballs:\n"+getPokeballsStr()+
	    "\nPokeDollars: "+getMoney()+ "\n";
    }

    public void chooseStarter(){
	System.out.println("Which starter Pokemon do you choose?");
	System.out.println("1: Charmander");
	System.out.println("2: Squirtle");
	System.out.println("3: Bulbsaur");
	String choiceStr = Keyboard.readString();
	
	if ("123".indexOf(choiceStr)==-1){
	    System.out.println("Please enter a number between 1-3 inclusive");
	    chooseStarter();
	}else{
	
	    int choice= Integer.parseInt(choiceStr);
	    if (!(choice > 0 && choice < 4)){
		System.out.println("Please enter a number between 1-3 inclusive");
		chooseStarter();
	    }else{
		Pokemon starter;
		if (choice == 1)
		    starter= new Pokemon("Charmander");
		else if (choice == 2)
		    starter= new Pokemon("Squirtle");
		else 
		    starter= new Pokemon("Bulbsaur");
		catchPokemon(starter);
	    }
	}
    }
    
    //1= potion 20HP, 2= Super Potion 50HP, 3= Hyper Potion 200HP, 4= Full Potion
    public void usePotions(Pokemon pokemon){
	System.out.println("Which potion would you like to use?");
	System.out.println(getPotionsStr());
	String choiceStr = Keyboard.readString();

	if (!isNum(choiceStr)){
	    System.out.println("Please enter a number between 1-4 inclusive");
	    usePotions(pokemon);
	}else{

	    int choice= Integer.parseInt(choiceStr);
	    if (!(choice> 0&& choice<5)){
		System.out.println("Please enter a number between 1-4 inclusive");
		usePotions(pokemon);
	    }
	
	    //checks if you have 
	    else if ( getAmount(Potions, choice) <= 0 ){
		System.out.println("You are out of "+ getName(Potions, choice));
		usePotions(pokemon);
	    }else{
	
		setPotions(choice, -1);
		if (choice== 4)
		    pokemon.setHP(pokemon.getMaxHP());
		else
		    pokemon.setHP(pokemon.getHP()+addHP(choice));
	    }
	}
    }

    public int addHP(int choice){
	int retInt= 0;
	if (choice == 1)
	    retInt= 20;
	else if (choice == 2 )
	    retInt= 50;
	else if (choice == 3 )
	    retInt= 200;
	return retInt;
    }

    public Boolean isNum(String str){
	return "1234".indexOf(str) != -1;
    }

    //================================================

    
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	
	System.out.println("Your name is Trainer "+test.getTrainerName());
	System.out.println("You have "+test.getNumPokeOnMe()+" Pokemon on you");
	System.out.println("You have a total of "+(test.getNumPokeOnMe()+test.getNumPokeInLab()) + " Pokemon");	
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	System.out.println("These are the Pokemon in your lab:\n" +test.getPokeInLab().toString());

	System.out.println();
	System.out.println(test.checkBag());
	System.out.println("Got 10 more potions.");
	test.setPotions(1, 10);
	System.out.println(test.checkBag());
    
	System.out.println("You bought 10 MasterBalls");
	test.setPokeballs(4, 10);
	test.setMoney(test.getMoney()-200);
	System.out.println("PokeDollars: "+ test.getMoney());
	System.out.println(test.getPokeballsStr());
	

	Pokemon test2= new Pokemon("Eevee");
	test2.setHP(1);
	test2.setMaxHP(3);
	System.out.println("Testing thow Pokeball================");
	test.throwPokeball(test2);
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	//System.out.println("The name of your first Pokemon is "+test.getPokeOnMe().get(0).getName());

	System.out.println("Choosing starter Pokemon");
	test.chooseStarter();
	System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());

	test.usePotions(test.getPokeOnMe().get(0));
	System.out.println(test.getPokeOnMe().get(0).getHP());
    
	/*System.out.println("Should be Potions: "+test.getName(test.getPotions(), 1));
	  System.out.println("Should be 20: "+test.getAmount(test.getPotions(), 1));*/
    }

}
