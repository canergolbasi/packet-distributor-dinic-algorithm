
import java.util.Vector;
import static java.lang.Math.min;

public class NodeList {

	int size;
	Vector<Edge> nodelist[];  // for making nodelist class public we should declare it here
	Vector<Integer> lev=new Vector<Integer>(); // this is the major thing in dinic algoritm.it is both using at the bfs and dfs part. 
	Vector<Integer> list =new Vector<Integer>();
	Vector<Integer> queue=new Vector<Integer>();
	
	@SuppressWarnings("unchecked")
	public NodeList(int size) {
		
		this.size = size;
		nodelist=new Vector[size];
			
		int i=0;
		
		while(!(i==(size))) {
			nodelist[i]=new Vector<>();
			
			i++;
		}
		
		for(int l=0;l<size;l++) {  // for the first usage we should assign inital value, otherwise it cause null exception
			list.add(0);
		}
		
		for(int m=0;m<size;m++) {
			lev.add(0);
		}
		
		for(int k=0;k<size;k++) {
			queue.add(0);   
		}
		
		
		
	}

	void addEdge(Vector<Integer> tg, Vector<Integer> tr, Vector<Integer> rg, Vector<Integer> rr, Vector<String> bags ) {
		
		int totaledge= (bags.size()/2) + rr.size() + rg.size() + tr.size() +tg.size() +1;  
		
		for(int i=0;i<bags.size()/2;i++) {   
			
			
			
			if(bags.get(2*i).equals("a")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				for(int jj=((bags.size()/2)+1); jj<totaledge; jj++) {  
				addedge(i+1,jj,1);
				};
				
								
				
			}else if(bags.get(2*i).equals("ab")) {
				
					
				
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tg ve rg
				for(int a=bags.size()/2+1 ; a<bags.size()/2 + tg.size() +1; a++) {
					addedge(i+1 ,a ,1);					
				}
				
				for( int b=bags.size()/2 + tg.size() +tr.size()+1 ; b< totaledge-rr.size();b++) {
					addedge(i+1,b ,1);
				}
			
				
				
			}else if(bags.get(2*i).equals("ac")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tr rr
				for(int c=bags.size()/2+ tg.size() +1 ; c<totaledge-rg.size()-rr.size() ; c++) {
					addedge(i+1,c,1);
				}
				
				for(int cc=totaledge-rr.size(); cc<totaledge;cc++) {
					addedge(i+1,cc,1);
				}
				
				
				
				
			}else if(bags.get(2*i).equals("ad")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				// tg ve tr
				for(int d=bags.size()/2 +1 ; d<bags.size()/2 + tg.size() + tr.size() +1 ;d++) {
					
					addedge(i+1,d,1);
				}
				
			}else if(bags.get(2*i).equals("ae")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//rg ve rr 
				for(int e=bags.size()/2 + tg.size() + tr.size()+1 ; e<totaledge;e++) {
					addedge(i+1,e,1);
				}
				
				
				
			}else if(bags.get(2*i).equals("abd")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tg
				for(int f=bags.size()/2 +1; f<bags.size()/2 +tg.size()+1;f++) {
					addedge(i+1,f,1);
				}
				
				
				//rg
			}else if(bags.get(2*i).equals("abe")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				for(int g=bags.size()/2 + tg.size() +tr.size()+1; g< totaledge-rr.size(); g++) {
					addedge(i+1 , g, 1);
				}
				
				
				
			}else if(bags.get(2*i).equals("acd")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				// tr
				for(int h=bags.size()/2+tg.size() +1 ; h<totaledge-rr.size()-rg.size(); h++) {
					addedge(i+1,h,1);
				}
				
				
			}else if(bags.get(2*i).equals("ace")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//rr
				for(int j=totaledge-rr.size(); j<totaledge; j++) {
					addedge(i+1,j , 1);					
				}
				
				
			}else if(bags.get(2*i).equals("b")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tg and rg				
				for(int k=bags.size()/2+1; k<bags.size()/2 + tg.size() +1 ; k++ ) {
					addedge(i+1, k , Integer.parseInt(bags.get(2*i+1)));
				}
				
				for(int kk=totaledge-rg.size()-rr.size(); kk<totaledge-rr.size();kk++) {
					addedge(i+1,kk,Integer.parseInt(bags.get(2*i+1)));
				}
				
				
			}else if(bags.get(2*i).equals("bd")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tg
				for(int l=bags.size()/2 +1 ; l<bags.size()/2 + tg.size() +1 ; l++) {
					addedge(i+1, l , Integer.parseInt(bags.get(2*i +1 )));
				}
				
				
			}else if(bags.get(2*i).equals("be")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//rg
				for(int m=totaledge-rr.size()-rg.size() ; m<totaledge-rr.size(); m++) {
					addedge(i+1, m ,Integer.parseInt(bags.get(2*i +1)));
				}
				
			}else if(bags.get(2*i).equals("c")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tr and rr
				for(int n=bags.size()/2+ tg.size() +1 ; n<totaledge-rg.size()-rr.size() ; n++) {
					addedge(i+1,n,Integer.parseInt(bags.get(2*i +1)));
				}
				
				for(int nn=totaledge-rr.size(); nn<totaledge;nn++) {
					addedge(i+1,nn,Integer.parseInt(bags.get(2*i +1)));
				}
				
				
			}else if(bags.get(2*i).equals("cd")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tr
				for(int o=bags.size()/2 +tg.size() +1 ; o<totaledge-rr.size()-rg.size();o++) {
					addedge(i+1, o, Integer.parseInt(bags.get(2*i +1)));
				}
				
				
				
			}else if(bags.get(2*i).equals("ce")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//rr
				for(int p=totaledge-rr.size() ; p<totaledge; p++) {
					addedge(i+1, p ,Integer.parseInt(bags.get(2*i +1)) );
				}
				
				
			}else if(bags.get(2*i).equals("d")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//tg tr
				for(int r=bags.size()/2 +1; r<totaledge-rg.size()-rr.size();r++) {
					addedge(i+1,r,Integer.parseInt(bags.get(2*i +1)));
				}
				
				
				
			}else if(bags.get(2*i).equals("e")) {
				addedge(0, i+1 , Integer.parseInt( bags.get(2*i+1) ) );
				
				//rg and rr
				for(int s=totaledge-rg.size()-rr.size() ; s<totaledge; s++) {
					addedge(i+1,s,Integer.parseInt(bags.get(2*i +1)));
				}
				
			}			
			
		}

		
	}


	 
	 int numberofgifts(int s, int d) {
		
		int z=0;
		int number=0;			
		while(!(z==(size))) {
			lev.set(z, 0);  // set values 0		
			z++;
		}
			
			//check does source already accessible
			while(accessible(s,d)>0 || accessible(s,d)==0) {				
				
				for(int i=0;i<size;i++) {
					list.set(i, 0);  
				}
				
				int adding;
				while(((adding=giftflow(s,d,Integer.MAX_VALUE))>0)) {					
					
									
					number=number+adding;
				}
				
			}			
			return number;			
		}
	 
