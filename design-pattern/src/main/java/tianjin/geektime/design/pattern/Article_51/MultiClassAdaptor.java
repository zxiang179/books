package tianjin.geektime.design.pattern.Article_51;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tianjin on 2021/2/20.
 */
public class MultiClassAdaptor {

    private class ASensitiveWordsFilter {
        public String filterSexyWords(String text) {
            return "filterSexyWords";
        }

        public String filterPoliticWords(String text) {
            return "filterPoliticWords";
        }
    }

    private class BSensitiveWordsFilter {
        public String filter(String text) {
            return "filter";
        }
    }

    private class CSensitiveWordsFilter {
        public String filter(String text, String mask) {
            return "filter&mask";
        }
    }

    private class RiskManagement {
        private ASensitiveWordsFilter aSensitiveWordsFilter = new ASensitiveWordsFilter();
        private BSensitiveWordsFilter bSensitiveWordsFilter = new BSensitiveWordsFilter();
        private CSensitiveWordsFilter cSensitiveWordsFilter = new CSensitiveWordsFilter();

        public String filterProcessor(String text) {
            text = bSensitiveWordsFilter.filter(text);
            text = aSensitiveWordsFilter.filterPoliticWords(text);
            text = aSensitiveWordsFilter.filterSexyWords(text);
            return cSensitiveWordsFilter.filter(text, "123");
        }
    }

    // ========================= Adaptor =========================

    private interface ISensitiveWordsFilter {
        String filter(String text);
    }

    private class ASFilterAdaptor implements ISensitiveWordsFilter {

        private ASensitiveWordsFilter aSensitiveWordsFilter;

        public ASFilterAdaptor(ASensitiveWordsFilter aSensitiveWordsFilter) {
            this.aSensitiveWordsFilter = aSensitiveWordsFilter;
        }

        @Override
        public String filter(String text) {
            String s = aSensitiveWordsFilter.filterPoliticWords(text);
            return aSensitiveWordsFilter.filterSexyWords(s);
        }
    }

    private class BSFilterAdaptor implements ISensitiveWordsFilter {

        private BSensitiveWordsFilter bSensitiveWordsFilter;

        public BSFilterAdaptor(BSensitiveWordsFilter bSensitiveWordsFilter) {
            this.bSensitiveWordsFilter = bSensitiveWordsFilter;
        }

        @Override
        public String filter(String text) {
            // ...
            return "";
        }
    }

    private class CSFilterAdaptor implements ISensitiveWordsFilter {

        private CSensitiveWordsFilter cSensitiveWordsFilter;

        public CSFilterAdaptor(CSensitiveWordsFilter cSensitiveWordsFilter) {
            this.cSensitiveWordsFilter = cSensitiveWordsFilter;
        }

        @Override
        public String filter(String text) {
            // ...
            return "";
        }
    }

    private class RiskManagement2 {

        private final List<ISensitiveWordsFilter> filters = new ArrayList<>();

        public void addFilter(ISensitiveWordsFilter filter) {
            filters.add(filter);
        }

        public String filterProcessor(String text) {
            for (ISensitiveWordsFilter filter : filters) {
                text = filter.filter(text);
            }
            return text;
        }
    }

}
