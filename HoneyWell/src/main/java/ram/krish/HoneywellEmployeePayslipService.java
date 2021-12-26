package ram.krish;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HoneywellEmployeePayslipService {
	@Autowired
	private HoneywellADPproxy adPproxy;
	
	@GetMapping(path="/honeywell/taxcal/{eno}/{name}/{salary}/{address}")
	public HoneywellEmployee callTax(
			@PathVariable("eno") int eno,
			@PathVariable("name") String name,
			@PathVariable("salary") Integer salary,
			@PathVariable("address") String address
			) {
		HoneywellEmployee employeeAdp=adPproxy.callTax(eno, salary);
		HoneywellEmployee employee=new HoneywellEmployee();
		employee.setAddress(address);
		employee.setEno(eno);
		employee.setName(name);
		employee.setNetPay(employeeAdp.getNetPay());
		employee.setPortNumber2(employeeAdp.getPortNumber2());
		employee.setSalary(salary);
		employee.setTaxAmount(employeeAdp.getTaxAmount());
		
		return employee;
	}
}
