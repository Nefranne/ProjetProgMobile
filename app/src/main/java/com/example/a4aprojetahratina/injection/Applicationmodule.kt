package com.example.a4aprojetahratina

import org.koin.dsl.module

val presentationModule = module {
    factory { MainViewModel() }
}