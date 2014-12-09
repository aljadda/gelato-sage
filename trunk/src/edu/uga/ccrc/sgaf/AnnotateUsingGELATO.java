package edu.uga.ccrc.sgaf;

import java.util.HashMap;
import java.util.Scanner;








import java.util.TreeMap;

import edu.uga.ccrc.sgaf.factory.AdductFactory;
import edu.uga.ccrc.sgaf.factory.AnalyteSettingsFactory;
import edu.uga.ccrc.simiantools.ms.annotation.input.MzXmlReader;
import edu.uga.ccrc.simiantools.ms.annotation.structure.GlycanStructureAnnotationGlycanBased;
import edu.uga.ccrc.simiantools.ms.om.data.Data;
import edu.uga.ccrc.simiantools.ms.om.data.DataHeader;
import edu.uga.ccrc.simiantools.ms.om.data.GlycanFilter;
import edu.uga.ccrc.simiantools.ms.om.data.Method;
import edu.uga.ccrc.simiantools.ms.om.data.Scan;

public class AnnotateUsingGELATO {
	
	public static void annotateUsingGELATO(){
		try{
		Data data = new Data();
		DataHeader dHeader = new DataHeader();
		GlycanFilter filter = new GlycanFilter();
		data.setDataHeader(dHeader);
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the full path of the mzXML file");
		String mzXMLFile = scan.nextLine();
		HashMap<Integer, Scan> scans = null;
		MzXmlReader reader = new MzXmlReader();
		scans = new HashMap(reader.readMzXmlFile(mzXMLFile,0.0,"percentage",Method.MS_TYPE_INFUSION));
		data.getDataHeader().setMethod(createMethod());
		data.setScans(scans);
		filter.setDatabase("./databases/All-Glycan");
		System.out.println("Enter the name of the output file");
		String outputFile = scan.nextLine();
		GlycanStructureAnnotationGlycanBased annotate = new GlycanStructureAnnotationGlycanBased(data,filter,"./tmpAnn/","./gelato/"+outputFile,true,null);
		annotate.annotateGlycanStructure(null);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	private static Method createMethod(){
		try{
		Scanner scan = new Scanner(System.in);
		Method method = new Method();
		System.out.println("Would you like to use Ppm as accuracy unit yes/no?");
		String isPpm = scan.nextLine();
		if(isPpm.trim().toLowerCase().equals("yes")){
			method.setAccuracyPpm(true);
			method.setFragAccuracyPpm(true);
		}else{
			method.setAccuracyPpm(false);
			method.setFragAccuracyPpm(false);
		}
		System.out.println("Enter the tolerance for MS1: ");
		String tolerance = scan.nextLine();
        method.setAccuracy(Double.parseDouble(tolerance));
        System.out.println("Enter the tolerance for MSn: ");
		String toleranceMsn = scan.nextLine();
        method.setFragAccuracy(Double.parseDouble(toleranceMsn));
        System.out.println("Enter the maximum number of Ions: ");
		String maxFrag = scan.nextLine();
        method.setMaxIonCount(Integer.parseInt(maxFrag));
//        method.setIonExchanges(null);
//        method.setNeutralLoss(null);
        method.setMaxIonExchangeCount(0);
        method.setMonoisotopic(true);
        method.setShift(0.0);
        method.setAnnotationType(Method.ANNOTATION_TYPE_GLYCAN);
        method.setAnnotationSource(Method.ANNOTATION_SRC_SIMIAN);
        method.setAnalyteSettings(AnalyteSettingsFactory.createAnalyteSettings());
        method.setIons(AdductFactory.createAdducts());
        
        return method;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
//	public String getDefaultDatabasesPath() {
//		try {
//			String path = ResourceLocatorUtils.getLegalPathOfResource(this, "/databases");
//			return path;
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			e.printStackTrace();
//			return null;
//		}
//	}

}
