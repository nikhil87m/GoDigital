package com.javacodegeeks.spring.elasticsearch;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;

@Configuration
public class SpringElasticsearchExample {
	@Autowired
	private CARRepository repository;

	@Autowired
	private ElasticsearchTemplate template;

	public static void main(String[] args) throws URISyntaxException, Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		try {
			System.out.println("Load context");
			SpringElasticsearchExample s = (SpringElasticsearchExample) ctx
					.getBean("mainBean");
			System.out.println("Add CARs");
			s.addCARs();
			System.out.println("Find all CARs");
			s.findAllCARs();
//			System.out.println("Find CAR by name 'Joe'");
			s.findCAR("Joe");
//			System.out.println("Find CAR by name 'John'");
			s.findCAR("John");
//			System.out.println("Find CARs by age");
			s.findCARsByAge(32);
		} finally {
			ctx.close();
		}
	}

	public void addCARs() {
		CAR joe = new CAR("01", "Joe", 32);
		Skill javaSkill = new Skill("Java", 10);
		Skill db = new Skill("Oracle", 5);
		joe.setSkills(Arrays.asList(javaSkill, db));
		CAR johnS = new CAR("02", "John S", 32);
		CAR johnP = new CAR("03", "John P", 42);
		CAR sam = new CAR("04", "Sam", 30);

		template.putMapping(CAR.class);
		System.out.println(template.getMapping("resource", "car"));
		IndexQuery indexQuery = new IndexQuery();
		indexQuery.setId(joe.getId());
		indexQuery.setObject(joe);
		template.index(indexQuery);
		template.refresh(CAR.class, true);
		repository.save(johnS);
		repository.save(johnP);
		repository.save(sam);
	}

	public void findAllCARs() {
		repository.findAll().forEach(System.out::println);
	}

	public void findCAR(String name) {
		List<CAR> empList = repository.findCARsByName(name);
		System.out.println("CAR list: " + empList);
	}

	public void findCARsByAge(int age) {
		List<CAR> empList = repository.findCARsByAge(age);
		System.out.println("CAR list: " + empList);
	}
}
