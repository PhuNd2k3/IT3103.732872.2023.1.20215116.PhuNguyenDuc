package hust.soict.headspi.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) throws IOException {
        // Nguyen Duc Phu 20215116: Code session 9
		String filename = "D:\\Ki_1_nam_3\\OOP\\IT3103.732872.2023.1.20215116.PhuNguyenDuc"
				+ "\\lab03OtherProject\\src\\hust\\soict\\headspi\\garbage\\test.txt";
		byte[] inputString = { 0 };
		long startTime, endTime;

		inputString = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		StringBuilder garbage = new StringBuilder();
		for (byte b : inputString) {
			garbage.append((char) b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
        // Nguyen Duc Phu 20215116: print around 4
	}
}
