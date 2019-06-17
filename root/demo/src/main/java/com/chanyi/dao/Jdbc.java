package com.chanyi.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Component;

/**
 * jdbc操作数据库类(使用Spring的JdbcTemplate实现)
 * 
 * 分页查询使用的是mysql数据库的limit关键词，如果使用其他数据库，请修改对应的queryForPage方法
 * 
 */
@Component
public class Jdbc extends NamedParameterJdbcDaoSupport {

	private static final String UPDATE_COUNT = "updatedCount:";

	private static final String SQL = "sql:";

	private static final String RESULT = "result:";

	@Value("${showSql:false}")
	private boolean log;

	@Value("${dbType:mysql}")
	private String dbType;

	@Resource
	private DataSource druidDataSource;

	@PostConstruct
	public void initDataSource() {
		super.setDataSource(druidDataSource);
	}

	@PreDestroy
	public void destroy() {
		logger.info("destroy");
	}

	@PostConstruct
	public void init() {
		logger.info("init");
	}

	/** 事务回滚. */
	public boolean rollback() {
		try {
			Connection con = super.getConnection();
			if (con == null) {
				return false;
			}
			con.rollback();
			return true;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return false;
		}
	}

	public int[] batchUpdate(String sql, BatchPreparedStatementSetter setter) {
		return this.getJdbcTemplate().batchUpdate(sql, setter);

	}

	public <T> T query(String sql, Class<T> elementType) {
		if (log) {
			logger.info(SQL + sql);
		}
		try {
			return this.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<T>(elementType));
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public <T> T query(String sql, Class<T> elementType, Object... args) {
		try {
			if (log) {
				logger.info(SQL + sql);
			}
			return this.getJdbcTemplate().queryForObject(sql, new BeanPropertyRowMapper<T>(elementType), args);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}




	public List<Map<String, Object>> queryForMaps(String sql) {
		if (log) {
			logger.info(SQL + sql);
		}
		try {
			return this.getJdbcTemplate().queryForList(sql);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ArrayList<>(0);
		}
	}

	public List<Map<String, Object>> queryForMaps(String sql, Object... args) {
		if (log) {
			logger.info(SQL + sql);
		}
		try {
			return this.getJdbcTemplate().queryForList(sql, args);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ArrayList<>(0);
		}
	}

	public Map<String, Object> queryForMap(String sql) {
		if (log) {
			logger.info(SQL + sql);
		}
		try {
			return this.getJdbcTemplate().queryForMap(sql);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public Map<String, Object> queryForMap(String sql, Object... args) {
		if (log) {
			logger.info(SQL + sql);
		}
		try {
			return this.getJdbcTemplate().queryForMap(sql, args);
		} catch (Exception e) {
			logger.info(e.getMessage());
			return null;
		}
	}

	public <T> List<T> queryForList(String sql, Class<T> elementType, Map<String, ?> paramMap) {
		try {
			List<T> list = this.getNamedParameterJdbcTemplate().query(sql, paramMap, new BeanPropertyRowMapper<T>(elementType));
			if (log) {
				this.logger.info("SQL:"+ sql);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return new ArrayList<>(0);
		}
	}


	public Date queryForDate(String sql) {
		try {
			Date result = this.getJdbcTemplate().queryForObject(sql, Date.class);
			if (log) {
				logger.info(RESULT + result + " " + SQL + sql);
			}
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}


	public String queryForString(String sql) {
		try {
			String result = this.getJdbcTemplate().queryForObject(sql, String.class);
			if (log) {
				logger.info(RESULT + result + " " + SQL + sql);
			}
			return result;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return null;
		}
	}


	public int updateForRecord(String sql) {
		if (log) {
			logger.info("执行 sql:" + sql);
		}
		int updatedCount = this.getJdbcTemplate().update(sql);
		if (log) {
			logger.info(UPDATE_COUNT + updatedCount + " " + SQL + sql);
		}
		return updatedCount;
	}

	public int batchUpdate(List<String> sqlList) {
		int updatedCount = 0;
		for (String sql : sqlList) {
			updatedCount += this.updateForRecord(sql);
		}
		return updatedCount;
	}

	public String beanName() {
		return this.getClass().getName();
	}

}
