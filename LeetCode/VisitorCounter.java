
import java.util.*;
import java.util.stream.*;

public class VisitorCounter {

    static class UserStats {
        private Optional<Long> visitCount;

        public Optional<Long> getVisitCount() {

            return visitCount;
        }

        public void setVisitCount(Optional<Long> visitCount) {
            this.visitCount = visitCount;

        }

    }

    public void abc(int... hola) {

    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {

        Map<Long, Long> res = null;

        for (Map<String, UserStats> map : visits) {

            if (map != null) {
                if (res == null) {
                    res = new HashMap<>();
                }

                Map<Long, Long> filterMap = map.entrySet().stream()
                        .filter(obj -> {

                            if (obj.getKey() != null && this.validLong(obj.getKey()) & obj.getValue() != null
                                    && obj.getValue().getVisitCount().isPresent()) {
                                return true;

                            }

                            return false;
                        })
                        .collect(Collectors.toMap(

                                e -> Long.parseLong(e.getKey()),
                                e -> e.getValue().getVisitCount().get())

                        );

                res = Stream.concat(res.entrySet().stream(), filterMap.entrySet().stream())
                        .collect(Collectors.groupingBy(Map.Entry::getKey,
                                Collectors.summingLong(Map.Entry::getValue)));

            }

        }

        return res;
    }

    private boolean validLong(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
