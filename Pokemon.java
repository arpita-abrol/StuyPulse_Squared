/*

 */

public abstract class Pokemon {


    //attributes
    protected String _name;
    protected int _level;
    protected int _attack;
    protected int _defense;
    protected int _HP;
    protected int _speed;
    //protected String _nickname;
    //protected String _object;


    //accessors
    public String getName() {
	return _name;
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

    public void setSpeed( int newSpeed ) {
	_speed = newSpeed;
    }


    //other methods
    /*public String evolve() {
	
      }*/

    
    //abstract methods


}
