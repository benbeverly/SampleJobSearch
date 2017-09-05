package benbeverly.samplejobsearch.fragment

import android.support.v4.app.Fragment

/**
 * BaseFragment to put things we want in all fragments
 */
abstract class BaseFragment : Fragment() {
    abstract fun getTitle(): String?
}