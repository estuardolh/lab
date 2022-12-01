from tkinter import *

def automata2(cadena_entrada):
    resultado = ""

    estado = 1
    for simbolo in cadena_entrada:
        match estado:
            case 1:
                print("test")
                
        if estado == 2 and not ( simbolo >= '0' and simbolo <= '9' or simbolo == 'E' or simbolo == '.' ):
            resultado = resultado + '\n' + "Error en estado 2, no se esperaba el simbolo: " + simbolo
        
        if estado == 3 and not ( simbolo >= '0' and simbolo <= '9' ):
            resultado = resultado + '\n' + "Error en estado 3, no se esperaba el simbolo: " + simbolo

        if estado == 4 and not ( simbolo >= '0' and simbolo <= '9' or simbolo == 'E' ):
            resultado = resultado + '\n' + "Error en estado 4, no se esperaba el simbolo: " + simbolo

        if estado == 5 and not ( simbolo >= '0' and simbolo <= '9' or simbolo == '+' or simbolo == '-' ):
            resultado = resultado + '\n' + "Error en estado 5, no se esperaba el simbolo: " + simbolo

        if estado == 6 and not ( simbolo >= '0' and simbolo <= '9'):
            resultado = resultado + '\n' + "Error en estado 6, no se esperaba el simbolo: " + simbolo

        if estado == 7 and not ( simbolo >= '0' and simbolo <= '9'):
            resultado = resultado + '\n' + "Error en estado 7, no se esperaba el simbolo: " + simbolo


        if estado == 1 and ( simbolo >= '0' and simbolo <= '9' or simbolo == '+' or simbolo == '-' ):
            estado = 2
        elif estado == 2 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 2 # CICLO
        elif estado == 2 and ( simbolo == '.' ):
            estado = 3
        elif estado == 2 and ( simbolo == 'E' ):
            estado = 5
        elif estado == 3 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 4
        elif estado == 4 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 4 # CICLO
        elif estado == 4 and ( simbolo == 'E' ):
            estado = 5
        elif estado == 5 and ( simbolo == '+' or simbolo == '-' ):
            estado = 6
        elif estado == 5 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 7
        elif estado == 7 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 7 # CICLO
        elif estado == 6 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 7

        if estado == 1 and not ( simbolo >= '0' and simbolo <= '9' or simbolo == '+' or simbolo == '-' ):
            resultado = resultado + '\n' + "Error en estado 1, no se esperaba el simbolo: " + simbolo
    
    
    return resultado

def ciclo_automata2(cadena_entrada):
    resultado = ""

    for texto in cadena_entrada.split():
        resultado = resultado + automata2(texto.strip('\n')) # strip quita saltos de linea
    
    return resultado

def automata1(cadena_entrada):
    resultado = ""

    estado = 1
    indice = 0
    for simbolo in cadena_entrada:
        if estado == 1 and ( simbolo >= 'a' and simbolo <= 'z' or simbolo >= 'A' and simbolo <= 'Z' or simbolo == '_' ):
            estado = 3
        elif estado == 3 and ( simbolo >= 'a' and simbolo <= 'z' or simbolo >= 'A' and simbolo <= 'Z' or simbolo == '_' or simbolo >= '0' and simbolo <= '9' ):
            estado = 3 # CICLO
        elif estado == 1 and ( simbolo >= '0' and simbolo <= '9' ):
            estado = 2
        
        if estado == 3 and not ( simbolo >= 'a' and simbolo <= 'z' or simbolo >= 'A' and simbolo <= 'Z' or simbolo == '_' or simbolo >= '0' and simbolo <= '9' ):
            resultado = resultado + '\n' + ("Error en estado 3, no se esperaba el simbolo: " + simbolo)

        if estado == 1:
            resultado = resultado + '\n' + ("Error en estado 1, no se esperaba el simbolo: " + simbolo)

        if estado == 2:
            if indice != len(cadena_entrada) - 1:
                resultado = resultado + '\n' + ("Error en estado 2, no se esperaba mas simbolos.")

        indice += 1
    
    return resultado

def ciclo_automata1(cadena_entrada):
    resultado = ""

    for texto in cadena_entrada.split():
        resultado = resultado + automata1(texto.strip('\n')) # strip quita saltos de linea
    
    return resultado

root = Tk()
root.geometry("500x360")
root.title(" Automatas ")
 
# combo
tkvar = StringVar(root)
items = { 'Automata1','Automata2'}
tkvar.set('Automata1')
combo = OptionMenu(root, tkvar, *items)

def procesar():
    entrada = caja_entrada.get("1.0", "end-1c")
    
    if(tkvar.get() == "Automata1"):
        salida.insert(END, ciclo_automata1(entrada))
    else:
        salida.insert(END, ciclo_automata2(entrada))

def limpiar():
    salida.delete('1.0', END)

etiqueta = Label(text = "Ingresar cadenas de entrada")

caja_entrada = Text(root, height = 6,
                width = 60,
                bg = "light yellow")
 
salida = Text(root, height = 5,
              width = 60,
              bg = "light cyan")
 
boton_ejecutar = Button(root, height = 2,
                 width = 26,
                 text ="Ejecutar",
                 command = lambda:procesar())

boton_limpiar = Button(root, height = 2,
                 width = 26,
                 text ="Limpiar",
                 command = lambda:limpiar())

combo.pack()
etiqueta.pack()
caja_entrada.pack()
boton_ejecutar.pack()
boton_limpiar.pack()
salida.pack()
 
mainloop()