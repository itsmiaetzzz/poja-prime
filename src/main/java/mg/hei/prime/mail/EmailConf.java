package mg.hei.prime.mail;

import lombok.Getter;
import mg.hei.prime.PojaGenerated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.ses.SesClient;

@PojaGenerated
@Configuration
public class EmailConf {

  @Getter private final String sesSource;

  public EmailConf(@Value("${aws.ses.source}") String sesSource) {
    this.sesSource = sesSource;
  }

  @Bean
  public SesClient getSesClient() {
    return SesClient.create();
  }
}
