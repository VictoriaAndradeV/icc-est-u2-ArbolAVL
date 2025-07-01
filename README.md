# Práctica Árbol AVL
## 📌 Información General

- *Título:* Práctica árbol AVL
- *Asignatura:* Estructura de Datos
- *Carrera:* Computación
- *Estudiante:* Victoria Andrade - Cristian Moscoso
- *Fecha:* 01/07/2025
- *Profesor:* Ing. Pablo Torres

---
## 🛠 Descripción
Esta tarea consiste en diseñar e implementar en Java un Árbol AVL, es decir, un árbol binario de búsqueda auto‐equilibrado. A grandes rasgos, sus objetivos y requisitos son:
# 1. Estructura de nodos
- Crear una clase Node que guarde el valor entero, punteros a subárboles izquierdo y derecho, y un campo height que refleje la altura del nodo.

# 2. Inserción con auto‐equilibrio

Implementar el método insert(int value) que inserte recursivamente un nuevo nodo.

LL: inserción en subárbol izquierdo de hijo izquierdo → rotación derecha.

RR: inserción en subárbol derecho de hijo derecho → rotación izquierda.

LR: inserción en subárbol derecho de hijo izquierdo → rotación izquierda en el hijo + rotación derecha en el nodo.

RL: inserción en subárbol izquierdo de hijo derecho → rotación derecha en el hijo + rotación izquierda en el nodo.

# 3. Rotaciones

Programar rightRotate(Node y) y leftRotate(Node x), que ajusten punteros y recalculen alturas de los nodos implicados.
