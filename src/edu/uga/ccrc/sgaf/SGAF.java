package edu.uga.ccrc.sgaf;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.util.Scanner;

import edu.uga.ccrc.sgaf.Menu;

public class SGAF {
	
	public static void main(String[] args){
		//create the necessary files
		File f = new File("./gelato");
		if (!f.exists()) {
		   f.mkdir();
		}
		
		File f1 = new File("./sageAnnotations");
		if (!f1.exists()) {
		   f1.mkdir();
		}
		
		File f2 = new File("./sage");
		if (!f2.exists()) {
		   f2.mkdir();
		}
		
		File f3 = new File("./tmpAnn");
		if (!f3.exists()) {
		   f3.mkdir();
		}
		
		while(true){
			
			for(Menu m : Menu.values()){
				System.out.println(m.getMenuText());
				
			}
			System.out.println("Please enter the number of your choice:");
			Scanner scanIn = new Scanner(System.in);
			String input = scanIn.nextLine();
			//String input = System.console().readLine("Please enter the number of your choice:");
			switch(input){
			case("1"):
				AnnotateUsingGELATO.annotateUsingGELATO();
			break;
			case("2"):
				TrainNewSAGE.trainNewSage();
			break;
			case("3"):
				TrainExistingSAGE.trainExistingSAGE();
			break;
			case("4"):
				AnnotateUsingSAGE.annotateUsingSAGE();
			break;
			case("5"):
				FilterUsingSAGE.filterUsingSAGE();
			break;
			default:
				System.out.println("Thanks for using SAGE/GELATO Integrated Annotation Framework..");
				System.exit(0);
			}
			
		}
	}

}
