public class FibonacciRecursividad {
  public static void mostrarAscii( int limite_superior ){
    if(limite_superior == 0){
      System.out.println("    0");
    }else if(limite_superior > 0){
      System.out.println("    1");
      fibonacci(1,1, limite_superior);
    }
  }

  private static int fibonacci( int i_0, int i_1, int limite_superior ){
    if(i_1 > limite_superior) return 0;

    System.out.println( "    " + i_1 );
    return fibonacci(i_1, i_0 + i_1, limite_superior);
  }
}
