package main;

public class ThreadProcessor extends Thread {
	
	String grilo;
	boolean griloB;
	int dist;
	int distTotal;
	int nPulos;
	
	int maxPulo = 50;
	int minPulo = 10;
	int pulo;
	
	String time;
	RankingManager rankManager;
	
	public ThreadProcessor (String tGrilo, int tDist, boolean tgriloB, int tnPulos, int tdistTotal, String tTime, 
			RankingManager tRank) {
		
		grilo = tGrilo;
		griloB = tgriloB;
		dist = tDist;
		distTotal = tdistTotal;
		nPulos = tnPulos;
		
		time = tTime;
		rankManager = tRank;
	
	}
	
	@Override
	public void run() {
		
		while (!griloB) {
			
			pulo = (int) (Math.random() * ((maxPulo - minPulo) + 1) + minPulo);
			dist += pulo;
			
			nPulos++;
			
			System.out.println ("O " + grilo + " pulou " + pulo + 
					"cm e percorreu um total de " + dist + "cm.");
			
			if (dist >= distTotal) {
				griloB = true;
				
				rankManager.Ranking(grilo, dist, time, nPulos);
				
				//System.out.println ("O " + grilo + " alcan?ou a linha de chegada com um total de " + nPulos + " pulos.");
			}
			
			
		}
		
	}
}
