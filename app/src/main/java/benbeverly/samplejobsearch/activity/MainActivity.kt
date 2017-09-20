package benbeverly.samplejobsearch.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import benbeverly.samplejobsearch.R
import benbeverly.samplejobsearch.fragment.BaseFragment
import benbeverly.samplejobsearch.fragment.JobListFragment

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportFragmentManager.addOnBackStackChangedListener(this)
        if (supportFragmentManager.backStackEntryCount == 0) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment, JobListFragment.newInstance())
                    .commit()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onBackStackChanged() {
        val fragManager = supportFragmentManager
        updateDisplayTitle(fragManager.fragments[fragManager.fragments.size - 1])
        displayUpButton(fragManager.backStackEntryCount > 0)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }

    private fun updateDisplayTitle(fragment: Fragment?) {
        when (fragment) {
            is BaseFragment -> supportActionBar?.title = fragment.getTitle() ?: title
            else -> supportActionBar?.title = title
        }
    }

    private fun displayUpButton(shouldDisplay: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(shouldDisplay)
    }
}
