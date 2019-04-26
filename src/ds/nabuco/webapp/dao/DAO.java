package ds.nabuco.webapp.dao;

import ds.nabuco.webapp.model.Client;

public interface DAO<T> {

	public void save(T t);
	
	public Client getClient(T t);
}
