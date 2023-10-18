package payback.ive;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Register") // Specify the table name
public class Register {

    @Id
    private String id;

    private String name;
    
    private String password; // Add this field

   public void setId(String id) {
        this.id = id;
   }

   public void setName(String name) {
        this.name = name;
   }

   public void setPassword(String password) {
        this.password = password;
   }
    
   public String getId() {
        return this.id;
   }
 
   public String getName() {
        return this.name;
  }
 
  public String getPassword() {
       return this.password;
  }
}