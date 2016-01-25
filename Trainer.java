import java.util.ArrayList;
import cs1.Keyboard;

public class Trainer{
    //=============Instance Vars===================================
    public String TrainerName;
    
    private ArrayList<Pokemon> onMePokemon;//Array of the Pokemon on you
    private ArrayList<Pokemon> inLabPokemon;//Array of Pokemon stored in the lab
    private ArrayList Pokeballs;//Array of your Pokeballs-Pokeball, Great Ball, Ultra Ball, Master Ball
    private ArrayList Potions;//Array of your Potions- Potion, Super Potion, Hyper Potion,  Max Potion
    private int PokeDollars;
    private int numPokeOnMe;
    private int numPokeInLab;
    private int currentTown;
    private Boolean inAdventure;
    private int xCoor;
    private int yCoor;
    private String type; 
    //================================================

    //===============Constructors=================================
    public Trainer(){
	TrainerName= "Pokemon Trainer";
	onMePokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	inLabPokemon= new ArrayList<Pokemon>();//Trainer starts with no Pokemon
	createPokeballs();
	createPotions();
	PokeDollars= 500;//Trainer starts with 500 money
	currentTown= 0;
	inAdventure= true;
	yCoor= 0;
	xCoor= 0;
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
    public int getCurrentTown(){
	return currentTown;
    }
    public Boolean getInAdventure(){
	return inAdventure;
    }

    public Pokemon getRare(){
	Pokemon rare;
	rare= new Pokemon("Mew");
	return rare;
    }
    public Pokemon getUncommon(){
	Pokemon uncommon;
	uncommon= new Pokemon("Pikachu");
	return uncommon;
    }
    public Pokemon getCommon(){
	Pokemon common;
	common= new Pokemon("Mew");
	return common;
    }
    //================================================

    //================Mutators================================
    /*Trainer chooses to buy:
      1: Potion
      2: Super Potion
      3: Hyper Potion
      4: Max Potion
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
    public void setInAdventure(Boolean bool){
	inAdventure= bool;
    }
    public void setCurrentTown(int town){
	currentTown= town;
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
    //Trainers starts with 10 Potions, 5 Super Potions, 0 Hyper Potions, and 0 Max Potions
    public void createPotions(){
	Potions= new ArrayList();
	Potions.add("Potions");
	Potions.add(10);
	Potions.add("Super Potions");
	Potions.add(5);
	Potions.add("Hyper Potions");
	Potions.add(0);
	Potions.add("Max Potions");
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
		    System.out.println("You caught a "+pokemonToCatch.getName()+"!");
		    catchPokemon(pokemonToCatch);
		}else{
		    System.out.println("Awww. "+ pokemonToCatch.getName()+ " escaped from the pokeball.");
		}
	    }
	}
    }
    
    //calculates the possibility of catching the Pokemon
    public Boolean blinkingPokeball(Pokemon pokemonToCatch, int pokeball){
	//System.out.println("Your original chance of failing: " + ((pokemonToCatch.getHPT()+0.00)/pokemonToCatch.getMaxHP()));*/
	
	double chanceFail= (pokemonToCatch.getHPT()*3.0)/(pokemonToCatch.getHP()*2.0);
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
	String choice = Keyboard.readString();

	Pokemon starter;
	if (choice.equals("1")){
	    starter= new Pokemon("Charmander");
	    catchPokemon(starter);}
	else if (choice.equals("2")){
	    starter= new Pokemon("Squirtle");
	    catchPokemon(starter);}
	else if (choice.equals("3")){
	    starter= new Pokemon("Bulbsaur");
	    catchPokemon(starter);}
	else{
	    System.out.println("Please enter a number between 1-3 inclusive");
	    chooseStarter();
	}
    }

    
    //1= potion 20HP, 2= Super Potion 50HP, 3= Hyper Potion 200HP, 4= Max Potion
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
		    pokemon.setHPT(pokemon.getHP());
		else
		    pokemon.setHPT(pokemon.getHPT()+addHP(choice));
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

    public void shop(){
	checkBag();
	System.out.println("Where would you like to go?");
	System.out.println("1: Potion Shop\n2: Pokeball Shop\n3: Exit");
	String choice= Keyboard.readString();
	if (choice.equals("1")){
	    buyPotions();
	}else if(choice.equals("2")){
	    buyPokeballs();
	}else if(choice.equals("3")){
	    System.out.println("Map");
	    return;
	}else{
	    System.out.println("Please enter a number between 1-3 inclusive");
	    shop();
	}
    }

