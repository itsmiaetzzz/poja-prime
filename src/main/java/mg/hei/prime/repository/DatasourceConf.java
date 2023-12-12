package mg.hei.prime.repository;

import javax.sql.DataSource;
import mg.hei.prime.PojaGenerated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@PojaGenerated
@Configuration
public class DatasourceConf {

  private final String appPropDbUrl;
  private final String appProdDbUsername;
  private final String appPropDbPassword;

  public DatasourceConf(
      @Value("${spring.datasource.url:#{null}}") String appPropDbUrl,
      @Value("${spring.datasource.username:#{null}}") String appProdDbUsername,
      @Value("${spring.datasource.password:#{null}}") String appPropDbPassword) {
    this.appPropDbUrl = appPropDbUrl;
    this.appProdDbUsername = appProdDbUsername;
    this.appPropDbPassword = appPropDbPassword;
  }

  @ConfigurationProperties(prefix = "datasource.postgres")
  @Bean
  @Primary
  public DataSource dataSource() {
    return DataSourceBuilder.create()
        .url(appPropDbUrl == null ? System.getenv("DATABASE_URL") : appPropDbUrl)
        .username(
            appProdDbUsername == null ? System.getenv("DATABASE_USERNAME") : appProdDbUsername)
        .password(
            appPropDbPassword == null ? System.getenv("DATABASE_PASSWORD") : appPropDbPassword)
        .build();
  }
}