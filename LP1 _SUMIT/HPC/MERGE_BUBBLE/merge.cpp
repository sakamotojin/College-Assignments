#include "bits/stdc++.h"
#include <omp.h>
using namespace std;
const int N = 10 ;
int a[N],t[N];


void mergesort(int low ,int high)
{
    if(high > low)
    {
        int mid = (low + high)/2 ;
        mergesort(low ,mid);
        mergesort(mid+1,high);
        merge(a+low,a+mid,a+mid+1,a+high,t);
        cout << endl ;
        for(int i = low ; i <= high ; i++)
            cout <<  t[i-low] << " ";
    }
}
int main()
{
  for(int i = 0; i < N ; i++)
    a[i] = rand()%100 ;
    for(int i = 0; i < N ; i++) cout << a[i] << " ";
    cout << endl ;
    mergesort(0,N-1 );
    for(int i = 0; i < N ; i++) cout << a[i]  << " ";
}
