import java.util.ArrayList;

public class MyThread extends Thread {

	int indice, low, high;
	String val;
	ArrayList<Object> newValues;
	int operatie;
	SingleTable table;
		MyThread(int indice, String val, ArrayList<Object> newValues, int low, int high, int operatie, SingleTable table)
		{
			this.indice = indice;
			this.val = val;
			this.newValues = newValues;
			this.low = low;
			this.high = high;
			this.operatie = operatie;
			this.table = table;
		}
		
		
		public void  run()
		{
			if(operatie == 1)
			{
				
				table.modifyTable1(indice, val, newValues, low, high);

			}
			if(operatie == 2)
			{
				
				table.modifyTable2(indice, val, newValues, low, high);

			}
			if(operatie == 3)
			{
				
				table.modifyTable3(indice, val, newValues, low, high);

			}
			if(operatie == 4)
			{
				
				table.modifyTable4(newValues, low, high);

			}
			
			
			
			
			
		}
}