    public void buyPotions(){
	System.out.println("Which potion would you like to buy?");
	System.out.println("Name      \tHealing   \tCost");
	System.out.println("1: Potion\t20HP     \t300PokeDollars");
	System.out.println("2: Super Potion\t50HP     \t700PokeDollars");
	System.out.println("3: Hyper Potion\t200HP     \t1200PokeDollars");
	System.out.println("4: Max Potion\tMaxHP     \t2500PokeDollars");
	System.out.println("5: Exit Shop");
	String choiceStr= Keyboard.readString();
	
	if (choiceStr.equals("5")){
	    System.out.println("shop here");//shop();
	}else{
	    if (isNum(choiceStr)){
		int choice= Integer.parseInt(choiceStr);
		System.out.println("How many "+getName(Potions, choice)+" would you like to buy?");
		int amount=Keyboard.readInt();
		if (choice==1){
		    if (canAfford(300, amount)){
			setPotions(1, amount);
			setMoney(getMoney()-(300*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPotions();
		    }
		}else if(choice==2){
		    if (canAfford(700, amount)){
			setPotions(2, amount);
			setMoney(getMoney()-(700*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPotions();
		    }
		}else if(choice==3){
		    if (canAfford(1200, amount)){
			setPotions(3, amount);
			setMoney(getMoney()-(1200*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPotions();
		    }
		}else if(choice==4){
		    if (canAfford(2500, amount)){
			setPotions(4, amount);
			setMoney(getMoney()-(2500*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPotions();
		    }
		}
	    }else{
		System.out.println("Please enter a number between 1-5 inclusive");
		buyPotions();
	    }
	}
    }
    public void buyPokeballs(){
	System.out.println("Which pokeball would you like to buy?");
	System.out.println("Name      \tRate Success   \tCost");
	System.out.println("1: Pokeball\t1x          \t200PokeDollars");
	System.out.println("2: Great Ball\t1.5x     \t600PokeDollars");
	System.out.println("3: Ultra Ball\t2x          \t1200PokeDollars");
	System.out.println("4: Exit Shop");
	String choiceStr= Keyboard.readString();
	
	if (choiceStr.equals("4")){
	    System.out.println("shop here");//shop();
	}else{
	    if (isNum(choiceStr)){
		int choice= Integer.parseInt(choiceStr);
		System.out.println("How many "+getName(Pokeballs, choice)+" would you like to buy?");
		int amount=Keyboard.readInt();
		if (choice==1){
		    if (canAfford(300, amount)){
			setPokeballs(1, amount);
			setMoney(getMoney()-(200*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPokeballs();
		    }
		}else if(choice==2){
		    if (canAfford(700, amount)){
			setPokeballs(2, amount);
			setMoney(getMoney()-(600*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPokeballs();
		    }
		}else if(choice==3){
		    if (canAfford(1200, amount)){
			setPokeballs(3, amount);
			setMoney(getMoney()-(1200*amount));
		    }else{
			System.out.println("Sorry you can't afford this");
			buyPokeballs();
		    }
		}
	    }else{
		System.out.println("Please enter a number between 1-4 inclusive");
		buyPokeballs();
	    }
	}
    }
    
    public Boolean canAfford(int cost, int amount){
	int totalCost= cost*amount;
	return getMoney()>= totalCost;
    }

    public void move(Maps map){
	System.out.println("What do you want to do?");
	System.out.println("1: Up\n2: Move Right\n3: Move Down\n4: Move Left\n5: Check Bag\n6: Check the Pokemon on Me");
	String choiceStr= Keyboard.readString();
	
	if ("123456".indexOf(choiceStr)==-1){
	    System.out.println("Please choose a number between 1-5 inclusijve");
	}else{
	    if (choiceStr.equals("1")){
		if (yCoor== 0){
		    System.out.println("Reached end of map");
		}else{
		    yCoor-=1;
		    map.setYCoor(yCoor);
		}
	    }else if (choiceStr.equals("2")){
		if (xCoor== map.getDefault()-1){
		    System.out.println("Reached end of map");
		}else{
		    xCoor+=1;
		    map.setXCoor(xCoor);
		}
	    }else if (choiceStr.equals("3")){
		if (yCoor== map.getDefault()-1){
		    System.out.println("Reached end of map");
		}else{
		    yCoor+=1;
		    map.setYCoor(yCoor);
		}
	    }else if (choiceStr.equals("4")){
		if (xCoor== 0){
		    System.out.println("Reached end of map");
		}else{
		    xCoor-=1;
		    map.setXCoor(xCoor);
		}
	    }else if (choiceStr.equals("5")){
		System.out.println(checkBag());
	    }else if (choiceStr.equals("6")){
		System.out.println(getPokeOnMe());
	    }else{
		System.out.println("Please choose a number between 1-5 inclusijve");
	    }
	}
	map.placeHuman();
	System.out.println(map.getMap());
	move(map);
	
    }
    public Boolean encounter(){
	int randNum= (Integer)((Math.random()+1)*3);
	if (randNum==1){
	    meetPokemon();
	}else{
	    System.out.println("No sign of any Pokemon here");
	}
    }
    
    public Pokemon meetPokemon(){
	int randNum= (Integer)((Math.random()+1)*100);
	if (randNum< 10){
	    System.out.println("Rare 10%");
	}else if (randNum< 40){
	    System.out.println("Uncommon 30%");
	}else if (randNum< 100){
	    System.out.println("Common 60%");
	}
	
    }

    public void battlePokemon(Pokemon enemy){
	System.out.println("Which Pokemon would you like to use?");
    }

    //================================================

    
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	/*
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
	  test2.setHPT(1);
	  test2.setHP(3);
	  System.out.println("Testing how Pokeball================");
	  test.throwPokeball(test2);
	  System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());
	  //System.out.println("The name of your first Pokemon is "+test.getPokeOnMe().get(0).getName());

	  System.out.println("Choosing starter Pokemon");
	  test.chooseStarter();
	  System.out.println("These are the Pokemon on you:\n" +test.getPokeOnMe().toString());

	  test.usePotions(test.getPokeOnMe().get(0));
	  System.out.println(test.getPokeOnMe().get(0).getHP());
	*/
	/*System.out.println("Should be Potions: "+test.getName(test.getPotions(), 1));
	  System.out.println("Should be 20: "+test.getAmount(test.getPotions(), 1));*/
	/*
	  test.buyPotions();
	  System.out.println(test.checkBag());

	  test.buyPokeballs();
	  System.out.println(test.checkBag());
	*/
	Maps testing= new Maps();
	System.out.println(testing.getMap());
	test.move(testing);
	

	    
    }
    
    
}
