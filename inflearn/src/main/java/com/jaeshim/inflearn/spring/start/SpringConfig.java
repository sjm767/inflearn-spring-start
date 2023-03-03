package com.jaeshim.inflearn.spring.start;

import com.jaeshim.inflearn.spring.start.aop.TimeTraceAop;
import com.jaeshim.inflearn.spring.start.repository.JpaMemberRepository;
import com.jaeshim.inflearn.spring.start.repository.MemberRepository;
import com.jaeshim.inflearn.spring.start.service.MemberService;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

//  private DataSource dataSource;
//
//  @Autowired
//  public SpringConfig(DataSource dataSource) {
//    this.dataSource = dataSource;
//  }

    //JPA를 사용하는 경우 
//  private EntityManager em;
//
//  @Autowired
//  public SpringConfig(EntityManager em) {
//    this.em = em;
//  }

  //SpringDataJPA를 사용하는 경우
  private final MemberRepository memberRepository;

  @Autowired
  public SpringConfig(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
  }

  @Bean
  public MemberService memberService() {
//    return new MemberService(memberRepository());
    //springData JPA를 사용하는 경우
    return new MemberService(memberRepository);
  }

//  @Bean
//  public MemberRepository memberRepository() {
////    return new MemoryMemberRepository();
////    return new JdbcMemberRepository(dataSource);
////    return new JdbcTemplateMemberRepository(dataSource);
////    return new JpaMemberRepository(em);
//  }

//  @Bean
//  public TimeTraceAop timeTraceAop(){
//    return new TimeTraceAop();
//  }
}
