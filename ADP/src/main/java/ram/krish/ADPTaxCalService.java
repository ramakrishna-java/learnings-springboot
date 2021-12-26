package ram.krish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ADPTaxCalService {
	@Autowired
	private Environment environment;
	
	@GetMapping(path = "/taxcal/{eno}/{salary}")
	public ADPEmployeeData callTax(@PathVariable("eno") int eno, @PathVariable("salary") int salary) {
		int taxAmount = (salary * 30) / 100;
		int netPay = salary - taxAmount;
		ADPEmployeeData adpEmployeeData=new ADPEmployeeData();
		adpEmployeeData.setEno(eno);
		adpEmployeeData.setNetPay(netPay);
		adpEmployeeData.setPortNumber(environment.getProperty("local.server.port"));
		adpEmployeeData.setSalary(salary);
		adpEmployeeData.setTaxAmount(taxAmount);
		return adpEmployeeData;
	}
}
