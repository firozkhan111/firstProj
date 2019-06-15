package DemoProj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegData {

	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter("/home/nt/Desktop/RegData.csv", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			for (int i = 0; i < 10; i++) {
				if (i < 9) {
					out.append("col_" + i + ",");
				} else {
					out.append("col_" + i);
				}
			}
			out.append("\n");

			for(long i=0;i<5;i++) {
				for(int j=0;j<10;j++) {
					if (j <9) {
						out.append(j + ",");
					} else {
						int k = (int)(i%2);
						out.append(k+"");
						//j++;
					}
				}
				out.append("\n");
				i++;
			}
			out.close();
		} catch (IOException e) {
			
		}

	}

}
