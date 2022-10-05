import kotlin.random.Random

class ShoppingItem(val itemName: String, val itemCount: Int) {

    companion object{
        var idCounter = 0
        fun createItemList(amount: Int): ArrayList<ShoppingItem>{
            val shoppingItemList = ArrayList<ShoppingItem>()
            for(i in 1..amount){
                shoppingItemList.add(ShoppingItem("Item Number: " + ++idCounter, Random.nextInt()))
            }
            return shoppingItemList
        }
    }

}