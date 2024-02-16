package uz.pixelgame.mymarketplace.domain.repository

import kotlinx.coroutines.Dispatchers
import uz.pixelgame.mymarketplace.data.model.ProductResponse
import uz.pixelgame.mymarketplace.data.network.ApiService
import uz.pixelgame.mymarketplace.utill.ResultWrapper
import uz.pixelgame.mymarketplace.utill.parseResponse
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class Repository @Inject constructor(private val service : ApiService){

    suspend fun getProducts(): ResultWrapper<ProductResponse?, Any?> {
        return parseResponse(Dispatchers.IO) {
            service.getProducts()
        }
    }
}