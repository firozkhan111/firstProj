package DemoProj;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Scale_100GB {
	public static void main(String[] args) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		PrintWriter out = null;
		try {
			fw = new FileWriter("/home/nt/Desktop/100GB.txt", true);
			bw = new BufferedWriter(fw);
			out = new PrintWriter(bw);
			for (int i = 0; i < 2100; i++) {
				if (i < 2099) {
					out.append("col_" + i + ",");
				} else {
					out.append("col_" + i);
				}
			}
			out.append("\n");

			for(long i=0;i<339999998;i++) {
				for(int j=0;j<2100;j++) {
					if (j < 2099) {
						out.append(j + ",");
					} else {
						int k = (int)(i%2);
						out.append(k+"");
					}
				}
				out.append("\n");
			}
			out.close();
		} catch (IOException e) {
			// exception handling left as an exercise for the reader
		}
	}
}
