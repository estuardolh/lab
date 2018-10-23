public class DescomposicionRecursividad {
  public DescomposicionRecursividad(){
  }
  
  /*
    5=4+1
    5=3+1+1
    5=2+1+1+1
    5=1+1+1+1+1
  */
  public static String descomponer( int n, int anidacion ){
    if(n < 0) return "";
    String salida = descomponer( n - 1, anidacion + 1 );
    System.out.println( n+anidacion+"="+anidacion + salida );
    return salida+"+1";
  }
}
