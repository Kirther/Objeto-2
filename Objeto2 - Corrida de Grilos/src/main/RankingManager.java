package main;

import java.util.concurrent.Semaphore;

public class RankingManager {
	
	String firstTime;
	
	int rank = 0;
	
	int distTime1 = 0;
	int pulosTime1 = 0;
	int distTime2 = 0;
	int pulosTime2 = 0;
	
	Semaphore semaforo = new Semaphore(1);
	
	public void Ranking (String grilo, int dist, String time, int nPulos)
	{
		
		try {
			semaforo.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (firstTime == null)
		{
			firstTime = time;
		}
		
		rank++;
		
		if (time == "Time 1")
		{
			distTime1 += dist;
			pulosTime1 += nPulos;
		}
		else
		{
			distTime2 += dist;
			pulosTime2 += nPulos;
		}
		
		semaforo.release();
		
		System.out.println("O " + grilo + " foi o " + rank + "º colocado com " + nPulos + " pulos.");
	}
	
	public void TeamRanking()
	{
		System.out.println("Time 1: Total de Pulos: " + pulosTime1 + " - Distância Percorrida: " + distTime1 + "cm.");
		System.out.println("Time 2: Total de Pulos: " + pulosTime2 + " - Distância Percorrida: " + distTime2 + "cm.");
		System.out.println(firstTime + " foi o vencedor");
	}

}
