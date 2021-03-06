package main;

public class main {
	
	public static void main(String[] args) {
		
		int maxGrilos = 5;
		int minGrilos = 2;
		int nGrilos;
		String[] grilos;
		boolean[] bGrilos;
		int[] nPulos;
		
		int totalDist = 300;
		int[] gDist;

		String[] times;
		RankingManager ranking = new RankingManager();
		
		nGrilos = (int) (Math.random() * ((maxGrilos - minGrilos) + 1) + minGrilos);
		
		if (nGrilos % 2 == 0)
		{
			//n?o precisa acontecer nada
		}
		else
		{
			nGrilos++;
		}
		
		grilos = new String[nGrilos];
		gDist = new int[nGrilos];
		bGrilos = new boolean[nGrilos];
		nPulos = new int[nGrilos];
		times = new String[nGrilos];
		
		//Gerando todos os grilos, e iniciando seus valores de iniciais de movimento e bool de chegada
		for (int i = 0; i < grilos.length; i++)
		{
			grilos[i] =  "Grilo_0" + (i + 1);
			gDist[i] = 0;
			nPulos[i] = 0;
			bGrilos[i] = false;
			
			if (i % 2 ==0)
				times[i] = "Time 1";
				else
					times[i] = "Time 2";
			
			//System.out.println("O " + grilos[i] + " j? andou " + gDist[i] + "cm, e seu valor para chegada ?: " + bGrilos[i]);
		}
		
		ThreadProcessor threads[] = new ThreadProcessor[nGrilos];
		
		System.out.println("In?cio da Corrida");
		
		
		for (int i = 0; i < nGrilos; i++)
		{
			threads[i] = new ThreadProcessor(grilos[i], gDist[i], bGrilos[i], nPulos[i], totalDist, times[i], ranking);
			threads[i].start();
		}
		
		for (int i = 0; i < nGrilos; i++)
		{
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		ranking.TeamRanking();
		
		//System.out.println("Fim da Corrida");

	}
}
