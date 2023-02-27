package com.jaeshim.inflearn.spring.start;

import com.jaeshim.inflearn.spring.start.repository.MemberRepository;
import com.jaeshim.inflearn.spring.start.repository.MemoryMemberRepository;
import com.jaeshim.inflearn.spring.start.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

  @Bean
  public MemberService memberService(){
    return new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
    return new MemoryMemberRepository();
  }
}
