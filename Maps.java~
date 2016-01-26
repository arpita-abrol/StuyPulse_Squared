import java.util.ArrayList;

public class Maps{
    private String[][] map;
    private String person= "O";
    private int _default= 10;
    private int yCoor;
    private int xCoor;
    private int _size;
    private double currentTown;
    
    public Maps(){
	yCoor=0;
	xCoor=0;
	_size= _default;
	map= new String[_size][_size];
	makeMap();
    }

    public Maps( int town ){
	this();
	placeHuman();
	currentTown = town;
	_size = (int)(Math.sqrt( town * 50 )) + 5;
	map= new String[_default][_default];
    }
    
    private void makeMap(){
	for (int i= 0; i< _size; i++){
	    for (int j= 0; j<_size; j++){
		map[i][j]= "X";
	    }
	}
	map[_size-1][_size-1]= "G";
	placeHuman();
    }

    public String getMap(){
	String ret= "";
	makeMap();
	for (int i= 0; i< _size; i++){
	    for (int j= 0; j<_size; j++){
		ret+=map[i][j]+"  ";
	    }
	    ret+= "\n";
	}
	return ret;
    }

    public void placeHuman(){
	map[yCoor][xCoor]=person;
    }
    public static void main(String[] args){
	Maps test= new Maps();
	System.out.println(test.getMap());
    }
    public void setXCoor(int num){
	xCoor= num;
    }
    public void setYCoor(int num){
	yCoor= num;
    }
    public void setSize(int size){
	_size=size;
    }
    public int getYCoor(){
	return yCoor; 
    }
    public int getXCoor(){
	return xCoor; 
    }
    public int getDefault(){
	return _default;
    }
    public int getSize(){
	return _size;
    }
    
}
