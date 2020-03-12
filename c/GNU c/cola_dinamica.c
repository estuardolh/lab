#include "stdlib.h"
#include "stdio.h"

typedef struct _Nodo {
  struct _Nodo *anterior;
  int dato;
} Nodo;

void add(Nodo **nodo, int dato){
  if(*nodo == NULL){
    *nodo = (Nodo*)malloc(sizeof(Nodo));
    (*nodo)->dato = dato;
    (*nodo)->anterior = NULL;
  }else{
    Nodo *itera = *nodo;
    while(itera->anterior != NULL){
      itera = itera->anterior;
    }
    (*nodo)->anterior = (Nodo*)malloc(sizeof(Nodo));
    (*nodo)->anterior->anterior = NULL;
    (*nodo)->dato = dato;
  }
}

void pop(Nodo **cabeza){
  if(*cabeza == NULL) return;

  while((*cabeza)->anterior->anterior != NULL){
    *cabeza = (*cabeza)->anterior;
  }
  (*cabeza)->anterior = NULL;
}

void print(Nodo *cabeza){
  if(cabeza == NULL) return;

  printf("%d\n", cabeza->dato);

  print(cabeza->anterior);
}

int main(){
  Nodo *cabeza = NULL;
  add(&cabeza, 3);
  add(&cabeza, 2);
  add(&cabeza, 1);
  add(&cabeza, 0);
//  pop(&cabeza);

  printf("------------\n");
  print(cabeza);
  printf("-----------.\n");

  exit(0);
}
