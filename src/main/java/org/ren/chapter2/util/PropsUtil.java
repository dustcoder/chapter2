package org.ren.chapter2.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropsUtil {

    private static  final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

    private static Properties loadProps(String fileName){
        Properties props = null;
        InputStream is = null;
        try {

            is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
            if(is == null){
                throw new FileNotFoundException(fileName + "file is not found");
            }
            props = new Properties();
            props.load(is);
        }catch (IOException e){
            LOGGER.error("load properties failure",e);
        }   finally {
            if(is != null){
                try {
                    is.close();
                }catch (IOException e){
                    LOGGER.error("close is failure",e);
                }
            }

        }
        return props;

    }


}
