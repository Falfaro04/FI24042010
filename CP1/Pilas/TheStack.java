import java.util.Random;
import java.util.Stack;

public class TheStack<Type> implements TheStackInterface<Type> {

    private Stack<Type> _stack;

    private Integer _capacity;

    public TheStack(Integer capacity) {
        _stack = new Stack<Type>();
        _capacity = capacity;
    }

    // https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
    // Corrección: evitar recursión infinita usando _stack.push en lugar de this.push
    public Boolean push(Type item) {
        var available = _stack.size() < _capacity;
        if (available) {
            _stack.push(item);
        }
        return available;
    }

    // https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
    // Modificación: retornar null si la pila está vacía
    public Type pop() {
        if (_stack.isEmpty()) {
            return null;
        }
        return _stack.pop();
    }

    // https://docs.oracle.com/javase/8/docs/api/java/util/Stack.html
    // Modificación: retornar null si la pila está vacía
    public Type peek() {
        if (_stack.isEmpty()) {
            return null;
        }
        return _stack.peek();
    }

    public boolean empty() {
        return _stack.isEmpty();
    }

    public int size() {
        return _stack.size();
    }

    public String print() {
        return _stack.toString();
    }

    public static void main(String[] args) {
        var capacity = Integer.parseInt(args[0]);
        TheStackInterface<Double> stack = new TheStack<Double>(capacity);
        System.out.println("Pushing {capacity + 1}");
        var random = new Random();
        for (var n = 0; n <= capacity; n++) {
            var number = random.nextDouble();
            var pushed = stack.push(number);
            System.out.println(" ↳ push(" + number + ") → " + pushed);
        }
        System.out.println();
        System.out.println("Pushed {full}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
        System.out.println();
        System.out.println("Popping {capacity + 1}");
        for (var n = 0; n <= capacity; n++) {
            var popped = stack.pop();
            System.out.println(" ↳ pop() → " + popped);
        }
        System.out.println();
        System.out.println("Popped {empty}");
        System.out.println(" ↳ print() → " + stack.print());
        System.out.println("   ↳ peek() → " + stack.peek());
        System.out.println("   ↳ size() → " + stack.size());
        System.out.println("   ↳ empty() → " + stack.empty());
    }
}
