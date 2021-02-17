package tianjin.geektime.design.pattern.Article_16;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by tianjin on 2021/1/16.
 */
public class Alert {

    private AlertRule rule;
    private Notification notification;

    public Alert(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }

    // todo 新增超时逻辑，改动1
    public void check(String api, long requestCount, long errorCount, long durationOfSeconds) {
        long tps = requestCount / durationOfSeconds;
        if (tps > rule.getMatchedRule(api).getMaxTps()) {
            notification.notify(NotificationEmergencyLevel.URGENCY);
        }
        if (errorCount > rule.getMatchedRule(api).getMaxErrorCounts()) {
            notification.notify(NotificationEmergencyLevel.SERVER);
        }
        // todo 新增超时逻辑，改动2

    }

}

class AlertRule {

    private static final Map<String, AlertRule> api2Rule = new HashMap<>();

    private long maxTps;
    private long maxErrorCounts;

    public AlertRule getMatchedRule(String api) {
        return api2Rule.get(api);
    }

    public long getMaxTps() {
        return this.maxTps;
    }

    public long getMaxErrorCounts() {
        return this.maxErrorCounts;
    }

}

class Notification {

    public void notify(NotificationEmergencyLevel level) {
        //
    }

}

enum NotificationEmergencyLevel {
    URGENCY,
    SERVER;
}