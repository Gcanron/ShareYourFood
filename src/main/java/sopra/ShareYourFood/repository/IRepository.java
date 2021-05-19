package sopra.ShareYourFood.repository;

import java.util.List;

public interface IRepository<T, PK>  {

	public List<T> findAll();

	public T findById(PK id);

	public T save(T obj);

	public void delete(T obj);
	}

