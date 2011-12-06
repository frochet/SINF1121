import java.io.*;

/**
 * Court programme donnant un exemple d'écriture et lecture 
 * avec des flux "bit à bit".
 * 
 * L'intérêt des flux "bit à bit" est principalement de permettre de lire
 * et écrire des booléens dans un fichier en n'utilisant que la place nécessaire,
 * c'est-à-dire UN SEUL BIT par booléen.
 * Note : une exception à cette règle est décrite dans la spécification de OutputBitStream.close()
 *
 * Pour faciliter l'écriture d'autres types primitifs, p.ex. char ou int, des méthodes
 * supplémentaires sont également prévues pour lire/écrire ces types.
 *
 * Exemple d'utilisation :
 * java ExampleBitStream monFichier 1234678 1 0 0 1 0
 *
 * @see InputBitStream
 * @see OutputBitStream
 */
public class ExampleBitStream {
  public static final boolean BIT_1 = true;
  public static final boolean BIT_0 = false;

  private static void usage() {
    System.err.println("");
    System.err.println ("Usage: java ExampleBitStream <File> integer [ bit_1 bit_2 ... bit_n ]");
    System.exit(-1);
  }

  public static void main (String [] args) {
    if (args.length >= 2) {
      try {
	String filename = args[0];  // fichier binaire qui sera écrit et ensuite relu 
	int ivalue = Integer.parseInt(args[1]); // second argument interprété comme un entier

	// Ouverture du flux de sortie
	OutputBitStream out = new OutputBitStream(filename);

	// Ecriture bit à bit de l'entier lu (32 bits écrits)
	out.write(ivalue);

	// Lecture des arguments restants, chacun étant interprété comme un bit 
	for (int i=2; i<args.length;i++) {
	  // On suppose que l'argument suivant est un entier
          // Si l'entier est non nul, il est interprété comme un bit à 1
          // Sinon, il est interprété comme un bit à 0
	  boolean b = (Integer.parseInt(args[i])!=0) ? BIT_1 : BIT_0;
	  // Ecriture du bit suivant correspondant au boolean b
	  out.write(b);
	}
	
	// Fermeture du flux de sortie
	out.close();

	/* --------------------------------------------------- */

	// Ouverture d'un flux d'entrée
	InputBitStream in = new InputBitStream(filename);

	// Lecture et impression de l'entier lu
	System.out.println ("Int value = " + in.readInt());

	// Lecture 
	try {
	  // Lecture bit à bit du flux d'entrée et impression du bit lu
	  while (true) {
	    boolean resu = in.readBoolean();
	    System.out.print (resu ? 1 : 0); 
	  }
	} catch (IOException e) { // Exception lancée notamment en fin de fichier
	  System.out.println("");
	  in.close();
	}
      } catch (Exception e) { // Mauvais usage des arguments sur la ligne de commande
	e.printStackTrace();
	usage();
      } 
    } else {
      usage();
    }
  } 
}

