package com.test.turkcelltest.presentation.di.annotations

import androidx.appcompat.app.AppCompatActivity
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Target(AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity(val value: KClass<out AppCompatActivity>)