package tianjin.geektime.design.pattern.Article_16;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjin on 2021/1/16.
 */
public class Alert2 {

    private final List<AlertHandler> handlerList = new ArrayList<>();

    // todo 注册TimeoutAlertHandler 改动3
    public void addAlertHandler(AlertHandler alertHandler) {
        handlerList.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (AlertHandler handler : handlerList) {
            handler.check(apiStatInfo);
        }
    }

}

abstract class AlertHandler {

    protected AlertRule rule;
    protected Notification notification;

    public AlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    abstract void check(ApiStatInfo apiStatInfo);

}

class TpsAlertHandler extends AlertHandler {

    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    void check(ApiStatInfo apiStatInfo) {
        // tps check logic
    }
}

class ErrorAlertHandler extends AlertHandler {

    public ErrorAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    void check(ApiStatInfo apiStatInfo) {
        // error count alert logic
    }
}

// todo 新增TimeoutAlertHandler 改动2
class TimeoutAlertHandler extends AlertHandler {

    public TimeoutAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    void check(ApiStatInfo apiStatInfo) {
        // error count alert logic
    }
}

@AllArgsConstructor
@Getter
@Setter
class ApiStatInfo {
    private String api;
    private long requestCount;
    private long errorCount;
    // todo 新增属性timeoutCount 改动1
    private long durationOfSeconds;

    public ApiStatInfo() {
    }
}