/*
 */

import java.util.*;

public class Pokemon {

    //instance vars
    private String _name;     //pokemon name
    private String _type;     //pokemon type
    private int _level;       //level of pokemon
    private int _num;         //pokedex number
    private int[] _attack = new int[2];      //pokemon attack--determines attack strength
    private int[] _defense = new int[2];     //pokemon defense--determines damage taken
    private int[] _HP = new int[2];          //pokemon HP--determines max damage
    private int[] _speed = new int[2];       //pokemon speed--determines first attacker
    private int[] _exp = new int[2];        //pokemon exp--determines current exp/needed exp
    private Objects[][]  _moves = new Objects[4][4];  //pokemon moves [move1,move2,move3,move4][power1,power2,power3,power4]



    //Constructors
    public Pokemon( String name ) {
	int num = CSVMaster.searchCSV( name, CSVMaster.pokeStats );
	String[] data = CSVMaster.singleLine( CSVMaster.pokeStats.get(num) );
	_name = name;
	_type = data[6];
	_level = 1;
	_num = num;
        setAttack(Integer.parseInt(data[3]));
        setDefense(Integer.parseInt(data[4]));
        setHP(Integer.parseInt(data[2]));
        setSpeed(Integer.parseInt(data[5]));
	setExp();
	//Objects[][] _moves = {} {};MOVE-GETTER FUNCTION
    }
    
    public Pokemon( String name, int level ) {
	this( name );
	_level = level;
	setAttack( getAttack() + (int)(Math.random()*2.5*level) );
	setDefense( getDefense() + (int)(Math.random()*2*level) );
	setHP( getHP() + (int)(Math.random()*3*level) );
	setSpeed( getSpeed() + (int)(Math.random()*2*level) );
	setExp();
	//MOVE-GETTER FUNCTION
    }

    public Pokemon( String name, int level, ArrayList<Objects> moveList ) {
	this( name, level );
	//MOVE-GETTER FUNCTION
    }
		   

    //accessors
    public String getName() {
	return _name;
    }  

    public String getType() {
	return _type;
    }
    
    public int getLevel() {
	return _level;
    }

    public int getNum() {
	return _num;
    }

    public int getAttackT() {
	return _attack[0];
    }

    public int getAttack() {
	return _attack[1];
    }

    public int getDefenseT() {
	return _defense[0];
    }

    public int getDefense() {
	return _defense[1];
    }

    public int getHPT() {
	return _HP[0];
    }

    public int getHP() {
	return _HP[1];
    }

    public int getSpeedT() {
	return _speed[0];
    }

    public int getSpeed() {
	return _speed[1];
    }

    public int getExpT() {
	return _exp[0];
    }

    public int getExp() {
	return _exp[1];
    }

    
    //mutators
    public void setName( String newName ) {
	_name = newName;
    }
    
    public void setLevel( int newLevel ) {
        _level = newLevel;
    }

    public void setNum( int newNum ) {
	_num = newNum;
    }

    public void setAttackT( int newAttack ) {
	_attack[0] = newAttack;
    }

    public void setAttack( int newAttack ) {
	if( newAttack > 100 ) { newAttack = 100; }
	_attack[0] = newAttack;
	_attack[1] = newAttack;
    }

    public void setDefenseT( int newDefense ) {
	_defense[0] = newDefense;
    }

    public void setDefense( int newDefense ) {
	_defense[0] = newDefense;
	_defense[1] = newDefense;
    }

    public void setHPT( int newHP ) {
	_HP[0] = newHP;
    }

    public void setHP( int newHP ) {
	_HP[0] = newHP;
	_HP[1] = newHP;
    }

    public void setSpeedT( int newSpeed ) {
	_speed[0] = newSpeed;
    }

    public void setSpeed( int newSpeed ) {
	_speed[0] = newSpeed;
	_speed[1] = newSpeed;
    }
    
    public void setExpT( int newExp ) {
	_exp[0] = newExp;
	if( getExpT() >= getExp() ) {
	    levelUp();
	}
	if( getLevel() == 100 ) {
	    _exp[0] = 0;
	}
    }
		   
    public void setExp() {
	_exp[0] = 0;
	_exp[1] = ( getLevel()*getLevel()*getLevel()+1 );
	if( getLevel() == 100 ) {
	    _exp[1] = 999999999;
	}
    }


    //other methods
		   
    public void levelUp() {
	if( getLevel() < 100 ) {
	    _level += 1;
	    setAttack( getAttack() + (int)(Math.random() * 2.5) );
	    setDefense( getDefense() + (int)(Math.random() * 2) );
	    setHP( getHP() + (int)(Math.random() * 3) );
	    setSpeed( getSpeed() + (int)(Math.random() * 2) );
	    setExp();
	    System.out.println( _name + " is now at level " + _level + "!");
	    evolve();
	}
    }

    public void evolve() {
	String[] data = CSVMaster.singleLine( CSVMaster.pokeEvolutions.get(getNum()) );
	if( data[2].equals("true") ) {
	    //evolve
	    if( data[3].equals("-1") ) {
		//stones
	    }
	    if( data[3].equals("-2") ) {
		//trade
	    }
	    if( data[3].equals("-3") ) {
		//EEVEE
	    }
	    if( Integer.parseInt(data[3]) <= getLevel() ) {
		setName( data[4] );
		setNum( getNum() + 1 );
		setAttack( getAttack() + 5 );
		setDefense( getDefense() + 3 );
		setHP( getHP() + 5 );
		setSpeed( getSpeed() + 2 );
		System.out.println(data[1] + " has evolved to " + getName() + "!");
	    }
	}
    }

    //returns if pokemon is alive
    public boolean isAlive() {
	return( getHPT() > 0 );
    }
    
    //attack another pokemon
    public int attack( Pokemon opp ) {
	return 0;
    }

    //quick summary about pokemon when you catch
    //idea: be able to call About: <pokeName> anywhere in the game
    public String about( String pokemonName){
	//GET FROM CSV
	return "";
    }

    public String toString() {
	String fin = _name;
	fin += "\tLevel: " + _level + "\nAttack: " + _attack[0] + "\tDefense: " + _defense[0];
	return fin;
    }


    //for testing purposes only
    public static void main( String[]args ) {
	Pokemon sample = new Pokemon("Bulbasaur",20);
	System.out.println( sample );
	sample.setExpT(10000);
	System.out.println( sample );
    }
	    

}
