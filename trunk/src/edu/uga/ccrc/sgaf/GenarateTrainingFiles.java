package edu.uga.ccrc.sgaf;

import java.io.File;

import edu.uga.cs.pgmhd.ms.learning.FileHandler;

public class GenarateTrainingFiles {
	
	public static void generateTrainingFiles(){
		System.out.print("Enter dataset name");
		String datasetName = System.console().readLine();
		System.out.print("Enter the file names for GELATO training files (comma separated)");
		String input = System.console().readLine();
		String[] gelatoFiles = input.split(",");
		FileHandler handler = new FileHandler();
		System.out.print("Please wait, this may take several minutes");
		for(String zipFileName : gelatoFiles){
				File folder = new File("./datasetName/gog/"+zipFileName+"/");
				folder.mkdir();
				handler.generateXMLFiles("./annotations/zip/"+zipFileName+".zip","./annotations/gog/"+zipFileName+"/");
		}
		System.out.println("Done. The training files are ready to train SAGE. The generated dataset name is: " + datasetName);
	}

}
