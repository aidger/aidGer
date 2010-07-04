package de.aidger.model;

import static de.aidger.utils.Translation._;

import java.io.File;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import de.aidger.utils.Configuration;
import de.aidger.utils.Logger;
import de.aidger.utils.Translation;
import de.aidger.view.UI;
import de.unistuttgart.iste.se.adohive.util.tuple.Pair;

/**
 * Initializes Configuration and Translation and relays the methods
 *
 * @author aidGer Team
 */
public final class Runtime {

    /**
     * Holds he only instance of the class.
     */
    private static Runtime instance = null;

    /**
     * The path the config is saved in.
     */
    private String configPath;

    /**
     * The configuration class handling the settings.
     */
    private Configuration configuration = null;

    /**
     * The class handling the translation of strings.
     */
    private Translation translation = null;

    /**
     * Is this the first start of aidGer?
     */
    private boolean firstStart = false;

    /**
     * Constructor must be private and does nothing.
     */
    private Runtime() {

    }

    /**
     * Provides access to an instance of this class.
     *
     * @return Instance of the Runtime class
     */
    public synchronized static Runtime getInstance() {
        if (instance == null) {
            instance = new Runtime();
        }

        return instance;
    }

    /**
     * Resolves the OS of the user and the file path to the aidGer settings.
     */
    public void initialize() {
        /* Get the path to the users home or config directory */
        String home = "";
        String os = System.getProperty("os.name").toLowerCase();
        if (os.indexOf("linux") > -1 || os.indexOf("mac") > -1) {
            /*
             * Try using the XDG_CONFIG_DIR variable first. Provides the
             * standard directory according to the desktop guidelines or a user
             * set equivalent
             */
            String confdir = System.getenv("XDG_CONFIG_HOME");
            if (confdir == null || confdir.isEmpty()) {
                /*
                 * Otherwise just use the homedir and the hidden config
                 * directory
                 */
                confdir = System.getProperty("user.home", ".");
                confdir += "/.config/";
            }
            home = confdir;
        } else if (os.indexOf("windows") > -1) {
            /*
             * Try using the APPDATA variable first. Should return the
             * ApplicationData folder but may fail on older Windows versions.
             */
            String confdir = System.getenv("APPDATA");
            if (confdir == null || confdir.isEmpty()) {
                /* Otherwise just use the homedir */
                confdir = System.getProperty("user.home", ".");
            }
            home = confdir;
        } else {
            home = System.getProperty("user.home", ".");
        }

        configPath = home + "/aidGer/";
        File file = new File(configPath);

        if (!file.exists() || !file.isDirectory()) {
            firstStart = true;
            if (!file.mkdirs()) {
                  UI.displayError(MessageFormat.format(
                        "Could not create directory \"{0}\".\n" +
                        "Please make sure that you have enough rights to create this directory.",
                        new Object[] { file.getPath() }));
                System.exit(-1);
            }
        }

        configuration = new Configuration();

        translation = new Translation(configuration.get("language"));

        /* Check if an instance of aidGer is already running */
        if (!Boolean.valueOf(getOption("debug")) && !checkLock()) {
            UI.displayError(_("Only one instance of aidGer can be run at a time."));
            System.exit(-1);
        }
    }

    /**
     * Get the path the config is saved in.
     *
     * @return The path of the config dir
     */
    public String getConfigPath() {
        return configPath;
    }

    /**
     * Set a custom config path (Only to be used in tests).
     *
     * @param path
     * 			  The new config path
     */
    public void setConfigPath(String path) {
    	configPath = path;
    }

    /**
     * Is this the first start of aidGer?
     *
     * @return True if this is the first start
     */
    public boolean isFirstStart() {
        return firstStart;
    }

    /**
     * Returns the location and name of the .jar file.
     *
     * @return The location
     */
    public String getJarLocation() {
        String location = getClass().getProtectionDomain().getCodeSource().
                getLocation().toString();
        int idx = location.indexOf(":");

        /* Windows uses file:/C:/folder whereas Unix uses file:/folder */
        if (idx != location.lastIndexOf(":")) {
            location = location.substring(idx + 2);
        } else {
            location = location.substring(idx + 1);
        }
        return location;
    }

    /**
     * Get the value of an option.
     *
     * @param option
     *            The option to get
     * @return The value of the specified option
     */
    public String getOption(String option) {
        return configuration.get(option);
    }

    /**
     * Get the value of an option or the default if the option doesn't exist
     *
     * @param option
     *            The option to get
     * @param def
     *            The default value
     * @return The value of the specified option or the default value
     */
    public String getOption(String option, String def) {
        String ret = configuration.get(option);
        if (ret == null) {
            configuration.set(option, def);
            return def;
        }
        return ret;
    }

    /**
     * Get an array of values for the specified option
     *
     * @param option
     *            The option to get
     * @return Array containing all values
     */
    public String[] getOptionArray(String option) {
        String str = getOption(option);

        if (str == null || (!str.startsWith("[") || !str.endsWith("]"))) {
            return null;
        }

        return str.substring(1, str.length() - 1).split(", ");
    }

    /**
     * Set the value of an option.
     *
     * @param option
     *            The option to set
     * @param value
     *            The value to set it to
     */
    public void setOption(String option, String value) {
        configuration.set(option, value);
    }

    /**
     * Sets the value of a property by converting an array into a single string.
     *
     * @param option
     *            The property to change
     * @param values
     *            Array of all values
     */
    public void setOptionArray(String option, String[] values) {
        setOption(option, java.util.Arrays.toString(values));
    }

    /**
     * Get a list of all languages installed on the system. The format is 0 =>
     * short, 1 => long language name.
     *
     * @return The list of all installed languages
     */
    public List<Pair<String, String>> getLanguages() {
        return translation.getLanguages();
    }

    /**
     * Check for a lock file or create it to only allow one running instance.
     *
     * @return True if no lock file exists and the application can be started
     */
    protected boolean checkLock() {
        File lock = new File(configPath + "/aidger.lock");
        if (lock.exists()) {
            return false;
        }

        try {
            lock.createNewFile();
            lock.deleteOnExit();
        } catch (IOException ex) {
            Logger.error(_("Couldn't create lockfile"));
        }

        return true;
    }

}
