import java.util.HashMap;
import java.util.Map;

class Bank {

    Map<Integer, Long> map;
    int number;

    public Bank(long[] balance) {
        number = balance.length;
        map = new HashMap<>();
        for (int i = 0; i < balance.length; i++) {
            map.put(i + 1, balance[i]);
        }
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!checkAccount(account1) || !checkAccount(account2)) {
            return false;
        }
        if (money > map.get(account1)) {
            return false;
        }
        map.put(account1, map.get(account1) - money);
        map.put(account2, map.get(account2) + money);
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!checkAccount(account)) {
            return false;
        }
        map.put(account, map.get(account) + money);
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!checkAccount(account)) {
            return false;
        }
        if (money > map.get(account)) {
            return false;
        }
        map.put(account, map.get(account) - money);
        return true;
    }

    private boolean checkAccount(int account) {
        if (account >= 1 && account <= number) {
            return true;
        }
        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */
