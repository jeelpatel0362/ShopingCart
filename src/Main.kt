fun main() {

    print("Enter Customer Name : ")
    val customerName = readln()
    print("Enter Mobile Number : ")
    val mobileNumber = readln()

    print("\nEnter number of products : ")
    val numProducts = readln().toInt()

    val productNames = mutableListOf<String>()
    val productPrices = mutableListOf<Double>()
    val productQuantities = mutableListOf<Int>()

    for (i in 0..<numProducts) {
        println("\nEnter details for Product ${i + 1} :")
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

    for (i in 0..<numProducts) {
        totalPrices.add(productPrices[i] * productQuantities[i])
    }

    for (i in 0..<numProducts) {
        for (j in i + 1..<numProducts) {
            if (productPrices[i] < productPrices[j]) {

                val tempPrice = productPrices[i]
                productPrices[i] = productPrices[j]
                productPrices[j] = tempPrice

                val tempName = productNames[i]
                productNames[i] = productNames[j]
                productNames[j] = tempName

                val tempQuantity = productQuantities[i]
                productQuantities[i] = productQuantities[j]
                productQuantities[j] = tempQuantity

                val tempTotal = totalPrices[i]
                totalPrices[i] = totalPrices[j]
                totalPrices[j] = tempTotal
            }
        }
    }

    println("\nCart: ")
    println("----------------------------------------------------------")
    println("| Product Name | Price      | Quantity  | Total Price    |")
    println("----------------------------------------------------------")

    var totalWithoutDiscount = 0.0
    for (i in 0..<numProducts) {
        println("  ${productNames[i]}\t\t${" %.2f".format(productPrices[i])}\t\t${ productQuantities[i]}\t\t${"  %.2f".format(totalPrices[i])}")
        totalWithoutDiscount += totalPrices[i]
    }
    println("----------------------------------------------------------")

    var discountPercentage = 0.0

    if (totalWithoutDiscount >= 5000) {

        discountPercentage = 30.0
    } else if (totalWithoutDiscount >= 2000.0 && totalWithoutDiscount <= 4999.0) {
        discountPercentage = 20.0
    } else if (totalWithoutDiscount >= 1000.0 && totalWithoutDiscount <= 1999.0) {
        discountPercentage = 10.0
    } else if (totalWithoutDiscount >= 500.0 && totalWithoutDiscount <= 999.0) {
        discountPercentage = 2.0
    }

    val discountAmount = (discountPercentage / 100) * totalWithoutDiscount
    val totalWithDiscount = totalWithoutDiscount - discountAmount

    println("Customer Details:")
    println("Name: $customerName")
    println("Mobile: $mobileNumber")

    println("----------------------------------------------------------")

    println("Total Price Before Discount: ${"%.2f".format(totalWithoutDiscount)}")
    println("Discount Applied: $discountPercentage%")

    println("----------------------------------------------------------")

    println("Total Price After Discount: ${"%.2f".format(totalWithDiscount)}")

}