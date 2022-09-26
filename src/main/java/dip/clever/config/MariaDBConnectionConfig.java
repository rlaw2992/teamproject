package dip.clever.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("application.properties")
public class MariaDBConnectionConfig {
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String user;
	@Value("${spring.datasource.password}")
	private String password;
	@Value("${spring.datasource.classname}")
	private String className;
	
	@Lazy
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {



		final HikariConfig hikariConfig = new HikariConfig();		
		
		System.out.println("=======>" + password); 
		System.out.println("=======>" + className);		
						
		hikariConfig.setUsername(user);
		hikariConfig.setPassword(password);
		
		hikariConfig.addDataSourceProperty("url", url);
		hikariConfig.setDataSourceClassName(className);
		hikariConfig.setLeakDetectionThreshold(2000);
		hikariConfig.setPoolName("DBpool");
				
		return new HikariDataSource(hikariConfig);
	}
}
