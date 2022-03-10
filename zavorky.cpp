#include <string>
#include <iostream>

using namespace std;


int main()
{
    zavorky(20,0,"");
    return 0;
}

static int zavorky(int n, int otevrenych, string s) {
    if (n == 0) {
        cout << s + "\n";    
    }else{
        if (otevrenych > 0) {
            zavorky(n - 1, otevrenych - 1, s + ")");
        }
        if (otevrenych < n) {
        zavorky(n - 1, otevrenych + 1, s + "(");    
        }
    }
}
