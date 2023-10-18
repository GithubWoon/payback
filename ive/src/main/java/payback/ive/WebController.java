package payback.ive;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {

  private final RegisterRepository registerRepository;

  public WebController(RegisterRepository registerRepository) {
    this.registerRepository = registerRepository;
  }

  @RequestMapping("/Baddie")
  public String baddie() {
    return "Baddie";
  }

  @RequestMapping("/Payback")
  public String Payback() {
    return "Payback";
  }

  @RequestMapping("/OTT")
  public String OTT() {
    return "OTT";
  }

  @RequestMapping("/Database")
  public String Database(Model model) {
    model.addAttribute("registers", registerRepository.findAll());
    return "Database";
  }

  @GetMapping("/registers")
  public String getRegisters(Model model) {
    model.addAttribute("registers", registerRepository.findAll()); // Add all registers to the model
    return "registers"; // Return the Registers view which will show all registers in your table.
  }

  @PostMapping("/api/add")
  @ResponseBody
  public void addRegister(@RequestBody Register newRegister) {
    registerRepository.save(newRegister);
  }
}
