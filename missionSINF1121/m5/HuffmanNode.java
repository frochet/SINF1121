/*
 * Auteur : Florentin, Claude
 */
/*Chaque noeud de l'arbre contiendra soit :
	 * - Seulement un poid
	 * - Seulement fréquence et lettre correspondante.*/
	public class HuffmanNode{
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
		
		public int getFrequence(){
			return this.frequence;
		}
		
		public int getLetter(){
			return this.letter;
		}
	}
	