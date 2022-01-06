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
        arrayOf("Velvet Creamy Vanilla Frappucino", "Strawberry Milkshake",
            "Salted Caramel Macchiato", "Dark Cherry Milkshake", "Hot Coffee",
            "Peach Iced Tea with Lemon", "Chocolate Chip Cookie")
    private var ingredients =
        arrayOf("coffee, heavy cream, vanilla syrup, sugar",
            "strawberry syrup, strawberries, milk, sugar, vanilla extract",
            "coffee, salted caramel syrup, milk, heavy cream, sugar, salted caramel chunks",
            "dark cherries, cherry syrup, milk, sugar",
            "coffee, sugar, water",
            "peach, ice, water, sugar",
            "flour, sugar, choc chips, butter, eggs, baking agent")
    private var prices =
        arrayOf("11$", "9$", "12$", "10$", "5$", "8$", "10$")
    private val images =
        intArrayOf(R.drawable.item10, R.drawable.item11,
            R.drawable.item16, R.drawable.item17, R.drawable.item6, R.drawable.item20,
        R.drawable.item23)

    private var titlesH =
        arrayOf("Hot Coffee Christmas Specials",
            "Snickers Milkshake Christmas Specials", "Salted Brownies",
            "Bounty Milkshake Christmas Specials", "Oreo Milkshake Christmas Specials",
            "Chocolate Chip Cookie", "Chocolate Frapuccino Christmas Specials")
    private var ingredientsH =
        arrayOf("coffee, sugar, water, heavy cream",
            "snickers chunks, milk, sugar, vanilla extract, heavy cream, choc syrup",
            "flour, sugar, chocolate, butter, eggs, baking powder, sea salt",
            "bounty chunks, milk, sugar, vanilla extract, heavy cream, choc syrup, coconut syrup",
            "oreo chunks, milk, sugar, vanilla extract, heavy cream, choc syrup",
            "flour, sugar, choc chips, butter, eggs, baking agent",
            "coffee, sugar, water, heavy cream, milk, chocolate syrup")
    private var pricesH =
        arrayOf("5$", "12$", "15$", "13$", "11$", "10$", "12$")
    private val imagesH =
        intArrayOf(R.drawable.item6, R.drawable.item25,
            R.drawable.item21, R.drawable.item14, R.drawable.item15, R.drawable.item23,
            R.drawable.item19)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        val sdk = holder.itemTitle.context.getString(R.string.sdk)
        val client = ConfigCatClient(sdk)
        val holiday = client.getValue(Boolean::class.java, "holiday", false)

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