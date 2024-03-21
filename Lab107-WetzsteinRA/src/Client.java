
import java.util.Random;

/**
 *
 * @author rwetz
 */
public class Client {

    public static void main(String[] args) {
        // ArrayStack
        System.out.println("ArrayStack Operations:");
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        System.out.println("Pushing 10 random integers onto the stack:");

        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(101);
            arrayStack.push(randomNumber);
            System.out.println("Added integer " + (i + 1) + ": " + randomNumber);
        }
        System.out.println("Popping the stack until it is empty:");
        int count = 1;
        while (!arrayStack.isEmpty()) {
            System.out.println("Deleted integer " + count + ": " + arrayStack.pop());
            count++;
        }

        System.out.println("-----------------------------------------------------------------");

        // LinkedStack
        System.out.println("\nLinkedStack Operations:");
        LinkedStack<Integer> linkedStack = new LinkedStack<>();
        System.out.println("Pushing 10 random integers onto the stack:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(101);
            linkedStack.push(randomNumber); // Pushing the same random integer generated
            System.out.println("Added integer " + (i + 1) + ": " + randomNumber);
        }

        System.out.println("Popping the stack until it is empty:");
        int count1 = 1;
        while (!linkedStack.isEmpty()) {
            System.out.println("Deleted integer " + count1 + ": " + linkedStack.pop());
            count1++;
        }

        System.out.println("-----------------------------------------------------------------");

        // ArrayQueue
        System.out.println("\nArrayQueue Operations:");
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        System.out.println("Enqueueing 10 random integers into the queue:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(101);
            arrayQueue.enqueue(rand.nextInt(101));
            System.out.println("Added integer " + (i + 1) + ": " + randomNumber);
        }
        System.out.println("Dequeueing the queue until it is empty:");
        int count2 = 1;
        while (!arrayQueue.isEmpty()) {
            System.out.println("Deleted integer " + count2 + ": " + arrayQueue.dequeue());
            count2++;
        }

        System.out.println("-----------------------------------------------------------------");

        // LinkedQueue
        System.out.println("\nLinkedQueue Operations:");
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        System.out.println("Enqueueing 10 random integers into the queue:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(101);
            linkedQueue.enqueue(rand.nextInt(101));
            System.out.println("Added integer " + (i + 1) + ": " + randomNumber);
        }

        System.out.println("Dequeueing the queue until it is empty:");
        int count3 = 1;
        while (!linkedQueue.isEmpty()) {
            System.out.println("Deleted integer " + count3 + ": " + linkedQueue.dequeue());
            count3++;
        }

        System.out.println("-----------------------------------------------------------------");

        // LinkedPositionalList
        System.out.println("\nLinkedPositionalList Operations:");
        LinkedPositionalList<Integer> linkedPositionalList = new LinkedPositionalList<>();
        System.out.println("Adding 10 random integers into the list:");
        for (int i = 0; i < 10; i++) {
            int randomNumber = rand.nextInt(101); // Generates random integer between 0 and 100 (inclusive)
            linkedPositionalList.addLast(randomNumber);
            System.out.println("Added integer " + (i + 1) + ": " + randomNumber);
        }
        System.out.println("Iterating forward through the list:");
        Position<Integer> currentPosition = linkedPositionalList.first();
        while (currentPosition != null) {
            System.out.println(currentPosition.getElement());
            currentPosition = linkedPositionalList.after(currentPosition);
        }
        System.out.println("Iterating backward through the list:");
        currentPosition = linkedPositionalList.last();
        while (currentPosition != null) {
            System.out.println(currentPosition.getElement());
            currentPosition = linkedPositionalList.before(currentPosition);
        }

        System.out.println("-----------------------------------------------------------------");

        // Create the main tree
        LinkedBinaryTree<String> mainTree = new LinkedBinaryTree<>();
        mainTree.addRoot("*");

        // Create operand subtrees
        LinkedBinaryTree<String> tree9 = new LinkedBinaryTree<>();
        tree9.addRoot("9");

        LinkedBinaryTree<String> tree8 = new LinkedBinaryTree<>();
        tree8.addRoot("8");

        LinkedBinaryTree<String> tree17 = new LinkedBinaryTree<>();
        tree17.addRoot("17");

        LinkedBinaryTree<String> tree14 = new LinkedBinaryTree<>();
        tree14.addRoot("14");

        LinkedBinaryTree<String> tree23 = new LinkedBinaryTree<>();
        tree23.addRoot("23");

        LinkedBinaryTree<String> treeMinus2 = new LinkedBinaryTree<>();
        treeMinus2.addRoot("-2");

        // Create operator subtrees
        LinkedBinaryTree<String> treeTimes1 = new LinkedBinaryTree<>();
        treeTimes1.addRoot("*");

        LinkedBinaryTree<String> treePlus1 = new LinkedBinaryTree<>();
        treePlus1.addRoot("+");

        LinkedBinaryTree<String> treeDivide = new LinkedBinaryTree<>();
        treeDivide.addRoot("/");

        LinkedBinaryTree<String> treePlus2 = new LinkedBinaryTree<>();
        treePlus2.addRoot("+");

        LinkedBinaryTree<String> treeTimes2 = new LinkedBinaryTree<>();
        treeTimes2.addRoot("+");

        //Attach operand subtrees to operator subtrees
        mainTree.attach(treeTimes1.root(), tree9, tree8); //subtreeA
        mainTree.attach(treePlus1.root(), treeTimes1, tree17); //subtreeB
        mainTree.attach(treePlus2.root(), tree14, tree23); //subtree C
        mainTree.attach(treeDivide.root(), treePlus1, treePlus2); //subtree D
        //mainTree.attach(treeTimes2.root(), treeDivide, treeMinus2); //subtree E
        mainTree.attach(mainTree.root(), treeDivide, treeMinus2); //attach all subtrees to main
        System.out.println("The root of the main tree is: " + mainTree.root().getElement()); //print root

        //Print the literal string representation of the expression
        System.out.println("Expression Tree (Literal String Representation):");
        System.out.println("( ( 9 * 8 ) + 17 ) / ( 14 + 23 ) * -2");

        //Calculate and print the height of the expression tree
        System.out.println("\nHeight of the Expression Tree: " + mainTree.height(mainTree.root()));

        //Print the traversals
        System.out.println("\nPreOrder Traversal:");
        printTraversal(mainTree.preorder());

        System.out.println("\nInOrder Traversal:");
        printTraversal(mainTree.inorder());

        System.out.println("\nPostOrder Traversal:");
        printTraversal(mainTree.postorder());

        System.out.println("\nBreadthFirst Traversal:");
        printTraversal(mainTree.breadthfirst());
    }

    //method to print traversals
    private static void printTraversal(Iterable<Position<String>> positions) {
        for (Position<String> pos : positions) {
            System.out.print(pos.getElement() + " ");
        }
        System.out.println();
    }
}
