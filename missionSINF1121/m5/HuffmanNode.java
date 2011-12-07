/*
 * Auteur : Florentin, Claude
 */
/*Chaque noeud de l'arbre contiendra soit :
	 * - Seulement un poid
	 * - Seulement frŽquence et lettre correspondante.*/
	public class HuffmanNode implements Comparable{
		private int poids;
		private int frequence;
		private char letter;
		HuffmanNode(int poids){ /* Correspond ˆ un noeud de l'arbre */
			this.poids = poids;
		}
		HuffmanNode(int frequence, char letter){ /* Correspond ˆ une feuille de l'arbre */
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
		
		 public int compareTo(Object o) {

		        if (o instanceof HuffmanNode) {
		            if (((HuffmanNode)o).getFrequence() > (this.getFrequence())) {
		                return 1;
		            } else if (((HuffmanNode)o).getFrequence() < this.getFrequence()) {
		                return -1;
		            } else {
		                return 0;
		            }
		        }else{
		            return 0;
		        }
		    }
	}
	