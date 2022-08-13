import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        int index;

        Transaction(String string, int i) {
            String[] strings = string.split(",");
            name = strings[0];
            time = Integer.parseInt(strings[1]);
            amount = Integer.parseInt(strings[2]);
            city = strings[3];
            index = i;
        }

        boolean invalidAmount() {
            return amount > 1000;
        }

        boolean invalidCityWith(Transaction otherWithSameName) {
            return Math.abs(this.time - otherWithSameName.time) <= 60 && !this.city.equals(otherWithSameName.city);
        }
    }

    public List<String> invalidTransactions(String[] transactions) {
        Map<String, List<Transaction>> map = new HashMap<>();
        for (int i = 0; i < transactions.length; i++) {
            String transaction = transactions[i];
            Transaction t = new Transaction(transaction, i);
            if (!map.containsKey(t.name)) {
                map.put(t.name, new ArrayList<>());
            }
            map.get(t.name).add(t);
        }
        List<String> res = new ArrayList<>();
        for (String name : map.keySet()) {
            List<Transaction> list = map.get(name);
            for (Transaction t : list) {
                if (t.invalidAmount()) {
                    res.add(transactions[t.index]);
                } else {
                    for (Transaction other : list) {
                        if (t.invalidCityWith(other)) {
                            res.add(transactions[t.index]);
                            break;
                        }
                    }
                }
            }
        }
        return res;
    }
}
