package uz.pixelgame.mymarketplace.data.model


import com.google.gson.annotations.SerializedName

data class ProductResponse(
    @SerializedName("items")
    val items: ArrayList<Item>
)