/**
 * 
 */
/**
 * @author jitengirdhar
 *
 */
public class Graph_trav {

		int numofVertices;		//number of vertices
		int[][]adjlist;			//adjacency matrix
		
		Graph_trav(int v)
		{
			this.numofVertices = v;
			
			this.adjlist = new int[v][v];
			
			for(int i =0;i<v;i++)
			{
				for(int j =0;j<v;j++)
				{
					adjlist[i][j] = 0;
				}
			}
		}
	
	//add an edge in undirected graph, every edge adds 2 elements in the adjacency list
	public static void add(Graph_trav g,int src, int end, int val)
	{
		g.adjlist[src][end] = val;
		g.adjlist[end][src] = val;	//as we are running on undirected graph edge(i,j) as well as edge(j,i) will be present
	}
	
	//Printing graph as adjacency matrix.
	public static void printgraph(Graph_trav g)
	{
		int v = g.numofVertices;	
		int[][] ourlist = g.adjlist;
		
		for(int i =0; i<v;i++)
		{
			for(int j =0; j<v;j++)
			{
				System.out.print(ourlist[i][j]);
				System.out.print("\t");
			}
			System.out.print("\n");
		}
	}

	
	//to get the next vertex from the graph using the greedy approach.
	public static int minvalIndex(int dist[], boolean taken[])
	{
		int minVal = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for(int v = 0; v < dist.length; v++)
		{
			if(dist[v] < minVal && taken[v] == false)
			{
				minVal = dist[v];
				minIndex = v;
			}
		}
		
		return minIndex;
	}
	
	//Dijkitsra's algorithm on adjacency matrix
	public static int[] dijkitsra(int graph[][], int s)
	{
		int nv = graph[0].length;	//number of vertices
		
		int dist[] = new int[nv];	//distance vector for each vertex
		boolean taken[] = new boolean[nv];	//to check if the vertex is already selected or not
		
		//initialization of distances of all vertices and that none are selected.
		
		for(int i =0; i < nv; i++)		
		{
			dist[i] = Integer.MAX_VALUE;
			taken[i] = false;
		}
		
		dist[s] = 0;	//starting vertex s
		
		//updating distances 
		for(int j = 0;j< nv; j++)
		{
			int nvx = minvalIndex(dist ,taken);
			taken[nvx] = true;
			
			for(int k = 0;k< nv; k++)
			{
				if(taken[k] == false && graph[nvx][k] != 0 && (dist[nvx] + graph[nvx][k]) < dist[k] && dist[nvx] != Integer.MAX_VALUE)
				{
					dist[k] = dist[nvx] + graph[nvx][k];
				}
			}	
		}
		
		return dist;
	}
	
	
	public static void main(String args[])
	{
		int v = 10;	//10 vertices
		Graph_trav g = new Graph_trav(v);
		//System.out.print(g.adjlist.length);
		add(g,0,2,9);
		add(g,2,3,24);
		add(g,3,1,19);
		add(g,1,7,44);
		add(g,7,0,1);
		add(g,0,6,14);
		add(g,6,3,18);
		add(g,3,4,6);
		add(g,4,5,11);
		add(g,6,5,30);
		add(g,6,7,5);
		add(g,5,7,20);
		add(g,7,8,1);
		add(g,8,9,2);
		add(g,9,1,5);
		add(g,7,9,1);
		//added 15 edges 
		printgraph(g);
		
		System.out.print("\n");
		
		int dxt[] = new int[v];
		dxt = dijkitsra(g.adjlist,0);
		
		System.out.print("Vertex");
		System.out.print("\t");
		System.out.print("Distance");
		System.out.print("\n");
		
		for(int i =0; i< v; i++)
		{
			System.out.print(i);
			System.out.print("\t");
			System.out.print(dxt[i]);
			System.out.print("\n");
		}
		
		
	}
	

}