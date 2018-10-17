import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EjemplosRecursividad {

  public EjemplosRecursividad(){
  }

  public void iniciar(){
    mostrarMenu();
  }

  public String obtenerLineaDeUsuario(String aviso) throws Exception {
    System.out.print( aviso );
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    return buffer.readLine();
  }

  public void mostrarMenu(){
    while(true){
      System.out.println("Menu de ejemplos recursividad:");
      System.out.println("");
      System.out.println("1. piramide");
      System.out.println("2. fibonacci");
      System.out.println("0, q. salir");
      try{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String linea = obtenerLineaDeUsuario("Eleccion: ");
        System.out.println("");
        if(linea.trim().equals("1")){
          int piramide_altura = Integer.parseInt( obtenerLineaDeUsuario("  Altura: ") );
          mostrarPiramide( piramide_altura );
        }else if(linea.trim().equals("2")){
          int limite_superior = Integer.parseInt( obtenerLineaDeUsuario("  Hasta: ") );
          mostrarFibonacci( limite_superior );
        }else if(linea.trim().equals("0") || linea.trim().equals("q")){
          System.out.println("salio.");
          break;
        }else{
          System.out.println("Seleccion desconocida");
        }
      }catch(Exception e){
        e.printStackTrace();
      }
      System.out.println("");
    }
  }

  public void mostrarPiramide( int piramide_altura ){
    piramide( piramide_altura );
  }
  public void mostrarFibonacci( int limite_superior ){
    if(limite_superior == 0){
      System.out.println("    0");
    }else if(limite_superior > 0){
      System.out.println("    1");
      fibonacci(1,1, limite_superior);
    }
  }

  public void piramide( int altura ){
    if(altura > 0){
      piramide(--altura);
      System.out.print("    ");
      for(int i = 0; i <= altura; i++){
        System.out.print("*");
      }
    }
    System.out.println("");
  }

  public int fibonacci( int i_0, int i_1, int limite_superior ){
    if(i_1 > limite_superior) return 0;

    System.out.println( "    " + i_1 );
    return fibonacci(i_1, i_0 + i_1, limite_superior);
  }
}
