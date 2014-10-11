package com.immunology.logic.dao;

import java.util.List;

public interface CrudDao {

	public <T> T create(T object);
	
	public <T> T find(Class<T> type, Object id);
	
	public <T> void delete(Class<T> type, Object id);
	
	public void delete(Object object);
	
	public <T> T saveOrUpdate(T object);
	
	public <T> List<T> getAll(Class<T> clazz);
}
