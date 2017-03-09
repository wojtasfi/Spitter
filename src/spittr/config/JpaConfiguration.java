package spittr.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
@EnableJpaRepositories(basePackages = "spittr.persistance", entityManagerFactoryRef="emf")
public class JpaConfiguration {
	
	
	@Bean
	public DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
				//.addScript("schema.sql")
				.build();
	}

	@Bean
	public JpaTransactionManager transactionManager() {
		return new JpaTransactionManager(); 
	}

	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter() {
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.H2);
		adapter.setShowSql(false);
		adapter.setGenerateDdl(true);
		return adapter;
	}

	@Bean
	public Object emf() {
		LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(dataSource());
		emf.setPersistenceUnitName("spitter");
		emf.setJpaVendorAdapter(jpaVendorAdapter());
		emf.setPackagesToScan("spittr.data");
		return emf;
	}
}
