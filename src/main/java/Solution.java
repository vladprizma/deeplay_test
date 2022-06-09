import errorcode.GameSolverErrorCode;
import exception.GameSolverException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    private final static int INF = Integer.MAX_VALUE;
    private final static int VERTEX_AMOUNT = 16;
    private final static int WIDTH = 4;
    private final static int HEIGHT = 4;

    private final static Map<String, Terms> entityTerms = new HashMap<>();

    public static int getResult(String field, String creature) throws GameSolverException {
        if (field.length() != 16)
            throw new GameSolverException(GameSolverErrorCode.INCORRECT_FIELD_STRING_LENGTH);
        return dijkstra(0, stringToCostMatrix(field, creature))[VERTEX_AMOUNT - 1];
    }

    private static int[] dijkstra(int start, int[][] graph) {
        boolean[] used = new boolean[VERTEX_AMOUNT];
        int[] dist = new int[VERTEX_AMOUNT];

        Arrays.fill(dist, INF);
        dist[start] = 0;

        // cV - currentVertex
        // nV - nextVertex
        while (true) {
            int cV = -1;
            for (int nV = 0; nV < VERTEX_AMOUNT; nV++) {
                if (!used[nV] && dist[nV] < INF && (cV == -1 || dist[cV] > dist[nV]))
                    cV = nV;
            }
            if (cV == -1)
                break;
            used[cV] = true;

            for (int nV = 0; nV < VERTEX_AMOUNT; nV++) {
                if (!used[nV] && isAdjacent(cV, nV))
                    dist[nV] = Math.min(dist[nV], dist[cV] + graph[nV / WIDTH][nV % WIDTH]);
            }
        }
        return dist;
    }

    // Проверяем смежность по упрощенной теореме Пифагора
    private static boolean isAdjacent(int currentVertex, int nextVertexIndex) {
        return Math.abs(currentVertex % WIDTH - nextVertexIndex % WIDTH) +
                Math.abs(currentVertex / WIDTH - nextVertexIndex / WIDTH) == 1;
    }

    private static int[][] stringToCostMatrix(String field, String creature) throws GameSolverException {
        char[] cell = field.toCharArray();
        int[][] costMatrix = new int[HEIGHT][WIDTH];

        //noinspection ConstantConditions
        entityTerms.putAll(Parser.readTerms(Params.getPathToTermsFile()));
        Terms creatureTerms = entityTerms.get(creature.trim());
        if (creatureTerms == null)
            throw new GameSolverException(GameSolverErrorCode.NO_SUCH_CREATURE_FOUND);

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (!creatureTerms.getCellCost().containsKey(cell[i * WIDTH + j]))
                    throw new GameSolverException(GameSolverErrorCode.NO_SUCH_COST_SYMBOL_FOUND);
                costMatrix[i][j] = creatureTerms.getCellCost().get(cell[i * WIDTH + j]);
            }
        }
        return costMatrix;
    }
}
