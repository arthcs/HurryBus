/**
 * 
 */
package tuturiais;

/**
 * @author Blackbeard
 *
 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
//JAX-RS suporta um mapeamento automático da classe JAXB anotado para XML e JSON
// Não é legal? 
public class Todo {
  private String summary;
  private String description;
  public String getSummary() {
    return summary;
  }
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
} 
