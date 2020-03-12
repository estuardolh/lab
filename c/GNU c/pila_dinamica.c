#include "stdlib.h"
#include "stdio.h"

typedef struct _Nodo {
  struct _Nodo *siguiente;
  int dato;
} Nodo;

void push(Nodo **nodo, int dato){
    Nodo *aux = (Nodo*)malloc(sizeof(Nodo));
    aux->dato = dato;
    aux->siguiente = *nodo;

    *nodo = aux;
}

void pop(Nodo **tope){
  if(tope == NULL) return;

  Nodo *auxiliar = (*tope)->siguiente;

  *tope = auxiliar;
}

void print(Nodo *tope){
  if(tope == NULL) return;

  printf("%d\n", tope->dato);

  print(tope->siguiente);
}

int main(){
  Nodo *tope = NULL;
  push(&tope, 3);
  push(&tope, 2);
  push(&tope, 1);

  pop(&tope);

  printf("------------\n");
  print(tope);
  printf("-----------.\n");

  exit(0);
}
