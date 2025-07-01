
public class AVLTrre {
  private Node root;

  public AVLTrre() {
    this.root = null;
  }

  public int height(Node node) { // O(2n)
    if (node == null) {
      return 0;
    }
    return node.getHeight();
  }

  public int getBalance(Node node) {
    if (node == null) {
      return 0;
    }
    return height(node.getIzquierda()) - height(node.getDerecha());
  }

  public void insert(int value) {
    System.out.println("Nodo a insertar");
    root = insertRec(root, value);
  }

  private Node insertRec(Node node, int value) {

    if (node == null) {
      Node newNode = new Node(value);
      newNode.setHeight(1);
      System.out.println("Nodo insertado " + newNode.getValue() + "Balane al insertar = " + getBalance(newNode));
      return newNode;
    }
    if (value < node.getValue()) {
      node.setIzquierda(insertRec(node.getIzquierda(), value));
    } else if (value > node.getValue()) {
      node.setDerecha(insertRec(node.getDerecha(), value));
    } else {
      return node;
    }
    // ACtualizar La altura de este ancestro node
    // pregunta ma los nodos hijos que altura tienen, toman su max y suman + 1 para
    // calcular la altura del padre
    int altura = 1 + Math.max(height(node.getIzquierda()), height(node.getDerecha()));

    // guarda la altura y no el nivel
    node.setHeight(altura);

    // calcula la altura pero me puede dar el nodo desequilibrado
    // hay que hacer el metodo para equilibrar
    System.out.println("\t Altura = " + node.getHeight());

    // Balance
    int balance = getBalance(node);

    // caso izquierda - izquierda Rotacion a la derecha
    if (balance > 1 && value < node.getIzquierda().getValue()) {
      System.out.println("Rotacion Derecha");
      return rightRotate(node);
    }

    // Caso derecha - derecha Rotacion Izquierda
    if (balance < -1 && value > node.getDerecha().getValue()) {
      System.out.println("Rotacion Izquierda");
      return leftRotate(node);
    }

    // Caso izquierda - derecha
    if (balance > 1 && value > node.getIzquierda().getValue()) {
      System.out.println("Cambio LR");
      node.setIzquierda(leftRotate(node.getIzquierda()));
      System.out.println("Rotacion Derecha");
      return rightRotate(node);
    }

    // Caso Derecha -Izquierda
    if (balance < -1 && value < node.getDerecha().getValue()) {
      System.out.println("Cambio RL");
      node.setDerecha(rightRotate(node.getDerecha()));
      System.out.println("Rotacion Izquierda");
      return leftRotate(node);
    }

    return node;
  }

  // rotación derecha
  private Node rightRotate(Node y) {
    Node x = y.getIzquierda();
    Node T2 = x.getDerecha();

    x.setDerecha(y);
    y.setIzquierda(T2);

    // actualizar alturas
    y.setHeight(1 + Math.max(
        height(y.getIzquierda()),
        height(y.getDerecha())));
    x.setHeight(1 + Math.max(
        height(x.getIzquierda()),
        height(x.getDerecha())));

    return x;
  }

  // rotación izquierda
  private Node leftRotate(Node x) {
    Node y = x.getDerecha();
    Node T2 = y.getIzquierda();

    y.setIzquierda(x);
    x.setDerecha(T2);

    // actualizar alturas
    x.setHeight(1 + Math.max(
        height(x.getIzquierda()),
        height(x.getDerecha())));
    y.setHeight(1 + Math.max(
        height(y.getIzquierda()),
        height(y.getDerecha())));

    return y;
  }

  // pre-orden para impresión
  private String preorder(Node n) {
    if (n == null)
      return "";
    return n.getValue() + " "
        + preorder(n.getIzquierda())
        + preorder(n.getDerecha());
  }
  
  @Override
  public String toString() {
    // quitamos espacios sobrantes al inicio/fin
    return preorder(root).trim();
  }
}
