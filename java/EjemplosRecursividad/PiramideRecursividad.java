public class PiramideRecursividad {
  public PiramideRecursividad(){
  }

  public static void mostrarAscii( int altura ){
    ascii( altura );
  }

  private static void ascii( int altura ){
    if(altura > 0){
      ascii(--altura);
      System.out.print("    ");
      for(int i = 0; i <= altura; i++){
        System.out.print("*");
      }
    }
    System.out.println("");
  }
}
