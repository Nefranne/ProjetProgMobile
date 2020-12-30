package com.example.a4aprojetahratina

import android.content.Context
import androidx.room.Room
import com.example.a4aprojetahratina.Data.Local.AppDatabase
import com.example.a4aprojetahratina.Data.Local.DatabaseDao
import com.example.a4aprojetahratina.Data.Repository.UserRepository
import com.example.a4aprojetahratina.Domain.usercase.CreateUserUseCase
import com.example.a4aprojetahratina.Domain.usercase.GetUserUseCase
import com.example.a4aprojetahratina.Presentation.Main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel(get(),get()) }
}

val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}

val dataModule : Module = module {
    single { UserRepository(get()) }
    single {createDataBase(androidContext())}

}



fun createDataBase(context: Context) : DatabaseDao {
    val appDatabase : AppDatabase = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}