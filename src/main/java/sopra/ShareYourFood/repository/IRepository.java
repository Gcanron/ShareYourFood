package sopra.ShareYourFood.repository;

import java.util.List;

public class IRepository<T, PK>  {

	List<T> findAll();

	T findById(PK id);

	T save(T obj);

	void delete(T obj);
}
