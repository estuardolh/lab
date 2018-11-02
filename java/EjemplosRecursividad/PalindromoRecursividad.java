public class PalindromoRecursividad {
  public PalindromoRecursividad(){
  }
  public static boolean esPalindromo(String palabra){
    if(palabra.length() > 1){
      char inicio = palabra.charAt(0);
      char char_final = palabra.charAt(palabra.length()-1);
      if(inicio == char_final){
        return esPalindromo(palabra.substring(1,palabra.length()-1));
      }else{
        return false;
      }
    }else{
      return true;
    }
  }
}
