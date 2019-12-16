package com.test.turkcelltest.data.cache.db.fishdata

import androidx.room.*
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem
import io.reactivex.Single

@Dao
abstract class ProductsDAO : IProductsDAO {

    @Query("SELECT * FROM ProductItem")
    abstract override fun getProducts(): Single<List<ProductItem>>

    @Query("SELECT * FROM ProductDetails WHERE productId=:id")
    abstract override fun getProduct(id: Int): Single<ProductDetails>

    @Transaction
    override fun cacheProducts(products: List<ProductItem>) {
        clearProductItems()
        insertProducts(products)
    }

    @Query("DELETE FROM ProductItem")
    protected abstract fun clearProductItems()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    protected abstract fun insertProducts(products: List<ProductItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract override fun cacheProductDetails(productDetails: ProductDetails)
}