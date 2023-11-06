package service;

import org.springframework.data.jpa.repository.JpaRepository;
import SpringBootApplication.Deltager;

public interface DeltagerInterface extends JpaRepository<Deltager, String>{
	Deltager findByFornavn(String fornavn);
	
}
