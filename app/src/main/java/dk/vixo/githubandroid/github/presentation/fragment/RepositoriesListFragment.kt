package dk.vixo.githubandroid.github.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import dagger.android.support.DaggerFragment
import dk.vixo.githubandroid.R
import dk.vixo.githubandroid.di.factories.ViewModelFactory
import dk.vixo.githubandroid.github.presentation.view.RepositoriesListView
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoriesListViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class RepositoriesListFragment : DaggerFragment() {

    @Inject
    lateinit var vmFactory: ViewModelFactory
    private val vm by viewModels<RepositoriesListViewModel> { vmFactory }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RepositoriesListView(vm)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        vm.detailEvent.onEach { repo ->
            parentFragmentManager.commit {
                replace(R.id.container, RepositoryDetailFragment.newInstance(repo), RepositoryDetailFragment.TAG)
                setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                addToBackStack(RepositoryDetailFragment.TAG)
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)
    }

    companion object {
        const val TAG = "fragment_repositories_list"

        fun newInstance() = RepositoriesListFragment()
    }
}