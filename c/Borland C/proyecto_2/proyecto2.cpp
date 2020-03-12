#include <io.h>
#include <stdio.h>
#include <conio.h>
#include <stdlib.h>
#include <process.h>
#include <alloc.h>
#include <string.h>
#include <math.h>
#include <locale.h>
#include <windows.h>

#define ASCII_INFERIOR 32
#define ASCII_SUPERIOR 255
#define TAMANO_CONTADORES 255
#define MAX_BUFFER 10000

#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <stdarg.h>
#include <malloc.h>

/*******************************************************************************
                             Estructuras
*******************************************************************************/

struct NodoArbol{
	NodoArbol *Izq;
	NodoArbol *Der;
	int frecuencia;
	char caracter;
};

struct NodoCola{
	NodoCola *siguiente;
	NodoArbol *nodo_arbol;
};

int contadores[TAMANO_CONTADORES];

struct Contador{
	char caracter;
	int contador;
	
	char solucion[MAX_BUFFER*10];
};

Contador contadores_ordenados_asc[255];

/*******************************************************************************
                             Prototipos
*******************************************************************************/
NodoCola *crearNodoCola(NodoArbol *nodo_arbol);
void insertarNodoCola(NodoCola **raiz, NodoCola *nuevo_nodo);
NodoCola *peekNodoCola(NodoCola *raiz);
void popNodoCola(NodoCola **raiz);
void imprimirCola(NodoCola *raiz);
int esColaVacia(NodoCola *tope);

NodoArbol *NuevoNodoArbol(int frecuencia, NodoArbol *nodo_izq, NodoArbol *nodo_der);
NodoArbol *NuevoNodoArbol(int frecuencia, NodoArbol *nodo_izq, NodoArbol *nodo_der, char caracter);
void PonerNodosArbol(NodoArbol **Raiz, NodoArbol *nodo_derecho, NodoArbol *nodo_izquierdo);
void mostrarArbol(NodoArbol **raiz, int identacion);

/*******************************************************************************
                             cola
*******************************************************************************/

NodoCola *crearNodoCola(NodoArbol *nodo_arbol){
	NodoCola *nodo_nuevo = NULL;
	nodo_nuevo = (NodoCola *)malloc((sizeof(NodoCola)));
	nodo_nuevo->nodo_arbol = nodo_arbol;

	nodo_nuevo->siguiente = NULL;

	return nodo_nuevo;
}

void insertarNodoCola(NodoCola **raiz, NodoCola *nuevo_nodo){
	if((*raiz) == NULL){
		(*raiz) = nuevo_nodo;
	}else{
		insertarNodoCola( &(*raiz)->siguiente, nuevo_nodo );
	}
}

NodoCola *peekNodoCola(NodoCola *raiz){
	return raiz;
}

void popNodoCola(NodoCola **raiz){
	if((*raiz) != NULL){
		if((*raiz)->siguiente == NULL){
			*raiz = NULL;
		}else{
			NodoCola *nodo_nuevo = (*raiz)->siguiente;
			*raiz = NULL;
			*raiz = nodo_nuevo;
		}
	}
}

void imprimirCola(NodoCola *raiz){
	if(raiz != NULL){
		printf("{%d:{%d, %d}}\n", raiz->nodo_arbol->frecuencia
			, raiz->nodo_arbol->Izq != NULL? raiz->nodo_arbol->Izq->frecuencia : -1
			, raiz->nodo_arbol->Der != NULL? raiz->nodo_arbol->Der->frecuencia : -1);
		imprimirCola(&(*(raiz->siguiente)));
	}
}

int esColaVacia(NodoCola *tope){
	return ((tope)== NULL? 1 : 0);
}

/*******************************************************************************
                             arbol
*******************************************************************************/

NodoArbol *NuevoNodoArbol(int frecuencia, NodoArbol *nodo_izq, NodoArbol *nodo_der){
	return NuevoNodoArbol(frecuencia, nodo_izq, nodo_der, NULL);
}

NodoArbol *NuevoNodoArbol(int frecuencia, NodoArbol *nodo_izq, NodoArbol *nodo_der, char caracter){
	NodoArbol *Nodo=NULL;
	if((Nodo = (NodoArbol *)malloc(sizeof(NodoArbol)))==0 ){
		return NULL;
	}else{
		Nodo->caracter = caracter;
		Nodo->frecuencia = frecuencia;
		Nodo->Izq = nodo_izq;
		Nodo->Der = nodo_der;
		return Nodo;
	}
}

void PonerNodosArbol(NodoArbol **Raiz, NodoArbol *nodo_derecho, NodoArbol *nodo_izquierdo){
	(*Raiz)->Izq = nodo_izquierdo;
	(*Raiz)->Der = nodo_derecho;
}

