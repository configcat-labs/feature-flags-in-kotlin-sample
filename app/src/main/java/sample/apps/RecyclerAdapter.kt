package sample.apps
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.configcat.*

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles =
        arrayOf("Velvet Frappucino", "Strawberry Milkshake",
            "Caramel Macchiato", "Watermelon Fresh", "Hot Coffee",
            "Peach Iced Tea", "Choc Frappucino")
    private var ingredients =
        arrayOf("coffee, heavy cream, vanilla syrup, sugar",
            "strawberry syrup, strawberries, milk, sugar, vanilla extract",
            "coffee, salted caramel syrup, milk, heavy cream, sugar, salted caramel chunks",
            "dark cherries, cherry syrup, milk, sugar",
            "coffee, sugar, water",
            "peach, ice, water, sugar",
            "flour, sugar, choc chips, butter, eggs, baking agent")
    private var prices =
        arrayOf("11$", "19$", "12$", "10$", "15$", "18$", "10$")
    private val images =
        intArrayOf(R.drawable.item7, R.drawable.item2,
            R.drawable.item16, R.drawable.item4, R.drawable.item10, R.drawable.item17,
        R.drawable.item8)

    private var titlesH =
        arrayOf("Coffee Christmas",
            "Snickers Milkshake", "Milk Coffee",
            "Hot Choc", "Oreo Milkshake",
            "Christmas Flurry", "Chocolate Frapuccino")
    private var ingredientsH =
        arrayOf("coffee, sugar, water, heavy cream",
            "snickers chunks, milk, sugar, vanilla extract, heavy cream, choc syrup",
            "flour, sugar, chocolate, butter, eggs, baking powder, sea salt",
            "bounty chunks, milk, sugar, vanilla extract, heavy cream, choc syrup, coconut syrup",
            "oreo chunks, milk, sugar, vanilla extract, heavy cream, choc syrup",
            "flour, sugar, choc chips, butter, eggs, baking agent",
            "coffee, sugar, water, heavy cream, milk, chocolate syrup")
    private var pricesH =
        arrayOf("15$", "12$", "15$", "13$", "11$", "10$", "12$")
    private val imagesH =
        intArrayOf(R.drawable.item30, R.drawable.item11,
            R.drawable.item31, R.drawable.item32, R.drawable.item6, R.drawable.item30,
            R.drawable.item32)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val sdk = holder.itemTitle.context.getString(R.string.sdk)
        val client = ConfigCatClient(sdk)
        var holiday = client.getValue(Boolean::class.java, "holiday", false)

        if(holiday) {
            holder.itemTitle.text = titlesH[position]
            holder.itemIngredients.text = ingredientsH[position]
            holder.itemPrice.text = pricesH[position]
            Glide.with(holder.itemView)
                .load(imagesH[position])
                .into(holder.itemImage)

        } else {
            holder.itemTitle.text = titles[position]
            holder.itemIngredients.text = ingredients[position]
            holder.itemPrice.text = prices[position]
            Glide.with(holder.itemView)
                .load(images[position])
                .into(holder.itemImage)

        }
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemIngredients: TextView
        var itemPrice: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemIngredients = itemView.findViewById(R.id.item_ingredients)
            itemPrice = itemView.findViewById(R.id.item_price)
        }
    }
}