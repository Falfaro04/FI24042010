import java.util.Arrays;

public class CustomGraph {

    private char[] _chars;
    private int[][] _matrix;

    public CustomGraph(char[] chars) {
        _chars = chars;
        _matrix = new int[chars.length][chars.length];
    }

    public void addDirectedEdge(char source, char target) {
        addEdge(source, target);
    }

    private void addEdge(char source, char target) {

        // ChatGPT - adyacencia en la matriz
        int sourceIndex = -1;
        int targetIndex = -1;

        for (int i = 0; i < _chars.length; i++) {
            if (_chars[i] == source) {
                sourceIndex = i;
            }
            if (_chars[i] == target) {
                targetIndex = i;
            }
        }

        // Si algún caracter no está, no se registra
        if (sourceIndex == -1 || targetIndex == -1) {
            return;
        }

        _matrix[sourceIndex][targetIndex] = _matrix[sourceIndex][targetIndex] + 1;
    }

    public String getMatrix() {
        var builder = new StringBuilder(" ");
        for (int index = 0; index < _chars.length; index++) {
            builder.append(" , " + _chars[index]);
        }
        for (int row = 0; row < _chars.length; row++) {
            builder.append("\n");
            builder.append(_chars[row]);
            for (int col = 0; col < _chars.length; col++) {
                builder.append(" , " + _matrix[row][col]);
            }
        }
        builder.append("\n");
        return builder.toString();
    }
}
