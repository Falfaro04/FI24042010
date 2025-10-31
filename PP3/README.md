# Práctica Programada 3 — Lista Circular Doblemente Enlazada

**Estudiante:** Freddy Alfaro Álvarez  
**Carné:** FI24042010  
**Curso:** Estructuras de Datos (SC-304)  
**Profesor:** Luis Andrés Rojas Matey  
**IDE:** Visual Studio Code  

---

## Descripción

Implementación de una **lista circular doblemente enlazada** en Java, con métodos para agregar y eliminar nodos en ambos extremos (`addFirst`, `addLast`, `removeFirst`, `removeLast`).  
Los valores almacenados son números naturales entre **0 y 9**, generados aleatoriamente.

---

## Prompts utilizados (ChatGPT)

- ¿Cómo se conecta el primer y último nodo en una lista circular doblemente enlazada?  
- Ayúdame a implementar `addFirst` y `removeLast` sin romper la circularidad.

---

## Páginas consultadas

- ChatGPT (https://chatgpt.com/c/690414b2-46e0-832a-b9b9-023782e82fc2)

---

## Preguntas 

### 1. Estructura tipo Cola (Queue) y Pila (Stack)

**Cola (Queue):**  
Usaría una **lista circular**, porque permite insertar por el final y eliminar por el inicio fácilmente.

**Pila (Stack):**  
Usaría una **lista simplemente enlazada**, ya que solo se inserta y elimina por un mismo extremo, algo más simple.

---

### 2. Ventajas y desventajas de crear su propia lista

**Ventaja:**  
Control total sobre la estructura y su comportamiento.  

**Desventaja:**  
Más propenso a errores y menos optimizado que las estructuras como `LinkedList`.
