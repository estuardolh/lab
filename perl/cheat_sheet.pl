#!/usr/bin/perl

# variables escalares
$v_numero = 9;
$v_cadena = 'valor';

print "numero=".$v_numero.", cadena=".$v_cadena."\n";

# signos de operacion no tan usados
# ** = exponente
# % = modulo

for($indice = 0; $indice < 10; $indice++){
  print "indice=".$indice."\n";
}

# operadores no tan usados
# -= restar y asignar
# += sumar y asignar
# *= multiplicar y asignar
# **= exponenciar y asignar
# /= dividir y asignar
# %= modulo y asignar
# .= concatenar y asignar

$v_numero = 10;
print "++ right: ".$v_numero++."\n";

$v_numero = 10;
print "++ left: ".++$v_numero."\n";

# operadores de comparacion de cadenas
# eq = igual
# ne = no igual
# gt = mas grande que
# lt = menos que
# ge = mas grande o igual que
# le = menos o igual que

# condicion if
# if(expresion){ bloque* } [ elsif(expresion){} [ else{} ] ]
# while(expresion){} : mientras expresion es verdadera ejecuta.
# until(expresion){} : mientras expresion es falsa ejecuta.

@lista = ('jose ', 'ama ', 'con ','vehemencia.');
foreach $palabra(@lista){
  print $palabra;
}
print " por desgracia.\n";

print <<EOF;
Esto
es un
texto
multi-
linea.
EOF

print "Nombre de archivo: ".__FILE__."\n";
print "Numero de lineas: ".__LINE__."\n";
print "Paquete: ".__PACKAGE__."\n";

print "lista[1] = ".$lista[1]."\n";

# qw o quote word
# ejemplo de uso:
# @v_array = qw(jose ama con vehemencia.);
# se crea un array con los items: jose, ama, con, vehemencia.
# para encerrar la cadena pueden usarse otros signos en lugar de ( )
# ejemplo:
# @v_array = qw/jose ama con vehemencia./

# los arrays pueden ser secuenciales
# ejemplo: expresar una lista de 10 numeros consejutivos desde 0
# @v_array = (1..10);
# o tambien usando letras
# @v_array = (a..z);

# para determinar el numero de elementos en un array
print "numero de elementos en array 'lista': ".$#lista."\n";

push @lista, " si\n";
print @lista;

pop @lista;
print @lista;
print "\n";

shift @lista;
print @lista;
print "\n";

unshift @lista, 'jose ';
print @lista;
print "\n";

# reemplazando una porcion de un array
@reemplazo = (1..20);
splice(@reemplazo,5,5,21..25); # notar que no se imprime sino hasta despues.
print "@reemplazo\n";

@reemplazo = sort(@reemplazo);
print "@reemplazo\n";
@reemplazo = reverse @reemplazo;
print "@reemplazo\n";

# imprimiendo un valor de la lista
print "$reemplazo[0]\n";

#
# Hash tables
#

# se puede usar , en lugar de =>
# se puede usar {} en lugar de ()
%htabla = ('jose'=>'andrea');

print "para jose: $htabla{'jose'} ;(\n";

#
# Subrutina
#

print "promedio=";
promedio(1,2,3,4);
print "\n";

sub promedio{
  $n = scalar(@_);

  $suma = 0;
  foreach $numero(@_){
    $suma += $numero;
  }

  $res = $suma / $n;
  print $res;
}

print "parejas perfectas:\n";
imprime_hash(%htabla);
print "\n";

sub imprime_hash{
  my (%tabla) = @_; # al usar 'my' es una variable Privada para el Scope
  foreach $llave(keys %tabla){
    print "  llave=".$llave."\n";
    print "  valor=".$tabla{$llave}."\n";
    print "  -";
  }
}

print "pareja perfecta: ".pareja_perfecta('jose','andrea')."\n";

sub pareja_perfecta{
  if(@_[0] eq 'jose' && @_[1] eq 'andrea'){
    return 1;
  }else{
    return 0;
  }
}

# referencia
# para referenciar un valor escalar, se usa un '\' antes del nombre
# de la variable.
# ejemplo escalar: $ref = \$nombre_escalar;
# ejemplo array: $ref = \$nombre_lista;
# ejemplo hash: $ref = \%nombre_hash;
# ejemplo funcion: $ref = \&nombre_subrutina;
#   para llamar funcion: &$ref($argumentos);
# 
# deferencia
# se utiliza cuando se desea usar los valores de una variable
# en lugar de la referencia a la que se hizo.
# ejemplo escalar: $valor = $$valor_ref;
# ejemplo hash: %tabla = %$tabla;
# ejemplo array: @lista = @$array;

# ejemplo de bloques BEGIN y END
# print "valor";
# BEGIN { print "BEGIN"; }
# END { print "END"; }
# lo anterior imprime:
# BEGIN
# valor
# END
