#include <bits/stdc++.h>
#include <iostream>
using namespace std::chrono;
using namespace std;

int op = 0;
int depth=0;
void complexRec(int n)
{

    if (n <= 2)
    {
        op++;
        return; // 1
    }

    int p = n;
    while (p > 0)
    {
        vector<int> temp(n);
        for (int i = 0; i < n; i++)
        { // n^2
            temp[i] = i ^ p;
            op++;
        }
        p >>= 1;
    }

    vector<int> small(n);
    for (int i = 0; i < n; i++)
    { // n
        small[i] = i * i;
        op++;
    }

    if (n % 3 == 0)
    { // 1
        reverse(small.begin(), small.end());
        op++;
    }
    else
    {
        reverse(small.begin(), small.end());
        op++;
    }

    complexRec(n / 2); // n/2
    depth++;
    complexRec(n / 2); // n/2
    complexRec(n / 2); // n/2
}

int main()
{
    auto start = high_resolution_clock::now();

    complexRec(20);

    auto end = high_resolution_clock::now();

    auto duration = duration_cast<milliseconds>(end - start);

    cout << "Execution time: " << duration.count() << endl;
    cout << "Number of operations: " << op << endl;
    cout << "Depth = " << depth;
}
// Recurence relation = 3T(n/2)+nlogn+n+2
// time complexity : n^log3

// #include <iostream>
// using namespace std::chrono

// auto start = high_resolution_clock::now();

// auto end = high_resolution_clock::now();
// auto duration = duration_cast<milliseconds>(end-start);
// cout<<duration.count();

// int main() {

//     return 0;
// }