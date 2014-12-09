package edu.uga.ccrc.sgaf.factory;

import java.util.ArrayList;
import java.util.List;

import edu.uga.ccrc.simiantools.ms.om.data.IonSettings;

public class IonExchangeFactory {
	
	public static List<IonSettings> createIonExchange(){
		List<IonSettings> ionExchanges = new ArrayList();
		IonSettings exchange = new IonSettings();
		
		exchange.setCharge(1);
        exchange.getCounts().add(1);
        exchange.setMass(22.98);
        exchange.setName("myExchange");
        exchange.setLabel("exchange");
        
        ionExchanges.add(exchange);
        
        return ionExchanges;
        
        
	}

}
