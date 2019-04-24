import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class pass2 
{
	public static void main(String args[])
	{
		try
		{
			String File1="/home/swapnil/Desktop/PASS1-2/pass2_mc/src/IC.txt";
			FileReader fr = new FileReader(File1);
			BufferedReader br = new BufferedReader(fr);		
			
			String File3="/home/swapnil/Desktop/PASS1-2/pass2_mc/src/sym_table.txt";
			FileReader fr1 = new FileReader(File3);
			BufferedReader sym = new BufferedReader(fr1);		
			
			String File2="/home/swapnil/Desktop/PASS1-2/pass2_mc/src/Pass2_MC.txt";
			FileWriter fw = new FileWriter(File2);
			BufferedWriter bw =new BufferedWriter(fw); 
			
			String line="";
			int val=0;
			
			HashMap<Integer,Integer>hash= new HashMap<Integer, Integer>();

			while((line=sym.readLine())!=null)
			{
					String p[]=line.split("\\s+");
					hash.put(Integer.parseInt(p[0]),Integer.parseInt(p[1]));				
			}
			//System.out.println(hash);
			
			while((line=br.readLine())!=null)
			{
				String parts[]=line.split("\\s+");
				
				if((parts[1].equals("AD")) && (parts[2].equals("1")))
				{
						bw.write("\n");
						continue;
				}
				else if(parts[1].equals("IS"))
				{
					if(parts[4].equals("S"))
					{
						if(parts[5].equals("1"))
						{
							val=hash.get(1);
						}
						else
						{
							if(parts[5].equals("2"))
							{
								val=hash.get(2);
							}
						}
					}
					
					bw.write("0"+parts[2]+"\t0"+parts[3]+"\t"+val+"\n");
				}
				else if(parts[1].equals("DL"))
				{		
					bw.write("00\t00\t"+"00"+parts[4]+"\n");
				}
				else
				{
					bw.write("\n");
				}
			}
			
			bw.close();
			br.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
