import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum ProductCategory{
    Paracetamol,
    analgesic,
    chocolate
}
class Item{
    int id;
    ProductCategory cat;
    int qty;
    Item( int id, ProductCategory pc, int qty){
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
interface IRule{
    boolean breached( Cart cart );
}
class BulkBuyLimitCategory implements  IRule{

    Map<ProductCategory , Integer> categoryQtyLimitMap;
    BulkBuyLimitCategory ( Map<ProductCategory , Integer> categoryQtyMap){
        this.categoryQtyLimitMap = categoryQtyMap;
    }


    @Override
    public boolean breached( Cart cart) {
        Map<ProductCategory , Integer> itemCatQtyMap = new HashMap<>();
        for( Item item: cart.items){
            itemCatQtyMap.put( item.cat ,  itemCatQtyMap.getOrDefault( item.cat , 0) + item.qty);
        }

        for( Map.Entry<ProductCategory, Integer> entry : itemCatQtyMap.entrySet() ){
            if( entry.getValue() > categoryQtyLimitMap.getOrDefault( entry.getKey() , 10000) ){
                return true;
            }
        }
        return false;
    }
}

class BulkBuyLimitRule implements  IRule{


    int maxLimit = 10;
    BulkBuyLimitRule ( int maxLimit ){
        this.maxLimit = maxLimit;
    }
    @Override
    public boolean breached( Cart cart) {
        for( Item item: cart.items){
            if( item.qty > maxLimit ){
                return  true;
            }
        }
        return false;
    }
}

class RuleEngine{
    List<IRule> rules;
    RuleEngine(  List<IRule> rules ){
        this.rules = rules;
    }
    boolean apply( Cart cart ){
        boolean breached = false;
        for( IRule rule : rules ){
            if( rule.breached( cart ) ){
                breached = true;
                break;
            }
        }

        return breached;
    }
}


public class Driver {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Item item1 = new Item( 1, ProductCategory.Paracetamol , 5);
        Item item2 = new Item( 2, ProductCategory.analgesic , 2);
        Item item3 = new Item( 3, ProductCategory.chocolate , 3);
        Item item4 = new Item( 4, ProductCategory.Paracetamol , 2);

        List<Item> items = List.of( item1,item2,item3,item4);
        Cart cart = new Cart( items );

        Map<ProductCategory , Integer> categoryQtyLimitMap =  new HashMap<>();
        categoryQtyLimitMap.put( ProductCategory.Paracetamol , 10);
        IRule rule1 = new BulkBuyLimitCategory( categoryQtyLimitMap );
        IRule rule2 = new BulkBuyLimitRule( 10 );
        List<IRule> rules = List.of( rule1, rule2);
        RuleEngine ruleEngine = new RuleEngine(rules );
        System.out.println( ruleEngine.apply( cart ) );

    }
}
