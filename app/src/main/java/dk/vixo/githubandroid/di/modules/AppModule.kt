package dk.vixo.githubandroid.di.modules

import android.content.Context
import dagger.Binds
import dagger.Module
import dk.vixo.githubandroid.GithubApplication
import dk.vixo.githubandroid.di.scope.AppContext

@Module
abstract class AppModule {

    @Binds
    @AppContext
    abstract fun providesContext(app: GithubApplication): Context
}