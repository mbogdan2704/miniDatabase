import java.awt.List;
import java.util.ArrayList;

public class SingleTable {
	String[] columnNames;
	String[] columnTypes;
	ArrayList<ArrayList<Object>> values = new ArrayList<ArrayList<Object>>();
	public ArrayList<ArrayList<Object>> getValues() {
		return values;
	}

	int numValues = 0;
	
	

	public ArrayList<Object> getValue(int num) {
		return getValues().get(num);
	}

	public void setValue(ArrayList<Object> values) {
		int ok = 1;
		for(int i = 0 ; i < values.size(); i++)
			if(verify(values.get(i), i) == 0)
				ok = 0;
		if(ok == 1)
			getValues().add(values);
	}

	SingleTable(String[] columnNames, String[] columnTypes) {
		this.columnNames = columnNames;
		this.columnTypes = columnTypes;
	
	}

	public String[] getColumnNames() {
		return columnNames;
	}

	public void setColumnNames(String[] columnNames) {
		this.columnNames = columnNames;
	}

	public String[] getColumnTypes() {
		return columnTypes;
	}

	public void setColumnTypes(String[] columnTypes) {
		this.columnTypes = columnTypes;
	}
	public int getIndiceColumn(String column)
	{
		for(int i = 0 ; i < columnNames.length; i++)
		{
			if(columnNames[i].equals(column))
			{
				return i;
			}
		}
		
		return -1;
	}
	public void modifyTable1(int indice, String val,  ArrayList<Object> newValues)
	{
		for(int i = 0; i < getValues().size(); i++)
		{
			if(compare(values.get(i).get(indice),val, indice) == 1) {
				for(int j = 0 ; j< values.get(i).size(); j++)
				{
					if(verify(newValues.get(j), j) == 1)
						values.get(i).set(j, newValues.get(j));
					else {
						System.err.println("ERROxxR");
						
					}
					}
			
			}
		}
	}
	
	public void modifyTable2(int indice, String val,  ArrayList<Object> newValues)
	{
		if(columnTypes[indice].equals("int"))
		{
			try {
				int x = Integer.parseInt(val);
				for(int i = 0; i < getValues().size(); i++)
				{

					if((int)values.get(i).get(indice) < x) {
						for(int j = 0 ; j< values.get(i).size(); j++)
						{
							if(verify(newValues.get(j), j) == 1)
								values.get(i).set(j, newValues.get(j));
							else
								System.err.println("ERROR");
						}

					}
				}
			}catch(NumberFormatException e) {
				System.err.println("ERROdsaR");
			}
		}

		else
			System.err.println("ERRsORxx");
	}
	
	public void modifyTable3(int indice, String val,  ArrayList<Object> newValues)
	{
		if(columnTypes[indice].equals("int"))
		{
			try {
				int x = Integer.parseInt(val);
				for(int i = 0; i < getValues().size(); i++)
				{

					if((int)values.get(i).get(indice) < x) {
						for(int j = 0 ; j< values.get(i).size(); j++)
						{
							if(verify(newValues.get(j), j) == 1)
								values.get(i).set(j, newValues.get(j));
							else
								System.err.println("ERROR");
						}

					}
				}
			}catch(NumberFormatException e) {
				System.err.println("ERROasR");
			}
		}

		else
			System.err.println("ERROaR");
	}
	
	public void modifyTable4(ArrayList<Object> newValues)
	{
		for(int i = 0; i < getValues().size(); i++)
		{

			for(int j = 0 ; j< values.get(i).size(); j++)
			{
				if(verify(newValues.get(j), j) == 1)
					values.get(i).set(j, newValues.get(j));
				else {
					System.err.println("ERROxxR");

				}
			}


		}
	}
	//-1 pentru eroare
	public int verify(Object o, int indice)
	{
		String type = columnTypes[indice];
		if(type.equals("int"))
		{
			if(o instanceof Integer)
				return 1;
			else
				return 0;
		}
		else if(type.equals("string"))
		{
			if(o instanceof String)
				return 1;
			else
				return 0;
		}
		else if(type.equals("bool"))
		{
			if(o instanceof Boolean)
				return 1;
			else
				return 0;
		}
		return 0;
	}
	public int compare(Object o, String val, int indice)
	{
		try { //DACA E INTEGER
			int valx = Integer.parseInt(val); 
			if(!columnTypes[indice].equals("int"))
				return -1;
			else
				if((int)o == valx)
					return 1;
				else
					return 0;

		} catch(NumberFormatException e) { 


			if(val.equals("true") || val.equals("false")) //DACA E BOOL
			{
			
				if(!columnTypes[indice].equals("bool"))

					return -1;

				else
				{
					if((boolean)o == Boolean.parseBoolean(val)) {
					
						return 1;
					}
					else
						return 0;
				}
			}
			else { //DACA E STRING
				if(!columnTypes[indice].equals("string"))
					return -1;
				else
					if(o.equals(val))
						return 1;
					else
						return 0;
			}
		}

	}
	
}
