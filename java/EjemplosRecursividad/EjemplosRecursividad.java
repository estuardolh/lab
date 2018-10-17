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
      System.out.println("3. ?");
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
        }else if(linea.trim().equals("3")){
          // to to here
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
    PiramideRecursividad.mostrarAscii( piramide_altura );
  }
  public void mostrarFibonacci( int limite_superior ){
    FibonacciRecursividad.mostrarAscii( limite_superior );
  }
}
