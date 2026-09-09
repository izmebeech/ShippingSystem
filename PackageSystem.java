package vecka2;
// register packages and their dimensions
// make sure they're not larger than 100x100x100 cm
// calculate postage price for package when registered
// up to 20 cm costs 100 kr
// larger than 20 cm costs 200 kr
// odd package size +50 kr to original price
// store cost and package info in a database
public class PackageSystem {
    static void main() {

        ShippingInfo[] orders = new ShippingInfo[10];
        int orderCount = 0;

        while(true){
        IO.println("Enter package width:");
        int width = Integer.parseInt(IO.readln());

        IO.println("Enter package height:");
        int height = Integer.parseInt(IO.readln());

        IO.println("Enter package depth:");
        int depth = Integer.parseInt(IO.readln());

        if(width>100||height>100||depth>100) {
            IO.println("Package too large");
            continue;
        }

            Box box = new Box(width, height, depth);
            int price = calculateShippingCost(box);
            IO.println("Your postage will be " + price + " kr.");

            //store cost and dimensions
            ShippingInfo shippingInfo = new ShippingInfo(box, price);
            orders[orderCount] = shippingInfo;
            orderCount++;

        }


    } public static int calculateShippingCost(Box box) {
        int price;

        if (box.width() <= 20 && box.height() <= 20 && box.depth() <= 20) {
            price = 100;
        } else {
            price = 200;
        }
        int maxSide = Math.max(Math.max(box.width(), box.height()), box.depth());
        int minSide = Math.min(Math.min(box.width(), box.height()), box.depth());;

        if (maxSide > 2 * minSide) {
            price += 50;
        }
        return price;
    }
    }

