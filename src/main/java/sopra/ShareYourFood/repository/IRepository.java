package sopra.ShareYourFood.repository;

public interface IRepository {

public interface IRepository<T, PK>  {

	public List<T> findAll();

	public T findById(PK id);

	public T save(T obj);

	public void delete(T obj);
	}

