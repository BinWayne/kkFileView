package org.artofsolving.jodconverter.util;


import java.io.File;

/**
 * @author : kl
 **/
public class ConfigUtils {

    private static final String MAIN_DIRECTORY_NAME = "server";
    private static final String OFFICE_PLUGIN_NAME = "office-plugin";
    private static final String CLASSES = "classes";

    public static String getHomePath() {
        String userDir = System.getenv("KKFILEVIEW_BIN_FOLDER");
        if (userDir == null) {
            userDir = System.getProperty("usr.dir");
        }
        if (userDir.endsWith("bin")) {
            userDir = userDir.substring(0, userDir.length() - 4);
        } else {
            String separator = File.separator;
             if(userDir.endsWith(CLASSES)){
                return userDir;
            }
            else if (userDir.contains(MAIN_DIRECTORY_NAME)) {
                userDir = userDir + separator + "src" + separator +  "main";
            }
        }
        return userDir;
    }


    public static String getOfficePluginPath() {
        String userDir = System.getenv("KKFILEVIEW_BIN_FOLDER");
        if (userDir == null) {
            userDir = System.getProperty("user.dir");
        }
        if (userDir.endsWith("bin")) {
            userDir = userDir.substring(0, userDir.length() - 4);
        } else {
            String separator = File.separator;
            if (!userDir.contains(OFFICE_PLUGIN_NAME)) {
                userDir = userDir + separator + OFFICE_PLUGIN_NAME;
            }
        }
        return userDir;
    }

    public static String getCustomizedConfigPath() {
        String homePath = getHomePath();
        String separator = java.io.File.separator;
        if(homePath.endsWith("classes")){
            return homePath + separator + "application.properties";
        }
        return homePath + separator + "config" + separator + "application.properties";
    }
}
