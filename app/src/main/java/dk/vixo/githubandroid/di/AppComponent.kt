package dk.vixo.githubandroid.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dk.vixo.githubandroid.GithubApplication
import dk.vixo.githubandroid.di.modules.AppModule
import dk.vixo.githubandroid.di.modules.FragmentBuilderModule
import dk.vixo.githubandroid.di.modules.NetworkModule
import dk.vixo.githubandroid.di.modules.ViewModelModule

@Component(modules = [
    AndroidInjectionModule::class,
    AndroidSupportInjectionModule::class,
    AppModule::class,
    ViewModelModule::class,
    NetworkModule::class,
    FragmentBuilderModule::class
])
interface AppComponent : AndroidInjector<GithubApplication> {

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}