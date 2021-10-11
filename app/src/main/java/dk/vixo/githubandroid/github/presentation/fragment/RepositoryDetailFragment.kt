package dk.vixo.githubandroid.github.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import dagger.android.support.DaggerFragment
import dk.vixo.githubandroid.di.factories.ViewModelFactory
import dk.vixo.githubandroid.github.domain.model.Repository
import dk.vixo.githubandroid.github.presentation.view.RepositoryDetailView
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoryDetailViewModel
import javax.inject.Inject

class RepositoryDetailFragment : DaggerFragment() {

    lateinit var repository: Repository

    @Inject
    lateinit var vmFactory: ViewModelFactory

    private val vm by viewModels<RepositoryDetailViewModel> {
        vmFactory
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                RepositoryDetailView(vm) {
                    requireActivity().onBackPressed()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm.setRepository(repo = repository)
    }

    companion object {
        const val TAG = "fragment_repositories_detail"

        fun newInstance(repo: Repository) = RepositoryDetailFragment().apply {
            this.repository = repo
        }
    }
}