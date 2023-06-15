package services;

import java.util.List;

import dao.GenericDAO;

public class GenericServiceImpl<T> implements GenericService<T> {
	private GenericDAO<T> dao;

	public GenericServiceImpl(GenericDAO<T> dao) {
		this.dao = dao;
	}

	@Override
	public T getById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<T> getAll() {
		return dao.findAll();
	}

	@Override
	public void save(T entity) {
		dao.save(entity);
	}

	@Override
	public void update(T entity) {
		dao.update(entity);
	}

	@Override
	public void delete(T entity) {
		dao.delete(entity);
	}
}