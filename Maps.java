import java.util.ArrayList;

public class Maps{
    private String[][] map;
    private String person= "O";
    private int _default= 10;
    private int yCoor;
    private int xCoor;
    private int size;
    
    public Maps(){
	yCoor=0;
	xCoor=0;
	map= new String[_default][_default];
	makeMap();
    }
    public Maps(int x, int y, int size){
	xCoor=x;
	yCoor=y;
	map= new String[size][size];
	makeMap();
	placeHuman();
    }
    private void makeMap(){
	for (int i= 0; i< _default; i++){
	    for (int j= 0; j<_default; j++){
		map[i][j]= "X";
	    }
	}
	placeHuman();
    }

    public String getMap(){
	String ret= "";
	makeMap();
	for (int i= 0; i< _default; i++){
	    for (int j= 0; j<_default; j++){
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
    public int getYCoor(){
	return yCoor; 
    }
    public int getXCoor(){
	return xCoor; 
    }
    public int getDefault(){
	return _default;
    }
    
}
