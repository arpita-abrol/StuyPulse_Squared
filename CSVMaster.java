import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVMaster {

    //public arraylists of csv files
    public static ArrayList<String> pokeStats = CSVtoArray( "PokemonStats.csv" );
    public static ArrayList<String> pokeMoves = CSVtoArray( "PokemonMoves.csv" );
    public static ArrayList<String> pokeEvolutions = CSVtoArray( "PokemonEvolutions.csv" );
    //public static ArrayList<String> moves = CSVtoArray( "Moves.csv" );
    //public ArrayList<String> adventure0 = CSVtoArray( "PalletPokemon.csv" );


    //turns a CSV file into an arraylist
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

    //turns a string from CSV files into an array
    public static String[] singleLine( String line ) {
	String[] arr = line.split(",");
	return arr;
    }


    //search a CSV file for a pokemon
    public static int searchCSV( String pokemon, ArrayList list ) {
	for( int x = 1; x < list.size(); x++ ) {
	    if( singleLine(""+list.get(x))[1].equals(pokemon) ) {
		return x;
	    }
	}
	return -1;
    }

    //search CSV files
    public static int searchCSV( String pokemon, ArrayList list, int index ) {
	for( int x = 0; x < list.size()-1; x++ ) {
	    if( singleLine(""+list.get(x))[index].equals(pokemon) ) {
		return x;
	    }
	}
	return -1;
    }


    /* 
    public static void main( String[]args ) {
	System.out.println( pokeStats.get(151) );
	System.out.println( singleLine( pokeStats.get(44) )[0] );
	System.out.println( searchCSV( "Mew", pokeStats ) );
    }
    */
}
