package mybatis.helloworld;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class HelloWorld {

	//根据id查询用户信息，得到一条记录的结果
	@Test
	public void findUserById() throws IOException{
		/**
		 * 1.创建会话工厂
		 */
		String resource = "sqlmapconfig/SqlMapConfig_HelloWorld.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2.通过工厂得到sqlsession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		/**
		 * 3.通过SqlSession操作数据库
		 * 第一个参数：映射文件中statement的id,等于namespace+"."+statement的id
		 * 第二个参数：指定和映射文件中所匹配的paramenterType类型的参数
		 * sqlSession.selectOne结果是映射文件中所匹配的resultType类型的对象
		 */
		User user = sqlSession.selectOne("test.findUserById", 10);
		System.out.println(user);
//		List<User> users = sqlSession.selectList("test.findUserByName", "%小明%");
		List<User> users = sqlSession.selectList("test.findUserByName", "小明");
		System.out.println(users);
		
	}
	
	@Test
	public void insertUser() throws IOException{
		/**
		 * 1.创建会话工厂
		 */
		String resource = "sqlmapconfig/SqlMapConfig_HelloWorld.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2.通过工厂得到sqlsession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//插入用户信息简单版
		User userInsert = new User();
		userInsert.setUsername("侯志明");
		userInsert.setBirthday(new Date());
		userInsert.setAddress("山西临汾");
		userInsert.setSex("男");
		sqlSession.insert("test.insertUser", userInsert);
		
		//提交事务
		sqlSession.commit();
		
		/**
		 * 释放资源
		 */
		sqlSession.close();
	}
	
	@Test
	public void insertUserReturnIDZiDong() throws IOException{
		/**
		 * 1.创建会话工厂
		 */
		String resource = "sqlmapconfig/SqlMapConfig_HelloWorld.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2.通过工厂得到sqlsession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//插入用户信息  mysql获取 自增长主键
		User userInsert2 = new User();
		userInsert2.setUsername("侯志明2");
		userInsert2.setBirthday(new Date());
		userInsert2.setAddress("山西临汾2");
		userInsert2.setSex("男");
		sqlSession.insert("test.insertUserAndGetId", userInsert2);
		
		System.out.println(userInsert2.getId());
		
		//提交事务
		sqlSession.commit();
		
		/**
		 * 释放资源
		 */
		sqlSession.close();
	}
	
	@Test
	public void insertUserReturnIDNoZiDong() throws IOException{
		/**
		 * 1.创建会话工厂
		 */
		String resource = "sqlmapconfig/SqlMapConfig_HelloWorld.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2.通过工厂得到sqlsession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//插入用户信息3  mysql获取 非自增长主键
		User userInsert3 = new User();
		userInsert3.setUsername("侯志明3");
		userInsert3.setBirthday(new Date());
		userInsert3.setAddress("山西临汾3");
		userInsert3.setSex("男");
		sqlSession.insert("test.insertUserAndGetId", userInsert3);
		
		System.out.println(userInsert3.getId());
		//提交事务
		sqlSession.commit();
		
		/**
		 * 释放资源
		 */
		sqlSession.close();
				
	}
	
	@Test
	public void deleteUser() throws IOException{
		/**
		 * 1.创建会话工厂
		 */
		String resource = "sqlmapconfig/SqlMapConfig_HelloWorld.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		
		/**
		 * 2.通过工厂得到sqlsession
		 */
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//删除用户
		sqlSession.insert("test.deleteUser",29);
		
		//提交事务
		sqlSession.commit();
		
		/**
		 * 释放资源
		 */
		sqlSession.close();
				
	}
}
