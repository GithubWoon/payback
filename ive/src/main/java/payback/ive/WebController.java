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

  @RequestMapping("/AddManager")
  public String AddManager() {
    return "AddManager";
  }

  @RequestMapping("/AddQuantity")
  public String AddQuantity() {
    return "AddQuantity";
  }

  @RequestMapping("/Basket")
  public String Basket() {
    return "Basket";
  }

  @RequestMapping("/BasketComplete")
  public String BasketComplete() {
    return "BasketComplete";
  }

  @RequestMapping("/Cancel")
  public String Cancel() {
    return "Cancel";
  }

  @RequestMapping("/CancelComplete")
  public String CancelComplete() {
    return "CancelComplete";
  }

  @RequestMapping("/Complete")
  public String Complete() {
    return "Complete";
  }

  @RequestMapping("/Look")
  public String Look() {
    return "Look";
  }

  @RequestMapping("/ManagerMenu")
  public String ManagerMenu() {
    return "ManagerMenu";
  }

  @RequestMapping("/Menu")
  public String Menu() {
    return "Menu";
  }

  @RequestMapping("/Purchase")
  public String Purchase() {
    return "Purchase";
  }

  @RequestMapping("/PurchaseComplete")
  public String PurchaseComplete() {
    return "PurchaseComplete";
  }

  @RequestMapping("/Receipt")
  public String Receipt() {
    return "Receipt";
  }

  @RequestMapping("/Register")
  public String Register() {
    return "Register";
  }

  @RequestMapping("/Start")
  public String Start() {
    return "Start";
  }

  @RequestMapping("/UserMenu")
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
