package tianjin.geektime.design.pattern.Article_51;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/**
 * Created by tianjin on 2021/2/20.
 */
public class CompatibleOldInterface {

    private static Enumeration enumeration(final Collection collection) {
        return new Enumeration() {
            Iterator i = collection.iterator();

            @Override
            public boolean hasMoreElements() {
                return i.hasNext();
            }

            @Override
            public Object nextElement() {
                return i.next();
            }
        };

    }
}
