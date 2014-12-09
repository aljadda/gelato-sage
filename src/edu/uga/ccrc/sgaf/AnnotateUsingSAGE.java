package edu.uga.ccrc.sgaf;

import java.util.Scanner;

import edu.uga.cs.ms.pgmhd.prediction.MultiLabelClassifierWithPrecursorCheck;
import edu.uga.cs.pgmhd.ms.data.Fragment;
import edu.uga.cs.pgmhd.om.NewGraph;
import edu.uga.cs.pgmhd.xml.handler.Deserialize;

public class AnnotateUsingSAGE {
	private static NewGraph<Fragment> graph = new NewGraph<Fragment>();
	public static void annotateUsingSAGE(){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the name of SAGE:");
		String sageName = scan.nextLine();
		System.out.print("Enter the full path of the mzXML file to annotate:");
		String mzXMLFile = scan.nextLine();
		System.out.print("Enter the output folder name:");
		String output = scan.nextLine();
		Deserialize<Fragment> dser = new Deserialize<Fragment>();
		//graph = dser.deserialize("./sage/"+sageName+".xml");
		MultiLabelClassifierWithPrecursorCheck predictor = new MultiLabelClassifierWithPrecursorCheck("./sageAnnotations/"+output);
		predictor.annotateMsExperiment(mzXMLFile, "./sage/"+sageName+".xml");
	}

}
