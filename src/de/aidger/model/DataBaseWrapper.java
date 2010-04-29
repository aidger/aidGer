/**
 *
 */
package de.aidger.model;

import java.util.List;
import java.util.Vector;

/**
 * Wraps the AdoHive Database interface into a nicer API
 *
 * @author Philipp Gildein
 */
public final class DataBaseWrapper {

    /**
     * Holds the only instance of the class.
     */
    private static DataBaseWrapper instance = null;

    /**
     * Private constructor to only allow access through getInstance().
     */
    private DataBaseWrapper() {

    }

    /**
     * Provides access to an instance of this class.
     *
     * @return The only instance of the class
     */
    public static DataBaseWrapper getInstance() {
	if (instance == null) {
	    instance = new DataBaseWrapper();
	}

	return instance;
    }

    /**
     * Get all models of the specified type
     *
     * @param <T> The type of the model
     * @return A list containing all models or null
     */
    public <T extends AbstractModel> List<T> getAll() {
	return new Vector<T>();
    }

    /**
     * Get a specific model by specifying its unique id
     *
     * @param <T> The type of the model
     * @param id The unique id of the model
     * @return The model if one was found or null
     */
    public <T extends AbstractModel> T getById(int id) {
	return null;
    }

    /**
     * Get a specific model by specifying a set of keys
     *
     * @param <T> The type of the model
     * @param o The set of keys specific to this model
     * @return The model if one was found or null
     */
    public <T extends AbstractModel> T getByKeys(Object... o) {
	return null;
    }

    /**
     * Save the model to the database
     *
     * @param <T> The type of the model
     * @param model The model to save
     */
    public <T extends AbstractModel> void save(T model) {

    }

    /**
     * Remove the model from the database
     *
     * @param <T> The type of the model
     * @param model The model to remove
     */
    public <T extends AbstractModel> void remove(T model) {

    }
}
