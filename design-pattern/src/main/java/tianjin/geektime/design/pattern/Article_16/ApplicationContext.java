package tianjin.geektime.design.pattern.Article_16;

/**
 * Created by tianjin on 2021/1/16.
 */
public class ApplicationContext {

    private AlertRule alertRule;
    private Notification notification;
    private Alert2 alert;

    public void initializeBeans() {
        alertRule = new AlertRule();
        notification = new Notification();
        alert = new Alert2();
        alert.addAlertHandler(new TpsAlertHandler(alertRule, notification));
        alert.addAlertHandler(new TimeoutAlertHandler(alertRule, notification));
    }

    public Alert2 getAlert() {
        return alert;
    }

    private static final ApplicationContext instance = new ApplicationContext();

    public static ApplicationContext getInstance() {
        return instance;
    }

    private ApplicationContext() {
        instance.initializeBeans();
    }

}

class Demo {
    public static void main(String[] avgs) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
