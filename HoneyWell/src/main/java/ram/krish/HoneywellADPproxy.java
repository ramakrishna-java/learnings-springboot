package ram.krish;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("ADPTaxCal")
public interface HoneywellADPproxy {
	@GetMapping(path = "/taxcal/{eno}/{salary}")
	public HoneywellEmployee callTax(@PathVariable("eno") int eno, @PathVariable("salary") Integer salary);

}
