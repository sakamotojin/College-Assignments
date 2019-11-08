// sakamoto_jin
#include "bits/stdc++.h"
using namespace std ;
int n ;
int a[100] ;

int heu()
{
	int cost = 0 ;
	for(int i = 0 ; i < n ; i++)
		for(int j = i +1 ; j < n ; j++)
			cost += (a[j]<a[i]);
		return cost ;
}

int main()
{
	cin >> n ;
	for(int i = 0 ; i < n ; i++)
		a[i] = rand() %100;
	for(int i = 0 ; i < n ; i++ )
		cout << a[i] << " ";
	int bc = heu() ,cnt = 0 ;
	cout << " # " << bc << endl ;
	while(bc > 0 )
	{
		for(int i =0 ; i+1 < n ;i++)
		{
			int x = rand()%n , y = rand()%n ;
			swap(a[x],a[y]);
			int nc = heu();
			if(nc < bc){
				bc = nc ;
				cnt++;
				cout << endl ;
				for(int i = 0 ; i < n ; i++ )
					cout << a[i] << " ";
				cout << " # " << bc <<  endl ;
				swap(a[x],a[y]);
			}
			swap(a[x],a[y]);
		}
	}
	cout << cnt << endl ;
	return 0 ;

}