void mostrarArbol(NodoArbol **raiz, int identacion){
	if(*raiz == NULL){
		return;
	}else{		
		int nueva_identacion = identacion + 2;
		if((*raiz)->Izq != NULL) mostrarArbol(&(*raiz)->Izq, nueva_identacion);
		for(int i = 0; i < nueva_identacion; i++){printf(" ");}
		if((*raiz)->caracter == NULL){
			printf("%d\n", (*raiz)->frecuencia);
		}else{
			printf("%d(%c)\n", (*raiz)->frecuencia, (*raiz)->caracter);
		}
		if((*raiz)->Der != NULL) mostrarArbol(&(*raiz)->Der, nueva_identacion);
	}
}

char *generaCamino(NodoArbol **raiz, char caracter){
	if(*raiz == NULL){
		return "";
	}else{
		if((*raiz)->caracter == caracter){
			char token_final[MAX_BUFFER] = "";
			
			char token_aux[2];
			token_aux[0] = '.';
			token_aux[1] = '\0';
			
			strcpy(token_final, token_aux);
			
			return token_final;
		}
		
		char pista_total[MAX_BUFFER];
		
		char pista_izq[MAX_BUFFER];
		char pista_der[MAX_BUFFER];
		if((*raiz)->Izq != NULL){
			char *pista_izq_aux = generaCamino(&(*raiz)->Izq, caracter);
			strcpy(pista_izq, pista_izq_aux);
			
			if(strlen(pista_izq) > 0){
				strcpy(pista_izq, "1");
				strcat(pista_izq, pista_izq_aux);
				
				return pista_izq;
			}
		}
		
		if((*raiz)->Der != NULL){
			char *pista_der_aux = generaCamino(&(*raiz)->Der, caracter);
			strcpy(pista_der, pista_der_aux);
			
			if(strlen(pista_der) > 0){
				strcpy(pista_der, "0");
				strcat(pista_der, pista_der_aux);
				
				return pista_der;
			}
		}
		
		return "";
	}
}

/*******************************************************************************
                             principal
*******************************************************************************/

void cargarAContador(char caracter){
	int pos = (int)caracter - ASCII_INFERIOR;
	
	// incrementar frecuencia
	contadores[pos] = contadores[pos] + 1;
}

void cargarContadores(char *direccion_archivo){
	char caracter;
	FILE *archivo;
	
	archivo = fopen(direccion_archivo,"r");
	if (archivo){
		while((caracter=fgetc(archivo))!=EOF){
			cargarAContador(caracter);
		}
		fclose(archivo);
	}
}

void mostrarContadores(){
	for(int i = ASCII_INFERIOR; i <= ASCII_SUPERIOR; i++){
		char caracter = (char)i;
		int contador = contadores[i - ASCII_INFERIOR];
		
		if(contador > 0) printf("#[%c]=%d\n", caracter, contador);
	}
}

void ordenarContadorPorBurbuja(){
	for(int i = ASCII_INFERIOR; i <= ASCII_SUPERIOR; i++){
		contadores_ordenados_asc[i-ASCII_INFERIOR].contador = contadores[i-ASCII_INFERIOR];
		contadores_ordenados_asc[i-ASCII_INFERIOR].caracter = (char)i;
	}
	
	int n = ASCII_SUPERIOR - ASCII_INFERIOR + 1;
	
	while(1){
		int nuevo_n = 0;
		for(int i = 1; i < n; i++){
			if(contadores_ordenados_asc[i-1].contador > contadores_ordenados_asc[i].contador){
				Contador contador_0 = contadores_ordenados_asc[i-1];
				Contador contador_1 = contadores_ordenados_asc[i];
				
				contadores_ordenados_asc[i-1] = contador_1;
				contadores_ordenados_asc[i] = contador_0;
				
				nuevo_n = i;
			}
		}
		n = nuevo_n;
		if(n <= 1) break;
	}
}

void mostrarContadoresOrdenados(){
	for(int i = ASCII_INFERIOR; i <= ASCII_SUPERIOR; i++){
		char caracter = contadores_ordenados_asc[i - ASCII_INFERIOR].caracter;
		int contador = contadores_ordenados_asc[i - ASCII_INFERIOR].contador;
		
		if(contador > 0) printf("#[%c]=%d\n", caracter, contador);
	}
}

NodoCola *cola = NULL;

