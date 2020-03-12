#for .bashrc
function swapf(){
  mv $1 cop_$1
  mv $2 $1
  mv cop_$1 $2
}
