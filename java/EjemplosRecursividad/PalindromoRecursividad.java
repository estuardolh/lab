public class PalindromoRecursividad {
  public PalindromoRecursividad(){
  }
  public static boolean esPalindromo(String palabra, int indice_inicial){
    if(indice_inicial > ((palabra.length() / 2)-1) ) return true;

    char chr1 = palabra.charAt(indice_inicial);
    char chr2 = palabra.charAt(palabra.length() - 1 - indice_inicial);

    if(chr1==chr2) return true;

    return esPalindromo(palabra, indice_inicial++)? true:false;
  }
}
