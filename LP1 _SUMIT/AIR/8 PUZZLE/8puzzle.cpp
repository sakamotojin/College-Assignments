#include "bits/stdc++.h"
using namespace std ;
int in[3][3]={{3,7,6},{5,1,2},{4,0,8}};
int fi[3][3]={{5,3,6},{7,0,2},{4,1,8}};
map<int,pair<int,int>>mp ;
int mx = 0 ;
int dx[] = {-1,1,0,0};
int dy[] = {0,0,-1,1};


bool safe(int i ,int j)
{
	return (i >= 0 && j >= 0 && i < 3 && j < 3);
}
int cal(int mat[3][3])
{
	int cost = 0 ;
	for(int i = 0 ; i < 3 ; i++)
		for(int j = 0 ; j < 3 ; j++)
			cost += (abs(mp[mat[i][j]].first-i)+abs(mp[mat[i][j]].second-j)) ;
	return cost ;
}
class node
{
	public :
	node *parent ;
	int x , y ;
	int lev ;
	int mat[3][3] ;
	int cost ;
	node(){};
	node(node *pr ,int m[3][3] ,int le)
	{
		parent = pr ;
		cost = 0 ;
		for(int i = 0 ; i < 3 ; i++)
			for(int j = 0 ; j < 3 ; j++)
			{
				mat[i][j] = m[i][j] ;
				if(mat[i][j]==0)
					x = i , y = j ;
			}
			cost = cal(this->mat);
			lev = le ;
	}
};
struct comp
{
	bool operator()(const node* e1 , const node * e2)const
	{
		return ((e1->cost)>(e2->cost));
	}
};
vector<int> vis(node *ptr)
{

	vector<int> temp ;
	for(int i = 0 ; i < 3 ; i++)
		for(int j = 0 ; j < 3 ; j++)
			temp.push_back(ptr->mat[i][j]);
		return temp ;
}
void print(node *ptr)
{
	if(ptr==NULL) return ;
		print(ptr->parent);
		cout << "\n---------------\n" ;
	for(int i = 0 ; i < 3; i++)
	{
		for(int j =0 ; j < 3; j++)
			cout << ptr->mat[i][j] << " ";
		cout << endl ;
	}
}
void solve()
{
	priority_queue<node* , vector<node*>,comp> pq ;
	set<vector<int>> s ;
	node *root = new node(NULL ,in,0);
	pq.push(root);
	s.insert(vis(root));
	while(!pq.empty())
	{
		mx = max(mx,(int)pq.size());
		node *cur = pq.top();
		pq.pop();
		if(cur->cost==0)
		{
			print(cur);
			return  ;
		}
		for(int i = 0 ; i <4 ; i++)
		{
			if(safe(dx[i]+cur->x,dy[i]+cur->y))
			{
				swap(cur->mat[cur->x][cur->y],cur->mat[dx[i]+cur->x][dy[i]+cur->y]);
				if(s.find(vis(cur))==s.end())
				pq.push(new node(cur,cur->mat,cur->lev+1));
				swap(cur->mat[cur->x][cur->y],cur->mat[dx[i]+cur->x][dy[i]+cur->y]);
			}
		}
		//cout << endl ;
	}
}
int main()
{
	for(int i = 0 ; i < 3 ; i++)
		for(int j = 0 ; j <3 ; j++)
			mp[fi[i][j]] ={i,j};
	solve();
	cout << endl << mx ;
}
