package edu.uga.ccrc.sgaf.factory;

import java.util.ArrayList;
import java.util.List;

import edu.uga.ccrc.simiantools.ms.om.data.MoleculeSettings;

public class NeutralLossFactory {
	
	public static List<MoleculeSettings> createNeutralLoss(){
		List<MoleculeSettings> losses = new ArrayList();
		MoleculeSettings  nutralLoss = new MoleculeSettings();
        nutralLoss.setCount(1);
        nutralLoss.setLabel("Test");
        nutralLoss.setMass(20.0);
        nutralLoss.setName("Tester");
		
        losses.add(nutralLoss);
        
        return losses;
	}

}
