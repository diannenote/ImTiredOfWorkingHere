import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;

public class PDFMerge {
	public static void main(String[] args) throws IOException {
		 File file1 = new File(
		            "C:/Program Files (x86)/Apache Software Foundation/Tomcat 8.5/webapps/oz80/WEB-INF/ozsch80/Repository/pdf/paramTest1.pdf");
		 File file2 = new File(
		            "C:/Program Files (x86)/Apache Software Foundation/Tomcat 8.5/webapps/oz80/WEB-INF/ozsch80/Repository/pdf/paramTest2.pdf");
		        
		 PDFMergerUtility obj = new PDFMergerUtility();
		 	obj.setDestinationFileName(
		            "C:/Program Files (x86)/Apache Software Foundation/Tomcat 8.5/webapps/oz80/WEB-INF/ozsch80/Repository/pdf/newMerged.pdf");
		    obj.addSource(file1);
		    obj.addSource(file2);
		  
		        obj.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());
		  
		        System.out.println(
		            "PDF Documents merged to a single file");
	}
		
}
