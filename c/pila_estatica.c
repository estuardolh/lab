#include "stdio.h"
#include "stdlib.h"
#include <string.h>

#define PILA_ESTATICA_TAMANO 6
#define UNDERFLOW "Underflow"
#define OVERFLOW "Overflow"

int tope = 0;

int tamanoArray(int *array){
  return sizeof(array) / sizeof(int);
}

void push(int *pila, int dato){
  int tamano_pila = tamanoArray(pila);

  if(tope < tamano_pila){
    pila[tope] = dato;

    tope++;

    printf("fila insertada %d/%d\n",tope,tamano_pila);
    return 1;
  }else{
    printf(OVERFLOW);
    printf("\n");
    return 0;
  }
}

void printMe(int *pila){
  int tamano = tamanoArray(pila);

  for(int i = 0; i < tamano; i++){
    printf("pila[%d]=%d\n", i, pila[i]);
  }
}

int main(){
  int entrada[PILA_ESTATICA_TAMANO];

  memset(entrada, 0, PILA_ESTATICA_TAMANO);

  push(&entrada, 1);
  push(&entrada, 2);
  push(&entrada, 3);

  printMe(&entrada);

  printf("\n");
  return 0;
}
