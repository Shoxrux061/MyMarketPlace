package uz.pixelgame.mymarketplace.presentation.adapter

import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.pixelgame.mymarketplace.data.model.Item
import uz.pixelgame.mymarketplace.data.model.ProductResponse
import uz.pixelgame.mymarketplace.databinding.ItemImageBinding
import uz.pixelgame.mymarketplace.databinding.ItemProductBinding


class ViewPagerAdapter : RecyclerView.Adapter<ViewPagerAdapter.ViewHolder>() {


    private val data = ArrayList<Int>()

    fun setData(data:List<Int>){
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemImageBinding) : RecyclerView.ViewHolder(binding.root){
        fun bindData(data : Int){
            binding.imageView.setImageResource(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemImageBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(data[position])
    }
}