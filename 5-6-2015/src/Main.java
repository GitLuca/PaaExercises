import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		String file = "fileNew.txt";
		Scanner in = new Scanner(new FileReader(file));
		int size = in.nextInt();
		MinPath[] list = new MinPath[size];
		int step=1;
		int[][] mat = new int[size][size];
		for (int i=0;i<size; ++i) {
			for(int j=0; j<size; ++j) {
				mat[i][j] = in.nextInt();
				//System.out.printf(" %d",mat[i][j]);
			}
			//System.out.print("\n");
		}
		int[][] mat1 = new int[size][size];
		for (int i=0;i<size-1; ++i) {
			for(int j=step; j<size; ++j) {
				mat1[i][j] = mat[i][j];
				//System.out.printf(" %d",mat1[i][j]);			
			}
			list[i] = readPath(mat1[i], i, size);
			//System.out.print("\n");
			step++;
		}
		for(int k =0; k<size-1; ++k) {
			System.out.printf("%d %d %d\n", list[k].getStart(), list[k].getEnd(), list[k].getCost());
		}
		in.close();
	}
	
	public static MinPath readPath(int[] line, int index, int size) {
		MinPath path = new MinPath();
		int cost=0;
		int end =0;
		path.setStart(index+1);
		if(line.length == 1) {
			path.setEnd(size);
			path.setCost(line[0]);
			return path;
		}
		cost = 100;
		for(int i=0; i<line.length;++i ) {
			if(line[i]<cost && line[i]!=0) {
				cost = line[i];
				end = i+1;
			}
		}
		path.setEnd(end);
		path.setCost(cost);
		
		return path;
	}

}
