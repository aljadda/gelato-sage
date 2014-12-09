package edu.uga.ccrc.sgaf.factory;

import edu.uga.ccrc.simiantools.ms.om.data.AnalyteSettings;
import edu.uga.ccrc.simiantools.ms.om.data.Method;

public class MethodFactory {
	
	public static Method createMethod(){
		Method method = new Method();
        method.setAccuracy(0.5);
        method.setAccuracyPpm(false);
        method.setMaxIonCount(3);
        method.setMaxIonExchangeCount(0);
        method.setMonoisotopic(true);
        method.setShift(0.0);
        method.setAnnotationType(Method.ANNOTATION_TYPE_GLYCAN);
        method.setAnnotationSource(Method.ANNOTATION_SRC_SIMIAN);
        method.setAnalyteSettings(AnalyteSettingsFactory.createAnalyteSettings());
        method.setIons(AdductFactory.createAdducts());
        
        return method;
	}

}
