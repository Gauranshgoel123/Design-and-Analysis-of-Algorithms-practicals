import java.util.Scanner;
import java.util.Vector;

public class OBST {

    static void calculateOBST(Vector<Integer> keys, Vector<Double> probabilities) {
        int n = keys.size();
        double[][] cost = new double[n + 1][n + 1];
        double[][] weight = new double[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            weight[i][i] = probabilities.get(i - 1);
            cost[i][i] = probabilities.get(i - 1);
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 1; i <= n - length + 1; i++) {
                int j = i + length - 1;
                weight[i][j] = weight[i][j - 1] + probabilities.get(j - 1);
                cost[i][j] = Double.MAX_VALUE;

                for (int r = i; r <= j; r++) {
                    double currentCost = cost[i][r - 1] + cost[r + 1][j] + weight[i][j];
                    if (currentCost < cost[i][j]) {
                        cost[i][j] = currentCost;
                    }
                }
            }
        }
        
        System.out.println("Min cost of OBST: " + cost[1][n]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of keys: ");
        int n = scanner.nextInt();
        
        Vector<Integer> keys = new Vector<>(n);
        Vector<Double> probabilities = new Vector<>(n);
        
        System.out.println("Enter keys: ");
        for (int i = 0; i < n; i++) {
            keys.add(scanner.nextInt());
        }

        System.out.println("Enter probabilities: ");
        for (int i = 0; i < n; i++) {
            probabilities.add(scanner.nextDouble());
        }

        calculateOBST(keys, probabilities);
        scanner.close();
    }
}
