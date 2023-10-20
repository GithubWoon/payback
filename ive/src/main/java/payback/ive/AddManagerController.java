package payback.ive;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddManagerController {

  private final ManagerRepository managerRepository;

  public AddManagerController(ManagerRepository managerRepository) {
    this.managerRepository = managerRepository;
  }

  @PostMapping("/shopping/AddManager")
  public String addManager(Manager newManager, Model model) {

    if (managerRepository.existsById(newManager.getId())) {
      model.addAttribute("message", "입력하신 ID는 사용중입니다.");
      return "addmanager";
    } else {
      managerRepository.save(newManager);
      model.addAttribute("message", "새로운 관리자가 추가되었습니다.");
      return "complete";
    }
    
  }
}
