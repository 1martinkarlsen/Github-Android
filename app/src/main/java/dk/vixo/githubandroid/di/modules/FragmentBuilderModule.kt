package dk.vixo.githubandroid.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import dk.vixo.githubandroid.github.GithubModule
import dk.vixo.githubandroid.github.presentation.fragment.RepositoriesListFragment
import dk.vixo.githubandroid.github.presentation.fragment.RepositoryDetailFragment

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [GithubModule::class])
    abstract fun repositoriesListFragment(): RepositoriesListFragment

    @ContributesAndroidInjector(modules = [GithubModule::class])
    abstract fun repositoryDetailFragment(): RepositoryDetailFragment

}