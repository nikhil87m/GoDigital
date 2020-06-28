package com;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class TestConverter {

	public static void main(String[] args) {

		ObjectMapper mapper = new ObjectMapper();
		Employee employee = new Employee();
		employee.setDept("Medical");
		employee.setName("Nikhil");
		Address address = new Address();
		address.setState("NY");
		address.setZipCode(10001);
		employee.setAddress(address);
		
		String  empJSON = "{\"name\":\"Shaikh\",\"dept\":\"Science\",\"address\":{\"state\":\"FL\",\"zipCode\":32003}}";
		try {
			//Object to JSON in String
			String jsonInString = mapper.writeValueAsString(employee);
			System.out.println(jsonInString);
			// Object to JSON
			Employee employee2 = mapper.readValue(empJSON, Employee.class);
			System.out.println("Employee"+employee2);
			System.out.println("Employee name: "+employee2.getName());
			System.out.println("Employee Dept: "+employee2.getDept());
			System.out.println("Employee Address Zip code: "+employee2.getAddress().getZipCode());
			System.out.println("Employee Address State: "+employee2.getAddress().getState());
			
		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
