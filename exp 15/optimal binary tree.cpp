#include <iostream>
#include <vector>
#include <limits>
using namespace std;

void OBST(const vector<int>& keys, const vector<double>& probabilities) {
    int n = keys.size();
    vector<vector<double>> c(n + 1, vector<double>(n + 1, 0.0));
    vector<vector<double>> w(n + 1, vector<double>(n + 1, 0.0));

    for (int i = 1; i <= n; ++i) {
        w[i][i] = probabilities[i - 1];
        c[i][i] = probabilities[i - 1];
    }

    for (int l = 2; l <= n; ++l) {
        for (int i = 1; i <= n - l + 1; ++i) {
            int j = i + l - 1;
            w[i][j] = w[i][j - 1] + probabilities[j - 1];
            c[i][j] = numeric_limits<double>::max();

            for (int r = i; r <= j; ++r) {
                double cur = (r > i ? c[i][r - 1] : 0) + 
                             (r < j ? c[r + 1][j] : 0) + w[i][j];
                if (cur < c[i][j]) {
                    c[i][j] = cur;
                }
            }
        }
    }

    cout << "Min cost of OBST: " << c[1][n] << endl;
}

int main() {
    int n;
    cout << "Enter the number of keys: ";
    cin >> n;

    vector<int> keys(n);
    vector<double> probabilities(n);

    cout << "Enter keys: ";
    for (int i = 0; i < n; ++i) {
        cin >> keys[i];
    }

    cout << "Enter probabilities: ";
    for (int i = 0; i < n; ++i) {
        cin >> probabilities[i];
    }

    OBST(keys, probabilities);

    return 0;
}
