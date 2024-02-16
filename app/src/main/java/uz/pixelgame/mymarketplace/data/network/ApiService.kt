package uz.pixelgame.mymarketplace.data.network

import retrofit2.Response
import retrofit2.http.GET
import uz.pixelgame.mymarketplace.data.model.ProductResponse

interface ApiService {
    @GET("v3/97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getProducts():Response<ProductResponse?>
}