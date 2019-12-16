package com.test.turkcelltest.presentation.ui.base

import android.content.Context
import androidx.annotation.LayoutRes
import com.test.turkcelltest.presentation.utils.ResettableLazy
import com.test.turkcelltest.presentation.utils.resettableManager
import moxy.MvpAppCompatFragment
import javax.inject.Inject
import javax.inject.Provider

abstract class BaseFragment<P : BasePresenter<*, *>>(@LayoutRes contentLayoutId: Int) :
    MvpAppCompatFragment(contentLayoutId) {

    val lazyMgr = resettableManager()

    @Inject
    protected lateinit var presenterProvider: Provider<P>
    protected abstract val presenter: P

    protected abstract fun injectComponent()

    override fun onAttach(context: Context) {
        injectComponent()
        super.onAttach(context)
    }

    override fun onDestroyView() {
        lazyMgr.reset()
        super.onDestroyView()
    }

    fun <PROPTYPE> resettableLazy(init: () -> PROPTYPE): ResettableLazy<PROPTYPE> {
        return ResettableLazy(lazyMgr, init)
    }
}