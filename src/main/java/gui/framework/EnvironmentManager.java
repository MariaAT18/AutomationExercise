package gui.framework;

import utils.LoggerManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EnvironmentManager {
    private Properties properties;
    private static final LoggerManager log = LoggerManager.getInstance();
    private static final String envFilePath = System.getProperty("user.dir") + File.separator + "environments.properties";
    private static EnvironmentManager instance;
    private String envId;

    private EnvironmentManager() {
        initialize();
    }

    private void initialize() {
        log.info("Reading credentials");

        String environmentId = System.getProperty("envId");
        if ((environmentId == null) || (environmentId.isEmpty())) {
            envId = "automation";
        } else {
            envId = environmentId.toLowerCase();
        }
        log.info("Automation Environment Id --> " + envId);
        properties = new Properties();
        Properties envProperties = new Properties();
        try {
            envProperties.load(new FileInputStream(envFilePath));
        } catch (IOException e) {
            log.error("unable to load properties file");
        }
        properties.putAll(envProperties);
    }

    public static EnvironmentManager getInstance() {
        if (instance == null || instance.properties == null) {
            instance = new EnvironmentManager();
        }
        return instance;
    }

    private String getEnvironmentSetting(String setting) {
        return (String) properties.get(setting);
    }

    public String getEnvId() {
        return envId;
    }

    public String getBaseURL() {
        return getEnvironmentSetting(getEnvId() + ".baseURL");
    }

    public String getUsername(String user) {
        return getEnvironmentSetting(getEnvId() + "." + user + ".username");
    }

    public String getEmail(String user) {
        return getEnvironmentSetting(getEnvId() + "." + user + ".email");
    }

    public String getPassword(String user) {
        return getEnvironmentSetting(getEnvId() + "." + user + ".password");
    }
}
