/*

 */

import java.util.*;

public class Pokemon {

    //instance vars
    private String _name;     //pokemon name
    private String _type;     //pokemon type
    private int _level;       //level of pokemon
<<<<<<< HEAD
    private int[] _attack;      //pokemon attack--determines attack strength
    private int[] _defense;     //pokemon defense--determines damage taken
    private int[] _HP;          //pokemon HP--determines max damage
    private int[] _speed;       //pokemon speed--determines first attacker
    private int[] _exp;        //pokemon exp--determines current exp/needed exp
    private Objects[][]  _moves;  //pokemon moves [move1,move2,move3,move4][power1,power2,power3,power4]
=======
    private int _attack;      //pokemon attack--determines attack strength
    private int _defense;     //pokemon defense--determines damage taken
    private int _HP;          //pokemon HP--determines max damage
    private int _MaxHP;          //pokemon HP--determines max damage
    private int _speed;       //pokemon speed--determines first attacker
    private ArrayList<Objects>  _moves;  //pokemon moves [move1,move2,move3,move4][power1,power2,power3,power4]
    
>>>>>>> origin/master
    //private String _nickname; ~~EXTRA FEATURE--TBI  give your pokemon a nickname!
    //private String _object;  ~~EXTRA FEATURE--TBI   objects your pokemon can hold


    //Constructors
    public Pokemon( String name ) {
	_name = name;
	//_type = ; //GET FROM CSV
	_level = 1;
	//int[] _attack = ; //GET FROM CSV
	//int[] _defense = ; //GET FROM CSV
	//int[] _HP = ; //GET FROM CSV
	//int[] _speed = ; //GET FROM CSV
        int[] _exp = {0, (_level*_level*_level)};
	//Objects[][] _moves = {} {};MOVE-GETTER FUNCTION
    }

    public Pokemon( String name, int level ) {
	this( name );
	_level = level;
	int[] _exp = {0, (_level*_level*_level)};
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

    public int getMaxHP() {
	return _MaxHP;
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
    public void setLevel( int newLevel ) {
        _level = newLevel;
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
	if( newDefense > 100 ) {newDefense = 100; }
	_defense[0] = newDefense;
	_defense[1] = newDefense;
    }

    public void setHPT( int newHP ) {
	_HP[0] = newHP;
    }

    public void setHP( int newHP ) {
	if( newHP > 100 ) {newHP = 100; }
	_HP[0] = newHP;
	_HP[1] = newHP;
    }

    public void setSpeedT( int newSpeed ) {
	_speed[0] = newSpeed;
    }

    public void setMaxHP( int newHP ) {
	_MaxHP = newHP;
    }
    
    public void setSpeed( int newSpeed ) {
	if( newSpeed > 100 ) {newSpeed = 100; }
	_speed[0] = newSpeed;
	_speed[1] = newSpeed;
    }

    public void setExpT( int newExp ) {
	_exp[0] = newExp;
	if( getExpT() >= getExp() ) {
	    evolve();
	}
	if( getLevel() == 100 ) {
	    _exp[0] = 0;
	}
    }

    public void setExp( int newExp ) {
	_exp[0] = 0;
	_exp[1] = newExp;
	if( getLevel() == 100 ) {
	    _exp[1] = 999999999;
	}
    }


    //other methods
    public void evolve() {
	if( getLevel() >= 100 ) {
	    System.out.println( "Max level reached" );
	}
        _level += 1;
	setAttack( getAttack() + (int)(Math.random() * 5) );
	setDefense( getDefense() + (int)(Math.random() * 5) );
	setHP( getHP() + (int)(Math.random() * 3) );
	setSpeed( getSpeed() + (int)(Math.random() * 3) );
	setExp( _level * _level * _level );
	System.out.println( _name + " is now at level " + _level + "!");
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
<<<<<<< HEAD
	String fin = _name;
	fin += "\tLevel: " + _level + "\nAttack: " + _attack[0] + "\tDefense: " + _defense[0];
=======
	String fin = "\n"+_name;
	fin += "\tLevel: " + _level + "\tAttack: " + _attack + "\tDefense: " + _defense;
>>>>>>> origin/master
	return fin;
    }


    //for testing purposes only
    public static void main( String[]args ) {
	
    }
		    

}
