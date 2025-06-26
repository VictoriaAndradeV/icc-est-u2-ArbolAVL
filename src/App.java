public class App {
    public static void main(String[] args) throws Exception {
        AVLTrre arbol = new AVLTrre();
        arbol.insert(10);
        arbol.insert(20);
        arbol.insert(15);
        System.out.println(arbol);
    }
}
