import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVMaster {

    public static ArrayList<String> pokeStats = CSVtoArray( "PokemonStats.csv" );
    public static ArrayList<String> pokeMoves = CSVtoArray( "PokemonMoves.csv" );
    public static ArrayList<String> moves = CSVtoArray( "Moves.csv" );
    public static ArrayList<String> pokeEvolutions = CSVtoArray( "PokemonEvolutions.csv" );
    //public ArrayList<String> adventure0 = CSVtoArray( "PalletPokemon.csv" );

    
    public static ArrayList<String> CSVtoArray( String name ) {
	BufferedReader thisFile = null;
	ArrayList<String> arrayFile = new ArrayList<String>();
	try {
	    String line;
	    thisFile = new BufferedReader(new FileReader(name));
	    while ((line = thisFile.readLine()) != null) {
		arrayFile.add( line );
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    try {
		if (thisFile != null) thisFile.close();
	    } catch (IOException e) {
		e.printStackTrace();
	    }
	}
	return arrayFile;
    }

    public static void main( String[]args ) {
    	CSVtoArray( "sample.csv" );
	System.out.println( pokeStats.get(44) );
    }
}