	 // add edge between vehicle to t
		void addEdgetot(Vector<Integer> tg, Vector<Integer> tr, Vector<Integer> rg, Vector<Integer> rr, Vector<String> bags ) {
			
			int totaledge= (bags.size()/2) + rr.size() + rg.size() + tr.size() +tg.size() +1;  // totaledge 16 oldu
			//tg icin
			int val1=0;
			for(int t=bags.size()/2+1; t<bags.size()/2 + tg.size() +1;t++) {
				addedge(t,totaledge,tg.get(val1));
				val1++;
			}
			
			//tr
			int val2=0;
			for(int u=bags.size()/2 + tg.size()+1 ; u< totaledge-rg.size()-rr.size();u++) {
				addedge(u,totaledge, tr.get(val2));
				val2++;
			}
			
			//rg
			int val3=0;
			for(int v=totaledge-rr.size()-rg.size();v<totaledge-rr.size();v++) {
				addedge(v,totaledge, rg.get(val3));
				val3++;
			}
			
			//rr
			int val4=0;
			for(int y=totaledge-rr.size();y<totaledge;y++) {
				addedge(y,totaledge,rr.get(val4));
				val4++;
			}
		}
		
		
	 
	 int giftflow(int s,int d,int back) {
		
			if(s==d) {
				return back;
			}
			
			while(list.get(s)<nodelist[s].size()) {
				
				Edge edge1=nodelist[s].get(list.get(s));
				
				if(edge1.backward<edge1.capacity) {
					if(lev.get(edge1.destination).equals(lev.get(s)+1)) {
						int aflow;
						int calc=min(edge1.capacity-edge1.backward,back);
						aflow=giftflow(edge1.destination ,d ,calc);
						if(aflow>0) {
							
							edge1.backward=edge1.backward+aflow;
							nodelist[edge1.destination].get(edge1.reverseindex).backward=nodelist[edge1.destination].get(edge1.reverseindex).backward-aflow;
							return aflow;
						}
					}
				}  
				
				list.set(s, list.get(s)+1);
			}
			
			
			return 0;
		}
	 
	 
	 
	 void addedge(int s,int d,int c) {
		 int nodelist_size=nodelist[d].size();
		 
		 
		Edge new1=new Edge(d,c,nodelist_size);
		nodelist[s].add(new1);		
		int nodelist_size2=nodelist[s].size()-1;  // decrease size 1 because just now we add a new edge
		Edge new2=new Edge(s,0,nodelist_size2);  // reverse edge
		nodelist[d].add(new2);
	
		
	}
	 
	 
	
	int accessible(int s,int d) {
	
		for(int r=0;r<size;r++) {
			lev.set(r, -1);
		}
		
		// it is important to save levels of nodes, we use it in dfs algoritm
		lev.set(s, 0); // in bfs we use it instead of a boolean visited list
		
		for(int k=0;k<size;k++) {
			queue.set(k, 0);
		}
		
		queue.set(0, s);
				
		int j=1; // start from the queue's second element
		int i=0;
		
		while(!(i==(j))) {  
			
			int a=queue.get(i);			
			for(int b=0;b<nodelist[a].size();b++) {				
				if( nodelist[a].get(b).backward<nodelist[a].get(b).capacity ) {  //is capacity enough for flow
					if(lev.get(nodelist[a].get(b).destination) < 0 ) { //if destination is not visited
					
					lev.set(nodelist[a].get(b).destination, lev.get(a)+1); // increase level of next vertex, so we can check last element
					queue.set(j, nodelist[a].get(b).destination);   //like enqueue queue if destination is not visited
					j++; // in future make operation on next element
					}
				}
			}
			i++;
		}
		return lev.get(d);
	}
	
}
