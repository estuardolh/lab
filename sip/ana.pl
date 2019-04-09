#!/usr/bin/perl

use strict;
use warnings;

main();

sub help {
  my $ans = "";
  $ans = $ans."\nhelp";
  $ans = $ans."\n---";
  $ans = $ans."\nUSAGE:";
  $ans = $ans."\nperl ana.pl [OPTIONS] [FILE]";
  $ans = $ans."\nOPTIONS:";
  $ans = $ans."\n  unique ip\tprint unique ips found in log.";
  $ans = $ans."\n  unique host\tprint unique hosts found in log.";
  $ans = $ans."\n";

  return $ans;
}

sub getPacketsBy {
  my $result = "";

  my $by = $_[0];
  my $filename = $_[1];

  open(my $fh, '<:encoding(UTF-8)', $filename)
    or die "Could not open file '$filename' $!";

  while (my $row = <$fh>) {
    chomp $row;

    if($by eq 'from'){
      $result = $result . "ok";
    }

    #print "->$row\n";
    return $result;
  }  
}

sub getUniqueIp {
  return `grep -oE "[0-9]+\\.[0-9]+\\.[0-9]+\\.[0-9]+" $_[0] | sort | uniq`;
}

sub getUniqueHosts {
  return `grep -oE "(@|UDP |TCP )[-a-zA-Z0-9\.]+[^:>;]" $_[0] | sort | uniq`;
}

sub switch {
  if($_[0] eq 'help'){
    return help();
  }elsif($_[0] eq 'unique' && $_[1] eq 'ip'){
    return getUniqueIp($_[2]);
  }elsif($_[0] eq 'unique' && $_[1] eq 'host'){
    return getUniqueHosts($_[2]);
  }
}

sub main {
  print switch(@ARGV);

}
