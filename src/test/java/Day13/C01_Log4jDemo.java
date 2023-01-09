package Day13;


import org.apache.log4j.PropertyConfigurator;

import org.apache.log4j.Logger;

public class C01_Log4jDemo {
    public static void main(String[] args) {

        PropertyConfigurator.configure("log4j.properties");
        Logger Log4j = Logger.getLogger(C01_Log4jDemo.class.getName());


        Log4j.trace("Traje mesaji");
        Log4j.debug("debug mesaji");
        Log4j.info("info mesaji");
        Log4j.warn("warn mesaji");
        Log4j.error("error mesaji");
        Log4j.fatal("Fatal mesaji");

        // kaydattigi dosyaya solda ideanın altinda .logs klasorunun icinde txt kaydediliyor
    }
}
