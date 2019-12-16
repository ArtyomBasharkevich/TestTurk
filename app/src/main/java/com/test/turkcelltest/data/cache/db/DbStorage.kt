package com.test.turkcelltest.data.cache.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.test.turkcelltest.data.cache.db.fishdata.ProductsDAO
import com.test.turkcelltest.domain.entity.ProductDetails
import com.test.turkcelltest.domain.entity.ProductItem

@Database(entities = [ProductItem::class, ProductDetails::class], version = 1)
abstract class DbStorage : RoomDatabase() {

    abstract fun getProductsDAO(): ProductsDAO
}