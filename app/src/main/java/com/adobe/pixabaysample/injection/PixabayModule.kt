package com.adobe.pixabaysample.injection

import android.content.Context
import android.content.SharedPreferences
import com.adobe.pixabaysample.BuildConfig
import com.adobe.pixabaysample.endpoints.PixabayEndpoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(
    ActivityComponent::class,
    ViewModelComponent::class
)
class PixabayModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("MainPrefs", Context.MODE_PRIVATE)
    }

    @Provides
    fun provideRetrofitPixabay(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.PIXABAY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providePixabayEndpoints(retrofit: Retrofit): PixabayEndpoints {
        return retrofit.create(PixabayEndpoints::class.java)
    }
}