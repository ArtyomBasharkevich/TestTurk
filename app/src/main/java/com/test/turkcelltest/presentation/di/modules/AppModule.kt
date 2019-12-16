package com.test.turkcelltest.presentation.di.modules

import android.content.Context
import androidx.room.Room
import com.test.turkcelltest.data.cache.db.DbStorage
import com.test.turkcelltest.data.cache.db.fishdata.IProductsDAO
import com.test.turkcelltest.data.repository.Repository
import com.test.turkcelltest.data.threads.JobExecutor
import com.test.turkcelltest.domain.executor.ExecutionThread
import com.test.turkcelltest.domain.executor.PostExecutionThread
import com.test.turkcelltest.domain.repository.IRepository
import com.test.turkcelltest.presentation.threads.UIThread
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule() {

    @Binds
    abstract fun bindExecutionThread(jobExecutor: JobExecutor): ExecutionThread

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UIThread): PostExecutionThread

    @Binds
    abstract fun bindIRepository(repository: Repository): IRepository

    @Module
    companion object {
        private const val DB_NAME = "products_db"

        @JvmStatic
        @Provides
        @Singleton
        fun provideIFishDataDAO(context: Context): IProductsDAO = Room
            .databaseBuilder(context, DbStorage::class.java, DB_NAME)
            .build()
            .getProductsDAO()
    }
}