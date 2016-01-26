//meetPotions


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
	currentTown= 1;
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
    public int getAvgLvl(){
	double level=0.0;
	for(int i= 0; i<getNumPokeOnMe();i++){
	    level+= getPokeOnMe().get(i).getLevel();
	}
	return (int)(level/getNumPokeOnMe());
    }
    public int getXCoor(){
	return xCoor;
    }
    public int getYCoor(){
	return yCoor;
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
    public void setXCoor(int x){
	xCoor= x;
    }
    public void setYCoor(int y){
	yCoor= y;
    }
    //================================================

    //==============Methods==================================
    //Trainers starts with 5 Pokeball, 0 Great Ball, 0 Ultra Ball, and 0 Master Ball
    public void createPokeballs(){
	Pokeballs= new ArrayList();
	Pokeballs.add("Pokeball");
	Pokeballs.add(5);
	Pokeballs.add("Great Ball");
	Pokeballs.add(0);
	Pokeballs.add("Ultra Ball");
	Pokeballs.add(0);
	Pokeballs.add("Master Ball");
	Pokeballs.add(0);
    }
    //Trainers starts with 10 Potions, 5 Super Potions, 0 Hyper Potions, and 0 Max Potions
    public void createPotions(){
	Potions= new ArrayList();
	Potions.add("Potion");
	Potions.add(10);
	Potions.add("Super Potion");
	Potions.add(5);
	Potions.add("Hyper Potion");
	Potions.add(0);
	Potions.add("Max Potion");
	Potions.add(0);
    }
    

    //thows Pokeball. Catches Pokemon depending on the stats
    public void throwPokeball(Pokemon pokemonToCatch){
	System.out.println("Which Pokeball do you want to use?\nYour backpack:");
	System.out.println(getPokeballsStr());
	System.out.println("5- Exit");
	String PokeChoiceStr = Keyboard.readString();
	System.out.println("");
	
	//if input is not within "1234", return message and recurse
	if ("12345".indexOf(PokeChoiceStr)==-1){
	    System.out.println("Please enter a number between 1-5 inclusive");
	    throwPokeball(pokemonToCatch);
	}else{
	
	    int PokeChoice= Integer.parseInt(PokeChoiceStr);
	    if (!(PokeChoice >0 && PokeChoice<6)){
		System.out.println("Please enter a number between 1-5 inclusive");
		throwPokeball(pokemonToCatch);
	    }
	    else if(PokeChoice==5){
		return;
	    //if there are <= 0 of that Pokeball, return message and recurse
	    }else if (getAmount(Pokeballs, PokeChoice) < 1 ){
		System.out.println("You are out of "+ getName(Pokeballs, PokeChoice));
		throwPokeball(pokemonToCatch);
	    }else{

		setPokeballs(PokeChoice, -1);
		if (blinkingPokeball(pokemonToCatch, PokeChoice)){
		    System.out.println("You caught a "+pokemonToCatch.getName()+"!");
		    catchPokemon(pokemonToCatch);
		    pokemonToCatch.setIsCaught(true);
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
	    newPokemon.setHPT(newPokemon.getHP());
	    inLabPokemon.add(newPokemon);
	    System.out.println("Max number of Pokemon you can carry was reached, so "+newPokemon.getName() +" was sent to lab.");
	}else{
	    newPokemon.setHPT(newPokemon.getHP());
	    onMePokemon.add(newPokemon);
	    newPokemon.setIsCaught(true);
	    System.out.println(newPokemon.getName()+ " was sent to your backpack. You now have "+getNumPokeOnMe()+" Pokemon on you.");
	}
    }


    //Returns a string of all your Pokeballs and Potions.
    public String checkBag(){
	return "These are the items in your backpack:\n"+
	    "Here are your Potions:\n"+getPotionsStr()+
	    "\nHere are your Pokeballs:\n"+getPokeballsStr()+
	    "\nPokeDollars: "+getMoney()+ "\n";
    }
    
    //choose your starter Pokemon
    public void chooseStarter(){
	System.out.println("Which starter Pokemon do you choose?");
	System.out.println("1: Charmander");
	System.out.println("2: Squirtle");
	System.out.println("3: Bulbasaur");
	String choice = Keyboard.readString();
	System.out.println("");

	Pokemon starter;
	if (choice.equals("1")){
	    starter= new Pokemon("Charmander");
	    catchPokemon(starter);}
	else if (choice.equals("2")){
	    starter= new Pokemon("Squirtle");
	    catchPokemon(starter);}
	else if (choice.equals("3")){
	    starter= new Pokemon("Bulbasaur");
	    catchPokemon(starter);}
	else{
	    System.out.println("Please enter a number between 1-3 inclusive");
	    chooseStarter();
	}
    }

    
    //1= potion 20HP, 2= Super Potion 50HP, 3= Hyper Potion 200HP, 4= Max Potion
    //Use potion on input Pokemon
    public void usePotions(Pokemon pokemon){
	System.out.println("Which potion would you like to use?");
	System.out.println(getPotionsStr());
	System.out.println("5- Exit");
	String choiceStr = Keyboard.readString();
	System.out.println("");
	

	if ("12345".indexOf(choiceStr)==-1){
	    System.out.println("Please enter a number between 1-4 inclusive");
	    usePotions(pokemon);
	}else{

	    int choice= Integer.parseInt(choiceStr);
	    if (!(choice> 0&& choice<6)){
		System.out.println("Please enter a number between 1-5 inclusive");
		usePotions(pokemon);
	    }
	    else if (choice==5)
		return;
	    //checks if you have 
	    else if ( getAmount(Potions, choice) <= 0 ){
		System.out.println("You are out of "+ getName(Potions, choice));
		usePotions(pokemon);
	    }else{
	
		setPotions(choice, -1);
		
		if (choice== 4){
		    pokemon.setHPT(pokemon.getHP());
		    System.out.println("Your "+pokemon.getName()+" now has full HP");
		}
		else{
		    pokemon.setHPT(pokemon.getHPT()+addHP(choice));
		    if (pokemon.getHPT()> pokemon.getHP()){
			pokemon.setHPT(pokemon.getHP());
		    }
		    System.out.println("Your "+pokemon.getName()+" now has "+ pokemon.getHPT()+" HP");
		}
	    }
	}
    }

    //calculates the HP a Pokemon adds depending on the choice
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



    //directs you to buy potion or pokeballs
    public void shop(){
	checkBag();
	System.out.println("Where would you like to go?");
	System.out.println("1: Potion Shop\n2: Pokeball Shop\n3: Exit");
	String choice= Keyboard.readString();
	System.out.println("");
	
	if (choice.equals("1")){
	    buyPotions();
	}else if(choice.equals("2")){
	    buyPokeballs();
	}else if(choice.equals("3")){
	    return;
	}else{
	    System.out.println("Please enter a number between 1-3 inclusive");
	    shop();
	}
    }

    //allows you to buy potions
    public void buyPotions(){
	System.out.println(checkBag());
	System.out.println("Which potion would you like to buy?");
	System.out.println("Name      \tHealing   \tCost");
	System.out.println("1: Potion\t20HP     \t300PokeDollars");
	System.out.println("2: Super Potion\t50HP     \t700PokeDollars");
	System.out.println("3: Hyper Potion\t200HP     \t1200PokeDollars");
	System.out.println("4: Max Potion\tMaxHP     \t2500PokeDollars");
	System.out.println("5: Exit Shop");
	String choiceStr= Keyboard.readString();
	System.out.println("");
	 
	if (choiceStr.equals("5")){
	    System.out.println("shop here");//shop();
	}else{
	    if ("1234".indexOf(choiceStr)!=-1){
		int choice= Integer.parseInt(choiceStr);
		System.out.println("How many "+getName(Potions, choice)+" would you like to buy?");
		int amount=Keyboard.readInt();
		System.out.println("");
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

    //allows you to buy pokeballs
    public void buyPokeballs(){
	System.out.println(checkBag());
	System.out.println("Which pokeball would you like to buy?");
	System.out.println("Name      \tRate Success   \tCost");
	System.out.println("1: Pokeball\t1x          \t200PokeDollars");
	System.out.println("2: Great Ball\t1.5x     \t600PokeDollars");
	System.out.println("3: Ultra Ball\t2x          \t1200PokeDollars");
	System.out.println("4: Exit Shop");
	String choiceStr= Keyboard.readString();
	System.out.println("");
	
	if (choiceStr.equals("4")){
	    System.out.println("shop here");//shop();
	}else{
	    if ("1234".indexOf(choiceStr)!=-1){
		int choice= Integer.parseInt(choiceStr);
		System.out.println("How many "+getName(Pokeballs, choice)+" would you like to buy?");
		int amount=Keyboard.readInt();
		System.out.println("");
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

    //returns whether you can afford something
    public Boolean canAfford(int cost, int amount){
	int totalCost= cost*amount;
	return getMoney()>= totalCost;
    }

    //allows you to heal your pokemon
    public void choosePotion(){
	System.out.println("Which Pokemon would you like to heal?");
        String pokeOnMe= "";
	for (int i= 0; i< getNumPokeOnMe(); i++){
	    pokeOnMe+= (i+1)+": "+getPokeOnMe().get(i);
	}
	System.out.println(pokeOnMe);
	int pokeToHeal= Keyboard.readInt();
	usePotions(getPokeOnMe().get(pokeToHeal-1));
    }
    
    //allows you to travel on the map
    public void move(Maps map){
	System.out.println(map.getMap());
	System.out.println("What do you want to do?");
	System.out.println("1: Move Up\n2: Move Right\n3: Move Down\n4: Move Left\n5: Check Bag\n6: Check the Pokemon on Me\n7: Use Potion");
	System.out.println("8: Go to the Healing Center for 3,000 PokeDollars");
	System.out.println("9: Go shopping");
	System.out.println("10: Swap with Pokemon in Lab");
	String choiceStr= Keyboard.readString();
	System.out.println("");
	
	if ("123456789".indexOf(choiceStr)==-1){
	    System.out.println("Please choose a number between 1-9 inclusive");
	}else if (choiceStr.equals("5")){
	    System.out.println(checkBag());
	}else if (choiceStr.equals("6")){
	    System.out.println("Here are the Pokemon you have on you");
	    System.out.println(getPokeOnMe());
	}else if (choiceStr.equals("7")){
	    choosePotion();
	}else if (choiceStr.equals("8")){
	    healingCenter();
	}else if (choiceStr.equals("9")){
	    shop();
	}else if (choiceStr.equals("10")){
	    if (getNumPokeInLab()== 0){
		System.out.println("You don't have any Pokemon in your lab");
	    }else{
		swapPokemon();
	    }
	}else{
	    //sets xCoor and yCoor
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
	    }
	    
	    if (map.getXCoor()== (map.getSize()-1)&& map.getYCoor()== (map.getSize()-1)){
		map.placeHuman();//adds the player
		if (gymBattle());{
		    setXCoor(0);
		    setYCoor(0);
		    setCurrentTown(getCurrentTown()+1);
		}
	    }else{
		map.placeHuman();//adds the player
		//chance of finding objects
		if (encounterPotions()){
		    meetPotions();
		}
		if (encounterPokeballs()){
		    meetPokeballs();
		}
		if (encounterMoney()){
		    meetMoney();
		}
		//generates and fight a wild pokemon
	   
		if (encounterPoke()){

		    Pokemon wildPoke = getRandomPokemon( getCurrentTown() );
		    System.out.println("A wild "+wildPoke.getName()+" appeared!");
		    if (!stillAlive()){
			System.out.println("None of your Pokemon has the energy to fight. Go to the next town to heal or use potions");
		    }else{
			while(wildPoke.isAlive()&&stillAlive()&&!(wildPoke.getIsCaught())){
			    System.out.println("What will you do?");
			    System.out.println("1: Battle\n2: Run");
			    int choice=Keyboard.readInt();
			    System.out.println("");
			
			    if (choice==1){
				battlePokemon(wildPoke);
			    }else if (choice== 2){
				break;
			    }else{
				System.out.println("Choose 1 or 2");   
			    }
			}
		    }
		}
	    }
	}
	//recursion
	move(map);
	
    }
    //generates a random pokemon depending on the town
    public Pokemon getRandomPokemon( int town ) {
	String name = getRandomName( town );
	Pokemon poke = new Pokemon(name,getAvgLvl());
	return poke;
    }
    //generates a random pokemon name depending on the town
    public String getRandomName( int town ) {
	ArrayList<String> arr = new ArrayList<String>();
	arr = CSVMaster.CSVtoArray("Town" + town + ".csv");
	int pNum = (int)(Math.random() * arr.size()-1);
	double random = Math.random()*100;
	
	if( 100-Double.parseDouble(CSVMaster.singleLine(arr.get(pNum+1))[2]) < random ) {
	    String pokeName = CSVMaster.singleLine(arr.get(pNum+1))[1];
	
	    return pokeName;
	}
	else{
	    return getRandomName( town );
	}
    }
    //stimutates a pokemon battle
    public void battlePokemon(Pokemon enemy){
	while(enemy.isAlive()&& stillAlive()&& !(enemy.getIsCaught())){
	    System.out.println("Which Pokemon would you like to use?");
	    String pokeOnMe= "";
	    for (int i= 0; i< getNumPokeOnMe(); i++){
		if (getPokeOnMe().get(i).getHPT()>0){
		    pokeOnMe+= (i+1)+": "+getPokeOnMe().get(i);
		}
	    }
	    System.out.println(pokeOnMe);
	    int pokeChoice=Keyboard.readInt();
	    if (pokeChoice> getNumPokeOnMe()|| pokeChoice< 0){
		System.out.println("Choose a valid number");
		battlePokemon(enemy);
	    }else{
		System.out.println("");
		pokeChoice-=1;

		Pokemon yourPokemon= getPokeOnMe().get(pokeChoice);

		while(enemy.isAlive()&& yourPokemon.isAlive()&& !(enemy.getIsCaught())){
		    System.out.println("");
		    System.out.println(enemy);
		    System.out.println("\t\t\t/$$    /$$  /$$$$$$");
		    System.out.println("\t\t\t| $$   | $$ /$$__  $$");
		    System.out.println("\t\t\t| $$   | $$| $$  \\__/");
		    System.out.println("\t\t\t|  $$ / $$/|  $$$$$$ ");
		    System.out.println("\t\t\t \\  $$ $$/  \\____  $$");
		    System.out.println("\t\t\t  \\  $$$/   /$$  \\ $$");
		    System.out.println("\t\t\t   \\  $/   |  $$$$$$/");
		    System.out.println("\t\t\t    \\_/     \\______/ ");
                     
		    System.out.println(yourPokemon);
		    System.out.println("What would you like to do?");
		    System.out.println("1: Attack\n2: Pokeball\n3: Potion\n4: Change Pokemon\n5: Run");
		    int battleChoice=Keyboard.readInt();
		    System.out.println("");
		    if (battleChoice== 1){
			yourPokemon.battle(enemy, this);
			int temp=(int) ((Math.random()*100)+enemy.getLevel()*50);
			setMoney(getMoney()+temp);
			System.out.println("You earned "+temp+" PokeDollars. You now have "+getMoney()+" PokeDollars");
		    }else if(battleChoice== 2){
			throwPokeball(enemy);
			if (!enemy.getIsCaught()){
			    enemy.attackT(yourPokemon);
			}
		    }else if(battleChoice== 3){
			usePotions(yourPokemon);
			enemy.attackT(yourPokemon);
		    }else if(battleChoice== 4){
			break;
		    }else if (battleChoice==5 ){
			enemy.setIsCaught(true);
			return;
		    }
		}
		if(!stillAlive()){
		    System.out.println("All of your Pokemon have been defeated.");
		}
	    }
	}
    }

    //stimutates a trainer battle
    public void battlePokemonT(Pokemon enemy){
	while(enemy.isAlive()&& stillAlive()&& !(enemy.getIsCaught())){
	    System.out.println("Which Pokemon would you like to use?");
	    String pokeOnMe= "";
	    for (int i= 0; i< getNumPokeOnMe(); i++){
		if (getPokeOnMe().get(i).getHPT()>0){
		    pokeOnMe+= (i+1)+": "+getPokeOnMe().get(i);
		}
	    }
	    System.out.println(pokeOnMe);
	    int pokeChoice=Keyboard.readInt();
	    if (pokeChoice> getNumPokeOnMe()|| pokeChoice< 0){
		System.out.println("Choose a valid number");
		battlePokemon(enemy);
	    }else{
		System.out.println("");
		pokeChoice-=1;

		Pokemon yourPokemon= getPokeOnMe().get(pokeChoice);

		while(enemy.isAlive()&& yourPokemon.isAlive()&& !(enemy.getIsCaught())){
		    System.out.println("What would you like to do?");
		    System.out.println("1: Attack\n2: Potion\n3: Change Pokemon\n");
		    int battleChoice=Keyboard.readInt();
		    System.out.println("");
		    if (battleChoice== 1){
			yourPokemon.battle(enemy, this);
		    }else if(battleChoice== 2){
			usePotions(yourPokemon);
			enemy.attackT(yourPokemon);
		    }else if(battleChoice== 3){
			break;
		    }
		}
		if(!stillAlive()){
		    System.out.println("All of your Pokemon have been defeated.");
		}
	    }
	}
    }
    
    //makes sure at least 1 Pokemon is still alive
    public Boolean stillAlive(){
	for (int i=0; i<getNumPokeOnMe(); i++){
	    if (getPokeOnMe().get(i).getHPT()>0){
		return true;
	    }
	}
	return false;
    }

    //returns whether you will encounter a Pokemon or objects
    public Boolean encounterPoke(){
        return Math.random()<.33;
    }
    public Boolean encounterPotions(){
        return Math.random()<1.0;
    }
    public Boolean encounterPokeballs(){
        return Math.random()<.40;
    }
    public Boolean encounterMoney(){
        return Math.random()<.50;
    }
    
    //generates objects
    public void meetPotions(){
	double chance = Math.random();
	String findPotion;
	if (chance< .5){
	    setPotions(1, 1);
	    findPotion= getName(Potions, 1);
	}else if (chance< .75){
	    setPotions(2, 1);
	    findPotion= getName(Potions, 2);
	}else if (chance< .95){
	    setPotions(3, 1);
	    findPotion= getName(Potions, 3);
	}else{
	    setPotions(4, 1);
	    findPotion= getName(Potions, 4);
	}
	System.out.println("You found a "+ findPotion);
    }
    public void meetPokeballs(){
	double chance = Math.random();
	String findPokeball;;
	if (chance< .4){
	    setPokeballs(1, 1);
	    findPokeball= getName(Pokeballs, 1);
	}else if (chance< .6){
	    setPokeballs(2, 1);
	    findPokeball= getName(Pokeballs, 2);
	}else if (chance< .85){
	    setPokeballs(3, 1);
	    findPokeball= getName(Pokeballs, 3);
	}else{
	    setPokeballs(4, 1);
	    findPokeball= getName(Pokeballs, 4);
	}
	System.out.println("You found a "+ findPokeball);
    }
    public void meetMoney(){
	int temp= (int)(Math.random()*200);
	System.out.println("You found "+ temp+" PokeDollars");
	setMoney(temp); 
    }


    //allows you to swap pokemon from your bag to the lab
    public void swapPokemon(){
	System.out.println("Which Pokemon would you like to swap out?");
	String pokeOnMe= "";
	for (int i= 0; i< getNumPokeOnMe(); i++){
	    pokeOnMe+= (i+1)+": "+getPokeOnMe().get(i);
	}
	System.out.println(pokeOnMe);
	
	int choice1=Keyboard.readInt();
	
	if (choice1> getNumPokeOnMe()|| choice1< 0){
	    System.out.println("Choose a valid number");
	    swapPokemon();
	}else{
	    System.out.println("Which Pokemon would you like to swap with?");
	    String pokeInLab= "";
	    for (int i= 0; i< getNumPokeInLab(); i++){
		pokeInLab+= (i+1)+": "+getPokeInLab().get(i);
	    }
	    System.out.println(pokeInLab);
	
	    int choice2=Keyboard.readInt();
	    if (choice2> getNumPokeInLab()|| choice2< 0){
		System.out.println("Choose a valid number");
		swapPokemon();
	    }else{
	        Pokemon temp1= getPokeOnMe().get(choice1-1);
		Pokemon temp2= getPokeInLab().get(choice2-1);
		getPokeOnMe().remove(choice1-1);
		getPokeInLab().remove(choice2-1);
		getPokeOnMe().add(temp2);
		getPokeInLab().add(temp1);
	    }
	}
	
    }

    public void healingCenter(){
	System.out.println("Do you want to spend 3,000 PokeDollars to heal all Pokemon on you? (y/n)");
	String choice=Keyboard.readString();
	if (choice.equals("y")){
	    if (canAfford(3000, 1)){
		setMoney(getMoney()-3000);
		for (int i=0; i< getNumPokeOnMe(); i++){
		    getPokeOnMe().get(i).setHPT(getPokeOnMe().get(i).getHP());
		}
		System.out.println("All your Pokemon are fully healed");
	    }else{
		System.out.println("Sorry, you don't have enough money.");
	    }
	}
	
    }

    public Boolean gymBattle(){
	if (getCurrentTown()== 1){
	    Town1Pewter Gym =new Town1Pewter();
	    return Gym.gym(this);
	}else if (getCurrentTown()== 2){
	    Town2Cerulean Gym = new Town2Cerulean();
	    return Gym.gym(this);
	}else if (getCurrentTown()== 3){
	    Town3Vermillion Gym = new Town3Vermillion();
	    return Gym.gym(this);
	}else{
	    Town4Celadon Gym = new Town4Celadon();
	    return Gym.gym(this);
	}

    }
    //================================================

    
    public static void main(String[] args){
	Trainer test= new Trainer("Ling");
	Pokemon test1= new Pokemon("Eevee");
	System.out.println(test1.getName());
	    /*
	Pokemon test2= new Pokemon("Squirtle");
	Pokemon test3= new Pokemon("Bulbasaur");
	Pokemon test4= new Pokemon("Charmander");
	Pokemon test5= new Pokemon("Mewtwo");	
	Pokemon test6= new Pokemon("Mew");
	Pokemon test7= new Pokemon("Pikachu");
	test.catchPokemon(test1);
	test.catchPokemon(test2);
	test.catchPokemon(test3);
	test.catchPokemon(test4);
	test.catchPokemon(test5);
	test.catchPokemon(test6);
	test.catchPokemon(test7);
	test.swapPokemon();
	System.out.println(test.getPokeOnMe());
	*/
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
	/*
	Maps testing= new Maps();
	System.out.println(testing.getMap());
	test.move(testing);
	*/

	    
    }
        
}
