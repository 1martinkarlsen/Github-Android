package dk.vixo.githubandroid.github

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dk.vixo.githubandroid.di.scope.ViewModelKey
import dk.vixo.githubandroid.github.data.network.GithubService
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoriesListViewModel
import dk.vixo.githubandroid.github.presentation.viewmodel.RepositoryDetailViewModel
import retrofit2.Retrofit

@Module(includes = [
    GithubViewModelModule::class
])
class GithubModule {

    @Provides
    fun providesGithubService(retrofit: Retrofit) =
        retrofit.create(GithubService::class.java)

}

@Module
abstract class GithubViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RepositoriesListViewModel::class)
    abstract fun bindsRepositoriesListViewModel(impl: RepositoriesListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RepositoryDetailViewModel::class)
    abstract fun bindsRepositoryDetailViewModel(impl: RepositoryDetailViewModel) : ViewModel
}