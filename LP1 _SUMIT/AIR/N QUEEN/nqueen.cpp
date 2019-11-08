// sakamoto_jin
#include "bits/stdc++.h"
using namespace std ;
const int N = 100 ;
int chess[N][N] ;
int n ;

bool safeh(int row, int col)
{
	bool flag = true ;
	for(int i = 1 ; i <= n ; i++)
		if(chess[i][col] || chess[row][i]) flag = false ;
	int i = row , j = col ;
	while(i > 0 && j > 0) if(chess[i--][j--]) flag = false ;
	i = row , j = col ;
	while(i > 0 && col <= n) if(chess[i--][j++]) flag = false ;
	return flag ;
}

int solve(int idx  )
{
	if(idx > n) return 1 ;
	for(int j = 1 ; j <= n ; j++)
	{
		if(safeh(idx ,j))
		{
			chess[idx][j] = 1;
			if(solve(idx+1)) return 1 ;
			chess[idx][j]  = 0 ;
		}
	}
	return 0 ;
}
int main()
{
	cin >> n ;
	solve(1);
	for(int i = 1 ; i <= n ; i++)
	{
		for(int j = 1 ; j <= n ; j++)
			cout << chess[i][j] << " " ;
		cout << endl;
	}

}
