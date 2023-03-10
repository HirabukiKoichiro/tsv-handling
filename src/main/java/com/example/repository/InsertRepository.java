package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Original;

@Repository
public class InsertRepository {

	@Autowired
	private NamedParameterJdbcTemplate template;

	private static final RowMapper<Original> ORIGINAL_ROW_MAPPER = new BeanPropertyRowMapper<>(Original.class);

	public void insert(Original original) {

		SqlParameterSource param = new BeanPropertySqlParameterSource(original);
		String sql = "INSERT INTO original(id, name, condition_id, category_name, brand, price, shipping, description) values(:trainId, :name, :conditionId, :categoryName, :brand, :price, :shipping, :description);";
		template.update(sql, param);

	}

	public List<Original> category() {
		String sql = "select id, name, condition_id, category_name, brand, price, shipping, description from original;";
		List<Original> originalList = template.query(sql, ORIGINAL_ROW_MAPPER);
		return originalList;

	}

//	 public void copy(Connection conn, String filePath, String tableName) throws Exception {
//		 CopyManager copyManager = new CopyManager(connection);
//		 Reader reader = new InputStreamReader(new FileInputStream(filePath), "UTF8");
//		 String sql = "COPY originaloriginal (id, name, condition_id, category_name, brand, price, shipping, description) FROM STDIN (FORMAT csv, HEADER)";
//		 long result= copyManager.copyIn(sql, reader);   
//		  }

}
