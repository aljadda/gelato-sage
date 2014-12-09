package edu.uga.ccrc.sgaf.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.uga.ccrc.simiantools.ms.om.data.IonSettings;

public class AdductFactory {
	
	public static List<IonSettings> createAdducts(){
		List<IonSettings> adducts = new ArrayList();
		IonSettings sod = new IonSettings();
		IonSettings prot = new IonSettings();
		IonSettings hIon = new IonSettings();
		List<Integer> counts = new ArrayList();
		Scanner scan = new Scanner(System.in);
		System.out.println("Would you like to use \'Na\' as your adduct yes/no?");
		String selection = scan.nextLine();
		if(selection.trim().toLowerCase().equals("yes")){
			System.out.println("maximim \'Na\' charge?");
			String maxCharge = scan.nextLine();
			sod.setCharge(1);
			sod.setLabel("Na");
			sod.setMass(22.98);
			sod.setName("Na");
			if(sod.getCounts().size()>0)
				sod.getCounts().remove(0);
			sod.getCounts().add(Integer.parseInt(maxCharge));
			adducts.add(sod);
		}
		
		System.out.println("Would you like to use \'Li\' as your adduct yes/no?");
		selection = scan.nextLine();
		if(selection.trim().toLowerCase().equals("yes")){
			System.out.println("maximim \'Li\' charge?");
			String maxCharge = scan.nextLine();
			prot.setCharge(1);
			prot.setLabel("Li");
			prot.setMass(6.94);
			prot.setName("Li");
			if(prot.getCounts().size()>0)
				prot.getCounts().remove(0);
			prot.getCounts().add(Integer.parseInt(maxCharge));
			adducts.add(prot);
		}
		
		System.out.println("Would you like to use \'H\' as your adduct yes/no?");
		selection = scan.nextLine();
		if(selection.trim().toLowerCase().equals("yes")){
			System.out.println("maximim \'H\' charge?");
			String maxCharge = scan.nextLine();
			hIon.setCharge(1);
			hIon.setLabel("H");
			hIon.setMass(1.0);
			hIon.setName("H");
			if(hIon.getCounts().size()>0)
				hIon.getCounts().remove(0);
			hIon.getCounts().add(Integer.parseInt(maxCharge));
			adducts.add(hIon);
		}

        return adducts;
		
	}
	

}
