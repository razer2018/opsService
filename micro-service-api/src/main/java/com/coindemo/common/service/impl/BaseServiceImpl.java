package com.coindemo.common.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import com.coindemo.common.dao.BaseDao;
import com.coindemo.common.model.BaseEntity;
import com.coindemo.common.model.Page;
import com.coindemo.common.query.Query;
import com.coindemo.common.service.BaseService;

/**
 * 基础Service服务接口实现类<br/>
 * 注意:主键为Long类型
 */
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {

	/**
	 * 获取基础数据库操作类
	 */
	protected abstract BaseDao<T, Long> getBaseDao();

	@Override
	public T queryOne(T query) {
		return getBaseDao().selectOne(query);
	}

	@Override
	public T queryById(Long id) {
		return getBaseDao().selectById(id);
	}

	@Override
	public List<T> queryList(T query) {
		return getBaseDao().selectList(query);
	}

	@Override
	public List<T> queryAll() {
		return getBaseDao().selectAll();
	}

	@Override
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey) {
		return getBaseDao().selectMap(query, mapKey);
	}

	@Override
	public Long queryCount() {
		return getBaseDao().selectCount();
	}

	@Override
	public Long queryCount(T query) {
		return getBaseDao().selectCount(query);
	}

	@Override
	@Transactional
	public Long insert(T entity) {
		return getBaseDao().insert(entity);
	}

	@Override
	@Transactional
	public int delete(T query) {
		return getBaseDao().delete(query);
	}

	@Override
	@Transactional
	public int deleteById(Long id) {
		return getBaseDao().deleteById(id);
	}

	@Override
	@Transactional
	public int deleteAll() {
		return getBaseDao().deleteAll();
	}

	@Override
	@Transactional
	public int updateById(T entity) {
		return getBaseDao().updateById(entity);
	}

	@Override
	@Transactional
	public int updateByIdSelective(T entity) {
		return getBaseDao().updateByIdSelective(entity);
	}

	@Override
	@Transactional
	public void deleteByIdInBatch(List<Long> idList) {
		getBaseDao().deleteByIdInBatch(idList);
	}

	@Override
	@Transactional
	public void insertInBatch(List<T> entityList) {
		getBaseDao().insertInBatch(entityList);
	}

	@Override
	@Transactional
	public void updateInBatch(List<T> entityList) {
		getBaseDao().updateInBatch(entityList);
	}

	@Override
	public List<T> queryList(T query, Pageable pageable) {
		return getBaseDao().selectList(query, pageable);
	}

	@Override
	public Page<T> queryPageList(T query, Pageable pageable) {
		return getBaseDao().selectPageList(query, pageable);
	}

	@Override
	public <K, V extends T> Map<K, V> queryMap(T query, String mapKey, Pageable pageable) {
		return getBaseDao().selectMap(query, mapKey, pageable);
	}

	@Override
	public Page<T> queryPageList(Query query) {
		return getBaseDao().selectPageList(query);
	}
}
