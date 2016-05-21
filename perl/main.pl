#!/usr/bin/env perl
use strict;
use warnings;

print "hello world\n";

# a comment

my $a_var1 = "string";
my $a_var2 = 4;

print "una cadena: $a_var1, un numero: $a_var2\n";
print "an operation ",$a_var2*$a_var2,"\n";

my @an_array = (1,2,3);

print "an element of array(1,2,3) is ", $an_array[1],"\n";

print "array length is ", $an_array[$#an_array],"\n";

if( $#ARGV == 0 ){
  print "he aqui el primer argumento: ", $ARGV[0],"\n";
}else{
  print "no hay argumentos\n";
}

my %my_hash = (
  tools => "for use",
  people => "for relationship"
);

print "a hash!: people ", $my_hash{people},"\n";

print "print condicionado aposteriori!\n" if 1;

for( my $i = 0; $i < 4; $i++ ){
  print $i, ") a for statement! go go go! \n";
}

my $container = "graciosa";
print "container = graciosa\n";
if( $container =~ /a/ ){  # if container has "a" then
  print 'container has "a"',"\n";
  $container =~ s/a/e/g;
  print 'replacing "a" for "e", then: ', $container;
}
