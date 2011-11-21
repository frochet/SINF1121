import java.util.Comparator;

//Auteur : Claude
public class AlphaComp implements Comparator<String> {

	public int compare(String arg0, String arg1) {
		
		//Mise à la même longueur
		if (arg0.length()>arg1.length()){
			arg1=arg1+" ";
			arg0.substring(0, arg0.length());
		}
		else if (arg1.length()>arg0.length()){
			arg0=arg0+" ";
			arg1.substring(0, arg1.length());
		}
			
		
		if(arg0==arg1){
			return 0;
		}
		else if(arg0==""&&arg1==""){
			return 0;
		}
		else if(arg0==""){
			return -1;
		}
		else if(arg1==""){
			return 1;
		}		
		else {
			while (arg0!=""&&arg1!=""){

				if((int)arg0.charAt(0)<(int)arg1.charAt(0)){
					return -1;
				}
				
				else if((int)arg0.charAt(0)>(int)arg1.charAt(0)){
					return 1;
				}
				else if((int)arg0.charAt(0)==(int)arg1.charAt(0)){
					arg0=arg0.substring(1);
					arg1=arg1.substring(1);
				}
			}
		}
		return 0;	
	}
}
