package com.ym.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ym.customer.domain.Customer;
import com.ym.customer.domain.PageBean;
import com.ym.customer.util.JdbcUtil;

public class CustomerDao {
	/**
	 * 实现对数据的增删改查
	 */

	// 批处理
	@Test
	public void addBatchCustomer() {
		// 获取连接
		Connection c = JdbcUtil.getConnection();
		String sql = "insert into t_customer values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			for (int i = 4; i <= 300; i++) {
				ps.setInt(1, i);
				ps.setString(2, "customer_" + i);
				ps.setString(3, i % 2 == 0 ? "female" : "male");
				ps.setString(4, "1983-12-" + ((i > 30) ? i / 10 : i));
				ps.setString(5, "10010" + i);
				ps.setString(6, "123456" + i);
				ps.setString(7, i % 2 == 0 ? "打球" : "唱歌");
				ps.addBatch();
			}
			long start = System.currentTimeMillis();
			ps.executeBatch();
			long end = System.currentTimeMillis();
			System.out.println(end - start);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 添加customer
	public void addCustomer(Customer customer) {
		// 获取连接
		Connection c = JdbcUtil.getConnection();
		String sql = "insert into t_customer values(3,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, customer.getName());
			ps.setString(2, customer.getGender());
			ps.setString(3, customer.getBirthday());
			ps.setString(4, customer.getPhone());
			ps.setString(5, customer.getEmail());
			ps.setString(6, customer.getDesc());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 通过id查找customer
	public static Customer findCustomerById(String id) {
		Customer customer = null;
		// 获取连接
		Connection c = JdbcUtil.getConnection();
		String sql = "select * from t_customer where id=?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setName(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setBirthday(rs.getString(3));
				customer.setGender(rs.getString(4));
				customer.setPhone(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setDesc(rs.getString(7));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customer;

	}

	// 查找所有customer
	public static List<Customer> findAllCustomers() {

		List<Customer> list = new ArrayList<Customer>();
		Customer customer = null;
		// 获取连接
		Connection c = JdbcUtil.getConnection();
		String sql = "select * from t_customer ";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setBirthday(rs.getString(3));
				customer.setGender(rs.getString(4));
				customer.setPhone(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setDesc(rs.getString(7));
				list.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// 通过id删除用户
	public static void delete(String id) {
		// 获取连接
		Connection c = JdbcUtil.getConnection();
		String sql = "delete  from t_customer where id = ?";
		try {
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static PageBean<Customer> findAll(int pCode, int pSize) {

		// 创建pageBean对象，把pageCode,PagaSize,TotalRecord,beanList都获得
		// 封装成pageBean对象
		PageBean<Customer> pBean = new PageBean<Customer>();
		pBean.setPageCode(pCode);
		pBean.setPageSize(pSize);
		int totalRecord = 0;
		Connection connection = JdbcUtil.getConnection();
		String sql = "select count(*) as num from t_customer";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				totalRecord = rs.getInt("num");
			}
//			System.out.println(totalRecord);
			pBean.setTotalRecord(totalRecord);
			// 得到beanList
			List<Customer> beanList = getBeanList((pCode - 1) * pSize +1, pCode*pSize);
			pBean.setBeanList(beanList);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pBean;

	}

	private static List<Customer> getBeanList(int pCode, int pSize) {
		List<Customer> customers = new ArrayList<Customer>();
		Customer customer = null;

		Connection connection = JdbcUtil.getConnection();
		String sql = "select * from t_customer where id between ? and ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, pCode);
			ps.setInt(2, pSize);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getString(1));
				customer.setName(rs.getString(2));
				customer.setBirthday(rs.getString(3));
				customer.setGender(rs.getString(4));
				customer.setPhone(rs.getString(5));
				customer.setEmail(rs.getString(6));
				customer.setDesc(rs.getString(7));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customers;

	}

}
