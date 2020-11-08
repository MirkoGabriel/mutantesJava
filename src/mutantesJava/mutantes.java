package mutantesJava;

public class mutantes {

	 public static void main(String[] args) {
	        // TODO code application logic here
	       int bandera=0;
	       boolean resultado;
	       String[] dna = {"ATGCGA","CAGTGC","TTATGT","AGAAGG","CCCCTA","TCACTG"};
	        /*   VALIDACION DE DATOS 
	             PONE LA BANDERA EN 1 SI:
	             -LA LONGITUD DE UN STRING NO COINCIDE CON LA LONGITUD DEL ARRAY 
	             -SI UN STRING NO CONTIENE 'A' 'C' 'G' 'T'  
	       */
	        for (int i = 0; i < dna.length; i++) {
	            if(dna[i].length()!=dna.length){
	                bandera=1;
	            }
	            for (int j = 0; j < dna[i].length(); j++) {
	                if(dna[i].charAt(j)!='A' && dna[i].charAt(j)!='C' && dna[i].charAt(j)!='G' &&dna[i].charAt(j)!='T' ){
	                   bandera=1;
	                }
	            }
	        }
	      /*
	            SI LA BANDERA ESTA EN 1 FINALIZA EL PROGRAMA
	            SI LA BANDERA ESTA EN 0 ENTRA A LA FUNCION
	      */
	       if(bandera==1){
	           System.out.println("Error fin del programa..");
	       }else{
	            resultado=isMutant(dna);
	        
	            if(resultado==true){
	                System.out.println("Mutante");
	            }else{
	                System.out.println("Humano");
	            } 
	       }
	       
	    }
	    
	    
	    /* SI HAY UNA SECUENCIA DE CARACTERES IGUALES OBLICUA HORIZONATAL VERTICAL RETORNA TRUE SINO FALSE*/
	    public static boolean isMutant(String [] dna){
	        int sum=0, n1, n2; 
	        char letra1,letra2,letra3,letra4;
	        /*
	            RECORRO CADA POSICION DEL ARRAY
	        */
	        for (int i = 0; i < dna.length; i++) {
	            n1=i;
	            /* RECORRO CADA CARACTER DEL ARRAY*/
	            for (int j = 0; j < dna.length; j++) {
	                n2=j;
	                sum=0;
	                /* SI LA POCICION EN LA QUE ME ENCCUENTRO ME PERMITE 
	                   COMPARAR LOS SIGUIENTES CUATRO CARACTERES
	                   LOS COMPARO SI SON IGUALES SUMA 1 
	                */
	                
	                /* COMPARA DE FORMA OBLICUA DECRECIENTE*/
	                if((dna.length-j)>3 && (dna.length-i)>3){
	                    letra1=dna[i].charAt(j);
	                    letra2=dna[n1+1].charAt(n2+1);
	                    letra3=dna[n1+2].charAt(n2+2);
	                    letra4=dna[n1+3].charAt(n2+3);
	                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
	                    	sum++;
	                    }
	                }
	                /* COMPARA DE FORMA HORIZONTAL*/

	                if((dna.length-j)>3){
	                    letra1=dna[i].charAt(j);
	                    letra2=dna[i].charAt(n2+1);
	                    letra3=dna[i].charAt(n2+2);
	                    letra4=dna[i].charAt(n2+3);
	                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
	                    	sum++;
	                    }
	                }
	                /* COMPARA DE FORMA VERTICAL*/
	                if((dna.length-i)>3){
	                    letra1=dna[i].charAt(j);
	                    letra2=dna[n1+1].charAt(j);
	                    letra3=dna[n1+2].charAt(j);
	                    letra4=dna[n1+3].charAt(j);
	                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
	                    	sum++;
	                    }
	                }
	                /* COMPARA DE FORMA OBLICUA ASCENDENTE*/
	                if(j>=3 && (dna.length-i)>3){
	                    letra1=dna[i].charAt(j);
	                    letra2=dna[n1+1].charAt(n2-1);
	                    letra3=dna[n1+2].charAt(n2-2);
	                    letra4=dna[n1+3].charAt(n2-3);
	                    if(letra2==letra1 && letra3==letra1 && letra4==letra1){
	                    	sum++;
	                    }
	                }
	                if(sum>0) {
	                	return true;
	                }
	            }
	        }
	       
	            return false;
	    }
}
