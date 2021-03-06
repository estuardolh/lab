#include <iostream.h>
#include <ctype.h>
#include <conio.h>
#include <stdio.h>
#include <stdlib.h>

#define	VERDADERO 	1;#define	FALSO 		0;

struct NodoArbol{	NodoArbol *Izq;
   NodoArbol *Der;
   int  Info;
};

NodoArbol *CreaNodo(int);void InsertaNodo(NodoArbol **, NodoArbol *);
int EliminaNodo(NodoArbol **, NodoArbol **, int);
int BuscaNodo(NodoArbol **Raiz, NodoArbol **Nodo, NodoArbol **Anterior, int numero);
NodoArbol *MuestraArbolInorden(NodoArbol *);
NodoArbol *MuestraArbolPreorden(NodoArbol *);
NodoArbol *MuestraArbolPostorden(NodoArbol *);
void EliminaArbol( NodoArbol **);
int Menu();

NodoArbol *CreaNodo(int valor){	NodoArbol *Nodo=NULL;
   if ((Nodo = (NodoArbol *)malloc(sizeof(NodoArbol)))==0){
        return NULL;
   }else {
   	Nodo->Info = valor;
   	Nodo->Izq = NULL;
   	Nodo->Der = NULL;
   	return Nodo;
   }
}

void InsertaNodo(NodoArbol **Raiz, NodoArbol *Nodo){   if(*Raiz==NULL){
   	*Raiz = Nodo;
   }else{
   	if((*Raiz)->Info > Nodo->Info){
      	InsertaNodo(&(*Raiz)->Izq, Nodo);
   	}else{
      	if((*Raiz)->Info < Nodo->Info)
      		InsertaNodo(&(*Raiz)->Der, Nodo);
      }
   }
}

int BuscaNodo(NodoArbol **Raiz, NodoArbol **Nodo, NodoArbol **Anterior, int numero){	NodoArbol *Aux=NULL;
   Aux=*Raiz;
   while(Aux!=NULL){
   	if(Aux->Info == numero){
      	*Nodo = Aux;
      	return VERDADERO;
      }
      *Anterior = Aux;
      if(Aux->Info < numero)
      	Aux = Aux->Der;
      else
      	Aux = Aux->Izq;
   }

   return FALSO;}

int EliminaNodo(NodoArbol **Raiz, NodoArbol **Nodo, int numero){	NodoArbol *Anterior, *AuxAnt, *Aux;
   if(*Raiz==NULL){
   	printf("Arbol no existe");

      return 0;
   }

   if(!BuscaNodo(&(*Raiz), &(*Nodo), &Anterior, numero)){   	printf("Nodo no existe");
      return 0;
   }

   //Nodo Hoja   if(((*Nodo)->Izq == NULL)&&((*Nodo)->Der == NULL)){
   	if (Anterior->Der == *Nodo)
      	Anterior->Der = NULL;
      else
      	Anterior->Izq = NULL;
   }

   //Nodo solo tiene una hoja izq   if(((*Nodo)->Izq != NULL)&&((*Nodo)->Der == NULL)){
   	if (Anterior->Izq == *Nodo)
      	Anterior->Izq = (*Nodo)->Izq;
      else
      	Anterior->Der = (*Nodo)->Izq;
   }

   //Nodo solo tiene una hoja der   if(((*Nodo)->Izq == NULL)&&((*Nodo)->Der != NULL)){
   	if (Anterior->Der == *Nodo)
      	Anterior->Der = (*Nodo)->Der;
      else
      	Anterior->Izq = (*Nodo)->Der;
   }

   //Nodo tiene dos hijos   if(((*Nodo)->Izq != NULL)&&((*Nodo)->Der != NULL)){   	Aux=(*Nodo)->Izq;
      AuxAnt=Aux;
      while(Aux->Der!=NULL){
        	AuxAnt=Aux;
         Aux=Aux->Der;
      }
      (*Nodo)->Info=Aux->Info;
      AuxAnt->Der=Aux->Izq;
      if(Anterior ==NULL)
      	Raiz=Nodo;
   }
}

NodoArbol *MuestraArbolInorden(NodoArbol *Raiz){	if(Raiz==NULL){
   	return NULL;
   }
   else{
   	MuestraArbolInorden(Raiz->Izq);
      printf("%d ", Raiz->Info);
      //printf("%c ", Raiz->Info);      MuestraArbolInorden(Raiz->Der);
   }
}

NodoArbol *MuestraArbolPreorden(NodoArbol *Raiz){	if(Raiz==NULL){
   	return NULL;
   }
   else{
   	printf("%d ", Raiz->Info);
      //printf("%c ", Raiz->Info);   	MuestraArbolPreorden(Raiz->Izq);
      MuestraArbolPreorden(Raiz->Der);
   }
}

NodoArbol *MuestraArbolPostorden(NodoArbol *Raiz){	if(Raiz==NULL){
   	return NULL;
   }
   else{
   	MuestraArbolPostorden(Raiz->Izq);
      MuestraArbolPostorden(Raiz->Der);
      printf("%d ", Raiz->Info);
      //printf("%c ", Raiz->Info);   }
}

void EliminaArbol( NodoArbol **Raiz ){   if (*Raiz != NULL) {
      EliminaArbol(&(*Raiz)->Izq);
      EliminaArbol(&(*Raiz)->Der);
      *Raiz=NULL;
   }
}

int SumarArbol(NodoArbol **Raiz){
	if(*Raiz == NULL){
   	return 0;
   }
   int suma_izq = SumarArbol(&(*Raiz)->Izq);
   int suma_der = SumarArbol(&(*Raiz)->Der);

   return suma_izq + (*Raiz)->Info + suma_der;
}

int Menu(){	int Opcion;
   //clrscr();
   printf("\n\n");
   printf("1 - Insertar Nodo \n");
   printf("2 - Eliminar Nodo \n");
   printf("3 - Mostrar Arbol \n");
   printf("4 - Eliminar Arbol \n");
   printf("5 - Sumar elementos de Arbol \n");
   printf("0 - Salir \n");

	printf("Ingrese Opcion: ");   scanf("%d",&Opcion);
   return Opcion;
}

void main(){   NodoArbol *Raiz=NULL,*Nodo=NULL;

   int numero, Opcion, suma;

   do{   	Opcion = Menu();
      switch(Opcion){
       	case 0: 	break;
         case 1:  printf("Ingrese valor: ");   					scanf("%d", &numero);   					Nodo = CreaNodo(numero);   					InsertaNodo(&Raiz, Nodo);
                  break;
         case 2:  printf("Ingrese valor: ");   					scanf("%d", &numero);         			EliminaNodo(&Raiz,&Nodo,numero);                  break;
         case 3:  if (Raiz == NULL)         				printf("\nEl arbol esta vacio ...\n");         			else{                  		printf("Arbol: \n\n\n");								printf("Notacion Preorden: \n");								*MuestraArbolPreorden(Raiz);								printf("\nNotacion Inorden: \n");								*MuestraArbolInorden(Raiz);   							printf("\nNotacion Postorden: \n");								*MuestraArbolPostorden(Raiz);                  }                  getch();                  break;         case 4:  EliminaArbol(&Raiz );                  break;         case 5:                  suma = SumarArbol(&Raiz);                  printf("Resultado: %d\n", suma);                  break;         default: printf("Opci�n Inv�lida: \n");         			break;      }   }while(Opcion != 0);}