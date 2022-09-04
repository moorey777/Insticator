package com.Insticator.Insticator;

import com.Insticator.Insticator.model.Answer;
import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MappedTypes(Answer.class)
@MapperScan("com.Insticator.Insticator.mapper")
@SpringBootApplication
public class InsticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsticatorApplication.class, args);
	}

}
