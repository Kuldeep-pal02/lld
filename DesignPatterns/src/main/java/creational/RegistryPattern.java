package creational;

import java.util.HashMap;
import java.util.Map;

public class RegistryPattern {
    // Not an official pattern defined in GoF
    //Registry Pattern provides a central place to store and retrieve pre-configured objects,
    // so that you can clone or reuse them
    private static final Map<String, NotificationTemplate> templates = new HashMap<>();

    public static void register( String key, NotificationTemplate template){
        templates.put( key, template);
    }
    public static NotificationTemplate get(String key) {
        NotificationTemplate template = templates.get(key);
        if (template == null) throw new IllegalArgumentException("No template found: " + key);
        return template.clone(); // 🔥 Prototype Pattern in action
    }
}

class NotificationTemplate implements Cloneable{ // this should be public and in its own file

    @Override
    public NotificationTemplate clone() {
        try {
            return (NotificationTemplate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}