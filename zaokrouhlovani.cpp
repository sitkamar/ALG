#include <string>
#include <iostream>

using namespace std;


int main()
{

    for(int i = 0; i < 100; i++){
        int s = 0;
        for(int j = 0; j < i; j++){
            s += 1/i;
        }
        cout << i << " " << s << endl;
    }
}
