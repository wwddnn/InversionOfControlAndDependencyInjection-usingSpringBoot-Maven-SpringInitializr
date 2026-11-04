package com.devsuperior.aula;

import com.devsuperior.aula.entities.Employee;
import com.devsuperior.aula.services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AulaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AulaApplication.class, args);
	}

	@Autowired
	private SalaryService salaryService;

	@Override
	public void run(String... args) throws Exception {

		Employee employee = new Employee("Maria", 4000.0);
		System.out.printf("Net salary %.2f%n", salaryService.netSalary(employee));
	}

	//o spring gerencia cada componente (ex service) e dessa forma ele controla a criacao, injecao e destruicao desse componente conforme necessario.
	//usar a anotacao @autowired desacopla a criacao de objetos dos mesmos conforme os principios de inversao de controle e injecao de dependencia.
	//fizemos a injecao de dependencia atraves o @Autowired. O spring tambem aceita se fizermos por construtor
}
