package ds.webapp.dao;

import d.webapp.model.Client;

public interface DAO<T> {

	public void save(T t);
	
	public Client getClient(T t);
}