void procesarContadores(){
	int ancla = -1;
	int primer = 1;
	
	for(int i = 0; i < TAMANO_CONTADORES-1; i++){
		Contador contador_0 = contadores_ordenados_asc[i];
		
		if(contadores_ordenados_asc[i].contador > 0){
			if(ancla == -1){
				ancla = i;
				primer = 1;
			}
			
			if(primer == 1){
				Contador contador_1 = contadores_ordenados_asc[i+1];
				
				int frecuencia_a = contador_0.contador;
				int frecuencia_b = contador_1.contador;
				
				if(frecuencia_a > frecuencia_b){
					// intercambiar orden
					contador_1 = contador_0;
					contador_0 = contadores_ordenados_asc[i+1];
				}
				
				frecuencia_a = contador_0.contador;
				frecuencia_b = contador_1.contador;
				
				NodoArbol *arbol = NuevoNodoArbol(frecuencia_a + frecuencia_b,
									NuevoNodoArbol(frecuencia_a, NULL, NULL, contador_0.caracter), NuevoNodoArbol(frecuencia_b, NULL, NULL, contador_1.caracter)
								);
				cola = crearNodoCola(arbol);
				
				primer = 0;
				i = i + 1; // en siguiente podre procesar
			}else{
				// obtener suma de todo anterior
				int suma = 0;
				for(int j = ancla; j < i; j++){
					Contador contador_j = contadores_ordenados_asc[j];
					int frecuencia_j = contador_j.contador;
					suma = suma + frecuencia_j;
				}
				
				int frecuencia_b = contador_0.contador;
				
				NodoArbol *arbol_izq = NULL;
				NodoArbol *arbol_der = NULL;
				if(suma > frecuencia_b){
					frecuencia_b = suma;
					suma = contador_0.contador;
					
					arbol_izq = NuevoNodoArbol(suma, NULL, NULL, contador_0.caracter);
					arbol_der = NuevoNodoArbol(frecuencia_b, NULL, NULL);
				}else{
					arbol_izq = NuevoNodoArbol(suma, NULL, NULL);
					arbol_der = NuevoNodoArbol(frecuencia_b, NULL, NULL, contador_0.caracter);
				}
				
				// armar nuevo arbol
				NodoArbol *arbol = NuevoNodoArbol(suma + frecuencia_b,
									arbol_izq
									, arbol_der
								);
				NodoCola *cola_i = crearNodoCola(arbol);
				
				// meter en cola
				insertarNodoCola(&cola, cola_i);
			}
		}
	}	
}

void procesarCola(char *direccion_archivo){
	
	NodoArbol *arbol_completo = NULL;
	int frecuencia = -1;
	while(esColaVacia(cola) == 0){
		// nodo cola actual
		NodoCola *nodo_actual = peekNodoCola(cola);
		popNodoCola(&cola);
		
		if(frecuencia == -1){
			NodoArbol *nodo_arbol_actual = nodo_actual->nodo_arbol;
			frecuencia = nodo_arbol_actual->frecuencia;
			
			arbol_completo = nodo_arbol_actual;
		}else{
			NodoArbol *nodo_arbol_actual = nodo_actual->nodo_arbol;
			NodoArbol *nodo_arbol_actual_izq = nodo_arbol_actual->Izq;
			NodoArbol *nodo_arbol_actual_der = nodo_arbol_actual->Der;
			
			NodoArbol *arbol_aux = arbol_completo;
			arbol_completo = NULL;
			
			arbol_completo = nodo_arbol_actual;
			if(frecuencia == nodo_arbol_actual_izq->frecuencia){
				arbol_completo->Izq = arbol_aux;
			}else{
				arbol_completo->Der = arbol_aux;
			}
			
			frecuencia = nodo_arbol_actual->frecuencia;
		}
	}
	
	printf("--nodos en arbol--\n");
	
	mostrarArbol(&arbol_completo, 2);
	
	printf("--cargar soluciones--\n");
	
	for(int i = 0; i < TAMANO_CONTADORES; i++){
		Contador contador_actual = contadores_ordenados_asc[i];
		if(contador_actual.contador > 0){
			char caracter_actual = contador_actual.caracter;
			strcpy((contadores_ordenados_asc[i]).solucion, generaCamino(&arbol_completo, caracter_actual));
		}
	}
	
	printf("--reescribir--\n");
	
	// leer archivo entrada
	char caracter;
	FILE *archivo_entrada;
	FILE * archivo_salida;
	
	char dir_archivo_salida[MAX_BUFFER];
	strcpy(dir_archivo_salida, direccion_archivo);
	strcat(dir_archivo_salida, ".huff");
	
	
	archivo_entrada = fopen(direccion_archivo,"r");
	archivo_salida = fopen (dir_archivo_salida,"w");
	
	if (archivo_entrada){
		while((caracter=fgetc(archivo_entrada))!=EOF){
			for(int i = 0; i < 255; i++){
				if(contadores_ordenados_asc[i].caracter == caracter){
					for(int k = 0; k < strlen(contadores_ordenados_asc[i].solucion); k++){
						char hup[2];
						hup[0]=((contadores_ordenados_asc[i]).solucion)[k];
						hup[1]='\0';
						if(((contadores_ordenados_asc[i]).solucion)[k] != '.') fprintf (archivo_salida, hup, 'A');
					}
					break;
				}
			}
		}
		fclose(archivo_entrada);
	}
	
	fclose (archivo_salida);
	
	printf("--listo--\n");
}

void main(){
	char direccion_archivo[255*2];
	
	printf("Ingresa la direccion del archivo de entrada:\n");
	gets(direccion_archivo);
	strcpy(direccion_archivo, direccion_archivo);

	cargarContadores(direccion_archivo);
	
	printf("--contadores--\n");
	
	mostrarContadores();
	
	printf("--contadores ordenados--\n");
	
	ordenarContadorPorBurbuja();
	mostrarContadoresOrdenados();
	
	procesarContadores();
	printf("--nodos de arbol--\n");
	imprimirCola(cola);
	procesarCola(direccion_archivo);
	
	gets("");
}