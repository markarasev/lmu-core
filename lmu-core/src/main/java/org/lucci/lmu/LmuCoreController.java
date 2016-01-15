package org.lucci.lmu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.lucci.lmu.input.JarFileAnalyser;
import org.lucci.lmu.input.PackageAnalyzer;
import org.lucci.lmu.model.IModel;
import org.lucci.lmu.output.ModelExporter;
import org.lucci.lmu.output.ModelExporterImpl;

import java.util.List;
import java.util.jar.JarFile;

/**
 * @author Benjamin Benni, Marc Karassev
 * 
 * This class is an implementation of the app's API.
 */
public class LmuCoreController implements LmuCore {

    // Constants

    private static final Logger LOGGER = LogManager.getLogger();
	
	// Attributes
	
	private ModelExporter modelExporter = new ModelExporterImpl();
			
	// Methods

	@Override
	public void analyzePaths(List<String> paths, String outputPath, String outputFormat) {
		JarFile jarFile = null; // TODO
        String jarPath = ""; // TODO

        analyzeJar(jarPath, outputPath, outputFormat);
	}

	@Override
	public void analyzeJar(String jarPath, String outputPath, String outputFormat) {
        try {
            IModel model = new JarFileAnalyser().createModel(jarPath);

            modelExporter.exportToFile(model, outputPath, outputFormat);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
}
