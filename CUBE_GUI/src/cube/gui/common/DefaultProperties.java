package cube.gui.common;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DefaultProperties {
	
	private static DefaultProperties defaultPropertiesInstance;
	private Properties prop;
	
	private DefaultProperties(){
		prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("etc/default.properties");

			// load a properties file
			prop.load(input);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static DefaultProperties getDefaultProperties(){
		if(defaultPropertiesInstance != null){
			return defaultPropertiesInstance;
		}else{
			return new DefaultProperties();
		}
	}
	
	public Properties getProperties(){
		return this.prop;
	}

}