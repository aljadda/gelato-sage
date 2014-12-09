package edu.uga.ccrc.sgaf;

import java.util.Scanner;

import edu.uga.cs.ms.pgmhd.prediction.AnnotationFilter;

public class FilterUsingSAGE {
	
	public static void filterUsingSAGE(){
		Scanner scan = new Scanner(System.in);
		AnnotationFilter filter = new AnnotationFilter();
		System.out.print("Enter the full path of your mzXML file:");
		String mzXMLFile = scan.nextLine();
		System.out.print("Enter the full path of the GELATO annotations file:");
		String gelatoFile = scan.nextLine();
		System.out.print("Enter the name of SAGE:");
		String sageFile = scan.nextLine();
		System.out.print("Enter maximum number of accepted annotations:");
		String maxAnn = scan.nextLine();
		int max = Integer.parseInt(maxAnn);
		filter.FilterGelatoAnnotation(mzXMLFile, gelatoFile, sageFile, max);
	}

}
