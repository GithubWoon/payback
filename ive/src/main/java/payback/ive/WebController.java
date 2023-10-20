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
  public String Baddie() {
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

  @RequestMapping("/Login")
  public String Login() {
    return "Login";
  }

  @RequestMapping("/AddComplete")
  public String AddComplete() {
    return "AddComplete";
  }

  @PostMapping("/AddManager")
  public String AddManager() {
    return "AddManager";
  }

  @PostMapping("/AddQuantity")
  public String AddQuantity() {
    return "AddQuantity";
  }

  @PostMapping("/Basket")
  public String Basket() {
    return "Basket";
  }

  @PostMapping("/BasketComplete")
  public String BasketComplete() {
    return "BasketComplete";
  }

  @PostMapping("/Cancel")
  public String Cancel() {
    return "Cancel";
  }

  @PostMapping("/CancelComplete")
  public String CancelComplete() {
    return "CancelComplete";
  }

  @PostMapping("/Complete")
  public String Complete() {
    return "Complete";
  }

  @PostMapping("/Look")
  public String Look() {
    return "Look";
  }

  @PostMapping("/ManagerMenu")
  public String ManagerMenu() {
    return "ManagerMenu";
  }

  @PostMapping("/Menu")
  public String Menu() {
    return "Menu";
  }

  @PostMapping("/Purchase")
  public String Purchase() {
    return "Purchase";
  }

  @PostMapping("/PurchaseComplete")
  public String PurchaseComplete() {
    return "PurchaseComplete";
  }

  @PostMapping("/Receipt")
  public String Receipt() {
    return "Receipt";
  }

  @PostMapping("/Register")
  public String Register() {
    return "Register";
  }

  @PostMapping("/Start")
  public String Start() {
    return "Start";
  }

  @PostMapping("/UserMenu")
  public String UserMenu() {
    return "UserMenu";
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
