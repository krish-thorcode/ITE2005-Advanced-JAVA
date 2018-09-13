import java.util.*;
class Genome{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the genome string:");
		String genome = in.nextLine();
		String start = "ATG";
		String end1 = "TAG";
		String end2 = "TAA";
		String end3 = "TGA";
		int flag = 0;
		char[] valid = genome.toCharArray();
		for(int i=0;i<valid.length;i++){
			switch(valid[i]){
				case 'A':
				case 'C':
				case 'G':
				case 'T':
					break;
				default:
					flag = 1;
					break;
			}
			if(flag == 1){
				System.out.println("Invalid Input");
				break;
			}
		}
		int i = 0;
		int j;
		System.out.println("Genes in " + genome + ": ");
		while(i<genome.length()){
			int a = genome.indexOf(start,i);
			if(a==-1)
				break;
			int b = genome.indexOf(end1,a+3);
			int c = genome.indexOf(end2,a+3);
			int d = genome.indexOf(end3,a+3);
			if(b==-1){
				b = genome.length() + 30;
			}
			if(c==-1){
				c = genome.length() + 30;
			}
			if(d==-1){
				d = genome.length() + 30;
			}
			if(b<c && b<d){
				j = b;
			}
			else if(c<b && c<d){
				j = c;
			}
			else{
				j = d;
			}
			if(b>genome.length() && d>genome.length() && c>genome.length())
				break;
			String gene = genome.substring(a+3,j);
			if(gene.length()%3 == 0){
				if(!gene.equals(start))
					System.out.println(gene);
			}
			i = a+1;
			//System.out.println(i);
		}
	}
}
