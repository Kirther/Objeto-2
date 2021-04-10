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
	
	public ThreadProcessor (String tGrilo, int tDist, boolean tgriloB, int tnPulos, int tdistTotal) {
		
		grilo = tGrilo;
		griloB = tgriloB;
		dist = tDist;
		distTotal = tdistTotal;
		nPulos = tnPulos;
		
		
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
				
				System.out.println ("O " + grilo + " alcançou a linha de chegada com um total de " + nPulos + " pulos.");
			}
			
			
		}
		
	}
}
