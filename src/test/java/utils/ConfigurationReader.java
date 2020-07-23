package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;

    static{
        try(FileInputStream inputStream=new FileInputStream("src/test/resources/application.properties")){
            properties=new Properties();
            properties.load(inputStream);
        } catch (IOException e){
            throw new RuntimeException("ConfigurationReader couldn't load the properties: /n"+e);
        }
    }
    public static String getProperty(String key){
        return properties.getProperty(key);
    }

}
