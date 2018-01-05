import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class MyThread2 extends Thread {

	Vector<Object> u;
	SingleTable table;
	int indice;
	int operatie;
	int low, high;
	public final Semaphore resourcex = new Semaphore(1);

		MyThread2(Vector<Object> u, SingleTable table, int indice, int operatie, int low, int high)
		{
			this.u = u;
			this.table = table;
			this.indice = indice;
			this.operatie = operatie;
			this.low = low;
			this.high = high;
		}
		public void run()
		{
			if(operatie == 1)
			{
				int sum = 0;
				for(int k = low; k <= high; k++)
				{
					sum += (int)table.getValues().get(k).get(indice);
				}
	
					
					u.add(sum);
								
			}
			if(operatie == 2)
			{
				int min = 99999;;
				for(int k = low; k <= high; k++)
				{
					if((int)table.getValues().get(k).get(indice) < min)
					{
						min = (int)table.getValues().get(k).get(indice);
					}
				}
	
			u.add(min);
			}
			if(operatie == 3)
			{
				int max = -99999;;
				for(int k = low; k <= high; k++)
				{
					if((int)table.getValues().get(k).get(indice) > max)
					{
						max = (int)table.getValues().get(k).get(indice);
					}
				}
	
			u.add(max);
			}
		}
}
