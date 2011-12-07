/*
 * Auteur : Florentin
 */
/*Chaque noeud de l'arbre contiendra soit :
	 * - Seulement un poid
	 * - Seulement fréquence et lettre correspondante.*/
	public class HuffmanNode implements Comparable<HuffmanNode>{
		private int poids;
		private int frequence;
		private char letter;
		HuffmanNode(int poids){ /* Correspond à un noeud de l'arbre */
			this.poids = poids;
		}
		HuffmanNode(int frequence, char letter){ /* Correspond à une feuille de l'arbre */
			this.frequence = frequence;
			this.letter = letter;
		}
		public void setPoids(int poids){
			this.poids = poids;
		}
		@Override
		public int compareTo(HuffmanNode arg0) {
			// TODO Auto-generated method stub
			if(this.frequence > arg0.getFrequence())
				return 1;
			else if( this.frequence < arg0.getFrequence())
				return -1;
			else
				return 0;
		}
		public int getFrequence(){
			return this.frequence;
		}
		
		public int getLetter(){
			return this.letter;
		}
	}
	