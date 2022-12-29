package orm;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataBaseBuilder {
	private static SqlSessionFactory factory;
	private static final String config="orm/MyBatisConfig.xml";
	
	//초기화 블럭을 사용하여 객체 생성
	static {
		try {
			factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader(config));
		} catch (IOException e) {
			//마이바티스 설정 오류시 메시지
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getFactory() {
		return factory;
	}
}
