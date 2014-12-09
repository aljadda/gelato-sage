package edu.uga.ccrc.sgaf;

import java.io.File;
import java.util.List;
import java.util.Scanner;

import edu.uga.ccrc.simiantools.ms.om.data.Data;
import edu.uga.ccrc.simiantools.ms.om.data.GlycanScansAnnotation;
import edu.uga.cs.pgmhd.ms.data.Fragment;
import edu.uga.cs.pgmhd.ms.learning.FileHandler;
import edu.uga.cs.pgmhd.ms.learning.NewGraphLearner;
import edu.uga.cs.pgmhd.ms.preprocessing.PeakPicker;
import edu.uga.cs.pgmhd.om.NewGraph;
import edu.uga.cs.pgmhd.xml.handler.Deserialize;

public class TrainExistingSAGE {
	private static NewGraph<Fragment> graph = new NewGraph<Fragment>();
	public static void trainExistingSAGE(){
		Scanner scan = new Scanner(System.in);
		NewGraphLearner learner = new NewGraphLearner(graph);
		System.out.print("Enter the name of SAGE:");
		String sageName = scan.nextLine();
		System.out.print("Now retrieving SAGE..");
		Deserialize<Fragment> dser = new Deserialize<Fragment>();
		graph = dser.deserialize("./sage/"+sageName+".xml");
		System.out.print("Enter dataset name");
		String datasetName = scan.nextLine();;
		System.out.print("Enter the file names for GELATO training files (comma separated)");
		String input = scan.nextLine();
		String[] gelatoFiles = input.split(",");
		FileHandler handler = new FileHandler();
		System.out.print("Please wait, this may take several minutes");
		for(String zipFileName : gelatoFiles){
				File folder = new File("./"+datasetName+"/gog/"+zipFileName+"/");
				folder.mkdir();
				handler.generateXMLFiles("./gelato/"+zipFileName+".zip","./"+datasetName+"/gog/"+zipFileName+"/");
				Data data = handler.deSerializeDataObject("./gelato/"+zipFileName+".zip");
				PeakPicker pick = new PeakPicker(data);
				pick.pickPeaks();
				List<String> fileNames = handler.readFileNames("./"+datasetName+"/gog/"+zipFileName+"/");
				for(String fileName : fileNames){
					GlycanScansAnnotation gsa = handler.deSerialize("./"+datasetName+"/gog/"+zipFileName+"/",fileName);
					learner.learnTheStructure(gsa,data);
				}
		}
		System.out.println("Done. Sage has been trained using dataset : " + datasetName);
	
		
		
		
	}

}
