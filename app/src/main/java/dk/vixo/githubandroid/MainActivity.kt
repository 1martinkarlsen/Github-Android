package dk.vixo.githubandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction.TRANSIT_FRAGMENT_FADE
import androidx.fragment.app.commit
import dk.vixo.githubandroid.github.presentation.fragment.RepositoriesListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.commit {
            add(R.id.container, RepositoriesListFragment.newInstance(), RepositoriesListFragment.TAG)
            setTransition(TRANSIT_FRAGMENT_FADE)
            addToBackStack(RepositoriesListFragment.TAG)
        }
    }

    override fun onBackPressed() {
        val backStackSize = supportFragmentManager.backStackEntryCount
        if (backStackSize > 1) {
            supportFragmentManager.popBackStack()
        } else {
            this.finish()
        }
    }
}