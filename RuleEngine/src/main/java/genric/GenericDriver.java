package genric;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

enum ProductCategory{
    Paracetamol,
    analgesic,
    chocolate
}
class Item{
    int id;
    ProductCategory cat;
    int qty;
    Item(int id, ProductCategory pc, int qty){
        this.cat = pc;
        this.qty = qty;
        this.id = id;
    }
}

class Cart{
    List<Item> items;
    Cart( List<Item> items){
        this.items = items;
    }
}

class LoanApplication {
    int loanAmount;
    int creditScore;

    LoanApplication(int loanAmount, int creditScore) {
        this.loanAmount = loanAmount;
        this.creditScore = creditScore;
    }
}



interface IRule<T>{
    boolean breached( T data );
}

class BulkBuyLimitRule<T> implements IRule<T> {
    private final int maxLimit;
    private final Function<T, List<Item>> extractor;

    BulkBuyLimitRule(int maxLimit, Function<T, List<Item>> extractor) {
        this.maxLimit = maxLimit;
        this.extractor = extractor;
    }

    @Override
    public boolean breached(T data) {
        List<Item> items = extractor.apply(data);
        for (Item item : items) {
            if (item.qty > maxLimit) {
                return true;
            }
        }
        return false;
    }
}


class LoanAmountLimitRule implements IRule<LoanApplication> {
    private final int maxLimit;

    LoanAmountLimitRule(int maxLimit) {
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean breached(LoanApplication data) {
        return data.loanAmount > maxLimit;
    }
}

class RuleEngine<T> {
    private final List<IRule<T>> rules;

    RuleEngine(List<IRule<T>> rules) {
        this.rules = rules;
    }

    List<String> apply(T data) {
        List<String> breachedRules = new ArrayList<>();

        for (IRule<T> rule : rules) {
            if (rule.breached(data)) {
                breachedRules.add(rule.getClass().getSimpleName());
            }
        }

        return breachedRules;
    }
}


public class GenericDriver {
    public static void main(String[] args) {


        Cart cart = new Cart(List.of(
                new Item(1, ProductCategory.Paracetamol, 5),
                new Item(2, ProductCategory.analgesic, 2),
                new Item(3, ProductCategory.chocolate, 3)
        ));

        List<IRule<Cart>> cartRules = List.of(
                new BulkBuyLimitRule<>(10, c -> c.items)
        );

        RuleEngine<Cart> cartRuleEngine = new RuleEngine<>(cartRules);
        List<String> breachedRules = cartRuleEngine.apply(cart);

        System.out.println(breachedRules.isEmpty() ? "All rules MET!" : "Rule BREACHED: " + breachedRules);




        LoanApplication loanApplication = new LoanApplication(50000, 600);

        List<IRule<LoanApplication>> loanRules = List.of(
                new LoanAmountLimitRule(40000)
        );

        RuleEngine<LoanApplication> loanRuleEngine = new RuleEngine<>(loanRules);
        breachedRules = loanRuleEngine.apply(loanApplication);

        System.out.println(breachedRules.isEmpty() ? "Loan Approved!" : "Loan Rejected: " + breachedRules);





    }
}
