package org.vamdc.validator.cli;

import java.io.File;
import java.io.IOException;

import org.vamdc.validator.Settings;
import org.vamdc.validator.interfaces.XSAMSIOModel;
import org.vamdc.validator.interfaces.XSAMSSourceException;
import org.vamdc.validator.interfaces.XSAMSValidatorException;
import org.vamdc.validator.iocontroller.XSAMSDocument;

/**
 * Command-line interface process.
 * In command-line mode Java TAP-VAMDC plugin testing is not supported(yet)
 * @author doronin
 *
 */
public class CLIProcess {

	public final int STATUS_ERROR=1;
	public final int STATUS_PROCESSED=0;
	public final int STATUS_DONE_NOTHING=-1;

	private int status=STATUS_DONE_NOTHING;


	public CLIProcess(OptionsParser parser){
		//Check if we are asked to print usage?
		if ( Boolean.TRUE.equals(parser.getOptionValue(parser.printUsage))) {
			parser.printUsage();
			System.exit(0);
		}

		//If we have output path defined, work in CLI mode
		String outputPath = (String)parser.getOptionValue(parser.outputPath);
		if (outputPath!=null){
			File outputFile = new File(outputPath);
			if (outputFile.isDirectory() && outputFile.canWrite()){
				String query = null;
				
				//Forse network mode
				Settings.override(Settings.OperationMode, Settings.OperationModes.network);
				//Set status
				status = STATUS_PROCESSED;
				
				XSAMSIOModel doc = new XSAMSDocument();
				int counter = 0;
				try{
					//For each query do it, validate output and save both document and errors in output path.
					while ((query=(String)parser.getOptionValue(parser.queryString))!=null){

						System.out.println(query);
						try{
							doc.doQuery(query);
						}catch(XSAMSSourceException e){
							e.printStackTrace();
						} catch (XSAMSValidatorException e) {
							e.printStackTrace();
						}

						saveOutput(doc,outputFile, counter++);
					}
				}catch(IOException e){
					e.printStackTrace();
					status++;
				}finally{
					doc.close();
				}
			}else{
				status = STATUS_ERROR;
			}

		}
	}

	public int getStatus(){
		return status;
	}

	/**
	 * Save output file and report file to specified output folder
	 * @param doc XSAMS validator model
	 * @param basePath base path for files
	 * @param index index of query in a list
	 */
	private void saveOutput(XSAMSIOModel doc, File basePath, int index) throws IOException{
		//Check if base is a directory
		if (!basePath.isDirectory())
			throw new IOException("basePath is not a directory");

		//Save XSAMS document
		File xsamsDocument = new File(basePath.getAbsolutePath()+File.separator+"xsams"+index+".xml");
		if (!xsamsDocument.exists()){
			System.out.print("Writing "+xsamsDocument.getAbsolutePath()+" ...");
			doc.saveFile(xsamsDocument);
			System.out.println("Done");
		}
		else
			throw new IOException("File"+xsamsDocument.getAbsolutePath()+" already exists!");

		//Save status
		File statusFile = new File(basePath.getAbsolutePath()+File.separator+"report"+index+".xml");
		if (!statusFile.exists()){
			System.out.print("Writing "+statusFile.getAbsolutePath()+" ...");
			new XMLReport(doc,statusFile,xsamsDocument.getName()).write();
			System.out.println("Done ");
		}
		else
			throw new IOException("File"+statusFile.getAbsolutePath()+" already exists!");

	}

}