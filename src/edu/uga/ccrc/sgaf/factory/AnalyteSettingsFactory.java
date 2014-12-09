package edu.uga.ccrc.sgaf.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.uga.ccrc.simiantools.ms.om.data.AnalyteSettings;
import edu.uga.ccrc.simiantools.ms.om.data.GlycanSettings;

public class AnalyteSettingsFactory {
	
	public static List<AnalyteSettings> createAnalyteSettings(){
		Scanner scan = new Scanner(System.in);
		List<AnalyteSettings> analyteSettings = new ArrayList();
		AnalyteSettings analyte = new AnalyteSettings();
		GlycanSettings gSettings = new GlycanSettings();
		gSettings.setAllowInnerFragments(false);
        gSettings.setPerDerivatisationType(getPerDerivatisationType());
        System.out.println("Set the max number of cleaveges: ");
        String maxClvg = scan.nextLine(); 
        gSettings.setMaxNumOfCleavages(Integer.parseInt(maxClvg));
        System.out.println("Set the max number of Cross Ring cleaveges: ");
        String maxCRClvg = scan.nextLine(); 
        gSettings.setMaxNumOfCrossRingCleavages(Integer.parseInt(maxCRClvg));
        gSettings.setGlycanFragments(FragmentFactory.createFragments());
        gSettings.setReducingEnd(ReducingEndFactory.createReducingEnd());
        
        analyte.setGlycanSettings(gSettings);
        analyteSettings.add(analyte);
        return analyteSettings;
	}
	
	
	private static String getPerDerivatisationType(){
		System.out.println("Enter the number of your choice:");
		System.out.println("1- perMe");
		System.out.println("2- perDMe");
		System.out.println("3- perMe(C^13)");
		System.out.println("4- perAc");
		System.out.println("5- None");
		Scanner scan = new Scanner(System.in);
		String perD = scan.nextLine();
		String selection = "perMe";
		switch(perD){
		case("1"):
			selection = "perMe";
		break;
		case("2"):
			selection = "perDMe";
		break;
		case("3"):
			selection = "perMe(C^13)";
		break;
		case("4"):
			selection = "perAc";
		break;
		case("5"):
			selection = "None";
		break;
		default:
			selection = "perMe";
		}
		
		
		return selection;
	}

}
