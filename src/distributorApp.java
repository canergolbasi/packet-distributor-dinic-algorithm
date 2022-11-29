
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class distributorApp {

	public static Vector<Integer> train_g=new Vector<>(); 
	public static Vector<Integer> train_r=new Vector<>(); 
	public static Vector<Integer> reindeer_g=new Vector<>(); 
	public static Vector<Integer> reindeer_r=new Vector<>(); 
	
	public static Vector<String> bags=new Vector<>();

	public static void main(String[] args) throws IOException {
		
		String inputFileName=args[0];
		String outputFileName=args[1];
		

		
		Scanner sc2 = null;	 
		try {
			sc2 = new Scanner(new File(inputFileName));
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		Scanner s2 = new Scanner(sc2.nextLine());
		int traing=Integer.parseInt(s2.nextLine());
		
		
		if(traing>0) {
		Scanner s3=new Scanner(sc2.nextLine());
		for(int i=0;i<traing;i++) {
			int a=s3.nextInt();
			train_g.add(a);
		}
		}else {
			Scanner s3=new Scanner(sc2.nextLine());
			
		}		
		
		Scanner s5=new Scanner(sc2.nextLine());
		int trainr=Integer.parseInt(s5.nextLine());
		
		if(trainr>0) {
			Scanner s6=new Scanner(sc2.nextLine());
			for(int i=0;i<trainr;i++) {
				int a=s6.nextInt();
				train_r.add(a);
			}
			}else {
				Scanner s6=new Scanner(sc2.nextLine());
				
			}
		
			Scanner s8=new Scanner(sc2.nextLine());
			int reindeerg=Integer.parseInt(s8.nextLine());
			
			
			if(reindeerg>0) {
				Scanner s9=new Scanner(sc2.nextLine());
				for(int i=0;i<reindeerg;i++) {
					int a=s9.nextInt();
					reindeer_g.add(a);
				}
				}else {
					Scanner s9=new Scanner(sc2.nextLine());
					
				}
	
			Scanner s11=new Scanner(sc2.nextLine());
			int reindeerr=Integer.parseInt(s11.nextLine());
			
			
			if(reindeerr>0) {
				Scanner s12=new Scanner(sc2.nextLine());
				for(int i=0;i<reindeerr;i++) {
					int a=s12.nextInt();
					reindeer_r.add(a);
				}
				}else {
					Scanner s12=new Scanner(sc2.nextLine());
					
				}
		
			Scanner s14=new Scanner(sc2.nextLine());
			int numberofgifttypes=Integer.parseInt(s14.nextLine());
			
			
			
			int nodelist_size=numberofgifttypes+(traing + trainr + reindeerg + reindeerr)+2;
		
			NodeList n=new NodeList(nodelist_size);
			
			Scanner s15=new Scanner(sc2.nextLine());
			for(int j=0;j<numberofgifttypes;j++) {
				
				String gifttype=s15.next();
				int giftnumber=	s15.nextInt();
				
				String sgiftnumber=Integer.toString(giftnumber);
				
				bags.add(gifttype);
				bags.add(sgiftnumber);

			}
	
			n.addEdge(train_g, train_r, reindeer_g, reindeer_r, bags);
			
			n.addEdgetot(train_g, train_r, reindeer_g, reindeer_r, bags);
			
		
	    int destination=bags.size()/2+ train_g.size()+ train_r.size()+ reindeer_g.size() + reindeer_r.size()+1;
	    
	    int flow=n.numberofgifts(0, destination);
	
	    int totalgift=0;
	    for(int z=0;z<bags.size()/2;z++) {
	    	
	    	totalgift=totalgift+Integer.parseInt(bags.get(2*z+1));
	    }
	    
	    int result=totalgift-flow;
	    //System.out.println("cevap :" + result  );
	    
	    
	 // writing to file
	 		FileWriter myWriter = null;
	     	myWriter = new FileWriter(outputFileName);
	     	myWriter.write(Integer.toString(result));
	  
	     	myWriter.close();

	   
	}
}
