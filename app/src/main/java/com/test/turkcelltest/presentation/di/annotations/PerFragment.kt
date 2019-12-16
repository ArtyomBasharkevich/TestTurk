package com.test.turkcelltest.presentation.di.annotations

import androidx.fragment.app.Fragment
import javax.inject.Scope
import kotlin.reflect.KClass

@Scope
@Target(AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class PerFragment(val value: KClass<out Fragment>)