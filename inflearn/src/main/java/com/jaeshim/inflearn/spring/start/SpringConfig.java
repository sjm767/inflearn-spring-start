package com.jaeshim.inflearn.spring.start;

import com.jaeshim.inflearn.spring.start.repository.JdbcMemberRepository;
import com.jaeshim.inflearn.spring.start.repository.JdbcTemplateMemberRepository;
import com.jaeshim.inflearn.spring.start.repository.MemberRepository;
import com.jaeshim.inflearn.spring.start.repository.MemoryMemberRepository;
import com.jaeshim.inflearn.spring.start.service.MemberService;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  private DataSource dataSource;

  @Autowired
  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService() {
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository() {
//    return new MemoryMemberRepository();
//    return new JdbcMemberRepository(dataSource);
    return new JdbcTemplateMemberRepository(dataSource);
  }
}
