# Introduction #

GELATO and SAGE are two modules to automate the MS annotation. The following instructions will guide you through the API of both tools.

## How to Annotate Using GELATO ##
# Create _Data_ object
'Data data = new Data();'
# Create _DataHeader_ object
'DataHeader dHeader = new DataHeader();'
# Create _GlycanFilter_ object
'GlycanFilter filter = new GlycanFilter();'
# Set the _DataHeader_ object
'data.setDataHeader(dHeader);'
# Create _HashMap_ to store the MS scans
'HashMap<Integer, Scan> scans = null;'
# Create _MzXMLReader_ object to read the input mzXML file
'MzXmlReader reader = new MzXmlReader();'
# Extract the scans from mzXML file into the scans _HashMap_
'scans = new HashMap(reader.readMzXmlFile($mzXMLFilePath,$Intensity\_CutOff,$CutOff\_Type,$MS\_Type));' For example, 'reader.readMzXmlFile("/home/mzXMLFiles/myMzXMLFile","percentage",Method.MS\_TYPE\_INFUSION)'
The 0.0 means no cutoff based upon intensity is required
# Create _Method_ object as described in section _How To Create Method Object_
# Set the created _Method_ object in the _DataHeader_ object
'data.getDataHeader().setMethod(createMethod());'
# Set the scans into the _Data_ object
'data.setScans(scans);'
# Choose the _Glycan Database_ to be used in the annotation
'filter.setDatabase("./$databasesFolder/$databaseName");'
We provide the following curated databases:
**All-Glycan: This database includes all glycan structures from the Glycan Ontology (GlycO).** GSL-Glycan: This database contains only Glycosphingolipid glycan structures.
**N-Glycan: This database contains only N-Glycan structures.** O-Glycan: This database contains only O-Glycan structures.
# Initialize the annotation process
'GlycanStructureAnnotationGlycanBased annotate = new GlycanStructureAnnotationGlycanBased(_Data_,_GlycanFilter_,_tmpFolder_,_Output Path_,true,null);'
# Run the annotation process.
annotate.annotateGlycanStructure(null);

the full code is in class "AnnotateUsingGELATO".