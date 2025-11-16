import java.util.Arrays;
import java.util.Stack;

public class BinTreeIntArray {

    private Integer[] _tree;

    public BinTreeIntArray(int size) {
        _tree = new Integer[size];
    }

    public Integer[] getTree() {
        return _tree;
    }

    // =====================
    //       INSERT
    // =====================
    public void insert(int value) {
        int index = 0;

        while (index < _tree.length) {
            if (_tree[index] == null) {
                _tree[index] = value;
                break;
            } else if (value < _tree[index]) {
                int left = 2 * index + 1;
                if (left >= _tree.length) break;
                index = left;
            } else if (value > _tree[index]) {
                int right = 2 * index + 2;
                if (right >= _tree.length) break;
                index = right;
            } else {
                break; // valor duplicado
            }
        }

        System.out.println(" ↳ insert: " + value + " → " + Arrays.toString(_tree));
    }

    // =====================
    //    IN-ORDER (L-R)
    // =====================
    public void inOrderTraversal() { // left -> root -> right
        System.out.print(" ↳ inOrderTraversal → ");

        Stack<Integer> stack = new Stack<>();
        int index = 0;

        while (!stack.isEmpty() || (index < _tree.length && _tree[index] != null)) {
            while (index < _tree.length && _tree[index] != null) {
                stack.push(index);
                index = 2 * index + 1;
            }

            index = stack.pop();
            System.out.print(_tree[index] + " ");

            index = 2 * index + 2;
        }

        System.out.println();
    }

    // =====================
    //   PRE-ORDER (R-L)
    // =====================
    public void preOrderTraversal() { // root -> left -> right
        System.out.print(" ↳ preOrderTraversal → ");

        if (_tree.length > 0 && _tree[0] != null) {

            Stack<Integer> stack = new Stack<>();
            stack.push(0);

            while (!stack.isEmpty()) {
                int index = stack.pop();
                if (index >= _tree.length || _tree[index] == null) continue;

                System.out.print(_tree[index] + " ");

                int right = 2 * index + 2;
                int left = 2 * index + 1;

                if (right < _tree.length) stack.push(right);
                if (left < _tree.length) stack.push(left);
            }
        }

        System.out.println();
    }

    // =====================
    //  POST-ORDER (L-R-R)
    // =====================
    public void postOrderTraversal() { // left -> right -> root
        System.out.print(" ↳ postOrderTraversal → ");

        if (_tree.length > 0 && _tree[0] != null) {

            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            s1.push(0);

            while (!s1.isEmpty()) {
                int index = s1.pop();
                if (index >= _tree.length || _tree[index] == null) continue;

                s2.push(index);

                int left = 2 * index + 1;
                int right = 2 * index + 2;

                if (left < _tree.length) s1.push(left);
                if (right < _tree.length) s1.push(right);
            }

            while (!s2.isEmpty()) {
                System.out.print(_tree[s2.pop()] + " ");
            }
        }

        System.out.println();
    }

    // =====================
    //        MAIN
    // =====================
    public static void main(String[] args) {
        var tree = new BinTreeIntArray(7);

        System.out.println("Empty array → " + Arrays.toString(tree.getTree()));
        tree.insert(4);
        tree.insert(6);
        tree.insert(5);
        tree.insert(2);
        tree.insert(7);
        tree.insert(1);
        tree.insert(3);

        System.out.println("\nFull array → " + Arrays.toString(tree.getTree()));
        tree.inOrderTraversal();      // 1 2 3 4 5 6 7
        tree.preOrderTraversal();     // 4 2 1 3 6 5 7
        tree.postOrderTraversal();    // 1 3 2 5 7 6 4
    }
}
