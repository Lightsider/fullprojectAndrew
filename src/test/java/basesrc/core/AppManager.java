package basesrc.core;

import helpers.PageHelper;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

@Data
public class AppManager {
    private WebDriver driver;
    private PageHelper pageHelper;
    public WebDriverWait wait;

    public PageHelper pagesHelper(){
        if(pageHelper == null){
            pageHelper = new PageHelper(this);
        }
        return pageHelper;
    }


}
