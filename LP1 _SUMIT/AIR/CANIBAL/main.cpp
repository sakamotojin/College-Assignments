#include "bits/stdc++.h"
using namespace std ;
int dx[] = {-1,0,-1,-2,0} ;
int dy[] = {-1,-1,0,0,-2} ;

int stc[2] ={3,0} ,stm[2] ={3,0};
int b = 0 ;
int cal(int c[2] , int m[2])
{
	return (3-c[1]) +(3-m[1]) ;
}
class node
{
	public :
	int c[2] , m[2] ,b  ;
	int lev ;
	node *par ;
	int cost ;
	node(){}
	node(node *pa,int c1[2] ,int m1[2] ,int b1,int le)
	{
		par = pa ;
		lev = le ;
		c[0] = c1[0],c[1] = c1[1], m[0] = m1[0] ,m[1] = m1[1] ;
		b = b1;
		cost = cal(c1,m1);
	}
	void change(int x ,int y)
	{
		c[b] += x ;
		c[b^1] -= x ;
		m[b] += y ;
		m[b^1] -= y ;
		b = b^1 ;
	}
	void print()
	{
		cout << " (" << c[0] << "    " << m[0] << "    " ;
		cout << c[1] << "    " << m[1] << "    " << b << " ) \n";
	}
};
bool safe(node *tmp)
{
	bool flag = true ;
		if(tmp->c[0] < 0 || tmp->c[1] < 0 || tmp->m[1] < 0 || tmp->m[0] < 0) return false ;
	 flag = flag && ((tmp->c[0] <= tmp->m[0])||(tmp->m[0]==0));
	 flag = flag && ((tmp->c[1] <= tmp->m[1])||(tmp->m[1]==0));
	 return flag ;
}
void print(node *trv)
{
	if(trv==NULL) return ;
		print(trv->par);
	trv->print();
}
struct comp
{
	bool operator()(const node* e1 ,const node* e2) const
	{
		return (e1->cost+e1->lev) >(e2->cost+e2->lev);
	}
};
void solve()
{
	priority_queue<node* ,vector<node*>,comp> pq ;
	node *root = new node(NULL ,stc,stm,b,0);
	pq.push(root);
	while(!pq.empty())
	{
		node *cur = pq.top() ;
		pq.pop();
		if(cur->cost==0)
		{
			cout << "\nPATH\n (CR , MR , CL , ML , B)\n";
			print(cur);
			return ;
		}
		for(int i = 0; i < 5 ; i++)
		{
			cur->change(dx[i],dy[i]);
			if(safe(cur))
				pq.push(new node(cur,cur->c ,cur->m,cur->b ,cur->lev+1));
			cur->change(dx[i],dy[i]);
		}
	}
}

int main()
{
	solve();
	return 0 ;
}
