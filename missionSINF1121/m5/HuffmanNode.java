/*Chaque noeud de l'arbre contiendra soit :
	 * - Seulement un poid
	 * - Seulement fr�quence et lettre correspondante.*/
	public class HuffmanNode implements Comparable<HuffmanNode>{
		private int poids;
		private int frequence;
		private char letter;
		private HuffmanNode(int poids){ /* Correspond � un noeud de l'arbre */
			this.poids = poids;
		}
		private HuffmanNode(int frequence, char letter){ /* Correspond � une feuille de l'arbre */
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
	}
	