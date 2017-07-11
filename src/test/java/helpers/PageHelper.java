package helpers;

import basesrc.core.AppManager;
import basesrc.pages.RegPage;

/**
 * Created by andrey.popov on 11.07.2017.
 */
public class PageHelper {
    private RegPage regPage;
    private AppManager app;
    public RegPage regPage(){
        if(regPage == null){
            regPage = new RegPage(app);
        }
        return regPage;
    }
    public PageHelper(AppManager app)
    {
        this.app=app;
    }
}
