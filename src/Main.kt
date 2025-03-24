fun main() {

    print("Enter Customer Name : ")
    val customerName = readln()
    print("Enter Mobile Number : ")
    val mobileNumber = readln()

    print("Enter number of products : ")
    val numProducts = readln().toInt()

    val productNames = mutableListOf<String>()
    val productPrices = mutableListOf<Double>()
    val productQuantities = mutableListOf<Int>()

    for (i in 0..<numProducts) {
        println("Enter details for Product ${i + 1} :")
        print("Product Name : ")
        val name = readln()
        print("Product Price : ")
        val price = readln().toDouble()
        print("Product Quantity : ")
        val quantity = readln().toInt()

        productNames.add(name)
        productPrices.add(price)
        productQuantities.add(quantity)
    }

    val totalPrices = mutableListOf<Double>()

    for (i in 0..< numProducts) {
        totalPrices.add(productPrices[i] * productQuantities[i])
    }

}