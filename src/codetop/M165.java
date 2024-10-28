package codetop;

class M165 {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int cur = 0;
        while (cur < ss1.length || cur < ss2.length) {
            int a = cur < ss1.length ? Integer.parseInt(ss1[cur]) : 0;
            int b = cur < ss2.length ? Integer.parseInt(ss2[cur]) : 0;
            int compare = Integer.compare(a, b);
            if (compare != 0) {
                return compare;
            }
            cur++;
        }
        return 0;
    }
}