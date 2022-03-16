package ee.ttu.algoritmid.subtreedifference;

public class SubtreeDifference {



    /**
     * Calculate difference between sum of all left children and sum of all right children for every node
     * @param rootNode root node of the tree. Use it to traverse the tree.
     * @return root node of the tree where for every node is computed difference of sums of it's left and right children
     */
    public Node calculateDifferences(Node rootNode) {

        Node left = rootNode.getLeft();
        Node right = rootNode.getRight();
        if (right != null & left != null) {
            calculateDifferences(left);
            calculateDifferences(right);
            long rightSum = right.getSumOfAllChildren() + right.getValue();
            long leftSum = left.getSumOfAllChildren() + left.getValue();
            rootNode.setSumOfAllChildren(leftSum + rightSum);
            rootNode.setDifferenceOfLeftAndRight(leftSum - rightSum);


        } else if (left != null) {
            calculateDifferences(left);
            long leftSum = left.getSumOfAllChildren() + left.getValue();
            rootNode.setSumOfAllChildren(leftSum);
            rootNode.setDifferenceOfLeftAndRight(leftSum);

        } else if (right != null) {
            calculateDifferences(right);
            long rightSum = right.getSumOfAllChildren() + right.getValue();
            rootNode.setSumOfAllChildren(rightSum);
            rootNode.setDifferenceOfLeftAndRight(-rightSum);

        }

        return rootNode;
    }

    public static void main(String[] args) throws Exception {
        /**
         *  Use this example to test your solution
         *                  Tree:
         *                   15
         *               /       \
         *             10         17
         *           /   \       /  \
         *         3     13     5    25
         *                \
         *                 1
         *                /
         *               1
         */
        Node rootNode = new Node(15);
        Node a = new Node(10);
        Node b = new Node(17);
        Node c = new Node(3);
        Node d = new Node(13);
        Node e = new Node(5);
        Node f = new Node(25);
        Node g = new Node(1);
        Node h = new Node(1);



        //rootNode.setLeft(a);
        rootNode.setRight(b);
        a.setLeft(c);
        a.setRight(d);
        b.setLeft(e);
        b.setRight(f);

        SubtreeDifference solution = new SubtreeDifference();
        solution.calculateDifferences(rootNode);
        System.out.println(rootNode.getDifferenceOfLeftAndRight());

        if (rootNode.getDifferenceOfLeftAndRight() != -21 ||
                a.getDifferenceOfLeftAndRight() != -10 ||
                b.getDifferenceOfLeftAndRight() != -20 ||
                c.getDifferenceOfLeftAndRight() != 0) {
            throw new Exception("There is a mistake in your solution.");
        }

        System.out.println("Your solution should be working fine in basic cases, try to push.");

    }

}