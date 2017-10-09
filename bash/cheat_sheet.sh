function menu {
  filename=`basename "$0"`
  echo "filename=$filename"
  
  echo "+---------------------------+"
  echo "| Simple menu               |"
  echo "| @JEstuardo                |"
  echo "| 08/10/2017 16:23:26.03    |"
  echo "|                           |"
  echo "|                           |"
  echo "+---------------------------+"  
  
  # coloreando
  resultado="|EJ|PE|ER|"
  echo "$resultado" | head -n 27 | GREP_COLOR='38;5;82' egrep --color=always 'EJ|$' | GREP_COLOR='38;5;124' egrep --color=always 'ER|$' | GREP_COLOR='38;5;214' egrep --color=always 'PE|$'
  
  # tiempo transcurrido
  segundos=61
  fechahora=`echo "Tiempo transcurrido: $(($segundos / 60)) min $(($segundos % 60)) seg"`
  
  # tamano de string
  tamano="${3var}"
  
  # array de argumentos
  tamano="$@"
  
  # cantidad de argumentos
  tamano="$#"
}

menu
