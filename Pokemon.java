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
    private int _attack;      //pokemon attack--determines attack strength
    private int _defense;     //pokemon defense--determines damage taken
    private int _HP;          //pokemon HP--determines max damage
    private int _MaxHP;          //pokemon HP--determines max damage
    private int _speed;       //pokemon speed--determines first attacker
    private ArrayList<Objects>  _moves;  //pokemon moves [move1,move2,move3,move4][power1,power2,power3,power4]

=======
    private int _attack;      //pokemon attack--determines attack strength
    private int _defense;     //pokemon defense--determines damage taken
    private int _HP;          //pokemon HP--determines max damage
    private int _speed;       //pokemon speed--determines first attacker
    private ArrayList<Objects>  _moves;  //pokemon moves [move1,move2,move3,move4][power1,power2,power3,power4]
>>>>>>> parent of e4c8725... add
    //private String _nickname; ~~EXTRA FEATURE--TBI  give your pokemon a nickname!
    //private String _object;  ~~EXTRA FEATURE--TBI   objects your pokemon can hold


    //Constructors
    public Pokemon( String name ) {
	_name = name;
	//_type = ; //GET FROM CSV
	_level = 1;
	//_attack = ; //GET FROM CSV
	//_defense = ; //GET FROM CSV
	//_HP = ; //GET FROM CSV
	//_speed = ; //GET FROM CSV
	//MOVE-GETTER FUNCTION
    }

    public Pokemon( String name, int level ) {
	this( name );
	_level = level;
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

    public int getAttack() {
	return _attack;
    }

    public int getDefense() {
	return _defense;
    }

    public int getHP() {
	return _HP;
    }

    public int getMaxHP() {
	return _MaxHP;
    }
    
    public int getSpeed() {
	return _speed;
    }

    
    //mutators
    public void setLevel( int newLevel ) {
        _level = newLevel;
    }

    public void setAttack( int newAttack ) {
	_attack = newAttack;
    }

    public void setDefense( int newDefense ) {
	_defense = newDefense;
    }

    public void setHP( int newHP ) {
	_HP = newHP;
    }

    public void setMaxHP( int newHP ) {
	_MaxHP = newHP;
    }
    
    public void setSpeed( int newSpeed ) {
	_speed = newSpeed;
    }


    //other methods
    public String evolve() {
        _level += 1;
	_attack += (Math.random() * 5);
	_defense += (Math.random() * 5);
	_HP += (Math.random() * 3);
	_speed +=  (Math.random() * 3);    
	if( _level > 100 ) { _level = 100; } 
	if( _attack > 100 ) { _attack = 100; }
	if( _defense > 100 ) { _defense = 100; }
	if( _HP > 100 ) { _HP = 100; };
	if( _speed > 100 ) { _speed = 100; }
	return _name + " is now at level " + _level + "!";
    }

    //returns if pokemon is alive
    public boolean isAlive() {
	return( getHP() > 0 );
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
<<<<<<< HEAD
	fin += "\tLevel: " + _level + "\nAttack: " + _attack[0] + "\tDefense: " + _defense[0];
	String fin = "\n"+_name;
	fin += "\tLevel: " + _level + "\tAttack: " + _attack + "\tDefense: " + _defense;
=======
	fin += "\tLevel: " + _level + "\nAttack: " + _attack + "\tDefense: " + _defense;
>>>>>>> parent of e4c8725... add
	return fin;
    }


    //for testing purposes only
    public static void main( String[]args ) {
	
    }
		    

}
