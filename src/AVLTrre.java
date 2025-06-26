
public class AVLTrre {
  private Node root;
  public AVLTrre(){
    this.root=null;
  }

  public int height(Node node){ //O(2n)
    if(node==null){
      return 0;

    }
  
    return node.getHeight();
  
  }


  public int getBalance(Node node){
    if(node==null){
      return 0;
    }
    return height(node.getIzquierda()) - height(node.getDerecha());
  }


  public void insert(int value){
    System.out.println("Nodo a insertar");
    root= insertRec(root, value);
  }


  private Node insertRec(Node node, int value){
    if(node ==null){
      Node newNode = new Node( value);
      newNode.setHeight(1);
       System.out.println("Nodo insertado "+ newNode.getValue() + "Balane al insertar = "+ getBalance(newNode));
       return newNode;
    }
    if(value< node.getValue()){
      node.setIzquierda(insertRec(node.getIzquierda(), value));
    }else if(value> node.getValue()){
      node.setDerecha(insertRec(node.getDerecha(), value));
    }else{
      return node;
    }
    //ACtualizar La altura de este ancestro node
    //pregunta ma los nodos hijos que altura tienen, toman su max y suman + 1 para calcular la altura del padre
    int altura= 1 + Math.max(height(node.getIzquierda()) , height(node.getDerecha()));

    //guarda la altura y no el nivel
    node.setHeight(altura);

    //calcula la altura pero me puede dar el nodo desequilibrado
    //hay que hacer el metodo para equilibrar 
     System.out.println("\t Altura = " + node.getHeight());


    // Balance
    int balance=getBalance(node);
    // caso izquierda  - izquierda Rotacion a la derecha 
    if(balance > 1 && value< node.getIzquierda().getValue()){
      System.out.println("Rotacion Derecha ");
    }
    // Caso derecha - derecha Rotacion Izquierda

    if(balance<-1 && value> node.getDerecha().getValue()){
      System.out.println("Rotacion Izquierda ");
    }
    // Caso izquierda - derecha 
    if(balance>1 && value> node.getIzquierda().getValue()){
      System.out.println("Cambio ");
      System.out.println("Rotacion Derecha ");
    }

    //Caso Derecha -Izquierda

    if(balance<-1 && value< node.getDerecha().getValue()){
      System.out.println("Cambio ");
      System.out.println("Rotacion Izquierda ");
    }


    return node;
  }
}
