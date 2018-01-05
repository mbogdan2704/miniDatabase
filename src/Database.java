import java.util.ArrayList;
import java.util.HashMap;

public class Database implements MyDatabase {
	int numWorkerThreads;

	
    
	HashMap<String, SingleTable> hmap = new HashMap<String, SingleTable>();
	
	public HashMap<String, SingleTable> getHmap() {
		return hmap;
	}

	public void setHmap(HashMap<String, SingleTable> hmap) {
		this.hmap = hmap;
	}

	@Override
	public void initDb(int numWorkerThreads) {
		// TODO Auto-generated method stub
		this.setNumWorkerThreads(numWorkerThreads);
	}

	@Override
	public void stopDb() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable(String tableName, String[] columnNames, String[] columnTypes) {
		// TODO Auto-generated method stub
		SingleTable newTable = new SingleTable(columnNames, columnTypes);
		hmap.put(tableName, newTable);
		
		
		
	}

	@Override
	public ArrayList<ArrayList<Object>> select(String tableName, String[] operations, String condition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(String tableName, ArrayList<Object> values, String condition) {

		if(hmap.get(tableName) == null)
			System.err.println("ERROR");
		else {
			String[] elements = condition.split(" ");
			if(elements[0] != "") {
				if(elements[1].equals("=="))
				{
					int indice = hmap.get(tableName).getIndiceColumn(elements[0]);
					if(indice == -1)
						System.err.println("ERROxR");
					else
						hmap.get(tableName).modifyTable1(indice, elements[2], values);
				}

				if(elements[1].equals("<"))
				{
					int indice = hmap.get(tableName).getIndiceColumn(elements[0]);
					if(indice == -1)
						System.err.println("ERROR");
					else
						hmap.get(tableName).modifyTable2(indice, elements[2], values);
				}
				if(elements[1].equals(">"))
				{
					int indice = hmap.get(tableName).getIndiceColumn(elements[0]);
					if(indice == -1)
						System.err.println("ERROR");
					else
						hmap.get(tableName).modifyTable3(indice, elements[2], values);
				}
			}
			else
			{
				hmap.get(tableName).modifyTable4(values);
			}
		}



	}

	@Override
	public void insert(String tableName, ArrayList<Object> values) {
		SingleTable currentTable = hmap.get(tableName);
		//AICI TREBUIE VERIFICAT DACA VALUES CORESPUNDE CU TIPURILE
		if(currentTable == null)
			System.err.println("ERROR");
		else
			currentTable.setValue(values);


	}

	@Override
	public void startTransaction(String tableName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endTransaction(String tableName) {
		// TODO Auto-generated method stub
		
	}
	
	public int getNumWorkerThreads() {
		return numWorkerThreads;
	}

	public void setNumWorkerThreads(int numWorkerThreads) {
		this.numWorkerThreads = numWorkerThreads;
	}
	
	


}
