package uz.pixelgame.mymarketplace.presentation.adapter

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.pixelgame.mymarketplace.R
import uz.pixelgame.mymarketplace.data.model.Item
import uz.pixelgame.mymarketplace.data.model.ProductResponse
import uz.pixelgame.mymarketplace.databinding.ItemProductBinding


class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.ViewHolder>() {

    lateinit var onClickItem : (Item) -> Unit

    private val data = ArrayList<Item>()

    fun setData(data:ProductResponse){
        this.data.addAll(data.items)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(data : Item){
            binding.discount.text = data.price.discount.toString()
            binding.price.text = data.price.price
            binding.rating.text = data.feedback.rating.toString()
            binding.priceDisc.text = data.price.priceWithDiscount
            binding.subtitle.text = data.subtitle
            binding.title.text = data.title
            binding.price.paintFlags = binding.price.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
            val adapter = ViewPagerAdapter()
            binding.viewPager.adapter = adapter
            binding.dotsIndicator.attachTo(binding.viewPager)
            when(data.id){
                "cbf0c984-7c6c-4ada-82da-e29dc698bb50"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.six)
                    imageList.add(R.drawable.five)
                    adapter.setData(imageList)
                }
                "54a876a5-2205-48ba-9498-cfecff4baa6e"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.one)
                    imageList.add(R.drawable.two)
                    adapter.setData(imageList)
                }
                "75c84407-52e1-4cce-a73a-ff2d3ac031b3"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.five)
                    imageList.add(R.drawable.six)
                    adapter.setData(imageList)
                }
                "16f88865-ae74-4b7c-9d85-b68334bb97db"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.three)
                    imageList.add(R.drawable.four)
                    adapter.setData(imageList)
                }
                "26f88856-ae74-4b7c-9d85-b68334bb97db"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.two)
                    imageList.add(R.drawable.three)
                    adapter.setData(imageList)
                }
                "15f88865-ae74-4b7c-9d81-b78334bb97db"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.six)
                    imageList.add(R.drawable.one)
                    adapter.setData(imageList)
                }
                "88f88865-ae74-4b7c-9d81-b78334bb97db"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.four)
                    imageList.add(R.drawable.three)
                    adapter.setData(imageList)
                }
                "55f58865-ae74-4b7c-9d81-b78334bb97db"->{
                    val imageList = ArrayList<Int>()
                    imageList.add(R.drawable.one)
                    imageList.add(R.drawable.five)
                    adapter.setData(imageList)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}