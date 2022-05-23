class Solution {
    public String validIPAddress(String queryIP) {
        String[] path = queryIP.split("\\.", -1);
        if (path.length == 4) {
            return validIPv4(path);
        } else {
            path = queryIP.split(":", -1);
            if (path.length == 8) {
                return validIPv6(path);
            } else {
                return "Neither";
            }
        }
    }

    private String validIPv4(String[] path) {
        for (String s : path) {
            if (s.length() > 1 && s.charAt(0) == '0') {
                return "Neither";
            } else {
                try {
                    int num = Integer.parseInt(s);
                    if (num > 255) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
        }
        return "IPv4";
    }

    private String validIPv6(String[] path) {
        for (String s : path) {
            if (s.length() == 0 || s.length() > 4) {
                return "Neither";
            } else {
                try {
                    int num = Integer.parseInt(s, 16);
                    if (num > 0xffff) {
                        return "Neither";
                    }
                } catch (NumberFormatException e) {
                    return "Neither";
                }
            }
        }
        return "IPv6";
    }
}
